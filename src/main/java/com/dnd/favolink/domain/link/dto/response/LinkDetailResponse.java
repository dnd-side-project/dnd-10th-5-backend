package com.dnd.favolink.domain.link.dto.response;

public record LinkDetailResponse(
        String url,
        String name,
        String content,
        String imageUrl
) {
}
