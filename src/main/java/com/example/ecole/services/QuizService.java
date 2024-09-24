package com.example.ecole.services;

import com.example.ecole.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz SaveQuiz(Quiz quiz);
    Quiz UpdateQuiz(Quiz quiz);
    void DeleteQuizById(Long Id);
    void DeleteAllQuiz();
    Quiz getQuizById(Long Id);
    List<Quiz> getAllQuiz();
}