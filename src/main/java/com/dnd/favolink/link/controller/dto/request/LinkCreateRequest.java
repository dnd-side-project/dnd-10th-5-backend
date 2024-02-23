package com.dnd.favolink.link.controller.dto.request;

public record LinkCreateRequest(
        int spaceId,
        int folderId,
        String url,
        String name,
        String content,
        String imageUrl
) {
}
