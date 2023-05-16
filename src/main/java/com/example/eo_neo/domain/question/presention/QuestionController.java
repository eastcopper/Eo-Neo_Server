package com.example.eo_neo.domain.question.presention;

import com.example.eo_neo.domain.question.presention.dto.response.GetQuizResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuestionController {

    @GetMapping("/{id}")
    public List<GetQuizResponse> getQuiz(@PathVariable String id) {
        return null;
    }

}
