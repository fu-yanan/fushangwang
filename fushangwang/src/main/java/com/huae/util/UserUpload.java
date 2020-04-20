package com.huae.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.huae.bean.User;
import com.huae.service.UserService;

@Controller
public class UserUpload {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register")  
	
	public String InsertJourneyTest(HttpServletRequest request) throws IllegalStateException, IOException {  
	     //把带二进制表单数据的request对象交给spring转换 得到一个文件和普通数据分开的新request对象  
	    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
	      
	    // 获取from表单参数  
	    String username = multipartRequest.getParameter("username");  
	    String idcard = multipartRequest.getParameter("idcard");  
	    String phone = multipartRequest.getParameter("phone"); 
	    String select_local=multipartRequest.getParameter("province");
	    String select_local2=multipartRequest.getParameter("city");
	    String select_local3=multipartRequest.getParameter("town");
	    String select_local4=multipartRequest.getParameter("local");
	    String local=select_local+select_local2+select_local3+select_local4;
	    User u=new User();
	    u.setIdcard(idcard);
	    u.setPhone(phone);
	    u.setUsername(username);
	    u.setComefrom(local);
	    Date utilDate = new Date();//util.Date
        //util.Date转sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		u.setJointime(sqlDate);
	          
	        //获得Request中的图片 photo 是from表单文件的name  
		MultipartFile file = (MultipartFile) multipartRequest.getFile("idcard_img"); 
		MultipartFile file2 = (MultipartFile) multipartRequest.getFile("liscese_img");
	    System.out.println("这是图片"+file2);
	   
	    if(file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length()>0){  
	        //图片服务器路径  
	         String file_path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/images/";  
	         //原始文件名  
	        String originalFileName = file.getOriginalFilename();  

	        //新文件名，添加原始文件名后缀  
	        String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));

	        //创建新文件，路径为：图片服务器路径+新文件名  
	        File newFile = new File(file_path + newFileName);  

	        //将内存中的数据写入磁盘  
	        file.transferTo(newFile); 

	        u.setIdcard_img("images/" + newFileName);

	     
	   }  
	    if(file2 != null && file2.getOriginalFilename() != null && file2.getOriginalFilename().length()>0){
	    	 //图片服务器路径  
	         String file_path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/images/";  
	         //原始文件名  
	        String originalFileName2 = file2.getOriginalFilename();  

	        //新文件名，添加原始文件名后缀  
	        String newFileName2 = UUID.randomUUID() + originalFileName2.substring(originalFileName2.lastIndexOf("."));  

	        //创建新文件，路径为：图片服务器路径+新文件名  
	        File newFile2 = new File(file_path + newFileName2);  

	        System.out.println("文件地址"+file_path+newFileName2);
	        //将内存中的数据写入磁盘  
	        file2.transferTo(newFile2);  

	        u.setLiscese_img("images/" + newFileName2);
	    }
	    return userService.regist(u);  
	}
}
