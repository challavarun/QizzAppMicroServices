package com.example.quizzservice.controllers;

import lombok.Data;

@Data
public class QuizDTo {
    private String category;
    private int numQ;
    private String title;
}
