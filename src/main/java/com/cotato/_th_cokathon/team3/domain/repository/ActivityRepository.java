package com.cotato._th_cokathon.team3.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cotato._th_cokathon.team3.domain.entity.Activity;
import com.cotato._th_cokathon.team3.domain.enums.Category;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	Page<Activity> findAllByCategory(Category category, PageRequest pageRequest);
}