package com.dnd.favolink.space.controller;

import com.dnd.favolink.space.controller.dto.request.SpaceCreateRequest;
import com.dnd.favolink.space.controller.dto.request.SpaceUpdateRequest;
import com.dnd.favolink.space.controller.dto.response.SpacesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "🚀 Space")
@RestController
@RequestMapping("/spaces")
public class SpaceController {
    @Operation(summary = "🚀 저장소 목록 조회", description = "유저의 저장소 목록을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저의 저장소 목록")
    })
    @GetMapping
    public ResponseEntity<SpacesResponse> getSpaces() {
        return null;
    }

    @Operation(summary = "🚀 저장소 생성", description = "저장소를 생성합니다.")
    @PostMapping
    public void createSpace(@RequestBody SpaceCreateRequest request) {

    }

    @Operation(summary = "🚀 저장소 수정", description = "저장소를 수정합니다.")
    @PutMapping
    public void updateSpace(@RequestBody SpaceUpdateRequest request) {

    }

    @Operation(summary = "🚀 저장소 삭제", description = "저장소를 삭제합니다.")
    @DeleteMapping
    public void deleteSpace(@RequestParam int spaceId) {

    }
}
