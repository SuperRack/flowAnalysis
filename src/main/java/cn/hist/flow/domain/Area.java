package cn.hist.flow.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 地区
 */
public class Area {

	private String id;
	private String name;
	private String parentId;
	
	private List<Area> areas=new ArrayList<Area>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public String toString() {
		return "id=" + id + ", name=" + name + ", parentId=" + parentId;
	}
}