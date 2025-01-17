package com.cotato._th_cokathon.team3.domain.enums;

import com.cotato._th_cokathon.team3.common.exception.AppException;
import com.cotato._th_cokathon.team3.common.exception.ErrorCode;

public enum Category {
	EXERCISE(1, "Exercise"),
	STUDY(2, "Study"),
	DEVELOPMENT(3, "Development"),
	HOBBY(4, "Hobby"),
	TRAVEL(5, "Travel"),
	HEALTH(6, "Health"),
	CHALLENGE(7, "Challenge"),
	VOLUNTEERING(8, "Volunteering"),
	CULTURE(9, "Culture"),
	COOKING(10, "Cooking");

	private final int id;
	private final String name;

	Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Category fromId(int id) {
		for (Category category : values()) {
			if (category.id == id) {
				return category;
			}
		}
		throw new AppException(ErrorCode.CATEGORY_NOT_FOUND);
	}

	public static Category fromName(String name) {
		for (Category category : values()) {
			if (category.name.equalsIgnoreCase(name)) {
				return category;
			}
		}
		throw new AppException(ErrorCode.CATEGORY_NOT_FOUND);
	}
}