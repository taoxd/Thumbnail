package com.thumbnail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class UploadService {

	public String uploadImage(CommonsMultipartFile file, String uploadPath, String realUploadPath) {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = file.getInputStream();
			String des = realUploadPath + "/" + file.getOriginalFilename();
			os = new FileOutputStream(des);

			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer, 0, buffer.length)) > 0) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return uploadPath + "/" + file.getOriginalFilename();
	}
}