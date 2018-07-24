package cn.hist.flow.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class ProUtil {
	
	public static List<String> getLine(String proName){
		List<String> list=new ArrayList<String>();
		InputStream input = ProUtil.class.getClassLoader().getResourceAsStream(proName);
		Properties pro=new Properties();
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		Enumeration<?> propertyNames = pro.propertyNames();
		String line =null;
		while(propertyNames.hasMoreElements()){
			line = (String)propertyNames.nextElement();
			list.add(line);
		}
		return list;
	}
}
