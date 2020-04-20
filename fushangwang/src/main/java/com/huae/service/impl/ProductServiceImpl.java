package com.huae.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huae.bean.Store;
import com.huae.bean.StoreType;
import com.huae.dao.ProductDao;
import com.huae.service.ProductListService;

@Service
public class ProductServiceImpl implements ProductListService {
	@Autowired 
	private ProductDao productDao;
	@Override
	public String getProductList(String id,HttpServletRequest req) {
		//根据id查询商品表 该类别所有商品
		int pid=Integer.parseInt(id);
		List<Store> ls=productDao.getProductList(pid);
		req.setAttribute("ls", ls);
		//根据id查询类别表 该类别名称
		StoreType name=productDao.getName(pid);
		req.setAttribute("name", name);
		return "Products";
	}

}
