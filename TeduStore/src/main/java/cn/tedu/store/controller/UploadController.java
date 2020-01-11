package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/upload")
@Controller
public class UploadController {
	//显示上传的页面
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}

	@RequestMapping("/upload.do")
	public String  upload(MultipartFile file) throws IllegalStateException, IOException{
		//获取上传文件的文件名
		String fileName = 
				file.getOriginalFilename();
		//上传文件
		file.transferTo(new File("d:/",fileName));
		
		return "redirect:../main/showIndex.do";
	}
}








