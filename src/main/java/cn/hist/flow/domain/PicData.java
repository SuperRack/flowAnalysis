package cn.hist.flow.domain;

public class PicData {

	private Double value;
	private String name;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "PicData [value=" + value + ", name=" + name + "]";
	}
}
