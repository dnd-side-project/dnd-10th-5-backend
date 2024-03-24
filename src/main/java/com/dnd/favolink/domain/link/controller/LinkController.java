package com.dnd.favolink.domain.link.controller;

import com.dnd.favolink.domain.link.dto.request.LinkDeleteRequest;
import com.dnd.favolink.domain.link.dto.request.LinkCreateRequest;
import com.dnd.favolink.domain.link.dto.request.LinkUpdateRequest;
import com.dnd.favolink.domain.link.dto.request.SpaceChangeRequest;
import com.dnd.favolink.domain.link.dto.response.LinkDetailResponse;
import com.dnd.favolink.domain.link.dto.response.LinksResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "🔗 Link")
@RestController
@RequestMapping("/links")
public class LinkController {
    /**
     * 링크 조회 메서드
     */
    @Operation(summary = "🔗 링크 상세 조회", description = "링크에 대한 상세 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "링크 정보")
    })
    @GetMapping
    public LinkDetailResponse getLink(@PathVariable int linkId) {
        return null;
    }

    @Operation(summary = "🔗 저장소 내부 링크 조회", description = "특정 저장소 내에 존재하는 링크들을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "저장소 내부 링크 목록")
    })
    @GetMapping("/space")
    public ResponseEntity<LinksResponse> getLinksOfSpace(@RequestParam int spaceId) {
        return null;
    }

    @Operation(summary = "🔗 폴더 내부 링크 조회", description = "특정 폴더 내에 존재하는 링크들을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "폴더 내부 링크 목록")
    })
    @GetMapping("/folder")
    public ResponseEntity<LinksResponse> getLinksOfFolder(@RequestParam int folderId) {
        return null;
    }

    @Operation(summary = "🔗 링크 검색", description = "링크 검색 결과를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "검색된 링크 목록")
    })
    @GetMapping("/search")
    public ResponseEntity<LinksResponse> getLinksByInput(@RequestParam String input) {
        return null;
    }

    @Operation(summary = "🔗 리마인드 목록 조회", description = "리마인드 시켜줄 링크들의 목록을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저의 저장소 목록")
    })
    @GetMapping("/remind")
    @Parameter(name = "한 번도 찾지 않은 기간", description = "LEVEL0, LEVEL1, LEVEL2, LEVEL3, LEVEL4로 입력. 소문자 허용")
    public ResponseEntity<LinksResponse> getLinksByPeriodOfNoViewing(@RequestParam String periodOfViewing) {
        return null;
    }

    /**
     * 링크 생성 메서드
     */
    @Operation(summary = "🔗 새로운 링크 추가", description = "새로운 링크를 추가합니다.")
    @PostMapping
    public void uploadLink(@RequestBody LinkCreateRequest linkCreateRequest) {

    }

    /**
     * 링크 수정 메서드
     */
    @Operation(summary = "🔗 링크 수정", description = "기존 링크를 수정합니다.")
    @PutMapping
    public void updateLink(@PathVariable int linkId, @RequestBody LinkUpdateRequest linkUpdateRequest) {

    }

    @Operation(summary = "🔗 저장소 이동", description = "링크들을 다른 저장소로 이동시킵니다.")
    @PutMapping("/change-space")
    public void changeSpace(@RequestBody SpaceChangeRequest spaceChangeRequest) {

    }

    /**
     * 링크 삭제 메서드
     */
    @Operation(summary = "🔗 선택한 링크들 삭제", description = "링크들을 삭제합니다.")
    @DeleteMapping
    public void deleteLink(@RequestBody LinkDeleteRequest linkDeleteRequest) {

    }
}
