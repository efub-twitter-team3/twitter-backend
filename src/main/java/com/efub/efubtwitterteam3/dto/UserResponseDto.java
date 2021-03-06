package com.efub.efubtwitterteam3.dto;

import com.efub.efubtwitterteam3.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String nickname;
    private String identifier;
    private String bio;

    public UserResponseDto(User user){
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.identifier = user.getIdentifier();
        this.bio = user.getBio();
    }
}
