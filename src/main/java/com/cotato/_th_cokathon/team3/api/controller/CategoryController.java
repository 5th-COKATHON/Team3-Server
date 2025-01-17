package com.cotato._th_cokathon.team3.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotato._th_cokathon.team3.api.dto.response.CategoryResponse;
import com.cotato._th_cokathon.team3.common.dto.DataResponse;
import com.cotato._th_cokathon.team3.domain.service.CategoryService;

import lombok.RequiredArgsConstructor;

/**
 * Category 컨트롤러 : 카테고리 조회 API
 */

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;

	/**
	 * 모든 카테고리 조회 API
	 * @return 카테고리 리스트를 포함한 DataResponse
	 */
	@GetMapping
	public ResponseEntity<DataResponse<List<CategoryResponse>>> getCategories() {
		return ResponseEntity.ok(DataResponse.from(categoryService.getAllCategories()));
	}
}
