package com.huae.bean;

public class StoreAndType {
	private int id;
	private String p_name;
	private String type_name;
	private String p_href;
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
	public StoreAndType() {
		super();
	}
	public String getMerchantsnavigation() {
		return merchantsnavigation;
	}
	public void setMerchantsnavigation(String merchantsnavigation) {
		this.merchantsnavigation = merchantsnavigation;
	}
	public int getMerchantsnavigationpriority() {
		return merchantsnavigationpriority;
	}
	public void setMerchantsnavigationpriority(int merchantsnavigationpriority) {
		this.merchantsnavigationpriority = merchantsnavigationpriority;
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
		Recommendbusinessmanpriority = recommendbusinessmanpriority;
	}
	public StoreAndType(String p_name, String type_name, String p_href, int weight, String merchantsnavigation,
			int merchantsnavigationpriority, String businessesin, String recommendbusinessman,
			int recommendbusinessmanpriority) {
		super();
		this.p_name = p_name;
		this.type_name = type_name;
		this.p_href = p_href;
		this.weight = weight;
		this.merchantsnavigation = merchantsnavigation;
		this.merchantsnavigationpriority = merchantsnavigationpriority;
		Businessesin = businessesin;
		Recommendbusinessman = recommendbusinessman;
		Recommendbusinessmanpriority = recommendbusinessmanpriority;
	}
	public StoreAndType(int id, String p_name, String type_name, String p_href, int weight, String merchantsnavigation,
			int merchantsnavigationpriority, String businessesin, String recommendbusinessman,
			int recommendbusinessmanpriority) {
		super();
		this.id = id;
		this.p_name = p_name;
		this.type_name = type_name;
		this.p_href = p_href;
		this.weight = weight;
		this.merchantsnavigation = merchantsnavigation;
		this.merchantsnavigationpriority = merchantsnavigationpriority;
		Businessesin = businessesin;
		Recommendbusinessman = recommendbusinessman;
		Recommendbusinessmanpriority = recommendbusinessmanpriority;
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
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getP_href() {
		return p_href;
	}
	public void setP_href(String p_href) {
		this.p_href = p_href;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
