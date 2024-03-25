package com.dnd.favolink.domain.auth.error;

import com.dnd.favolink.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorCode {
    KAKAO_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"A-000","카카오 유저 정보를 받아오는데 실패했습니다."),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "A-001", "이미 존재하는 유저입니다.");

    private HttpStatus status;
    private String code;
    private String message;
}
