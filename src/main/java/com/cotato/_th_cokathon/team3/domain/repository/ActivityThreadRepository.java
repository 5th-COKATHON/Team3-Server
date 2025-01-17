package com.cotato._th_cokathon.team3.domain.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cotato._th_cokathon.team3.domain.entity.ActivityThread;

/**
 * ActivityThread Repository
 * - ActivityThread 데이터베이스 연동을 위한 JPA Repository
 */
public interface ActivityThreadRepository extends JpaRepository<ActivityThread, Long> {
    List<ActivityThread> findByActivityIdOrderByCreatedAtDesc(Long activityId, Pageable pageable);
}