package com.huae.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huae.bean.Advertising;
import com.huae.bean.Statement;
import com.huae.bean.StoreAndType;
import com.huae.bean.WebMessageConfig;
import com.huae.service.SetWebConfigService;

@Controller
public class SetWebConfigController {
	@Autowired
	private SetWebConfigService setWebConfigService;
	@RequestMapping("webconfig")
	public String webConfig(HttpServletRequest req){
		return setWebConfigService.getWebMessage(req);
	}
	@RequestMapping("statement")
	public String statement(){
		return "statement";
	}
	@RequestMapping("getAdvertising")
	public String getAdvertising(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest req){
		return setWebConfigService.getAdvertising(pn, req);
	}
	/**
	 * 增加广告 insertAdvertising
	 */
	@RequestMapping("insertAdvertising")
	@ResponseBody
	public Map<String,String> insertAdvertising(Advertising advertising,String advertisingName){
		System.out.println(advertising);
		System.out.println(advertisingName);
		return setWebConfigService.insertAdvertising(advertising);
		
	}
	/**
	 * 修改广告 updateAdvertising
	 */
	@RequestMapping("updateAdvertising")
	@ResponseBody
	public Map<String,Integer> updateAdvertising(Advertising advertising){
		return setWebConfigService.updateAdvertising(advertising);
	}
	/**
	 * 批量删除广告 deleteAllAdvertising
	 */
	@RequestMapping("deleteAllAdvertising")
	@ResponseBody
	public Map<String,Integer> deleteAllAdvertising(String[] ids){
		return setWebConfigService.deleteAllAdvertising(ids);
	}
	/**
	 * 删除广告 deleteAdvertising
	 */
	@RequestMapping("deleteAdvertising")
	@ResponseBody
	public Map<String,Integer> deleteAdvertising(String id){
		return setWebConfigService.deleteAdvertising(id);
	}
	/**
	 * 查询广告开启数量advertisingNum
	 */
	@RequestMapping("advertisingNum")
	@ResponseBody
	public boolean advertisingNum(){
		return setWebConfigService.advertisingNum();
	}
	/**
	 *获取id getAdvertisingByID
	 */
	@RequestMapping("getAdvertisingByID")
	public String getAdvertisingByID(String id,HttpServletRequest req){
		return setWebConfigService.getAdvertisingByID(id, req);
	}
	/**
	 * 跳转到声明页面
	 * @return
	 */
	@RequestMapping("statementList")
	@ResponseBody
	public JSONObject statementList(){
		return setWebConfigService.statementList();
		
	}
	/**
	 * 查询声明数量
	 * @return
	 */
	@RequestMapping("statementTypeNum")
	@ResponseBody
	public boolean statementTypeNum(){
		return setWebConfigService.statementTypeNum();
		
	}
	/**
	 * 增加声明
	 * @return
	 */
	@RequestMapping("insertStatement")
	@ResponseBody
	public Map<String,String> insertStatement(Statement statement){
		return setWebConfigService.insertStatement(statement);
		
	}
	/**
	 * 修改声明
	 * @return
	 */
	@RequestMapping("updateStatement")
	@ResponseBody
	public Map<String,String> updateStatement(Statement statement){
		return setWebConfigService.updateStatement(statement);
		
	}
	/**
	 * 查看声明
	 * @return
	 */
	@RequestMapping("getstatementByID")
	@ResponseBody
	public JSONObject getstatementByID(String id){
		return setWebConfigService.getstatementByID(id);
		
	}
	@RequestMapping("deleteStatementById")
	@ResponseBody
	public Map<String,Integer> deleteStatementById(String id){
		return setWebConfigService.deleteStatementById(id);
	}
	@RequestMapping("setwebconfig")
	@ResponseBody
	public Map<String,String> setWebConfig(WebMessageConfig wmc){
		return setWebConfigService.setWebConfig(wmc);
		
	}
}
