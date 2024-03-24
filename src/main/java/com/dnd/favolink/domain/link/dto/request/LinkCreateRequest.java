package com.dnd.favolink.domain.link.dto.request;

public record LinkCreateRequest(
        int spaceId,
        int folderId,
        String url,
        String name,
        String content,
        String imageUrl
) {
}
