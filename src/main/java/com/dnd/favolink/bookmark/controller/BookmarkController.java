package com.dnd.favolink.bookmark.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {
    @GetMapping
    public BookmarksResponse getBookmarks() {
        return null;
    }

    @PostMapping
    public void addBookmark(@RequestParam int linkId) {

    }

    @DeleteMapping
    public void deleteBookmark(@RequestParam int linkId) {

    }
}
