package com.huae.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huae.bean.Manager;
import com.huae.bean.StoreAndType;
import com.huae.bean.User;
import com.huae.dao.UserDao;
import com.huae.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserDao userDao;
	@Override
	public String getUser(Integer pn,HttpServletRequest req) {
		PageHelper.startPage(pn,5);
		List<User> list_u=userDao.getUser();
		PageInfo page=new PageInfo(list_u,5);
		req.setAttribute("list",list_u);
		req.setAttribute("pageInfo", page);
		return "member-list";
	}
	@Override
	public Map<String, Integer> deleteUser(String id) {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(id);
		int returnnum=userDao.deleteUser(uid);
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deleteAllUser(String[] ids) {
		int returnnum = userDao.deleteAllUser(ids);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public String getUserByStatus(Integer pn, HttpServletRequest req) {
		PageHelper.startPage(pn,5);
		List<User> list_u=userDao.getUserByStatus();
		PageInfo page=new PageInfo(list_u,5);
		req.setAttribute("list",list_u);
		req.setAttribute("pageInfo", page);
		return "member-list2";
	}
	@Override
	public String getUserByID(String id,HttpServletRequest req) {
		int uid=Integer.parseInt(id);
		User u=userDao.getUserByID(uid);
		req.setAttribute("u", u);
		return "updateuser";
	}
	@Override
	public Map<String, Integer> updateUser(User u) {
		int returnnum = userDao.updateUser(u);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> updatestatus(String id) {
		int uid=Integer.parseInt(id);
		int returnnum = userDao.updatestatus(uid);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> updateRefuse(String id) {
		int uid=Integer.parseInt(id);
		int returnnum = userDao.updateRefuse(uid);
		Map<String, Integer> map=new HashMap<>();

		if(returnnum>0){
			map.put("rescode", 1);
		}else{
			map.put("rescode", 0);
		}
		return map;
	}
	@Override
	public String sreachUser(Integer pn, HttpServletRequest req, User u) {
		PageHelper.startPage(pn,5);
		List<User> list_u=userDao.sreachUser(u);
		PageInfo page=new PageInfo(list_u,5);
		req.setAttribute("list",list_u);
		req.setAttribute("pageInfo", page);
		return "member-list";
	}
	@Override
	public Map<String, String> changepw(String pw, String new_pw, String new_pws) {
		Map<String,String> map=new HashMap<>();
		if(new_pw.equals(new_pws)){
			//查询密码是否一致
			Manager u=userDao.getPW(pw);
			if(u!=null){
				//更改密码
				int returnnum=userDao.updatePW(new_pw);
				if(returnnum>0){
					map.put("flag", "1");
				}
			}else{
				//密码错误
				map.put("flag", "0");
			}
		}else{	
				//密码输入不一致
			map.put("flag", "2");
		}
		return map;
	}
	@Override
	public String regist(User user) {
		int result=userDao.regist(user);
		if(result>0) {
			return "userindex";
		}
		return null;
		
	}

}
