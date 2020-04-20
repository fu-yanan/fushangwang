package com.huae.dao;

import java.util.List;

import com.huae.bean.Vedio;

public interface VedioDao {

	List<Vedio> getVedioList();

	int inservideo(Vedio v);

	int getVedioID(Vedio v);

	int updateVimg(Vedio v);

	Vedio getvideoByid(int vid);

	int updatevideomessage(Vedio v);

	int deletevedio(int vid);

	int deleteallvedio(String[] ids);

	int videoNum();

}
