package com.cotato._th_cokathon.team3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cotato._th_cokathon.team3.api.dto.request.ActivityThreadCreateRequest;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityThreadCreateResponse;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityThreadListResponse;
import com.cotato._th_cokathon.team3.common.dto.DataResponse;
import com.cotato._th_cokathon.team3.common.exception.ImageException;
import com.cotato._th_cokathon.team3.domain.service.ActivityThreadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * ActivityThread (인증 게시글) 컨트롤러
 * - Activity에 대한 인증 사진 및 설명을 추가하고 조회하는 기능 제공
 */
@Tag(name = "ActivityThread API", description = "활동 인증 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activities/{activityId}/threads")
public class ActivityThreadController {

    private final ActivityThreadService activityThreadService;

    /**
     * 특정 Activity에 ActivityThread 추가
     * @param activityId 활동 ID
     * @param request 인증 정보 (설명)
     * @param image 인증 이미지 (선택 사항)
     * @return 생성된 ActivityThread 정보 반환
     */
    @PostMapping("")
    @Operation(summary = "활동 인증 추가", description = "특정 활동에 대한 인증 추가")
    public ResponseEntity<DataResponse<ActivityThreadCreateResponse>> createActivityThread(
            @PathVariable Long activityId,
            @Parameter(description = "인증 정보", schema = @Schema(implementation = ActivityThreadCreateRequest.class))
            @RequestPart ActivityThreadCreateRequest request,
            @Parameter(description = "multipart/form-data 형식의 이미지를 input으로 받습니다. key 값은 image입니다.")
            @RequestPart(value = "image", required = false) MultipartFile image) throws ImageException {
        return ResponseEntity.ok(
                DataResponse.from(
                        ActivityThreadCreateResponse.of(
                                activityThreadService.createActivityThread(activityId, request, image)
                        )
                )
        );
    }

    /**
     * 특정 Activity의 ActivityThread 목록 조회 (최신순 페이징)
     * @param activityId 활동 ID
     * @param page 페이지 번호 (기본값: 0)
     * @param size 페이지 크기 (기본값: 10)
     * @return 해당 활동의 인증 목록 반환
     */
    @GetMapping("")
    @Operation(summary = "활동 인증 목록 조회", description = "특정 활동의 인증 내역을 최신순으로 조회")
    public ResponseEntity<DataResponse<ActivityThreadListResponse>> getActivityThreads(
            @PathVariable Long activityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(
                DataResponse.from(activityThreadService.getActivityThreads(activityId, page, size))
        );
    }
}
