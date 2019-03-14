package com.thumbnail;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upAction")
public class ThumbnailAction {
	private UploadService uploadService;
	private ThumbnailService thumbnailService;
	private ThumbnailAWTService thumbnailAWTService;

	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public ModelAndView thumbnail(@RequestParam("image") CommonsMultipartFile file, HttpSession session) {
		String uploadPath = "/images";
		/**
		 * 本地tomcat安装在D盘 D:\Program_Files\apache-tomcat-7.0.92
		 * 
		 * 输出 D:\Program_Files\apache-tomcat-7.0.92\webapps\thumbnail\images
		 */
		String realUploadPath = session.getServletContext().getRealPath(uploadPath);

		String imageUrl = uploadService.uploadImage(file, uploadPath, realUploadPath);//输出/images/和平之鸟.jpg
		String thumImageUrl = thumbnailService.thumbnail(file, uploadPath, realUploadPath);//输出/images/thum_和平之鸟.jpg
		/**
		 * 此方法会转换转换失败
		 */
		//String thumImageUrl = thumbnailAWTService.thumbnail(file, uploadPath, realUploadPath);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("imageURL", imageUrl);
		mv.addObject("thumbImageURL", thumImageUrl);

		mv.setViewName("thumbnail");

		return mv;
	}

	@Autowired
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@Autowired
	public void setThumbnailService(ThumbnailService thumbnailService) {
		this.thumbnailService = thumbnailService;
	}
	
	@Autowired
	public void setThumbnailAWTService(ThumbnailAWTService thumbnailAWTService) {
		this.thumbnailAWTService = thumbnailAWTService;
	}
	
	
}