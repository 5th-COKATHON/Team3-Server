package com.cotato._th_cokathon.team3.api.dto.response;

import com.cotato._th_cokathon.team3.domain.entity.Activity;

public record ActivityResponse(
	String title,
	String imageUrl,
	Long participantCount
) {

	public static ActivityResponse from(Activity activity) {
		return new ActivityResponse(
			activity.getTitle(),
			activity.getImageUrl(),
			activity.getParticipantCount()
		);
	}
}
