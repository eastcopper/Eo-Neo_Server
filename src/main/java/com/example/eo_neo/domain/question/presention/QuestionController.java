package com.example.eo_neo.domain.question.presention;

import com.example.eo_neo.domain.question.presention.dto.request.PostQuizRequest;
import com.example.eo_neo.domain.question.presention.dto.response.GetQuizResponse;
import com.example.eo_neo.domain.question.service.GetQuizService;
import com.example.eo_neo.domain.question.service.PostQuizService;
import com.example.eo_neo.domain.question.service.PutCorrect;
import com.example.eo_neo.domain.user.domain.QuestionCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuestionController {

    private final GetQuizService getQuizService;
    private final PostQuizService postQuizService;
    private final PutCorrect putCorrect;

    @GetMapping("/{id}")
    public List<GetQuizResponse> getQuiz(@PathVariable QuestionCategory id) {
        return getQuizService.execute(id);
    }

    @PostMapping
    public void postQuiz(@RequestBody PostQuizRequest request) {
        postQuizService.execute(request);
    }

    @PutMapping("/{id}")
    public void Correct(@PathVariable QuestionCategory id) {
        putCorrect.execute(id);
    }
}
