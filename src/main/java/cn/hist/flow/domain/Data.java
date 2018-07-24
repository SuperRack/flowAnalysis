package cn.hist.flow.domain;

public class Data {

	private String id;
	private Double flowUp;
	private Double flowDown;
	private String flowArea;
	private String flowDate;
	private String flowYear;
	private String flowMonth;
	private String flowDay;
	private String flowType;		//0:PC端产生的数据，1: 移动端产生的数据。
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getFlowUp() {
		return flowUp;
	}
	public void setFlowUp(Double flowUp) {
		this.flowUp = flowUp;
	}
	public Double getFlowDown() {
		return flowDown;
	}
	public void setFlowDown(Double flowDown) {
		this.flowDown = flowDown;
	}
	public String getFlowArea() {
		return flowArea;
	}
	public void setFlowArea(String flowArea) {
		this.flowArea = flowArea;
	}
	public String getFlowDate() {
		return flowDate;
	}
	public void setFlowDate(String flowDate) {
		this.flowDate = flowDate;
	}
	public String getFlowYear() {
		return flowYear;
	}
	public void setFlowYear(String flowYear) {
		this.flowYear = flowYear;
	}
	public String getFlowMonth() {
		return flowMonth;
	}
	public void setFlowMonth(String flowMonth) {
		this.flowMonth = flowMonth;
	}
	public String getFlowDay() {
		return flowDay;
	}
	public void setFlowDay(String flowDay) {
		this.flowDay = flowDay;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	
	public String toString() {
		return "id=" + id + ", flowUp=" + flowUp + ", flowDown="
				+ flowDown + ", flowArea=" + flowArea + ", flowDate="
				+ flowDate + ", flowYear=" + flowYear + ", flowMonth="
				+ flowMonth + ", flowDay=" + flowDay + ", flowType=" + flowType;
	}
}