package com.shopping.biz.fileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping("/upload.do")
	public String upload(Model model, @RequestParam("file1") MultipartFile file) {
		String url = fileUploadService.restore(file);
		model.addAttribute("url", url);
		return "insertBook.jsp";
	}
}