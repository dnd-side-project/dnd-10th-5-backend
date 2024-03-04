package com.dnd.favolink.domain.auth.dto.response;

import com.dnd.favolink.domain.user.entity.LoginType;

public record UserInfoResponse(String oauthId,
                               String nickname,
                               String profileImg,
                               LoginType loginType) {
}
