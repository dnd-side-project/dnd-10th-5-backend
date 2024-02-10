package com.dnd.favolink.global.error.exception;

import com.dnd.favolink.global.common.response.ErrorResponse;
import com.dnd.favolink.global.error.code.ErrorCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;
    private List<ErrorResponse.CustomFieldError> errors = new ArrayList<>();

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, List<ErrorResponse.CustomFieldError> errors) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
