package com.dnd.favolink.domain.auth.service;

import com.dnd.favolink.domain.auth.dto.request.RefreshRequest;
import com.dnd.favolink.domain.auth.dto.request.SignUpRequest;
import com.dnd.favolink.domain.auth.dto.response.TokenResponse;
import com.dnd.favolink.domain.auth.error.AuthErrorCode;
import com.dnd.favolink.domain.user.entity.LoginType;
import com.dnd.favolink.domain.user.entity.User;
import com.dnd.favolink.domain.user.repository.UserRepository;
import com.dnd.favolink.global.error.exception.BusinessException;
import com.dnd.favolink.global.jwt.JwtErrorCode;
import com.dnd.favolink.global.jwt.JwtTokenProvider;
import com.dnd.favolink.global.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dnd.favolink.global.redis.RedisPrefix.REFRESH_TOKEN;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisService redisService;
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
        return createTokens(user.getId());
    }

    public TokenResponse refresh(RefreshRequest refreshRequest) {
        String token = refreshRequest.refreshToken();
        validateToken(token);
        Long userId = jwtTokenProvider.getUserId(token);
        validateTokenComparingRedis(token, userId);
        return createTokens(userId);
    }

    private TokenResponse createTokens(Long userId) {
        String accessToken = jwtTokenProvider.createAccessToken(userId);
        String refreshToken = jwtTokenProvider.createRefreshToken(userId);
        return new TokenResponse(accessToken, refreshToken);
    }

    private void validateToken(String token) {
        if (token == null || !jwtTokenProvider.validateToken(token)) {
            throw new BusinessException(JwtErrorCode.INVALID_REFRESH_TOKEN);
        }
    }

    private void validateTokenComparingRedis(String token, Long userId) {
        if (!redisService.hasKey(REFRESH_TOKEN, userId.toString())) {
            throw new BusinessException(JwtErrorCode.INVALID_REFRESH_TOKEN);
        }

        String redisToken = redisService.get(REFRESH_TOKEN, userId.toString());
        if (!redisToken.equals(token)) {
            throw new BusinessException(JwtErrorCode.INVALID_REFRESH_TOKEN);
        }
    }
}
