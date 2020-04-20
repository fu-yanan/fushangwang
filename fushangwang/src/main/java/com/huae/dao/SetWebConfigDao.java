package com.huae.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huae.bean.Advertising;
import com.huae.bean.Statement;
import com.huae.bean.StoreAndType;
import com.huae.bean.StoreType;
import com.huae.bean.WebMessageConfig;

@Mapper
public interface SetWebConfigDao {

	int setWebConfig(WebMessageConfig wmc);

	WebMessageConfig getWebMessage();

	List<Statement> statementList();

	int statementTypeNum();

	int insertStatement(Statement statement);

	Statement getstatementByID(int id);

	int updateStatement(Statement statement);

	int deleteStatementById(int sid);

	List<StoreAndType> getAdvertising();

	int insertAdvertising(Advertising advertising);

	Advertising getAdvertisingByID(Advertising ad);

	int updateAdvertising(Advertising advertising);

	int deleteAllAdvertising(String[] ids);

	int deleteAdvertising(int sid);

	int advertisingNum();

}
