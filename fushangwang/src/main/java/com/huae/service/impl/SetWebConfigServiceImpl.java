package com.huae.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huae.bean.Advertising;
import com.huae.bean.Statement;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;
import com.huae.bean.WebMessageConfig;
import com.huae.dao.SetWebConfigDao;
import com.huae.service.SetWebConfigService;

@Service
public class SetWebConfigServiceImpl implements SetWebConfigService {
	@Autowired 
	private SetWebConfigDao setWebConfigDao;

	@Override
	public Map<String, String> setWebConfig(WebMessageConfig wmc) {
		int returnnum=setWebConfigDao.setWebConfig(wmc);
		Map<String, String> map=new HashMap<String,String>();
		
		if(returnnum>=1){
			map.put("flag", "1");
		}else{
			map.put("flag", "0");
		}
		return map;
	}

	@Override
	public String getWebMessage(HttpServletRequest req) {
		WebMessageConfig wmc=setWebConfigDao.getWebMessage();
		req.setAttribute("webmessage",wmc);
		return "webconfig";
	}

	@Override
	public JSONObject statementList() {
		List<Statement> list=setWebConfigDao.statementList();
		JSONObject object = new JSONObject();
		object.put("code", 0);
	     object.put("msg", "");
	     object.put("data", list);
		return object;
	}

	@Override
	public boolean statementTypeNum() {
		int returnnum=setWebConfigDao.statementTypeNum();
		if(returnnum>=3) {
			return false;
		}else {
			return true;
			
		}
	}

	@Override
	public Map<String, String> insertStatement(Statement statement) {
		try {
			if(statement.getStatus().equals("on")) {
				statement.setStatus("是");
			}else {
				statement.setStatus("否");
			}
		} catch (NullPointerException e) {
			statement.setStatus("否");
		}
		int returnnum = setWebConfigDao.insertStatement(statement);
		Map<String, String> map=new HashMap<>();
		if(returnnum>0){
			map.put("rescode", "1");
		}else{
			map.put("rescode", "0");
		}
		return map;
	}

	@Override
	public JSONObject getstatementByID(String ids) {
		int id = Integer.parseInt(ids);
		Statement statement=setWebConfigDao.getstatementByID(id);
		JSONObject json = new JSONObject();
		json.put("statement", statement);
		return json;
	}

	@Override
	public Map<String, String> updateStatement(Statement statement) {
		try {
			if(statement.getStatus().equals("on")) {
				statement.setStatus("是");
			}else {
				statement.setStatus("否");
			}
		} catch (NullPointerException e) {
			statement.setStatus("否");
		}
		int returnnum = setWebConfigDao.updateStatement(statement);
		Map<String, String> map=new HashMap<>();
		if(returnnum>0){
			map.put("rescode", "1");
		}else{
			map.put("rescode", "0");
		}
		return map;
	}

	@Override
	public Map<String, Integer> deleteStatementById(String id) {
		int sid=Integer.parseInt(id);
		int returnnum = setWebConfigDao.deleteStatementById(sid);
		Map<String, Integer> map=new HashMap<>();
		
		if(returnnum>0&&returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}

	@Override
	public String getAdvertising(Integer pn, HttpServletRequest req) {
		PageHelper.startPage(pn,5);
		List<StoreAndType> list_s=setWebConfigDao.getAdvertising();
		PageInfo page=new PageInfo(list_s,5);
		req.setAttribute("list",list_s);
		req.setAttribute("pageInfo", page);
		return "advertising";
	}

	@Override
	public Map<String, String> insertAdvertising(Advertising advertising) {
		try {
			if(advertising.getStatus().equals("on")) {
				advertising.setStatus("true");
			}else {
				advertising.setStatus("false");
			}
		} catch (NullPointerException e) {
			advertising.setStatus("false");
		}
		int returnnum = setWebConfigDao.insertAdvertising(advertising);
		Map<String, String> map=new HashMap<>();
		if(returnnum>0){
			map.put("rescode", "1");
		}else{
			map.put("rescode", "0");
		}
		return map;
	}

	@Override
	public String getAdvertisingByID(String id, HttpServletRequest req) {
		int sid=Integer.parseInt(id);
		Advertising ad = new Advertising();
		ad.setId(sid);
		Advertising rest=setWebConfigDao.getAdvertisingByID(ad);
		req.setAttribute("s", rest);
		return "updateAdvertising";
	}

	@Override
	public Map<String, Integer> updateAdvertising(Advertising advertising) {
		try {
			if(advertising.getStatus().equals("on")) {
				advertising.setStatus("true");
			}else {
				advertising.setStatus("false");
			}
		} catch (NullPointerException e) {
			advertising.setStatus("false");
		}
		int returnnum = setWebConfigDao.updateAdvertising(advertising);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}

	@Override
	public Map<String, Integer> deleteAllAdvertising(String[] ids) {
		int returnnum = setWebConfigDao.deleteAllAdvertising(ids);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}

	@Override
	public Map<String, Integer> deleteAdvertising(String id) {
		int sid=Integer.parseInt(id);
		int returnnum = setWebConfigDao.deleteAdvertising(sid);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}

	@Override
	public boolean advertisingNum() {
		int num=setWebConfigDao.advertisingNum();
		if(num>=2) {
			return false;
		}else {
			return true;
		}
	}

}
