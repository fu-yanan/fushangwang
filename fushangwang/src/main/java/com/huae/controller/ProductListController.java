package com.huae.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huae.service.ProductListService;

@Controller
public class ProductListController {
	@Autowired
	private ProductListService productListService;
	
	@RequestMapping("getproductlist")
	public String getProductList(String id,HttpServletRequest req){
		return productListService.getProductList(id,req);	
	}
}
