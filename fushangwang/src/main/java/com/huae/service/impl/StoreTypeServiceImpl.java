package com.huae.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huae.bean.Store;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;
import com.huae.bean.Vedio;
import com.huae.dao.StoreTypeDao;
import com.huae.service.StoreTypeService;

@Service
public class StoreTypeServiceImpl implements StoreTypeService{
	@Autowired
	private StoreTypeDao storeTypeDao;
	@Override
	public String getStoreType(Integer pn,HttpServletRequest req) {
		PageHelper.startPage(pn,5);
		List<StoreType> list_s=storeTypeDao.getStoreType();
		PageInfo page=new PageInfo(list_s,5);
		req.setAttribute("list_s",list_s);
		req.setAttribute("pageInfo", page);
		return "shoptype";
	}
	@Override
	public Map<String, Integer> inserttype(StoreType st) {
		// TODO Auto-generated method stub
		try {
			if(st.getNavigation().equals("on")) {
				st.setNavigation("true");
			}else {
				st.setNavigation("false");
				st.setNavigationNum(0);
			}
		} catch (NullPointerException e) {
			st.setNavigation("false");
			st.setNavigationNum(0);
		}
		try {
			if(st.getField().equals("on")) {
				st.setField("true");
			}else {
				st.setField("false");
			}
		} catch (NullPointerException e) {
			st.setField("false");
		}
		
		int returnnum = storeTypeDao.inserttype(st);
		Map<String, Integer> map=new HashMap<>();
		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public String getStoreTypeByID(String id, HttpServletRequest req) {
		int sid=Integer.parseInt(id);
		StoreType st=new StoreType();
		st.setId(sid);
		StoreType rest=storeTypeDao.getStoreTypeByID(st);
		req.setAttribute("st", rest);
		return "updatetype";
	}
	@Override
	public Map<String, Integer> updatetype(StoreType st) {
		try {
			if(st.getNavigation().equals("on")) {
				st.setNavigation("true");
			}
		} catch (NullPointerException e) {
			st.setNavigation("false");
			st.setNavigationNum(0);
		}
		try {
			if(st.getField().equals("on")) {
				st.setField("true");
			}else {
				st.setField("false");
			}
		} catch (NullPointerException e) {
			st.setField("false");
		}
		int returnnum = storeTypeDao.updatetype(st);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deleteStoreType(String id) {
		int sid=Integer.parseInt(id);
		int returnnum = storeTypeDao.deleteStoreType(sid);
		int returnnum1=storeTypeDao.deleteStoreByStoreTypeId(sid);
		Map<String, Integer> map=new HashMap<>();
		
		if(returnnum>0&&returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deleteAllSt(String[] ids) {
		int returnnum = storeTypeDao.deleteAllSt(ids);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public String getStore(Integer pn, HttpServletRequest req) {
		PageHelper.startPage(pn,5);
		List<StoreAndType> list_s=storeTypeDao.getStore();
		PageInfo page=new PageInfo(list_s,5);
		req.setAttribute("list",list_s);
		req.setAttribute("pageInfo", page);
		return "showstore";
	}
	@Override
	public String getType(HttpServletRequest req) {
		List<StoreType> t_list=storeTypeDao.getType();
		req.setAttribute("t_list", t_list);
		return "insertstore";
	}
	@Override
	public Map<String, Integer> insertStore(Store s) {
		try {
			if(s.getBusinessesin().equals("on")) {
				s.setBusinessesin("true");
			}else {
				s.setBusinessesin("false");
			}
		} catch (NullPointerException e) {
			s.setBusinessesin("false");
		}
		try {
			if(s.getMerchantsnavigation().equals("on")) {
				s.setMerchantsnavigation("true");
			}else {
				s.setMerchantsnavigation("false");
			}
		} catch (NullPointerException e) {
			s.setMerchantsnavigation("false");
			s.setMerchantsnavigationpriority(0);
		}
		try {
			if(s.getRecommendbusinessman().equals("on")) {
				s.setRecommendbusinessman("true");
			}else {
				s.setRecommendbusinessman("false");
			}
		} catch (NullPointerException e) {
			s.setRecommendbusinessman("false");
			s.setRecommendbusinessmanpriority(0);
		}
		int returnnum=storeTypeDao.insertStore(s);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
		
	}
	@Override
	public String getStoreByID(String id, HttpServletRequest req) {
		int sid=Integer.parseInt(id);
		StoreAndType sat=new StoreAndType();
		sat.setId(sid);
		StoreAndType resat=storeTypeDao.getStoreByID(sat);
		req.setAttribute("s", resat);
		List<StoreType> t_list=storeTypeDao.getType();
		req.setAttribute("t_list", t_list);
		return "updatestore";
	}
	@Override
	public Map<String, Integer> updateStore(StoreAndType sat) {
			//根据类别名称查询类别id
			int type_id =storeTypeDao.getTypeID(sat.getType_name());
			//更新商家表
			
			Store s=new Store();
			s.setId(sat.getId());
			s.setP_href(sat.getP_href());
			s.setP_name(sat.getP_name());
			s.setWeight(sat.getWeight());
			s.setImgName(sat.getImgName());
			try {
				if(sat.getBusinessesin().equals("on")) {
					s.setBusinessesin("true");
				}else {
					s.setBusinessesin("false");
				}
			} catch (NullPointerException e1) {
				s.setBusinessesin("false");
			}
			
			try {
				if(sat.getMerchantsnavigation().equals("on")) {
					s.setMerchantsnavigation("true");
					s.setMerchantsnavigationpriority(sat.getMerchantsnavigationpriority());
				}else {
					s.setMerchantsnavigation("false");
					s.setMerchantsnavigationpriority(0);
				}
				
			} catch (NullPointerException e) {
				s.setMerchantsnavigation("false");
				s.setMerchantsnavigationpriority(0);
			}
			try {
				if(sat.getRecommendbusinessman().equals("on")) {
					s.setRecommendbusinessman("true");
					s.setRecommendbusinessmanpriority(sat.getRecommendbusinessmanpriority());
				}else {
					s.setRecommendbusinessman("false");
					s.setRecommendbusinessmanpriority(0);
				}
				
			} catch (NullPointerException e) {
				s.setRecommendbusinessman("false");
				s.setRecommendbusinessmanpriority(0);
			}
			
			
			
			System.out.println(type_id);
			s.setP_type(type_id);
			int returnnum=storeTypeDao.updateStore(s);
			
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deleteStore(String id) {
		int sid=Integer.parseInt(id);
		int returnnum = storeTypeDao.deleteStore(sid);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deleteAllStore(String[] ids) {
		int returnnum = storeTypeDao.deleteAllStore(ids);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public boolean typeNum() {
		int number =storeTypeDao.typeNum();
		if(number>=4) {
			return false;
		}else
			return true;
	}
	
	
}
