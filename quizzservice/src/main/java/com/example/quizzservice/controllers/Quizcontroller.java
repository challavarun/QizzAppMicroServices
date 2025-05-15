package com.example.quizzservice.controllers;

import com.example.quizzservice.model.QuestionWapper;
import com.example.quizzservice.model.Responce;
import com.example.quizzservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class Quizcontroller {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity <String> createQuiz(@RequestBody QuizDTo quizDTo){
        return quizService.createQuiz(quizDTo.getCategory(),quizDTo.getNumQ(),quizDTo.getTitle());
    }
    @GetMapping("get/{Id}")
    public List<QuestionWapper> getQuiz(@PathVariable("Id") int Id){
        return quizService.getQuestions(Id);
    }
    @GetMapping
    public String poc()
    {
        return "Helloiw";
    }

}
