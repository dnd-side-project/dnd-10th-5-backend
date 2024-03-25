package com.dnd.favolink.domain.auth.feign;

import com.dnd.favolink.domain.auth.dto.kakao.KakaoInfo;
import com.dnd.favolink.domain.auth.dto.kakao.KakaoToken;
import com.dnd.favolink.global.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "kakaoClient", configuration = FeignConfig.class)
public interface KakaoFeignClient {
    @PostMapping
    KakaoInfo getInfo(URI baseUrl, @RequestHeader("Authorization") String accessToken);

    @PostMapping
    KakaoToken getToken(URI baseUrl, @RequestParam("client_id") String restApiKey,
                        @RequestParam("redirect_uri") String redirectUrl,
                        @RequestParam("code") String code,
                        @RequestParam("grant_type") String grantType);
}
