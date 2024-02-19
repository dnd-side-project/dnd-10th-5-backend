package com.dnd.favolink.domain.auth.dto.request;

import com.dnd.favolink.domain.user.entity.LoginType;

public record SignUpRequest(String oauthId, String nickname, String profileImg, LoginType loginType) {
}
