package com.dnd.favolink.bookmark.controller;

import java.util.List;

public record BookmarksResponse(
        List<Integer> linksId
) {
}
