package com.example.quizzservice.service;

import com.example.quizzservice.DOA.QuizDoa;
import com.example.quizzservice.Feign.QuizzInterface;
import com.example.quizzservice.model.QuestionWapper;
import com.example.quizzservice.model.Quiz;
import com.example.quizzservice.model.Responce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizService {

    @Autowired
    QuizDoa quizDoa;

    @Autowired
    QuizzInterface quizzInterface;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questionsIds = quizzInterface.getQuestionForQuiz(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questionsIds);
        quizDoa.save(quiz);
        return new ResponseEntity<>("Quiz Created Successfully", HttpStatus.OK);
    }
    public List<QuestionWapper> getQuestions(int id) {
        Quiz quiz = quizDoa.findById(id).orElse(null);
        if (quiz == null) return null;
        List<Integer> questionsIds = quiz.getQuestionsIds();
        return quizzInterface.getQuestionsfromId(questionsIds);
    }


}
