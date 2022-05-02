package com.efub.efubtwitterteam3.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String identifier;

    @Column(length = 255, nullable = true)
    private String bio;

    @Builder
    public User(String nickname, String identifier, String bio){
        this.nickname = nickname;
        this.identifier = identifier;
        this.bio = bio;
    }
}
