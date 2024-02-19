package com.dnd.favolink.domain.auth.dto.response;

public record LoginResponse(Boolean isNewUser, UserInfoResponse userInfoResponse, TokenResponse tokenResponse) {
}
