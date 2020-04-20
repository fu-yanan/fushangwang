package com.huae.bean;

public class WebMessageConfig {
	private Integer id;
	private String webip;//顶部网址设置
	private String linename;//下拉名称设置
	private String companyip;//公司地址设置
	private String companyphone;//电话设置
	private String version; //版权
	private String workdate;//服务时间设置
	private String keywords; //关键字
	private String  webrepresent;//描述
	private String welcomewords;//欢迎语
	private String ba;//备案号
	
	public String getBa() {
		return ba;
	}
	public void setBa(String ba) {
		this.ba = ba;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWebip() {
		return webip;
	}
	public void setWebip(String webip) {
		this.webip = webip;
	}

	public String getLinename() {
		return linename;
	}
	public void setLinename(String linename) {
		this.linename = linename;
	}
	public String getCompanyip() {
		return companyip;
	}
	public void setCompanyip(String companyip) {
		this.companyip = companyip;
	}
	public String getCompanyphone() {
		return companyphone;
	}
	public void setCompanyphone(String companyphone) {
		this.companyphone = companyphone;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getWebrepresent() {
		return webrepresent;
	}
	public void setWebrepresent(String webrepresent) {
		this.webrepresent = webrepresent;
	}
	public String getWelcomewords() {
		return welcomewords;
	}
	public void setWelcomewords(String welcomewords) {
		this.welcomewords = welcomewords;
	}
	
}
