package com.dnd.favolink.link.controller;

import com.dnd.favolink.global.common.response.BaseResponse;
import com.dnd.favolink.link.controller.dto.request.LinkDetailRequest;
import com.dnd.favolink.link.controller.dto.response.LinkDetailResponse;
import com.dnd.favolink.link.controller.dto.response.LinkOverviewResponse;
import com.dnd.favolink.link.controller.dto.response.LinksResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/link")
public class LinkController {
    @GetMapping
    public LinkDetailResponse getLink(@RequestParam int linkId) {
        return null;
    }

    @GetMapping("/space")
    public ResponseEntity<LinksResponse> getLinksOfSpace(@RequestParam int spaceId) {
        return null;
    }

    @GetMapping("/folder")
    public ResponseEntity<LinksResponse> getLinksOfFolder(@RequestParam int folderId) {
        return null;
    }

    @PostMapping
    public void uploadLink(@RequestBody LinkDetailRequest linkDetailRequest) {

    }

    @DeleteMapping
    public void deleteLink(@RequestParam int linkId) {

    }
}
