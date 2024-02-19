package com.dnd.favolink.domain.auth.controller;

import com.dnd.favolink.domain.auth.dto.response.LoginResponse;
import com.dnd.favolink.domain.auth.service.KakaoService;
import com.dnd.favolink.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final KakaoService kakaoService;

    @GetMapping("/kakao-login")
    public ResponseEntity<LoginResponse> kakaoLogin(@RequestParam String code) {
        LoginResponse loginResponse = kakaoService.kakaoLogin(code);
        return BaseResponse.ok(loginResponse);
    }
}
