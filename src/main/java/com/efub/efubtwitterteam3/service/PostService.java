package com.efub.efubtwitterteam3.service;

import com.efub.efubtwitterteam3.domain.Post;
import com.efub.efubtwitterteam3.domain.PostRepository;
import com.efub.efubtwitterteam3.domain.User;
import com.efub.efubtwitterteam3.domain.UserRepository;
import com.efub.efubtwitterteam3.dto.PostRequestDto;
import com.efub.efubtwitterteam3.service.error.CustomException;
import com.efub.efubtwitterteam3.service.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long createPost(PostRequestDto postRequestDto){
        if(postRequestDto.getContent().isEmpty()){
            throw new CustomException(ErrorCode.CANNOT_EMPTY_CONTENT);
        }

        Post post = postRequestDto.toEntity(userRepository);
        postRepository.save(post);
        return post.getId();
    }
}
