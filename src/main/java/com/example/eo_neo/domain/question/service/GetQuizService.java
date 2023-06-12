package com.example.eo_neo.domain.question.service;

import com.example.eo_neo.domain.question.domain.Question;
import com.example.eo_neo.domain.question.domain.repository.QuestionRepository;
import com.example.eo_neo.domain.question.presention.dto.response.GetQuizResponse;
import com.example.eo_neo.domain.user.domain.QuestionCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetQuizService {

    private final QuestionRepository questionRepository;

    public List<GetQuizResponse> execute(QuestionCategory category) {
        List<Question> question = questionRepository
                .findByCategoryOrderByIdAsc(category);
        List<GetQuizResponse> list = new ArrayList<>();
        for (Question q : question) {
            list.add(new GetQuizResponse(
                    q.getProblem(), q.getAnswer(), q.getCorrect()
            ));
        }
        return list;
    }
}
