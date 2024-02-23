package com.dnd.favolink.link.controller.dto.response;

import java.util.List;

public record LinksResponse(
        List<LinkOverviewResponse> responses
) {
}
