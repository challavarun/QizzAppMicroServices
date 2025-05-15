package com.QuizzAppMVC.QuestionAppService.controllers;

import com.QuizzAppMVC.QuestionAppService.model.Question;
import com.QuizzAppMVC.QuestionAppService.model.QuestionWrapper;
import com.QuizzAppMVC.QuestionAppService.model.Response;

import com.QuizzAppMVC.QuestionAppService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("question")
public class QueatoinController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestions")
    public List<Question> getAllQuestions(){
        return questionService.findAllQuestions();
    }

    @GetMapping("Category/{cat}")
    public List<Question> getCategoryQuestions(@PathVariable("cat") String Category){
        return questionService.findByCategory(Category);
    }
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("/Delete/{id}")
    public String deleteQuestion(@PathVariable("id") int id) {
        boolean deleted = questionService.deleteQuestion(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question with ID " + id + " not found");
        }
        return "Question Deleted Successfully";
    }
    @GetMapping("generate")
    public List<Integer> getQuestionForQuiz(@RequestParam String categoryname,@RequestParam int numQuestion){
        return questionService.getQuestionForQuiz(categoryname,numQuestion);
    }
    @PostMapping("getQuestions")
    public List<QuestionWrapper> getQuestionsfromId(@RequestBody List<Integer> questionsIds){
        return questionService.getQuestionFormId(questionsIds);
    }
    @PostMapping("getScore")
    public Integer getScore(@RequestBody List<Response> responces){
        return questionService.getScore(responces);
    }

    @GetMapping
    public String poc()
    {
        return "Helloiw";
    }






}
