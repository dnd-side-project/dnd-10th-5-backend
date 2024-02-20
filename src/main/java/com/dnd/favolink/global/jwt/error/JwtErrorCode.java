package com.dnd.favolink.global.jwt.error;

import com.dnd.favolink.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum JwtErrorCode implements ErrorCode {

    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "J-000", "유효하지 않은 jwt 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "J-001", "만료된 jwt 토큰입니다.");

    private HttpStatus status;
    private String code;
    private String message;
}
