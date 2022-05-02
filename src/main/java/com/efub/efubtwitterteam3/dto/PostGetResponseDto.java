package com.efub.efubtwitterteam3.dto;

import com.efub.efubtwitterteam3.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostGetResponseDto {
    private Long postId;
    private UserResponseDto user;
    private LocalDateTime date;
    private String content;

    public PostGetResponseDto(Post post){
        postId = post.getId();
        user = new UserResponseDto(post.getUser());
        date = post.getDate();
        content = post.getContent();
    }
}
