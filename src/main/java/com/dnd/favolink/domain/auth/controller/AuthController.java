package com.dnd.favolink.domain.auth.controller;

import com.dnd.favolink.domain.auth.dto.request.SignUpRequest;
import com.dnd.favolink.domain.auth.dto.response.LoginResponse;
import com.dnd.favolink.domain.auth.dto.request.RefreshRequest;
import com.dnd.favolink.domain.auth.dto.response.TokenResponse;
import com.dnd.favolink.domain.auth.service.AuthService;
import com.dnd.favolink.domain.auth.service.KakaoService;
import com.dnd.favolink.global.common.response.BaseResponse;
import com.dnd.favolink.global.common.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "🔐 Auth")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final KakaoService kakaoService;

    @Operation(summary = "🔐 카카오로그인", description = "카카오 인가코드를 전달합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "access, refresh 토큰"),
            @ApiResponse(responseCode = "500", description = "code: A-000 | message: 카카오 유저 정보를 받아오는데 실패했습니다.",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/kakao-login")
    public ResponseEntity<LoginResponse> kakaoLogin(@RequestParam String code) {
        LoginResponse loginResponse = kakaoService.kakaoLogin(code);
        return BaseResponse.ok(loginResponse);
    }

    @Operation(summary = "🔐 회원가입", description = "신규회원인 경우 회원가입을 수행합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "access, refresh 토큰"),
            @ApiResponse(responseCode = "400", description = "code: A-001 | message: 이미 존재하는 유저입니다.",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PostMapping("/sign-up")
    public ResponseEntity<TokenResponse> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        TokenResponse tokenResponse = authService.signUp(signUpRequest);
        return BaseResponse.ok(tokenResponse);
    }

    @Operation(summary = "🔐 토큰 리프레시", description = "refresh 토큰을 통해 access, refresh 토큰을 재발급합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "access, refresh 토큰"),
            @ApiResponse(responseCode = "400", description = "code: J-000 | message: 유효하지 않은 jwt 토큰입니다. <br>" +
                    "code: J-001 | message: 만료된 jwt 토큰입니다. <br>" +
                    "code: J-002 | message: 토큰을 갱신할 수 없습니다. <br>" +
                    "code: J-003 | message: 토큰이 필요합니다.",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@RequestBody @Valid RefreshRequest refreshRequest) {
        TokenResponse tokenResponse = authService.refresh(refreshRequest);
        return BaseResponse.ok(tokenResponse);
    }

    @Operation(summary = "🔐 로그아웃")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그아웃 성공")
    })
    @GetMapping("/logout")
    public ResponseEntity<String> logout(@AuthenticationPrincipal Long userId) {
        authService.logout(userId);
        return BaseResponse.ok("로그아웃 성공");
    }
}
