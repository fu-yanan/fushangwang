package com.huae.dao;

import java.util.List;

import com.huae.bean.Manager;
import com.huae.bean.User;

public interface UserDao {

	List<User> getUser();

	int deleteUser(int uid);

	int deleteAllUser(String[] ids);

	List<User> getUserByStatus();

	User getUserByID(int uid);

	int updateUser(User u);

	int updatestatus(int uid);

	int updateRefuse(int uid);

	List<User> sreachUser(User u);

	Manager getPW(String pw);

	int updatePW(String new_pw);

	int regist(User user);

}
