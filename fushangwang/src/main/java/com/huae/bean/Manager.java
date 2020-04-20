package com.huae.bean;

public class Manager {
	private Integer m_id;
	private String m_name;
	private String m_password;
	private boolean m_status; //管理员启用状态 默认启用
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public boolean isM_status() {
		return m_status;
	}
	public void setM_status(boolean m_status) {
		this.m_status = m_status;
	}
}
