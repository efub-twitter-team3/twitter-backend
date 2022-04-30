package com.efub.efubtwitterteam3;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 255, nullable = true)
    private String bio;
}
