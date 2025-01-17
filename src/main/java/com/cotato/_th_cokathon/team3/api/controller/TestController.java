package com.cotato._th_cokathon.team3.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotato._th_cokathon.team3.api.dto.request.SubmitQuestRequest;
import com.cotato._th_cokathon.team3.common.exception.ImageException;
import com.cotato._th_cokathon.team3.common.util.S3Uploader;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

	private final S3Uploader s3Uploader;

	@GetMapping
	public ResponseEntity<String> test() {
		return ResponseEntity.ok().body("ok");
	}

	@PostMapping(value = "/image", consumes = "multipart/form-data")
	public ResponseEntity<Void> uploadImage(@ModelAttribute SubmitQuestRequest request) throws ImageException {
		s3Uploader.uploadFiles(List.of(request.image()), "test");
		return ResponseEntity.noContent().build();
	}
}
