package cn.hist.flow.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReflexUtil {

	/**
	 * 通过ResultSet转换为Object对象
	 * 这个方法有个很大的限制，就是你查询出来结果的数据的属性名，它要与java对象的属性保持一致
	 * @param clazz
	 * @param rs
	 * @throws Exception
	 */
	public static List<Object> toBeans(Class<?> clazz,ResultSet rs)throws Exception{
		List<Object> resulData=new ArrayList<Object>();
		Object object =null;
		while(rs.next()){
			object=toObject(clazz,rs);
			//将object放入到List集合中
			resulData.add(object);
		}
		return resulData;
	}
	
	/**
	 * 单个对象的封装
	 * @param clazz
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	public static Object toBean(Class<?> clazz,ResultSet rs)throws Exception{
		if(rs==null){
			return null;
		}
		rs.next();
		return toObject(clazz,rs);
	}
	
	/*
	 * 将clazz转换成Object
	 * */
	private static Object toObject(Class<?> clazz,ResultSet rs)throws Exception{
		//获取查询出来的元数据。
		ResultSetMetaData metaData = rs.getMetaData();
		//通过元数据，想办法，去从元数据中获取所有查询出来的columns的名字
		//获取查询出来总共有多少列 
		int columnCount = metaData.getColumnCount();
		//1.通clazz.反射出一个Object实例
		Object object=clazz.newInstance();
		
		String name=null;
		//循环分别获取每个列中属性名称
		for(int i=1;i<=columnCount;i++){
			name= metaData.getColumnName(i);
			//获取对应columns查询出来的值
			//通过name反射出setXxx方法 ，进行存值。
			name="set"+name.substring(0,1).toUpperCase()+name.substring(1);
			setMethod(clazz, object, name, Class.forName(metaData.getColumnClassName(i)), rs.getObject(i));
		}
		return object;
	}
	
	public static void setMethod(Class<?> clazz,Object obj,String methodName,Class<?> paramType,Object param)throws Exception{
		Method me = clazz.getMethod(methodName,paramType);
		me.invoke(obj, param);
	}
	
	/**
	 * 传入一个对象，将对象中的属性与值转换成map
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> objToMap(Object obj)throws Exception{
		if(obj==null) return null;
		
		Map<String,Object> data=new LinkedHashMap<String,Object>();
		Class<? extends Object> clazz = obj.getClass();
		//获取所有的属性
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			data.put(field.getName(), field.get(obj));
		}
		return data;
	}
}
