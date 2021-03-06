package com.efub.efubtwitterteam3.service;

import com.efub.efubtwitterteam3.domain.PostRepository;
import com.efub.efubtwitterteam3.domain.User;
import com.efub.efubtwitterteam3.domain.UserRepository;
import com.efub.efubtwitterteam3.dto.PostGetResponseDto;
import com.efub.efubtwitterteam3.dto.UserRequestDto;
import com.efub.efubtwitterteam3.dto.UserResponseDto;
import com.efub.efubtwitterteam3.service.error.CustomException;
import com.efub.efubtwitterteam3.service.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

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

        entity.updateProfile(req.getNickname(), req.getIdentifier(), req.getBio());

        userRepository.save(entity);
        return new UserResponseDto(entity);  // 변경된 유저의 정보를 반환
    }

    @Transactional
    public List<PostGetResponseDto> findPostsByUser(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        return postRepository.findUserPostsCustomResponse(entity);
    }
}
