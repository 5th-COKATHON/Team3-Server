package com.cotato._th_cokathon.team3.api.dto.response;

public record ActivityCreateResponse(
	Long activityId
) {

	public static ActivityCreateResponse of(Long id) {
		return new ActivityCreateResponse(id);
	}
}