package com.dnd.favolink.domain.link.dto.response;

import java.util.List;

public record LinksResponse(
        List<LinkOverviewResponse> responses
) {
}
