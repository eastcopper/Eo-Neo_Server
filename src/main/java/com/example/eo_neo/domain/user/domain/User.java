package com.example.eo_neo.domain.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Setter
    private int CorrectBasic;

    @Setter
    private int CorrectLanguage;

    @Setter
    private int CorrectConversation;

    @Setter
    private int CorrectWord;

    @Setter
    private String nickName;

    @Column(nullable = false)
    @Fetch(FetchMode.JOIN)
    @ElementCollection
    private List<String> plan;

    public User planAdd(String addString) {
        this.plan.add(addString);
        return this;
    }

    @Builder
    public User(String accountId, String password, String nickName, List<String> plan) {
        this.accountId = accountId;
        this.password = password;
        this.nickName = nickName;
        this.CorrectBasic = 0;
        this.CorrectConversation = 0;
        this.CorrectLanguage = 0;
        this.CorrectWord = 0;
        this.plan = plan;
    }
}
