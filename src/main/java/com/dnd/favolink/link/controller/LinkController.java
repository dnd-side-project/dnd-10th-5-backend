package com.dnd.favolink.link.controller;

import com.dnd.favolink.link.controller.dto.request.LinkDeleteRequest;
import com.dnd.favolink.link.controller.dto.request.LinkDetailRequest;
import com.dnd.favolink.link.controller.dto.request.SpaceChangeRequest;
import com.dnd.favolink.link.controller.dto.response.LinkDetailResponse;
import com.dnd.favolink.link.controller.dto.response.LinksResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/links")
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

    @PutMapping
    public void updateLink(@RequestBody LinkDetailRequest linkDetailRequest) {

    }

    @PutMapping("/change-space")
    public void changeSpace(@RequestBody SpaceChangeRequest spaceChangeRequest) {

    }

    @DeleteMapping
    public void deleteLink(@RequestBody LinkDeleteRequest linkDeleteRequest) {

    }
}
