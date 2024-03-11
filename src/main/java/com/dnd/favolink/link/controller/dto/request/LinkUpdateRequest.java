package com.dnd.favolink.link.controller.dto.request;

public record LinkUpdateRequest(
        String url,
        String name,
        String content,
        String imageUrl
) {
}
