package com.huae.dao;

import java.util.List;

import com.huae.bean.Store;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;

public interface StoreTypeDao {

	List<StoreType> getStoreType();

	int inserttype(StoreType st);

	StoreType getStoreTypeByID(StoreType st);

	int updatetype(StoreType st);

	int deleteStoreType(int sid);

	int deleteAllSt(String[] ids);

	List<StoreAndType> getStore();

	List<StoreType> getType();

	int insertStore(Store s);

	StoreAndType getStoreByID(StoreAndType sat);

	int getTypeID(String type_name);

	int updateStore(Store s);

	int deleteStore(int sid);

	int deleteAllStore(String[] ids);

	int deleteStoreByStoreTypeId(int sid);

	int typeNum();

}
