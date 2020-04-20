package com.huae.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class VideoUpload {
	@RequestMapping(value = "uploadVideo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> upload(HttpServletRequest servletRequest, HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws IOException {
		Map<String,String> map=new HashMap<String,String>();
		if(!file.isEmpty()) {
			// 获取文件名称,包含后缀			
			String fileName = file.getOriginalFilename();		
			
			// 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
			// 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
			System.out.println("视频路径"+path);
			try {
				// 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法				
				FileUtil.fileupload(file.getBytes(), path, fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//返回路径到js
			
			map.put("respath",fileName);
			
			
		}
		return map;


	}
}
