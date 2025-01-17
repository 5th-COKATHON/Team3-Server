package com.cotato._th_cokathon.team3.common.exception;

import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageException extends IOException {
	private ErrorCode errorCode;
}