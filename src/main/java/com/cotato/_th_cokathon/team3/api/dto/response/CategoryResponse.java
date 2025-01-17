package com.cotato._th_cokathon.team3.api.dto.response;

import com.cotato._th_cokathon.team3.domain.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 카테고리 응답 DTO
 * - 클라이언트에게 반환되는 카테고리 정보
 */
@Getter
@AllArgsConstructor
public class CategoryResponse {
    private final Long id;
    private final String name;

    /**
     * 엔티티에서 DTO로 변환하는 정적 메서드
     * @param category 변환할 카테고리 엔티티
     * @return CategoryResponse 객체
     */
    public static CategoryResponse from(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}