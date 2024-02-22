package com.dnd.favolink.space.controller;

import com.dnd.favolink.space.controller.dto.request.SpaceCreateRequest;
import com.dnd.favolink.space.controller.dto.request.SpaceUpdateRequest;
import com.dnd.favolink.space.controller.dto.response.SpacesResponse;
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
@RequestMapping("/spaces")
public class SpaceController {
    @GetMapping
    public ResponseEntity<SpacesResponse> getSpaces() {
        return null;
    }

    @PostMapping
    public void createSpace(@RequestBody SpaceCreateRequest request) {

    }

    @PutMapping
    public void updateSpace(@RequestBody SpaceUpdateRequest request) {

    }

    @DeleteMapping
    public void deleteSpace(@RequestParam int spaceId) {

    }
}
