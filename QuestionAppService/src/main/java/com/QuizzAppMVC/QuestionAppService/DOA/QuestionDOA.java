package com.QuizzAppMVC.QuestionAppService.DOA;

import com.QuizzAppMVC.QuestionAppService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDOA extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
    @Query(value = "SELECT q.Id FROM question q WHERE category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)


    List<Integer> findRAndomQuestionsByCategory(String category, int numQ);
}
