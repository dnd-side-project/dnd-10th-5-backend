package com.dnd.favolink.domain.auth.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(@Schema(description = "신규 유저 여부") Boolean isNewUser,
                            @Schema(description = "신규 유저일 경우 카카오 유저 정보 반환") UserInfoResponse userInfoResponse,
                            @Schema(description = "기존 유저일 경우 토큰 반환") TokenResponse tokenResponse) {
}
