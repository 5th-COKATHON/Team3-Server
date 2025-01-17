package com.cotato._th_cokathon.team3.api.dto.response;

import com.cotato._th_cokathon.team3.domain.entity.ActivityThread;

/**
 * 개별 ActivityThread 응답 DTO
 */
public record ActivityThreadResponse(
        String description,
        String imageUrl
) {
    public static ActivityThreadResponse from(ActivityThread activityThread) {
        return new ActivityThreadResponse(
                activityThread.getDescription(),
                activityThread.getImageUrl()
        );
    }
}