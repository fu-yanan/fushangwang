package com.huae.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.huae.bean.Manager;

public interface ManagerService {

	Map<String, String> getLogin(Manager manager, HttpSession session);

}
