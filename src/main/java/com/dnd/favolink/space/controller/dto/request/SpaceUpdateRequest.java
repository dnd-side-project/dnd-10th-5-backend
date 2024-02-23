package com.dnd.favolink.space.controller.dto.request;

public record SpaceUpdateRequest(
        int spaceId,
        String name,
        String color
) {
}
