package com.cotato._th_cokathon.team3.domain.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.cotato._th_cokathon.team3.api.dto.response.CategoryResponse;
import com.cotato._th_cokathon.team3.domain.entity.Category;

/**
 * 카테고리 변환기 (Converter)
 * - 엔티티 리스트를 DTO 리스트로 변환하는 유틸리티 클래스
 */
public class CategoryConverter {

    /**
     * Category 엔티티 리스트를 CategoryResponse 리스트로 변환
     * @param categories 변환할 카테고리 리스트
     * @return 변환된 CategoryResponse 리스트
     */
    public static List<CategoryResponse> convertToResponseList(List<Category> categories) {
        return categories.stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toList());
    }
}