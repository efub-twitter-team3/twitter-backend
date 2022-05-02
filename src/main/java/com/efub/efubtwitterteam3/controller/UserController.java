package com.efub.efubtwitterteam3.controller;

import com.efub.efubtwitterteam3.dto.PostGetResponseDto;
import com.efub.efubtwitterteam3.dto.UserRequestDto;
import com.efub.efubtwitterteam3.dto.UserResponseDto;
import com.efub.efubtwitterteam3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDto findById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @PutMapping("/{userId}")
    public UserResponseDto updateUser(@PathVariable Long userId, @RequestBody UserRequestDto req){
        return userService.updateUser(userId, req);
    }

    @GetMapping("/{userId}/posts")
    public List<PostGetResponseDto> findPostsByUser(@PathVariable Long userId){
        return userService.findPostsByUser(userId);
    }
}
