package com.dnd.favolink.global.s3;

import com.dnd.favolink.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "🏞️ AWS S3")
@RequiredArgsConstructor
@RestController
@RequestMapping("/s3")
public class S3Controller {

    private final S3Service s3Service;

    @Operation(summary = "🏞️ presigned url 발급", description = "이미지 업로드를 위한 s3 presigned url 을 발급합니다. url 의 유효시간은 2분입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "presigned url")
    })
    @GetMapping("/presigned-url")
    public ResponseEntity<String> getPresignedUrl(@RequestParam @Schema(description = "확장자 포함 파일명") String fileName,
                                                  @RequestParam @Schema(description = "이미지 카테고리 | 가능한 값: PROFILE_IMAGE") S3Category s3Category) {
        String presignedUrl = s3Service.getPresignedUrl(fileName, s3Category);
        return BaseResponse.ok(presignedUrl);
    }
}
