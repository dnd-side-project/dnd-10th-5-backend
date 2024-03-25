package com.dnd.favolink.global.error.handler;

import com.dnd.favolink.global.common.response.ErrorResponse;
import com.dnd.favolink.global.error.code.CommonErrorCode;
import com.dnd.favolink.global.error.code.ErrorCode;
import com.dnd.favolink.global.error.exception.BusinessException;
import com.dnd.favolink.global.jwt.error.CustomJwtException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("BindException", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.INVALID_INPUT_VALUE, e.getConstraintViolations());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("MethodArgumentTypeMismatchException", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.TYPE_MISMATCH, e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> handleException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.MISSING_REQUEST_PARAMS, e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e) {
        log.error("NullPointerException", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.NULL_POINT, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.error("BusinessException", e);
        ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    @ExceptionHandler(CustomJwtException.class)
    protected ResponseEntity<ErrorResponse> handleJwtException(CustomJwtException e) {
        log.error("CustomJwtException", e);
        ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Internal Server Error", e);
        final ErrorResponse response = ErrorResponse.of(CommonErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
