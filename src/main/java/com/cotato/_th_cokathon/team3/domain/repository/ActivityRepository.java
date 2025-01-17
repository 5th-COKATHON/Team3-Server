package com.cotato._th_cokathon.team3.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cotato._th_cokathon.team3.domain.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}