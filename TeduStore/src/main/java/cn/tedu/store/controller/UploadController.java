package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	//1.显示上传的表单
	@RequestMapping("/showUpload.do")
	public String showUpload() {
		return "upload";
	}
	//2.实现文件上船的功能
	@RequestMapping("/uploadFile.do")
	public String  uploadFile(MultipartFile file) {
		try {
			//实现上传功能
			file.transferTo(new File("/home/soft01/code",file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//响应页面
		return "redirect:../Main/showIndex.do";
	}
}
