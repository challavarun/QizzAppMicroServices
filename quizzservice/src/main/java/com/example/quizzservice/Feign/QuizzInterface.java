package com.example.quizzservice.Feign;

import com.example.quizzservice.model.QuestionWapper;
import com.example.quizzservice.model.Responce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "QUESTIONAPPSERVICE")
public interface QuizzInterface {

    @GetMapping("question/generate")
    public List<Integer> getQuestionForQuiz(@RequestParam String categoryname, @RequestParam int numQuestion);


    @PostMapping("question/getQuestions")
    public List<QuestionWapper> getQuestionsfromId(@RequestBody List<Integer> questionsIds);


    @PostMapping("question/getScore")
    public Integer getScore(@RequestBody List<Responce> responces);
    }





