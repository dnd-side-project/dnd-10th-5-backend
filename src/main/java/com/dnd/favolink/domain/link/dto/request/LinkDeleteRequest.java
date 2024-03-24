package com.dnd.favolink.domain.link.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record LinkDeleteRequest(
        @Schema(description = "삭제할 링크들 id 목록")
        List<Integer> linkIds
) {
}
