package com.cotato._th_cokathon.team3.api.dto.response;

import java.util.List;

public record ActivityListResponse(
	int activityCount,
	List<ActivityResponse> activityResponses
) {

	public static ActivityListResponse from(List<ActivityResponse> activityResponses) {
		return new ActivityListResponse(
			activityResponses.size(),
			activityResponses
		);
	}
}