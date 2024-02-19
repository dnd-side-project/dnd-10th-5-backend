package com.dnd.favolink.domain.auth.service;

import com.dnd.favolink.domain.auth.dto.response.LoginResponse;
import com.dnd.favolink.domain.auth.dto.response.TokenResponse;
import com.dnd.favolink.domain.auth.dto.response.UserInfoResponse;
import com.dnd.favolink.domain.auth.dto.kakao.KakaoInfo;
import com.dnd.favolink.domain.auth.dto.kakao.KakaoToken;
import com.dnd.favolink.domain.auth.error.AuthErrorCode;
import com.dnd.favolink.domain.auth.feign.KakaoFeignClient;
import com.dnd.favolink.domain.user.entity.LoginType;
import com.dnd.favolink.domain.user.entity.User;
import com.dnd.favolink.domain.user.repository.UserRepository;
import com.dnd.favolink.global.error.exception.BusinessException;
import com.dnd.favolink.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoFeignClient kakaoFeignClient;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${kakao.auth-url}")
    private String kakaoAuthUrl;
    @Value("${kakao.user-api-url}")
    private String kakaoUserApiUrl;
    @Value("${kakao.restapi-key}")
    private String restapiKey;
    @Value("${kakao.redirect-url}")
    private String redirectUrl;

    @Transactional
    public LoginResponse kakaoLogin(String code) {
        KakaoInfo kakaoInfo = getInfo(code);

        String kakaoId = kakaoInfo.id().toString();
        String nickname = kakaoInfo.kakaoAccount().profile().nickname();
        String profileImg = kakaoInfo.kakaoAccount().profile().profileImageUrl();

        User user = userRepository.findByOauthIdAndLoginType(kakaoId, LoginType.KAKAO).orElse(null);

        if (user == null) {
            return new LoginResponse(true, new UserInfoResponse(kakaoId,nickname,profileImg,LoginType.KAKAO), null);
        }

        String accessToken = jwtTokenProvider.createAccessToken(user.getId());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getId());
        return new LoginResponse(false, null, new TokenResponse(accessToken,refreshToken));
    }

    private KakaoInfo getInfo(String code) {
        KakaoToken token = getToken(code);
        try {
            return kakaoFeignClient.getInfo(new URI(kakaoUserApiUrl), "bearer " + token.accessToken());
        } catch (Exception e) {
            log.error("error while getting kakao user info: ", e);
            throw new BusinessException(AuthErrorCode.KAKAO_ERROR);
        }
    }

    private KakaoToken getToken(String code) {
        try {
            return kakaoFeignClient.getToken(new URI(kakaoAuthUrl), restapiKey, redirectUrl, code, "authorization_code");
        } catch (Exception e) {
            log.error("error while getting kakao user token: ", e);
            throw new BusinessException(AuthErrorCode.KAKAO_ERROR);
        }
    }
}
