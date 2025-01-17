package com.cotato._th_cokathon.team3.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.cotato._th_cokathon.team3.common.exception.ErrorCode;
import com.cotato._th_cokathon.team3.common.exception.ImageException;

public class FileUtil {

	private static final List<String> IMAGE_FILE_EXTENSIONS = List.of("png", "jpg", "jpeg", "heif");

	public static String extractFileExtension(MultipartFile file) throws ImageException {
		String originalFilename = file.getOriginalFilename();
		if (originalFilename == null || !originalFilename.contains(".")) {
			throw new ImageException(ErrorCode.FILE_EXTENSION_FAULT);
		}

		return originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
	}

	public static boolean isImageFileExtension(String fileExtension) {
		return IMAGE_FILE_EXTENSIONS.contains(fileExtension.toLowerCase());
	}

	public static File convert(MultipartFile file) throws ImageException {
		String fileExtension = extractFileExtension(file);
		File convertFile = new File(System.getProperty("user.dir") + "/" + UUID.randomUUID() + "." + fileExtension);

		try {
			FileOutputStream fos = new FileOutputStream(convertFile);
			fos.write(file.getBytes());
			fos.close();

			return convertFile;
		} catch (IOException e) {
			throw new ImageException(ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}
}
