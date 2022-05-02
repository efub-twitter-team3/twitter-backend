package com.efub.efubtwitterteam3.domain;

import com.efub.efubtwitterteam3.dto.PostGetResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p")
    List<PostGetResponseDto> findPostsCustomResponse();
}
