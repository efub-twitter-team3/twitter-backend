package com.efub.efubtwitterteam3.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
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

}
