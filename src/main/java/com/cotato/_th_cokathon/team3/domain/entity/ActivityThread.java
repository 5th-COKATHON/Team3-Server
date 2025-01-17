package com.cotato._th_cokathon.team3.domain.entity;

import com.cotato._th_cokathon.team3.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity_thread")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ActivityThread extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_id", nullable = false)
	private Activity activity;

	@Column(name = "description")
	private String description;

	@Column(name = "image_url")
	private String imageUrl;

	@Builder
	public ActivityThread(Activity activity, String description, String imageUrl) {
		this.activity = activity;
		this.description = description;
		this.imageUrl = imageUrl;
	}
}
