package com.cotato._th_cokathon.team3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

	@GetMapping
	public ResponseEntity<String> test() {
		return ResponseEntity.ok().body("ok");
	}
}
