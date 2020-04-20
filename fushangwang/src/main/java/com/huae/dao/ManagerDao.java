package com.huae.dao;

import org.apache.ibatis.annotations.Mapper;

import com.huae.bean.Manager;

@Mapper
public interface ManagerDao {

	Manager getLogin(Manager manager);

}
