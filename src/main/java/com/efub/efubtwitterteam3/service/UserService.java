package com.efub.efubtwitterteam3.service;

import com.efub.efubtwitterteam3.domain.User;
import com.efub.efubtwitterteam3.domain.UserRepository;
import com.efub.efubtwitterteam3.dto.UserRequestDto;
import com.efub.efubtwitterteam3.dto.UserResponseDto;
import com.efub.efubtwitterteam3.service.error.CustomException;
import com.efub.efubtwitterteam3.service.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto findById(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto req){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        // patch 부분 수정
        if(req.getNickname() != null)
            entity.setNickname(req.getNickname());
        if(req.getIdentifier() != null)
            entity.setIdentifier(req.getIdentifier());
        if(req.getBio() != null)
            entity.setBio(req.getBio());

        userRepository.save(entity);
        return new UserResponseDto(entity);  // 변경된 유저의 정보를 반환
    }
}
