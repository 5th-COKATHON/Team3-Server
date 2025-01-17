package com.cotato._th_cokathon.team3.api.dto.request;

/**
 * ActivityThread 생성 요청 DTO
 * - 인증 설명을 포함
 */
public record ActivityThreadCreateRequest(
        String description
) {}