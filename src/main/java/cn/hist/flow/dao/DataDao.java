package cn.hist.flow.dao;

import java.util.List;

import cn.hist.flow.domain.BarData;
import cn.hist.flow.domain.Data;
import cn.hist.flow.domain.LineData;
import cn.hist.flow.domain.PicData;

public interface DataDao {

	List<String> findProvince();

	BarData countByPro(Data data, String proStr);

	List<String> findParendId();

	PicData findFlowByPcPicUp(String flowYear, String string);

	PicData findFlowByPcPicDown(String flowYear, String string);

	LineData findFLowByLineUp(String flowYear, String string);

	LineData findFLowByLineDown(String flowYear, String string);
}
