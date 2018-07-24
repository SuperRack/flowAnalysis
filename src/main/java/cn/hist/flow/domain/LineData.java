package cn.hist.flow.domain;

import java.util.Arrays;

public class LineData {

	private String name;
	private String type = "line";
	private String stack = "总量";
	private Double[] data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public Double[] getData() {
		return data;
	}

	public void setData(Double[] data) {
		this.data = data;
	}

	public String toString() {
		return "name=" + name + ", type=" + type + ", stack=" + stack
				+ ", data=" + Arrays.toString(data);
	}
}