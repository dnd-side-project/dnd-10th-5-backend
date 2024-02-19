package com.dnd.favolink.domain.auth.controller;

import com.dnd.favolink.domain.auth.dto.request.SignUpRequest;
import com.dnd.favolink.domain.auth.dto.response.LoginResponse;
import com.dnd.favolink.domain.auth.dto.request.RefreshRequest;
import com.dnd.favolink.domain.auth.dto.response.TokenResponse;
import com.dnd.favolink.domain.auth.service.AuthService;
import com.dnd.favolink.domain.auth.service.KakaoService;
import com.dnd.favolink.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final KakaoService kakaoService;

    @GetMapping("/kakao-login")
    public ResponseEntity<LoginResponse> kakaoLogin(@RequestParam String code) {
        LoginResponse loginResponse = kakaoService.kakaoLogin(code);
        return BaseResponse.ok(loginResponse);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<TokenResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        TokenResponse tokenResponse = authService.signUp(signUpRequest);
        return BaseResponse.ok(tokenResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@RequestBody RefreshRequest refreshRequest) {
        TokenResponse tokenResponse = authService.refresh(refreshRequest);
        return BaseResponse.ok(tokenResponse);
    }
}
