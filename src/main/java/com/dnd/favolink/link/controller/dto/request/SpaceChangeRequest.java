package com.dnd.favolink.link.controller.dto.request;

import java.util.List;

public record SpaceChangeRequest(
        List<Integer> links,
        int targetSpaceId
) {
}
