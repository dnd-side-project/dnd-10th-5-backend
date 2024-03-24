package com.dnd.favolink.domain.bookmark.dto.response;

import java.util.List;

public record BookmarksResponse(
        List<Integer> linksId
) {
}
