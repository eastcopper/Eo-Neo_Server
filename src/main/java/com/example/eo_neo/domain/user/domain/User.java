package com.example.eo_neo.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Setter
    private String nickName;

    @Builder
    public User (String accountId, String password, String nickName) {
        this.accountId = accountId;
        this.password = password;
        this.nickName = nickName;
    }
}
