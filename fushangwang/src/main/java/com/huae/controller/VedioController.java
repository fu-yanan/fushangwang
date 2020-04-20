package com.huae.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huae.bean.Vedio;
import com.huae.service.VedioService;

@Controller
public class VedioController {
	@Autowired
	private VedioService vedioService;
	
	@RequestMapping("getVedioList")
	public String getVedioList(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpServletRequest req){
		return vedioService.getVedioList(pn,req);
	}
	@RequestMapping("insertvideo")
	@ResponseBody
	public Map<String,Integer> insertvideo(Vedio v){
		return vedioService.insertvideo(v);
	}
	@RequestMapping("videoNum")
	@ResponseBody
	public boolean videoNum(){
		return vedioService.videoNum();
	}
	@RequestMapping("insertvideoimg")
	@ResponseBody
	public Map<String,String> insertvideoimg(String path,String id,String v_video){
		System.out.println("当前视频id"+id);
		return vedioService.insertvideoimg(path,id,v_video);
	}
	
	@RequestMapping("updatevideoByid")
    public String updatevideoByid(String id,HttpServletRequest req){
    	return vedioService.getvideoByid(id,req);
    }
	@RequestMapping("updatevideomessage")
	@ResponseBody
	public Map<String,Integer> updatevideomessage(Vedio v){
		return vedioService.updatevideomessage(v);
	}
	@RequestMapping("deletevedio")
	@ResponseBody
	public Map<String,Integer> deletevedio(String id){
		return vedioService.deletevedio(id);
	}
	//批量删除
	@RequestMapping("deleteallvedio")
	@ResponseBody
		public Map<String,Integer> deleteallvedio(String[] ids){
			return vedioService.deleteallvedio(ids);
		}
	
}
