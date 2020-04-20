package com.huae.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.huae.bean.Vedio;

public interface VedioService {

	String getVedioList(Integer pn, HttpServletRequest req);

	Map<String, Integer> insertvideo(Vedio v);

	Map<String, String> insertvideoimg(String path, String id, String v_video);

	String getvideoByid(String id, HttpServletRequest req);

	Map<String, Integer> updatevideomessage(Vedio v);

	Map<String, Integer> deletevedio(String id);

	Map<String, Integer> deleteallvedio(String[] ids);

	boolean videoNum();

}
