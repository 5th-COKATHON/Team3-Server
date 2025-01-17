package com.cotato._th_cokathon.team3.api.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record SubmitQuestRequest(
	MultipartFile image
) {
}
