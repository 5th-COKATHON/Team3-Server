package com.cotato._th_cokathon.team3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cotato._th_cokathon.team3.api.dto.request.ActivityCreateRequest;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityCreateResponse;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityListResponse;
import com.cotato._th_cokathon.team3.common.dto.DataResponse;
import com.cotato._th_cokathon.team3.common.exception.ImageException;
import com.cotato._th_cokathon.team3.domain.service.ActivityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Tag(name = "Activity Api", description = "활동 API(ex: 스쿼트 10개")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api/activities")
public class ActivityController {

	private final ActivityService activityService;

	@GetMapping("")
	@Operation(summary = "액티비티 전체 조회", description = "전체 액티비티 조회")
	public ResponseEntity<DataResponse<ActivityListResponse>> findActivities() {
		ActivityListResponse activities = activityService.findActivities();
		return ResponseEntity.ok(DataResponse.from(activities));
	}

	@PostMapping("")
	@Operation(summary = "액티비티 단건 생성", description = "액티비티에 대한 정보를 바탕으로 하나 생성")
	public ResponseEntity<DataResponse<ActivityCreateResponse>> createActivity(
		@Parameter(description = "액티비티 생성 정보", schema = @Schema(implementation = ActivityCreateRequest.class))
		@RequestPart ActivityCreateRequest request,
		@Parameter(description = "multipart/form-data 형식의 이미지를 input으로 받습니다. 이때 key 값은 image입니다.")
		@RequestPart(value = "image", required = false) MultipartFile image) throws ImageException {
		return ResponseEntity.ok(
			DataResponse.from(
				ActivityCreateResponse.of(
					activityService.createActivity(request, image)
				)
			)
		);
	}
}