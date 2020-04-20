package com.huae.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huae.bean.Advertising;
import com.huae.bean.BannerConfig;
import com.huae.bean.Store;
import com.huae.service.IndexWebService;

@Controller
public class IndexWebController {
	@Autowired
	private IndexWebService indexWebService;
	@RequestMapping("welcome")
	public String welcome(HttpServletRequest req){
		return indexWebService.getCountData(req);
	}
	//获取banner数据
	@RequestMapping("bannerconfig")
	public String bannerconfig(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest req){
		return indexWebService.getBannerMessage(req,pn);
	}
	//上传表单数据
	@RequestMapping("insertbanner")
	@ResponseBody
	public Map<String,Integer> insertbanner(BannerConfig bc){
		
		return indexWebService.insertbanner(bc);
	}
	//上传图片路径
	@RequestMapping("insertbannerimg")
	@ResponseBody
	public Map<String,String> insertbannerimg(String path,String id){
		System.out.println(path);
		return indexWebService.insertbannerimg(path,id);
	}
	//进入更新banner界面
	@RequestMapping("updatebanner")
	public String updatebanner(String id,HttpServletRequest req){
		return indexWebService.updatebanner(id,req);
	}
	//更新banner数据
	@RequestMapping("updatebannermessage")
	@ResponseBody
	public Map<String,Integer> updatebannermessage(BannerConfig bc){
		return indexWebService.updatebannermessage(bc);
	}
	//更新banner数据
	@RequestMapping("bannerNum")
	@ResponseBody
	public boolean bannerNum(){
		return indexWebService.bannerNum();
	}
	//单个删除
	@RequestMapping("deletebanner")
	@ResponseBody
	public Map<String,Integer> deletebanner(String id){
		int b_id=Integer.parseInt(id);
		BannerConfig bc=new BannerConfig();
		bc.setId(b_id);
		return indexWebService.deletebanner(bc);
	}
	//批量删除
	@RequestMapping("deleteallbanner")
	@ResponseBody
	public Map<String,Integer> deleteallbanner(String[] ids){
		return indexWebService.deleteallbanner(ids);
	}
	@RequestMapping("search")
	public String search(Store s,HttpServletRequest req){
		return indexWebService.search(s,req);
	}
	/*
	 * 获取用户首页全部数据
	 * 通过ajax加载
	 */
	@RequestMapping("getHomeData")
	@ResponseBody
	public Map<String,String> getHomeData(){
		return indexWebService.getHomeData();
	}
	@RequestMapping("getHomeDataList")
	@ResponseBody
	public Map<String,List> getHomeDataList(){
		return indexWebService.getgetHomeDataList();
	}
	@RequestMapping("getgetSecName")
	@ResponseBody
	public Map<String, List> getgetSecName() {
		return indexWebService.getgetSecName();
	}
	@RequestMapping("getgetBanner")
	@ResponseBody
	public Map<String, List> getgetBanner() {
		return indexWebService.getgetBanner();
	}
	@RequestMapping("getgetVideo")
	@ResponseBody
	public Map<String, List> getgetVideo() {
		return indexWebService.getgetVideo();
	}
	@RequestMapping("getgetNavType")
	@ResponseBody
	public Map<String, List> getgetNavType() {
		return indexWebService.getgetNavType();
	}
	@RequestMapping("getgetNews")
	@ResponseBody
	public Map<String, List> getgetNews() {
		return indexWebService.getgetNews();
	}
	@RequestMapping("getgetRecom")
	@ResponseBody
	public Map<String, List> getgetRecom() {
		return indexWebService.getgetRecom();
	}
	@RequestMapping("getgetSM")
	@ResponseBody
	public Map<String, List> getgetSM() {
		return indexWebService.getgetSM();
	}
	@RequestMapping("getStoreByTypeID")
	@ResponseBody
	public Map<String,List<Store>> getStoreByTypeID(String id){
		return indexWebService.getStoreByTypeID(id);
		
	}
	@RequestMapping("advertisingList")
	@ResponseBody
	public Map<String,List<Advertising>> advertisingList(){
		return indexWebService.advertisingList();
	}
	@RequestMapping("updateAdvertisingToStatus")
	@ResponseBody
	public boolean updateAdvertisingToStatus(String name){
		return indexWebService.updateAdvertisingToStatus(name);
		
	}
}
