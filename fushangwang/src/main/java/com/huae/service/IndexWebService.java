package com.huae.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.huae.bean.Advertising;
import com.huae.bean.BannerConfig;
import com.huae.bean.Store;


public interface IndexWebService {

	String getCountData(HttpServletRequest req);

	String getBannerMessage(HttpServletRequest req, Integer pn);

	Map<String, Integer> insertbanner(BannerConfig bc);

	Map<String, String> insertbannerimg(String path,String id);

	String updatebanner(String id, HttpServletRequest req);

	Map<String, Integer> updatebannermessage(BannerConfig bc);

	Map<String, Integer> deletebanner(BannerConfig bc);

	Map<String, Integer> deleteallbanner(String[] ids);

	String getindex(HttpServletRequest req);

	String search(Store s, HttpServletRequest req);

	boolean bannerNum();

	Map<String, String> getHomeData();

	Map<String, List> getgetHomeDataList();

	Map<String, List<Store>> getStoreByTypeID(String id);

	Map<String, List<Advertising>> advertisingList();

	boolean updateAdvertisingToStatus(String name);

	Map<String, List> getgetSecName();

	Map<String, List> getgetSM();

	Map<String, List> getgetRecom();

	Map<String, List> getgetNavType();

	Map<String, List> getgetNews();

	Map<String, List> getgetBanner();

	Map<String, List> getgetVideo();



}
