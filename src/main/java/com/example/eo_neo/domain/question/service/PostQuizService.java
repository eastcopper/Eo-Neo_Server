package com.example.eo_neo.domain.question.service;

import com.example.eo_neo.domain.question.domain.Question;
import com.example.eo_neo.domain.question.domain.repository.QuestionRepository;
import com.example.eo_neo.domain.question.presention.dto.request.PostQuizRequest;
import com.example.eo_neo.domain.user.domain.QuestionCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQuizService {

    private final QuestionRepository questionRepository;

    public void execute(PostQuizRequest request) {
        questionRepository.save(new Question(request.getCategory(), request.getProblem(), request.getAnswer(), request.getCorrect())
        );
    }
}
