package com.dnd.favolink.domain.space.dto.response;

import java.util.List;

public record SpacesResponse(
        List<SpaceResponse> responses
) {
}
