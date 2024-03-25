package com.dnd.favolink.domain.auth.dto.request;

import com.dnd.favolink.domain.user.entity.LoginType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SignUpRequest(@NotBlank String oauthId,
                            @NotBlank String nickname,
                            @NotBlank String profileImg,
                            @NotNull LoginType loginType) {
}
