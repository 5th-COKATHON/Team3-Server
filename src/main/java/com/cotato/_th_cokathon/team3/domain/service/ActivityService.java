package com.cotato._th_cokathon.team3.domain.service;

import java.util.List;

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
import com.cotato._th_cokathon.team3.domain.repository.CategoryRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ActivityService {

	private final ActivityRepository activityRepository;
	private final CategoryRepository categoryRepository;
	private final S3Uploader s3Uploader;
	private static final String ACTIVITY_FOLDER_NAME = "activity";

	public ActivityListResponse findActivities() {
		List<Activity> activities = activityRepository.findAll();
		return ActivityListResponse.from(
			activities
				.stream()
				.map(ActivityResponse::from)
				.toList()
		);
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