package com.cotato._th_cokathon.team3.api.dto.response;

import java.util.List;

/**
 * ActivityThread 목록 응답 DTO
 * - 인증 개수 및 인증 목록 반환
 */
public record ActivityThreadListResponse(
        int threadCount,
        List<ActivityThreadResponse> activityThreadResponses
) {
    public static ActivityThreadListResponse from(List<ActivityThreadResponse> activityThreadResponses) {
        return new ActivityThreadListResponse(
                activityThreadResponses.size(),
                activityThreadResponses
        );
    }
}