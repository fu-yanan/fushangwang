package com.huae.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.huae.bean.Advertising;
import com.huae.bean.Statement;
import com.huae.bean.WebMessageConfig;

public interface SetWebConfigService {

	Map<String, String> setWebConfig(WebMessageConfig wmc);

	String getWebMessage(HttpServletRequest req);

	JSONObject statementList();

	boolean statementTypeNum();

	Map<String, String> insertStatement(Statement statement);

	JSONObject getstatementByID(String id);

	Map<String, String> updateStatement(Statement statement);

	Map<String, Integer> deleteStatementById(String id);

	String getAdvertising(Integer pn, HttpServletRequest req);

	Map<String, String> insertAdvertising(Advertising advertising);

	String getAdvertisingByID(String id, HttpServletRequest req);

	Map<String, Integer> updateAdvertising(Advertising advertising);

	Map<String, Integer> deleteAllAdvertising(String[] id);

	Map<String, Integer> deleteAdvertising(String id);

	boolean advertisingNum();
	
}
