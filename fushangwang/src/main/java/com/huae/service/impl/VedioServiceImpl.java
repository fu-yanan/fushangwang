package com.huae.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huae.bean.BannerConfig;
import com.huae.bean.Vedio;
import com.huae.dao.VedioDao;
import com.huae.service.VedioService;

@Service
public class VedioServiceImpl implements VedioService{
	@Autowired
	private VedioDao vedioDao;
	@Override
	public String getVedioList(Integer pn, HttpServletRequest req) {
		PageHelper.startPage(pn,5);
		List<Vedio> v=vedioDao.getVedioList();
		PageInfo page=new PageInfo(v,5);
		req.setAttribute("v", v);
		req.setAttribute("pageInfo", page);
		return "videoconfig";
	}
	@Override
	public Map<String, Integer> insertvideo(Vedio v) {
		try {
			if(v.getCarousel().equals("on")) {
				v.setCarousel("true");
			}
		} catch (NullPointerException e) {
			v.setCarousel("false");
			v.setWeight(0);
		}
		int returnnum = vedioDao.inservideo(v);
		//查询当前视频id
		int v_id=vedioDao.getVedioID(v);
		System.out.println("当前视频id"+v_id);
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(returnnum>=1){
			map.put("v_id",v_id);
		}else{
			map.put("v_id",0);
		}
		return map;
	}
	//图片地址更新
	@Override
	public Map<String, String> insertvideoimg(String path, String id,String v_video) {
		int v_id=Integer.parseInt(id);
		Vedio v=new Vedio();
		v.setId(v_id);
		v.setV_img(path);
		v.setV_vedio(v_video);
		//图片数据更新
		int returnnum =vedioDao.updateVimg(v);
		Map<String, String> map=new HashMap<String,String>();
		if(returnnum>0){
			map.put("flag", "1");
		}else{
			map.put("flag", "0");
		}
		
		return map;
	}
	@Override
	public String getvideoByid(String id, HttpServletRequest req) {
		int vid=Integer.parseInt(id);
		//根据id获取视频数据
		Vedio v=vedioDao.getvideoByid(vid);
		req.setAttribute("v", v);
		return "videoconfig2";
	}
	@Override
	public Map<String, Integer> updatevideomessage(Vedio v) {
		try {
			if(v.getCarousel().equals("on")) {
				v.setCarousel("true");
			}
		} catch (NullPointerException e) {
			v.setCarousel("false");
			v.setWeight(0);
		}
		int returnnum=vedioDao.updatevideomessage(v);
		Map<String,Integer> map=new HashMap<String,Integer>();
		int id=v.getId();
		if(returnnum>=1){
			map.put("v_id",id);
		}else{
			map.put("v_id",0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deletevedio(String id) {
		int vid=Integer.parseInt(id);
		int returnnum=vedioDao.deletevedio(vid);
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(returnnum>=1){
			map.put("flag",1);
		}else{
			map.put("flag",0);
		}
		return map;
	}
	@Override
	public Map<String, Integer> deleteallvedio(String[] ids) {
		int returnnum=vedioDao.deleteallvedio(ids);
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(returnnum>=1){
			map.put("flag",1);
		}else{
			map.put("flag",0);
		}
		return map;
	}
	@Override
	public boolean videoNum() {
		int number =vedioDao.videoNum();
		if(number>=10) {
			return false;
		}else
			return true;
	}

}
