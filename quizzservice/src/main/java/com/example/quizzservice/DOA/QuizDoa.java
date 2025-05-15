package com.example.quizzservice.DOA;

import com.example.quizzservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDoa extends JpaRepository<Quiz, Integer> {

}
