package com.example.eo_neo.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(uniqueConstraints = @UniqueConstraint(
        name = "kimunil",
        columnNames = { "account_id" }
))
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, name = "account_id")
    private String accountId;
    private String password;
    private String nickName;

    @Builder
    public User (String accountId, String password, String nickName) {
        this.accountId = accountId;
        this.password = password;
        this.nickName = nickName;
    }
}
