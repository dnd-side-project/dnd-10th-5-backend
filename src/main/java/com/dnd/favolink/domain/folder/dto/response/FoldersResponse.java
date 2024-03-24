package com.dnd.favolink.domain.folder.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public record FoldersResponse(
        @Schema(description = "해당 스페이스 내부에 존재하는 폴더 목록")
        List<FolderResponse> responses
) {
}
