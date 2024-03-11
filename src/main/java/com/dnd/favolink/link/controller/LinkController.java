package com.dnd.favolink.link.controller;

import com.dnd.favolink.link.controller.dto.request.LinkDeleteRequest;
import com.dnd.favolink.link.controller.dto.request.LinkCreateRequest;
import com.dnd.favolink.link.controller.dto.request.LinkUpdateRequest;
import com.dnd.favolink.link.controller.dto.request.SpaceChangeRequest;
import com.dnd.favolink.link.controller.dto.response.LinkDetailResponse;
import com.dnd.favolink.link.controller.dto.response.LinksResponse;
import com.dnd.favolink.link.domain.PeriodOfNoViewing;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkController {
    /**
     * 링크 조회 메서드
     */
    @GetMapping
    public LinkDetailResponse getLink(@PathVariable int linkId) {
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

    @GetMapping("/search")
    public ResponseEntity<LinksResponse> getLinksByInput(@RequestParam String input) {
        return null;
    }

    @GetMapping("/remind")
    @Parameter(name = "한 번도 찾지 않은 기간", description = "LEVEL0, LEVEL1, LEVEL2, LEVEL3, LEVEL4로 입력. 소문자 허용")
    public ResponseEntity<LinksResponse> getLinksByPeriodOfNoViewing(@RequestParam String periodOfViewing) {
        return null;
    }

    /**
     * 링크 생성 메서드
     */
    @PostMapping
    public void uploadLink(@RequestBody LinkCreateRequest linkCreateRequest) {

    }

    /**
     * 링크 수정 메서드
     */
    @PutMapping
    public void updateLink(@PathVariable int linkId, @RequestBody LinkUpdateRequest linkUpdateRequest) {

    }

    @PutMapping("/change-space")
    public void changeSpace(@RequestBody SpaceChangeRequest spaceChangeRequest) {

    }

    /**
     * 링크 삭제 메서드
     */
    @DeleteMapping
    public void deleteLink(@RequestBody LinkDeleteRequest linkDeleteRequest) {

    }
}
