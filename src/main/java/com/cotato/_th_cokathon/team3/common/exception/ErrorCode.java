package com.cotato._th_cokathon.team3.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	IMAGE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 5001, "서버 이미지 처리 실패"),
	MESSAGE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 5002 , "이메일 메시지 처리 실패")
	;

	private final HttpStatus httpStatus;
	private final int code;
	private final String message;
}