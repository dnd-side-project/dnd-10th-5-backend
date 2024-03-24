package com.dnd.favolink.domain.folder.controller;

import com.dnd.favolink.domain.folder.dto.response.FoldersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "📁 Folder")
@RestController
@RequestMapping("/folder")
public class FolderController {
    @Operation(summary = "📁 저장소 내부의 폴더들 조회", description = "특정 저장소 내에 존재하는 폴더들의 목록을 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "특정 저장소 내부 폴더들의 목록")
    })
    @GetMapping
    public ResponseEntity<FoldersResponse> getFoldersBySpace(@RequestParam int spaceId) {
        return null;
    }

    @Operation(summary = "📁 폴더 생성", description = "특정 저장소 내부에 폴더를 생성합니다.")
    @PostMapping
    public void createFolder(@RequestParam int spaceId, @RequestParam String folderName) {

    }

    @Operation(summary = "📁 폴더 수정", description = "폴더 이름을 수정합니다.")
    @PutMapping
    public void updateFolder(@RequestParam int folderId, @RequestParam String folderName) {

    }

    @Operation(summary = "📁 폴더 삭제", description = "폴더를 삭제합니다.")
    @DeleteMapping
    public void deleteFolder(@RequestParam int folderId) {

    }
}
