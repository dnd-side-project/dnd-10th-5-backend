package com.dnd.favolink.global.jwt.error;

import com.dnd.favolink.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum JwtErrorCode implements ErrorCode {

    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "J-000", "유효하지 않은 jwt 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "J-001", "만료된 jwt 토큰입니다."),
    CANNOT_REFRESH(HttpStatus.BAD_REQUEST, "J-002", "토큰을 갱신할 수 없습니다."),
    EMPTY_TOKEN(HttpStatus.BAD_REQUEST, "J-003", "토큰이 필요합니다.");

    private HttpStatus status;
    private String code;
    private String message;
}