package com.huae.bean;

public class CountData {
	private Integer count;
	private String type_name;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@Override
	public String toString() {
		return "CountData [count=" + count + ", type_name=" + type_name + "]";
	}

}
