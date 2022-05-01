package com.efub.efubtwitterteam3.dto;

import com.efub.efubtwitterteam3.domain.Post;
import com.efub.efubtwitterteam3.domain.User;
import com.efub.efubtwitterteam3.domain.UserRepository;
import com.efub.efubtwitterteam3.service.error.CustomException;
import com.efub.efubtwitterteam3.service.error.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private Long userId;
    private LocalDateTime date;
    private String content;

    @Builder
    public PostRequestDto(Post post){
        this.userId = post.getUser().getId();
        this.date = post.getDate();
        this.content = post.getContent();
    }

    public Post toEntity(UserRepository userRepository) {
        return Post.builder()
                .user(userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND)))
                .date(date)
                .content(content)
                .build();
    }
}
