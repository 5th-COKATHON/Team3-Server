package com.cotato._th_cokathon.team3.api.dto.response;

import com.cotato._th_cokathon.team3.domain.entity.Activity;

public record ActivityDetailResponse(
	Long id,
	String title,
	String description,
	String imageUrl,
	Long participantCount
) {
	public static ActivityDetailResponse from(Activity activity) {
		return new ActivityDetailResponse(
			activity.getId(),
			activity.getTitle(),
			activity.getDescription(),
			activity.getImageUrl(),
			activity.getParticipantCount()
		);
	}
}
