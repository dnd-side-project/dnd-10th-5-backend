package com.dnd.favolink.folder.controller;

import com.dnd.favolink.folder.controller.dto.response.FoldersResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/folder")
public class FolderController {
    @GetMapping
    public ResponseEntity<FoldersResponse> getFoldersBySpace(@RequestParam int spaceId) {
        return null;
    }

    @PostMapping
    public void createFolder(@RequestParam String name) {

    }

    @PutMapping
    public void updateFolder(@RequestParam String name) {

    }
}
