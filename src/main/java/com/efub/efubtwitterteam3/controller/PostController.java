package com.efub.efubtwitterteam3.controller;

import com.efub.efubtwitterteam3.domain.Post;
import com.efub.efubtwitterteam3.dto.PostRequestDto;
import com.efub.efubtwitterteam3.dto.PostResponseDto;
import com.efub.efubtwitterteam3.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto postRequestDto) {
        Long postId = postService.createPost(postRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postId)
                .toUri();

        PostResponseDto postResponseDto = new PostResponseDto(postId, "SUCCESS");
        return ResponseEntity.created(location).body(postResponseDto);
    }
}
