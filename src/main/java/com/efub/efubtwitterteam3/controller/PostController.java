package com.efub.efubtwitterteam3.controller;

import com.efub.efubtwitterteam3.dto.PostGetResponseDto;
import com.efub.efubtwitterteam3.dto.PostRequestDto;
import com.efub.efubtwitterteam3.dto.PostResponseDto;
import com.efub.efubtwitterteam3.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public List<PostGetResponseDto> findAll() {
        return postService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto postRequestDto) {
        Long postId = postService.createPost(postRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postId)
                .toUri();

        PostResponseDto postCreateResponseDto = new PostResponseDto(postId, "SUCCESS");

        return ResponseEntity.created(location).body(postCreateResponseDto);
    }

    @GetMapping("/{postId}")
    public PostGetResponseDto findPostById(@PathVariable Long postId){
        return postService.findById(postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostResponseDto> deletePostById(@PathVariable Long postId){
        postService.deleteById(postId);
        PostResponseDto postDeleteResponseDto = new PostResponseDto(postId, "SUCCESS");

        return ResponseEntity.ok().body(postDeleteResponseDto);
    }
}
