package com.cotato._th_cokathon.team3.api.dto.response;

/**
 * ActivityThread 생성 응답 DTO
 * - 생성된 인증 ID 반환
 */
public record ActivityThreadCreateResponse(
        Long activityThreadId
) {
    public static ActivityThreadCreateResponse of(Long id) {
        return new ActivityThreadCreateResponse(id);
    }
}