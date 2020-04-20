package com.huae.bean;

public class Statement {
	private int statementId; //声明id
	private String statementName;//声明名称
	private String statementContext;//声明富文本框内容
	private String statementText;//声明文本内容
	private String status;//声明状态
	public Statement(int statementId, String statementName, String statementContext, String statementText,
			String status) {
		super();
		this.statementId = statementId;
		this.statementName = statementName;
		this.statementContext = statementContext;
		this.statementText = statementText;
		this.status = status;
	}
	public Statement() {
		super();
	}
	public int getStatementId() {
		return statementId;
	}
	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}
	public String getStatementName() {
		return statementName;
	}
	public void setStatementName(String statementName) {
		this.statementName = statementName;
	}
	public String getStatementContext() {
		return statementContext;
	}
	public void setStatementContext(String statementContext) {
		this.statementContext = statementContext;
	}
	public String getStatementText() {
		return statementText;
	}
	public void setStatementText(String statementText) {
		this.statementText = statementText;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", statementName=" + statementName + ", statementContext="
				+ statementContext + ", statementText=" + statementText + ", status=" + status + "]";
	}
	
}
