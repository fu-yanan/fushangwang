package com.huae.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huae.bean.Manager;
import com.huae.service.ManagerService;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerSerivce;
	@RequestMapping("login")
	@ResponseBody
	public Map<String,String> login(Manager manager,HttpSession session){
		return managerSerivce.getLogin(manager,session);
	}
	@RequestMapping("index")
	public String index(HttpSession session){
		Manager m=(Manager) session.getAttribute("manager");
		if(m!=null){
			return "index";
		}
		return "login";
		
	}
}
