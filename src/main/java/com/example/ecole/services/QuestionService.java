package com.example.ecole.services;

import com.example.ecole.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    Question getQuestionById(int questionId);
    Question saveQuestion(Question question);
    void deleteQuestion(int questionId);
}