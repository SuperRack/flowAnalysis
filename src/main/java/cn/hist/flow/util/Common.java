package cn.hist.flow.util;

public class Common {
	
	public static String toUUID(){
		return java.util.UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
