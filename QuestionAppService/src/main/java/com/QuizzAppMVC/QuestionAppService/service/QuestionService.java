package com.QuizzAppMVC.QuestionAppService.service;

import com.QuizzAppMVC.QuestionAppService.DOA.QuestionDOA;
import com.QuizzAppMVC.QuestionAppService.model.Question;
import com.QuizzAppMVC.QuestionAppService.model.QuestionWrapper;
import com.QuizzAppMVC.QuestionAppService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service


public class QuestionService {
    @Autowired
    QuestionDOA questionDoa;
    public List<Question> findAllQuestions() {

        return questionDoa.findAll();
    }

    public List<Question> findByCategory(String Category) {
        return questionDoa.findByCategory(Category);
    }

    public String addQuestion(Question question) {
        questionDoa.save(question);
        return "Question Added Successfully";
    }


    public boolean deleteQuestion(int id) {
        Optional<Question> question = questionDoa.findById(id);
        if (question.isPresent()) {
            questionDoa.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public List<Integer> getQuestionForQuiz(String categoryname, int numQuestion) {
        List<Integer> questions=questionDoa.findRAndomQuestionsByCategory(categoryname,numQuestion);
        return questions;

    }

    public List<QuestionWrapper> getQuestionFormId(List<Integer> questionsIds) {

        List<QuestionWrapper> wrappers=new ArrayList<>();
        List<Question> questions=new ArrayList<>();
        for(Integer id:questionsIds){
            questions.add(questionDoa.findById(id).get());
        }
        for(Question question:questions){
        QuestionWrapper wrapper=new QuestionWrapper();
        wrapper.setId(question.getId());
        wrapper.setQuestionTitle(question.getQuestionTitle());
        wrapper.setOption1(question.getOption1());
        wrapper.setOption2(question.getOption2());
        wrapper.setOption3(question.getOption3());
        wrapper.setOption4(question.getOption4());
        wrappers.add(wrapper);
        }
        return wrappers;
    }

    public Integer getScore(List<Response> responce) {


        int right=0;

        for(Response respo: responce){
            Question question=questionDoa.findById(respo.getId()).get();
            if(respo.getResponce().equals(question.getRightAnswer())){
                right++;
            }


        }
        return right;
    }


    }

