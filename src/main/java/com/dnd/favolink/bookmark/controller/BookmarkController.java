package com.dnd.favolink.bookmark.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "💟 Bookmark")
@RestController
@RequestMapping("/bookmark")
public class BookmarkController {
    @Operation(summary = "💟 즐겨찾기 조회", description = "유저가 즐겨찾기 해둔 링크들을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저가 즐겨찾기 해둔 링크들의 id 목록")
    })
    @GetMapping
    public BookmarksResponse getBookmarks() {
        return null;
    }

    @Operation(summary = "💟 즐겨찾기 추가", description = "특정 링크를 즐겨찾기에 추가합니다.")
    @PostMapping
    public void addBookmark(@RequestParam int linkId) {

    }

    @Operation(summary = "💟 즐겨찾기 삭제", description = "특정 링크를 즐겨찾기에서 삭제합니다.")
    @DeleteMapping
    public void deleteBookmark(@RequestParam int linkId) {

    }
}
