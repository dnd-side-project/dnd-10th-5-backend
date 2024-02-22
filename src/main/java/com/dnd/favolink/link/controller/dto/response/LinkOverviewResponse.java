package com.dnd.favolink.link.controller.dto.response;

public record LinkOverviewResponse(
        String name,
        String url,
        String imageUrl,
        String spaceName,
        String folderName
) {
}
