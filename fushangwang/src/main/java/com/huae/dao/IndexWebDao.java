package com.huae.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huae.bean.Advertising;
import com.huae.bean.BannerConfig;
import com.huae.bean.CountData;
import com.huae.bean.Statement;
import com.huae.bean.Store;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;
import com.huae.bean.Vedio;
import com.huae.bean.WebMessageConfig;


@Mapper
public interface IndexWebDao {

	Integer getCountUser();

	Integer getCountManager();

	List<CountData> getCountType();

	List<BannerConfig> getBannerMessage();

	int inserbanner(BannerConfig bc);

	int getBannerID(BannerConfig bc);

	int updateBanner(BannerConfig bc);

	BannerConfig getBannerByID(int b_id);

	int updatebannermessage(BannerConfig bc);

	int deletebanner(BannerConfig bc);

	int deleteallbanner(String[] ids);

	List<Vedio> getVedio();

	List<StoreType> getType();

	List<BannerConfig> getBannerMessageByW();

	List<Store> getTypeByW();

	List<StoreType> getTypes();

	WebMessageConfig getWebMessage();

	List<Store> getStore();

	List<Store> getStore2();

	List<Store> getStoreBySearch(Store s);

	int bannerNum();

	WebMessageConfig getHomeData();

	List<StoreType> getDH();

	List<Store> getDH2();

	List<Store> getStoreByTypeID(int id);

	List<Store> getNEWProduct();

	List<Store> getTJProduct();

	List<Statement> getStatement();

	List<Advertising> advertisingList();

	int updateAdvertisingToStatusByNameIsColor(String name);

	int updateAdvertisingToStatusNotNameIsColor(String name);




}
