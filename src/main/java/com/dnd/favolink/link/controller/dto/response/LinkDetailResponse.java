package com.dnd.favolink.link.controller.dto.response;

public record LinkDetailResponse(
        String url,
        String name,
        String content,
        String imageUrl
) {
}
