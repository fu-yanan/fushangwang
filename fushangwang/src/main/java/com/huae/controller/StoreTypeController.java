package com.huae.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huae.bean.Store;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;
import com.huae.service.StoreTypeService;

@Controller
public class StoreTypeController {
	@Autowired
	private StoreTypeService storeTypeService;
	@RequestMapping("getStoreType")
	public String getStoreType(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest req){
		return storeTypeService.getStoreType(pn,req);
	}
	@RequestMapping("inserttype")
	@ResponseBody
	public Map<String,Integer> inserttype(StoreType st){
		return storeTypeService.inserttype(st);
	}
	@RequestMapping("typeNum")
	@ResponseBody
	public boolean typeNum(){
		return storeTypeService.typeNum();
	}
	@RequestMapping("getStoreTypeByID")
	public String updatetype(String id,HttpServletRequest req){
		return storeTypeService.getStoreTypeByID(id, req);
	}
	@RequestMapping("updatetype")
	@ResponseBody
	public Map<String,Integer> updatetype(StoreType st){
		return storeTypeService.updatetype(st);
	}
	@RequestMapping("deleteStoreType")
	@ResponseBody
	public Map<String,Integer> deleteStoreType(String id){
		return storeTypeService.deleteStoreType(id);
	}
	@RequestMapping("deleteAllSt")
	@ResponseBody
	public Map<String,Integer> deleteAllSt(String[] ids){
		return storeTypeService.deleteAllSt(ids);
	}
	//获取商家数据
	@RequestMapping("getStore")
	public String getStore(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest req){
		return storeTypeService.getStore(pn, req);
	}
	//获取类目
	@RequestMapping("getType")
	public String getType(HttpServletRequest req){
		return storeTypeService.getType(req);
	}
	@RequestMapping("insertStore")
	@ResponseBody
	public Map<String,Integer> insertStore(Store s){
		return storeTypeService.insertStore(s);
	}
	@RequestMapping("getStoreByID")
	public String getStoreByID(String id,HttpServletRequest req){
		return storeTypeService.getStoreByID(id, req);
	}
	@RequestMapping("updateStore")
	@ResponseBody
	public Map<String,Integer> updateStore(StoreAndType sat){
		return storeTypeService.updateStore(sat);
	}
	@RequestMapping("deleteStore")
	@ResponseBody
	public Map<String,Integer> deleteStore(String id){
		return storeTypeService.deleteStore(id);
	}
	@RequestMapping("deleteAllStore")
	@ResponseBody
	public Map<String,Integer> deleteAllStore(String[] ids){
		return storeTypeService.deleteAllStore(ids);
	}
}
