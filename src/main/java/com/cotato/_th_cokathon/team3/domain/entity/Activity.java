package com.cotato._th_cokathon.team3.domain.entity;

import com.cotato._th_cokathon.team3.common.BaseTimeEntity;
import com.cotato._th_cokathon.team3.domain.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Activity extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description")
	private String description;

	@Enumerated(EnumType.STRING)
	private com.cotato._th_cokathon.team3.domain.enums.Category category;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "participant_count", nullable = false)
	private Long participantCount = 0L;

	@Builder
	public Activity(String title, String description, Category category, String imageUrl) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.imageUrl = imageUrl;
	}
}

