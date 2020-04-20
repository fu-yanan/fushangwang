package com.huae.bean;

public class Store {
	private int id;
	private String p_name;
	private String p_href;
	private int p_type;
	private int weight;
	private String imgName;
	private String merchantsnavigation; //是否显示到商家导航
	private int merchantsnavigationpriority;//显示商家导航优先级
	private String Businessesin;// 是否显示到商家入驻
	private String Recommendbusinessman; //是否设置为推荐商家
	private int Recommendbusinessmanpriority;//推荐商家优先级
	
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getMerchantsnavigation() {
		return merchantsnavigation;
	}
	public void setMerchantsnavigation(String merchantsnavigation) {
		this.merchantsnavigation=merchantsnavigation;
	}
	public int getMerchantsnavigationpriority() {
		return merchantsnavigationpriority;
	}
	public void setMerchantsnavigationpriority(int merchantsnavigationpriority) {
		try {
			this.merchantsnavigationpriority = merchantsnavigationpriority;
		} catch (NullPointerException e) {
			this.merchantsnavigationpriority=0;
		}
	}
	public String getBusinessesin() {
		return Businessesin;
	}
	public void setBusinessesin(String businessesin) {
		Businessesin = businessesin;
	}
	public String getRecommendbusinessman() {
		return Recommendbusinessman;
	}
	public void setRecommendbusinessman(String recommendbusinessman) {
		Recommendbusinessman = recommendbusinessman;
	}
	public int getRecommendbusinessmanpriority() {
		return Recommendbusinessmanpriority;
	}
	public void setRecommendbusinessmanpriority(int recommendbusinessmanpriority) {
		try {
			Recommendbusinessmanpriority = recommendbusinessmanpriority;
		} catch (NullPointerException e) {
			Recommendbusinessmanpriority = 0;
		}
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_href() {
		return p_href;
	}
	public void setP_href(String p_href) {
		this.p_href = p_href;
	}
	public int getP_type() {
		return p_type;
	}
	public void setP_type(int p_type) {
		this.p_type = p_type;
	}
}
