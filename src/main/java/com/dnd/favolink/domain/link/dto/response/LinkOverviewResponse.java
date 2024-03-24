package com.dnd.favolink.domain.link.dto.response;

public record LinkOverviewResponse(
        String name,
        String url,
        String imageUrl,
        String spaceName,
        String folderName
) {
}
