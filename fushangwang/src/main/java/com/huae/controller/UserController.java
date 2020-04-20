package com.huae.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huae.bean.User;
import com.huae.service.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserService userService;
	
	@RequestMapping("getUser")
	public String getUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest req){
		return userService.getUser(pn,req);
	}
	@RequestMapping("deleteUser")
	@ResponseBody
	public Map<String,Integer> deleteUser(String id){
		return userService.deleteUser(id);
	}
	@RequestMapping("deleteAllUser")
	@ResponseBody
	public Map<String,Integer> deleteAllUser(String[] ids){
		return userService.deleteAllUser(ids);
	}
	@RequestMapping("getUserByStatus")
	public String getUserByStatus(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest req){
		return userService.getUserByStatus(pn,req);
	}
	@RequestMapping("getUserByID")
	public String getUserByID(String id,HttpServletRequest req){
		return userService.getUserByID(id,req);
		
	}
	@RequestMapping("updateUser")
	@ResponseBody
	public Map<String,Integer> updateUser(User u){
		return userService.updateUser(u);
		
	}
	@RequestMapping("updatestatus")
	@ResponseBody
	public Map<String,Integer> updatestatus(String id){
		return userService.updatestatus(id);
		
	}
	@RequestMapping("updateRefuse")
	@ResponseBody
	public Map<String,Integer> updateRefuse(String id){
		return userService.updateRefuse(id);
		
	}
	@RequestMapping("sreachUser")
	public String sreachUser(@RequestParam(value="pn",defaultValue="1")Integer pn,User u,HttpServletRequest req){
		return userService.sreachUser(pn,req,u);
		
	}
	@RequestMapping("changepw")
	@ResponseBody
	public Map<String,String> changepw(String pw,String new_pw,String new_pws){
		return userService.changepw(pw,new_pw,new_pws);
	}
}
