package com.huae.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huae.bean.Manager;
import com.huae.dao.ManagerDao;
import com.huae.service.ManagerService;

@Service
public class ManagerSerivceImpl implements ManagerService{
	
	@Autowired
	private ManagerDao managerDao;
	@Override
	public Map<String, String> getLogin(Manager manager,HttpSession session) {
		Manager m =managerDao.getLogin(manager);
		Map<String, String> map=new HashMap<String,String>();
		if(m!=null){
			//设置登录标记
			session.setAttribute("manager",m);
			//返回登录状态
			map.put("msg","0");
		}else{
			map.put("msg", "1");
		}
		return map;
	}

}
