package com.dnd.favolink.domain.link.dto.request;

public record LinkUpdateRequest(
        String url,
        String name,
        String content,
        String imageUrl
) {
}
