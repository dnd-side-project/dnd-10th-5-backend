package com.dnd.favolink.link.controller.dto.request;

public record LinkDetailRequest(
        String url,
        String name,
        String content,
        String imageUrl
) {
}
