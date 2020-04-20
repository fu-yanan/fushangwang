package com.huae.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huae.bean.Store;
import com.huae.bean.StoreType;

@Mapper
public interface ProductDao {

	List<Store> getProductList(int p_type);

	StoreType getName(int id);

}
