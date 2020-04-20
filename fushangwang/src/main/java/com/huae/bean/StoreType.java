package com.huae.bean;

import java.util.List;

public class StoreType {
	private int id;
	private String navigation;
	private int navigationNum;
	private String type_name;
	private String field;
	private List<Store> storeList;
	
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	public int getNavigationNum() {
		return navigationNum;
	}
	public void setNavigationNum(int navigationNum) {
		try {
			if(navigationNum>0) {
				this.navigationNum = navigationNum;
			}else {
				this.navigationNum=0;
			}
		} catch (NullPointerException e) {
			this.navigationNum=0;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public List<Store> getStoreList() {
		return storeList;
	}
	@Override
	public String toString() {
		return "StoreType [id=" + id + ", type_name=" + type_name + ", storeList=" + storeList + "]";
	}
	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}
}
