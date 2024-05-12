package tn.pi.studentmanagement.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.studentmanagement.services.TagService;
import tn.pi.studentmanagement.tools.dtos.request.TagRequest;
import tn.pi.studentmanagement.tools.dtos.response.TagResponse;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/tag")
public class TagController {


    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TagResponse>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTag());
    }

    @PostMapping("/create")
    public ResponseEntity<TagResponse> createNewTag(@RequestBody TagRequest tagRequest) {
        return ResponseEntity.ok(tagService.createTag(tagRequest));
    }
}
