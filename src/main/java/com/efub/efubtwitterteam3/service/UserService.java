package com.efub.efubtwitterteam3.service;

import com.efub.efubtwitterteam3.domain.User;
import com.efub.efubtwitterteam3.domain.UserRepository;
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
}
