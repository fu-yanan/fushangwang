package com.huae.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.huae.bean.Store;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;

public interface StoreTypeService {

	String getStoreType(Integer pn, HttpServletRequest req);

	Map<String, Integer> inserttype(StoreType st);

	String getStoreTypeByID(String id, HttpServletRequest req);

	Map<String, Integer> updatetype(StoreType st);

	Map<String, Integer> deleteStoreType(String id);

	Map<String, Integer> deleteAllSt(String[] ids);

	String getStore(Integer pn, HttpServletRequest req);

	String getType(HttpServletRequest req);

	Map<String, Integer> insertStore(Store s);

	String getStoreByID(String id, HttpServletRequest req);

	Map<String, Integer> updateStore(StoreAndType sat);

	Map<String, Integer> deleteStore(String id);

	Map<String, Integer> deleteAllStore(String[] ids);

	boolean typeNum();

}
