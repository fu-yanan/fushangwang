package com.huae.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUpload {
	@RequestMapping(value = "img", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> upload(HttpServletRequest servletRequest, HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws IOException {

		// 如果文件内容不为空，则写入上传路径
		if (!file.isEmpty()) {

			// 上传文件路径
			// 获取服务器位置
			String pathss = request.getSession().getServletContext().getRealPath("");
			System.out.println(pathss);
			// 这些是项目需要 要改变路径
			String paths = pathss.substring(0, pathss.indexOf("fushangwang"));
			String ll = "images";
			String path = paths + ll;
			System.out.println("路径" + path);

			System.out.println("文件名称" + file.getOriginalFilename());
			// 上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);

			// 判断路径是否存在，没有就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}

			// 将上传文件保存到一个目标文档中
			File file1 = new File(path + File.separator + filename);
			file.transferTo(file1);
			Map<String, Object> res = new HashMap<>();
			// 返回的是一个url对象
			res.put("url", file1);
			return res;

		} else {
			return null;
		}

	}
}
