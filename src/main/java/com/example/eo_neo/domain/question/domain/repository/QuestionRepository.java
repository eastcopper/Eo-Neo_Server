package com.example.eo_neo.domain.question.domain.repository;

import com.example.eo_neo.domain.question.domain.Question;
import com.example.eo_neo.domain.user.domain.QuestionCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findByCategoryOrderByIdAsc(QuestionCategory category);
}
