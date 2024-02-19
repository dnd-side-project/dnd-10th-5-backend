package com.dnd.favolink.domain.auth.service;

import com.dnd.favolink.domain.auth.dto.request.SignUpRequest;
import com.dnd.favolink.domain.auth.dto.response.TokenResponse;
import com.dnd.favolink.domain.auth.error.AuthErrorCode;
import com.dnd.favolink.domain.user.entity.LoginType;
import com.dnd.favolink.domain.user.entity.User;
import com.dnd.favolink.domain.user.repository.UserRepository;
import com.dnd.favolink.global.error.exception.BusinessException;
import com.dnd.favolink.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public TokenResponse signUp(SignUpRequest signUpRequest) {
        String oauthId = signUpRequest.oauthId();
        String nickname = signUpRequest.nickname();
        String profileImg = signUpRequest.profileImg();
        LoginType loginType = signUpRequest.loginType();

        User user = userRepository.findByOauthIdAndLoginType(oauthId, loginType).orElse(null);

        if (user != null) {
            throw new BusinessException(AuthErrorCode.USER_ALREADY_EXISTS);
        }

        user = userRepository.save(User.builder()
                                            .oauthId(oauthId)
                                            .nickname(nickname)
                                            .profileImg(profileImg)
                                            .loginType(loginType)
                                            .build());

        String accessToken = jwtTokenProvider.createAccessToken(user.getId());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getId());
        return new TokenResponse(accessToken, refreshToken);
    }
}
