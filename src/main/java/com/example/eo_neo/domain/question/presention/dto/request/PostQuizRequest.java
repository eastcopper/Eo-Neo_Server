package com.example.eo_neo.domain.question.presention.dto.request;

import com.example.eo_neo.domain.user.domain.QuestionCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostQuizRequest {
    @NotNull
    private QuestionCategory category;

    @NotNull
    private String problem;

    @NotNull
    private List<String> answer;

    @NotNull
    private String correct;
}
