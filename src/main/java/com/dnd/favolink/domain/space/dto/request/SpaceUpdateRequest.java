package com.dnd.favolink.domain.space.dto.request;

public record SpaceUpdateRequest(
        int spaceId,
        String name,
        String color
) {
}
