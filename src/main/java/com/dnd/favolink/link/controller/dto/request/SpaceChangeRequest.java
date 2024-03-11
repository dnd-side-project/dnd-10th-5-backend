package com.dnd.favolink.link.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record SpaceChangeRequest(
        @Schema(description = "이동시킬 링크들 id")
        List<Integer> links,
        @Schema(description = "이동시킬 저장소")
        int targetSpaceId
) {
}
