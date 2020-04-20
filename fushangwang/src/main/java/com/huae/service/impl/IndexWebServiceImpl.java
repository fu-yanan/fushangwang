package com.huae.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huae.bean.Advertising;
import com.huae.bean.BannerConfig;
import com.huae.bean.CountData;
import com.huae.bean.Statement;
import com.huae.bean.Store;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;
import com.huae.bean.Vedio;
import com.huae.bean.WebMessageConfig;
import com.huae.dao.IndexWebDao;
import com.huae.service.IndexWebService;

@Service
public class IndexWebServiceImpl implements IndexWebService {
	@Autowired
	private IndexWebDao indexWebDao;
	@Override
	public String getCountData(HttpServletRequest req) {
		//会员统计
		Integer usercount =indexWebDao.getCountUser();
		req.setAttribute("usercount", usercount);
		System.out.println(usercount);
		//管理员统计
		Integer managercount=indexWebDao.getCountManager();
		req.setAttribute("managercount",managercount);
		System.out.println(managercount);
		//类目遍历统计
		List<CountData> list=indexWebDao.getCountType();
		req.setAttribute("type_list",list);
		for (CountData countData : list) {
			System.out.println(countData);
		}
		return "welcome";
	}
	/**
	 * 获取banner图
	 */
	@Override
	public String getBannerMessage(HttpServletRequest req,Integer pn) {
		PageHelper.startPage(pn,5);
		List<BannerConfig> bc=indexWebDao.getBannerMessage();
		PageInfo page=new PageInfo(bc,5);
		req.setAttribute("bc", bc);
		req.setAttribute("pageInfo", page);
		return "bannerconfig";
	}
	/**
	 * 添加banner
	 */
	@Override
	public Map<String, Integer> insertbanner(BannerConfig bc) {
		try {
			if(bc.getCarousel().equals("on")) {
				bc.setCarousel("true");
			}
		} catch (NullPointerException e) {
			bc.setCarousel("false");
			bc.setWeight(0);
		}
		int returnnum = indexWebDao.inserbanner(bc);
		//查询当前bannerid
		int b_id=indexWebDao.getBannerID(bc);
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(returnnum>=1){
			map.put("b_id",b_id);
		}else{
			map.put("b_id",0);
		}
		return map;
	}
	@Override
	public Map<String, String> insertbannerimg(String path,String id) {
		int b_id=Integer.parseInt(id);
		BannerConfig bc=new BannerConfig();
		bc.setB_img(path);
		bc.setId(b_id);
		//图片数据更新
		int returnnum =indexWebDao.updateBanner(bc);
		Map<String, String> map=new HashMap<String,String>();
		if(returnnum>0){
			map.put("flag", "1");
		}else{
			map.put("flag", "0");
		}
		
		return map;
	}
	@Override
	public String updatebanner(String id,HttpServletRequest req) {
		int b_id=Integer.parseInt(id);
		//查询当前banner数据
		BannerConfig bc =indexWebDao.getBannerByID(b_id);
		req.setAttribute("bc", bc);
		return "bannerconfig2";
	}
	@Override
	public Map<String, Integer> updatebannermessage(BannerConfig bc) {
		try {
			if(bc.getCarousel().equals("on")) {
				bc.setCarousel("true");
			}
		} catch (NullPointerException e) {
			bc.setCarousel("false");
			bc.setWeight(0);
		}
		int returnnum=indexWebDao.updatebannermessage(bc);
		Map<String,Integer> map=new HashMap<String,Integer>();
		int b_id=bc.getId();
		if(returnnum>=1){
			map.put("b_id",b_id);
		}else{
			map.put("b_id",0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deletebanner(BannerConfig bc) {
		// TODO Auto-generated method stub
		int returnnum=indexWebDao.deletebanner(bc);
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(returnnum>=1){
			map.put("flag",1);
		}else{
			map.put("flag",0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deleteallbanner(String[] ids) {
		int returnnum=indexWebDao.deleteallbanner(ids);
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(returnnum>=1){
			map.put("flag",1);
		}else{
			map.put("flag",0);
		}
		return map;
	}
	@Override
	public String getindex(HttpServletRequest req) {
		
		//使用resultMap获取类别以及商品数据
		List<StoreType> list_st=indexWebDao.getTypes();
		System.out.println(list_st);
		req.setAttribute("list_st", list_st);
		return "userindex";
	}
	@Override
	public String search(Store s,HttpServletRequest req) {
		// TODO Auto-generated method stub
		List<Store> list=indexWebDao.getStoreBySearch(s);
		System.out.println(list);
		req.setAttribute("pname", list);
		return "product";
	}
	@Override
	public boolean bannerNum() {
		int number =indexWebDao.bannerNum();
		if(number>=5) {
			return false;
		}else
			return true;
	}
	@Override
	public Map<String, String> getHomeData() {
		//查询网站首页信息
		WebMessageConfig wmc = indexWebDao.getHomeData();
		
		Map<String,String> map=new HashMap<String, String>();
		//设置欢迎语
		map.put("welcomeText", wmc.getWelcomewords());
		//设置顶部网址
		map.put("getLocal", wmc.getWebip());
		//设置服务时间
		map.put("getWorkTime", wmc.getWorkdate());
		//设置电话
		map.put("getPhone",wmc.getCompanyphone());
		//设置下拉名称
		map.put("getLineName",wmc.getLinename());
		//设置备案信息
		map.put("getBa",wmc.getBa());
		//设置版权信息
		map.put("getBq",wmc.getVersion());
		return map;
	}
	@Override
	public Map<String, List> getgetHomeDataList() {
		// TODO Auto-generated method stub
		//查询导航栏栏位
		List<StoreType> list_type=indexWebDao.getDH();
		Map<String,List> map=new  HashMap<String, List>();
		map.put("getNavName", list_type);
		return map;
	}
	@Override
	public Map<String, List> getgetSecName() {
		Map<String,List> map=new  HashMap<String, List>();
		//查询下拉菜单栏位
		List<Store> list_store=indexWebDao.getDH2();
		map.put("getSecName", list_store);
		return map;
	}
	@Override
	public Map<String, List> getgetBanner() {
		Map<String,List> map=new  HashMap<String, List>();
		//查询轮播图
		List<BannerConfig> list_banner=indexWebDao.getBannerMessage();
		map.put("getBanner",list_banner);
		return map;
	}
	@Override
	public Map<String, List> getgetVideo() {
		Map<String,List> map=new  HashMap<String, List>();
		//查询视频列表
		List<Vedio> list_video=indexWebDao.getVedio();
		map.put("getVideo",list_video);
		return map;
	}
	@Override
	public Map<String, List> getgetNavType() {
		Map<String,List> map=new  HashMap<String, List>();
		//查询商家类别以及商家
		List<StoreType> list_sat=indexWebDao.getTypes();
		map.put("getNavType",list_sat);
		return map;
	}
	@Override
	public Map<String, List> getgetNews() {
		Map<String,List> map=new  HashMap<String, List>();
		//查询最新入住商家
		List<Store> list_s=indexWebDao.getNEWProduct();
		map.put("getNews", list_s);
		return map;
	}
	@Override
	public Map<String, List> getgetRecom() {
		Map<String,List> map=new  HashMap<String, List>();
		//查询推荐商家
		List<Store> list_TJs=indexWebDao.getTJProduct();
		map.put("getRecom", list_TJs);
		return map;
	}
	@Override
	public Map<String, List> getgetSM() {
		Map<String,List> map=new  HashMap<String, List>();
		//查询声明
		List<Statement> list_stment=indexWebDao.getStatement();
		map.put("getSM", list_stment);
		return map;
	}
	
	@Override
	public Map<String, List<Store>> getStoreByTypeID(String id) {
		int id2=Integer.parseInt(id);
		//根据当前类别id查询商家
		List<Store> store=indexWebDao.getStoreByTypeID(id2);
		Map<String, List<Store>> map=new HashMap<String, List<Store>>();
		map.put("getstore",store);
		return map;
	}
	@Override
	public Map<String, List<Advertising>> advertisingList() {
		List<Advertising> list=indexWebDao.advertisingList();
		Map<String, List<Advertising>> map=new HashMap<String, List<Advertising>>();
		map.put("getgg",list);
		return map;
	}
	@Override
	public boolean updateAdvertisingToStatus(String name) {
		int i=0;
		if(name.equals("color")) {
			i=indexWebDao.updateAdvertisingToStatusByNameIsColor(name);
		}else{
			i=indexWebDao.updateAdvertisingToStatusNotNameIsColor(name);
		}
		if(i>0) 
			return false;
		else
			return false;
	}
	

}
