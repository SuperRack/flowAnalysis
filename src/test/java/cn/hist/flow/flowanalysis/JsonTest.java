package cn.hist.flow.flowanalysis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;

public class JsonTest {

	@Test
	public void testDemo(){
		Map<String,String> data=new HashMap<String,String>();
		data.put("a", "aa");
		data.put("b", "bb");
		data.put("c", "cc");
		data.put("d", "dd");
		
		String jsonString = JSONArray.toJSONString(data);
		System.out.println(jsonString);
	}
}
