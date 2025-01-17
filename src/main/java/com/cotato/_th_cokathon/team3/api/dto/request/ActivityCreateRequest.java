package com.cotato._th_cokathon.team3.api.dto.request;

public record ActivityCreateRequest(
	String title,
	String category,
	String description
) {
}