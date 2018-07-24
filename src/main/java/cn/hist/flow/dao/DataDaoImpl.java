package cn.hist.flow.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.hist.flow.domain.BarData;
import cn.hist.flow.domain.BarDataMapper;
import cn.hist.flow.domain.Data;
import cn.hist.flow.domain.LineData;
import cn.hist.flow.domain.LineDataMapper;
import cn.hist.flow.domain.PicData;
import cn.hist.flow.domain.PicDataMapper;

@Repository
public class DataDaoImpl implements DataDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> findProvince() {
		String sql="select name from flow_area where parentId is null";
		return jdbcTemplate.queryForList(sql, String.class);
	}
	
	public List<String> findParendId() {
		String sql="select id from flow_area where parentId is null";
		return jdbcTemplate.queryForList(sql, String.class);
	}
	
	
	public BarData countByPro(Data data, String proStr) {
		StringBuffer where=new StringBuffer();
		List<String> params = new ArrayList<String>();
		if(data.getFlowYear()!=null && data.getFlowYear()!="" && data.getFlowYear().length()>0){
			where.append(" and flowYear=? ");
			params.add(data.getFlowYear());
		}
		if(data.getFlowMonth()!=null && data.getFlowMonth()!="" && data.getFlowMonth().length()>0){
			where.append(" and flowMonth=? ");
			params.add(data.getFlowMonth());
		}
		if(data.getFlowType()!=null && data.getFlowType()!="" && data.getFlowType().length()>0){
			where.append(" and flowType=? ");
			params.add(data.getFlowType());
		}
		String sql="SELECT area.name,sum(flow.flowUp) flowUp, sum(flow.flowDown) flowDown FROM flow_data flow INNER JOIN flow_area area ON flow.flowArea = area.id WHERE area.id LIKE '"+proStr+".%'" +where.toString();
		return jdbcTemplate.queryForObject(sql, params.toArray(), new BarDataMapper());
	}
	
	public PicData findFlowByPcPicUp(String flowYear, String id) {
		String where="";
		List<String> params = new ArrayList<String>();
		if(flowYear!=null && flowYear!="" && flowYear.length()>0){
			where=" and flowYear=? ";
			params.add(flowYear);
		}
		String sql="SELECT sum(flow.flowUp) flowUp FROM flow_data flow INNER JOIN flow_area area ON flow.flowArea = area.id WHERE flowType='0' and area.id LIKE '"+id+".%'" +where;
		return jdbcTemplate.queryForObject(sql, params.toArray(), new PicDataMapper());
	}
	
	public PicData findFlowByPcPicDown(String flowYear, String id) {
		String where="";
		List<String> params = new ArrayList<String>();
		if(flowYear!=null && flowYear!="" && flowYear.length()>0){
			where=" and flowYear=? ";
			params.add(flowYear);
		}
		String sql="SELECT sum(flow.flowDown) flowDown FROM flow_data flow INNER JOIN flow_area area ON flow.flowArea = area.id WHERE flowType='0' and area.id LIKE '"+id+".%'" +where;
		return jdbcTemplate.queryForObject(sql, params.toArray(), new PicDataMapper());
	}
	
	public LineData findFLowByLineUp(String flowYear, String id) {
		String where="";
		List<String> params = new ArrayList<String>();
		if(flowYear!=null && flowYear!="" && flowYear.length()>0){
			where=" and flowYear=? ";
			params.add(flowYear);
		}
		String sql="SELECT sum(flow.flowUp) flowUp FROM flow_data flow INNER JOIN flow_area area ON flow.flowArea = area.id WHERE flowType='1' and area.id LIKE '"+id+".%'" +where +" group by flow.flowYear;";
		return jdbcTemplate.queryForObject(sql,params.toArray(),new LineDataMapper());
	}
	
	public LineData findFLowByLineDown(String flowYear, String id) {
		String where="";
		List<String> params = new ArrayList<String>();
		if(flowYear!=null && flowYear!="" && flowYear.length()>0){
			where=" and flowYear= ? ";
			params.add(flowYear);
		}
		String sql="SELECT sum(flow.flowDown) flowDown FROM flow_data flow INNER JOIN flow_area area ON flow.flowArea = area.id WHERE flowType='1' and area.id LIKE '"+id+".%'" +where +" group by flow.flowYear;";
		return jdbcTemplate.queryForObject(sql,params.toArray(),new LineDataMapper());
	}
}