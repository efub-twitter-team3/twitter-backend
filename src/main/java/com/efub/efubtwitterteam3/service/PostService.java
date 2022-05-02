package com.efub.efubtwitterteam3.service;

import com.efub.efubtwitterteam3.domain.Post;
import com.efub.efubtwitterteam3.domain.PostRepository;
import com.efub.efubtwitterteam3.domain.User;
import com.efub.efubtwitterteam3.domain.UserRepository;
import com.efub.efubtwitterteam3.dto.PostGetResponseDto;
import com.efub.efubtwitterteam3.dto.PostRequestDto;
import com.efub.efubtwitterteam3.service.error.CustomException;
import com.efub.efubtwitterteam3.service.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<PostGetResponseDto> findAll() {
        return postRepository.findPostsCustomResponse();
    }

    @Transactional
    public PostGetResponseDto findById(Long postId){
        Post entity = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.PAGE_NOT_FOUND));
        PostGetResponseDto postGetResponseDto = new PostGetResponseDto(entity);

        return postGetResponseDto;
    }

    @Transactional
    public void deleteById(Long postId){
        postRepository.delete(
                postRepository.findById(postId)
                        .orElseThrow(() -> new CustomException(ErrorCode.PAGE_NOT_FOUND))
        );
    }
}
