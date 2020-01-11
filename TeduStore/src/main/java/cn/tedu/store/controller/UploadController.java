package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/upload")
@Controller
public class UploadController {
	//��ʾ�ϴ���ҳ��
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}

	@RequestMapping("/upload.do")
	public String  upload(MultipartFile file) throws IllegalStateException, IOException{
		//��ȡ�ϴ��ļ����ļ���
		String fileName = 
				file.getOriginalFilename();
		//�ϴ��ļ�
		file.transferTo(new File("d:/",fileName));
		
		return "redirect:../main/showIndex.do";
	}
}








