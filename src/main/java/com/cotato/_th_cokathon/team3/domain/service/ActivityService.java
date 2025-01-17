package com.cotato._th_cokathon.team3.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cotato._th_cokathon.team3.api.dto.request.ActivityCreateRequest;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityListResponse;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityResponse;
import com.cotato._th_cokathon.team3.common.exception.ImageException;
import com.cotato._th_cokathon.team3.common.util.S3Uploader;
import com.cotato._th_cokathon.team3.domain.entity.Activity;
import com.cotato._th_cokathon.team3.domain.enums.Category;
import com.cotato._th_cokathon.team3.domain.repository.ActivityRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ActivityService {

	private final ActivityRepository activityRepository;
	private final S3Uploader s3Uploader;
	private static final String ACTIVITY_FOLDER_NAME = "activity";

	public ActivityListResponse findActivities(int page, int size, String sort, String filter) {
		Sort sortOption = createSort(sort);
		PageRequest pageRequest = PageRequest.of(page, size, sortOption);

		Page<Activity> activityPage;
		if ("all".equalsIgnoreCase(filter)) {
			// 필터가 "all"이면 모든 데이터 반환
			activityPage = activityRepository.findAll(pageRequest);
		} else {
			// 필터 값으로 Category enum 매핑
			Category category = Category.fromName(filter);
			activityPage = activityRepository.findAllByCategory(category, pageRequest);
		}

		return ActivityListResponse.from(
			activityPage.stream()
				.map(ActivityResponse::from)
				.toList()
		);
	}

	private Sort createSort(String filter) {
		if ("count".equalsIgnoreCase(filter)) {
			return Sort.by(Sort.Direction.DESC, "participantCount");
		}
		// 기본값: time (createdAt 기준 최신순 정렬)
		return Sort.by(Sort.Direction.DESC, "createdAt");
	}

	@Transactional
	public Long createActivity(ActivityCreateRequest request, MultipartFile image) throws ImageException {
		String imageUrl = s3Uploader.uploadFile(image, ACTIVITY_FOLDER_NAME);

		Activity build = Activity.builder()
			.title(request.title())
			.description(request.description())
			.category(Category.fromName(request.category()))
			.imageUrl(imageUrl)
			.build();

		return activityRepository.save(build).getId();
	}
}