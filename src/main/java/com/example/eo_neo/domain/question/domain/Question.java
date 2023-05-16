package com.example.eo_neo.domain.question.domain;

import com.example.eo_neo.domain.user.domain.QuestionCategory;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private QuestionCategory category;

    @Column(nullable = false, length = 1023)
    private String problem;

    @Column(nullable = false)
    @ElementCollection
    private List<String> answer;

    @Column(nullable = false)
    private String correct;
}
