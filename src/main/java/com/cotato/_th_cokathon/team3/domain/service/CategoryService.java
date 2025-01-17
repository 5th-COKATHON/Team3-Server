package com.cotato._th_cokathon.team3.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotato._th_cokathon.team3.api.dto.response.CategoryResponse;
import com.cotato._th_cokathon.team3.domain.converter.CategoryConverter;
import com.cotato._th_cokathon.team3.domain.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	/**
	 * 모든 카테고리를 조회하는 메서드
	 * @return CategoryResponse 리스트!
	 */
	@Transactional(readOnly = true)
	public List<CategoryResponse> getAllCategories() {
		return CategoryConverter.convertToResponseList(categoryRepository.findAll());
	}
}
