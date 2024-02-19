package com.dnd.favolink.global.jwt;

import com.dnd.favolink.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum JwtErrorCode implements ErrorCode {

    INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "J-000", "유효하지 않은 refresh 토큰 입니다.");

    private HttpStatus status;
    private String code;
    private String message;
}
