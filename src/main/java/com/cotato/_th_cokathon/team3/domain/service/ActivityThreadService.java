package com.cotato._th_cokathon.team3.domain.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cotato._th_cokathon.team3.api.dto.request.ActivityThreadCreateRequest;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityThreadListResponse;
import com.cotato._th_cokathon.team3.api.dto.response.ActivityThreadResponse;
import com.cotato._th_cokathon.team3.common.exception.ImageException;
import com.cotato._th_cokathon.team3.common.util.S3Uploader;
import com.cotato._th_cokathon.team3.domain.entity.Activity;
import com.cotato._th_cokathon.team3.domain.entity.ActivityThread;
import com.cotato._th_cokathon.team3.domain.repository.ActivityRepository;
import com.cotato._th_cokathon.team3.domain.repository.ActivityThreadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityThreadService {
    private final ActivityThreadRepository activityThreadRepository;
    private final ActivityRepository activityRepository;
    private final S3Uploader s3Uploader;
    private static final String ACTIVITY_THREAD_FOLDER_NAME = "activity-thread";

    @Transactional
    public Long createActivityThread(Long activityId, ActivityThreadCreateRequest request, MultipartFile image) throws
		ImageException {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        // 인증 추가 시 참가자 수 증가
        activity.incrementParticipantCount();
        activityRepository.save(activity);

        String imageUrl = image != null ? s3Uploader.uploadFile(image, ACTIVITY_THREAD_FOLDER_NAME) : null;

        ActivityThread thread = ActivityThread.builder()
                .activity(activity)
                .description(request.description())
                .imageUrl(imageUrl)
                .build();

        return activityThreadRepository.save(thread).getId();
    }

    @Transactional(readOnly = true)
    public ActivityThreadListResponse getActivityThreads(Long activityId, int page, int size) {
        List<ActivityThread> threads = activityThreadRepository.findByActivityIdOrderByCreatedAtDesc(activityId, PageRequest.of(page, size));
        return ActivityThreadListResponse.from(threads.stream().map(ActivityThreadResponse::from).toList());
    }
}