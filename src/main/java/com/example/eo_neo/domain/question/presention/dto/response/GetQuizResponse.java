package com.example.eo_neo.domain.question.presention.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetQuizResponse {
    private final String problem;

    private final List<String> answer;

    private final String correct;
}
