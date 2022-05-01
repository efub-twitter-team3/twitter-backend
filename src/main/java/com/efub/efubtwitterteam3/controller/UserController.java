package com.efub.efubtwitterteam3.controller;

import com.efub.efubtwitterteam3.dto.UserResponseDto;
import com.efub.efubtwitterteam3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDto findById(@PathVariable Long userId){
        return userService.findById(userId);
    }
}
