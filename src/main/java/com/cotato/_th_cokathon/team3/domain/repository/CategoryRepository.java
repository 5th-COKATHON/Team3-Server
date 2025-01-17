package com.cotato._th_cokathon.team3.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotato._th_cokathon.team3.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
