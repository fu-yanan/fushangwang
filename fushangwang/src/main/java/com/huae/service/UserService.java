package com.huae.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.huae.bean.User;

public interface UserService {

	String getUser(Integer pn,HttpServletRequest req);

	Map<String, Integer> deleteUser(String id);

	Map<String, Integer> deleteAllUser(String[] ids);

	String getUserByStatus(Integer pn, HttpServletRequest req);

	String getUserByID(String id, HttpServletRequest req);

	Map<String, Integer> updateUser(User u);

	Map<String, Integer> updatestatus(String id);

	Map<String, Integer> updateRefuse(String id);

	String sreachUser(Integer pn, HttpServletRequest req, User u);

	Map<String, String> changepw(String pw, String new_pw, String new_pws);

	String regist(User user);


}
