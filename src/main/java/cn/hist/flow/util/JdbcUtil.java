package cn.hist.flow.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mysql.jdbc.StringUtils;

public class JdbcUtil {

	private static PreparedStatement ps=null;
	private static ResultSet rs =null;
	private static Connection con=null;

	/**
	 * 通用查询单个对象的方法
	 */
	public static Object get(Class<?> clazz,String tableName,String column,Object obj)throws Exception{
		try {
			String sql="select * from "+tableName +" where "+column+" =?";
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setObject(1, obj);
			rs = ps.executeQuery();
			return ReflexUtil.toBean(clazz, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(rs,ps,con);
		}
		return null;
	}
	
	/**
	 * 多条件查询
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public static List find(Class<?> clazz,String sql,Object...args)throws Exception{
		try {
			con=ConnectionUtil.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			//设置参数
			setParam(ps,args);
			rs = ps.executeQuery();
			return ReflexUtil.toBeans(clazz, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(rs,ps,con);
		}
		return null;
	}
	
	/**
	 * 通用更新操作
	 */
	public static int update(String sql,Object...args)throws Exception{
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(sql);
			//设置参数
			setParam(ps,args);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(null,ps,con);
		}
		return -1;
	}
	
	/**
	 * 通用删除操作
	 * @param ps
	 * @param args
	 */
	public static int delete(String sql,Object...args)throws Exception{
		//删除操作与更新操作可以通用
		return update(sql,args);
	}
	
	/**
	 * 通用插入操作
	 * @param clazz	反射出要操作的属性
	 * @param obj	插入值
	 * @throws Exception
	 */
	public static int insert(String tableName,Object obj)throws Exception{
		try {
			List<Object> paramVals=new ArrayList<Object>();
			String sql=toSql(tableName, obj,paramVals);
			con= ConnectionUtil.getConnection();
			ps = con.prepareStatement(sql);
			int i=0;
			for (Object p:paramVals) {
				ps.setObject(++i, p);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(null,ps,con);
		}
		return -1;
	}

	//返回拼接好的sql
	public static String toSql(String tableName,Object obj,List<Object> paramVals)throws Exception{
		//1.确定表名
		if(tableName!=null && tableName!=""){
			//获取传入obj对象的真实类的名称
			tableName=obj.getClass().getSimpleName();
		}
		StringBuffer param=new StringBuffer("( ");
		StringBuffer values=new StringBuffer("");
		Map<String, Object> map = ReflexUtil.objToMap(obj);
		for (Entry<String, Object> set :map.entrySet() ) {
			if(set.getValue()!=null || set.getValue()!=""){
				param.append(set.getKey()+",");
				values.append("?,");
				paramVals.add(set.getValue());
			}
		}
		//拼接查询条件
		param.deleteCharAt(param.length()-1);
		values.deleteCharAt(values.length()-1);
		return "insert into "+tableName+param.toString()+" ) "+" values("+values.toString()+")";
	}
	
	//设置sql参数
	private static void setParam(PreparedStatement ps,Object...args){
		if(args!=null && args.length>0){
			int i=0;
			try {
				for(Object arg:args){
					ps.setObject(++i, arg);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
