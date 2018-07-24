package cn.hist.flow.domain;

import java.util.Arrays;

//柱状图数据封装
public class BarData {

	/**
	 * 示例: name: '河南省', type: 'bar', barGap: 0, data: [25, 220, 326, 103, 110,
	 * 260]
	 */

	private String name;
	private String type = "bar";
	private Integer barGap = 0;
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

	public Integer getBarGap() {
		return barGap;
	}

	public void setBarGap(Integer barGap) {
		this.barGap = barGap;
	}

	public Double[] getData() {
		return data;
	}

	public void setData(Double[] data) {
		this.data = data;
	}

	public String toString() {
		return "name=" + name + ", type=" + type + ", barGap=" + barGap
				+ ", data=" + Arrays.toString(data);
	}
}
