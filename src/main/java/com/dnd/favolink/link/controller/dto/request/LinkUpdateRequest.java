package com.dnd.favolink.link.controller.dto.request;

public record LinkUpdateRequest(
        int linkId,
        String url,
        String name,
        String content,
        String imageUrl
) {
}
