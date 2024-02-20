package com.dnd.favolink.link.controller.dto.request;

import java.util.List;

public record LinkDeleteRequest(
        List<Integer> linkIds
) {
}
