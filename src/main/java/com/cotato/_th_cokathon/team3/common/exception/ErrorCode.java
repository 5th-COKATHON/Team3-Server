package com.cotato._th_cokathon.team3.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	IMAGE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "서버 이미지 처리 실패", "I-001"),
	MESSAGE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "이메일 메시지 처리 실패", "I-002"),

	//File
	FILE_EXTENSION_FAULT(HttpStatus.BAD_REQUEST, "해당 파일 확장자 명이 존재하지 않습니다.", "F-001"),
	FILE_IS_EMPTY(HttpStatus.BAD_REQUEST, "파일이 비어있습니다", "F-002"),

	//500
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부에서 에러가 발생하였습니다.", "COMMON-002");

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}