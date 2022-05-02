package com.efub.efubtwitterteam3.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateResponseDto {
    Long postId;
    String message;

    public PostCreateResponseDto(Long postId, String message){
        this.postId = postId;
        this.message = message;
    }
}
