package com.example.ecole.controller;

import com.example.ecole.entity.Question;
import com.example.ecole.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController pour gérer les questions.
 * Expose des endpoints RESTful pour les opérations CRUD.
 */
@RestController
@RequestMapping("/api/questions")
@CrossOrigin("*")

public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * Récupère toutes les questions.
     *
     * @return une liste de toutes les questions
     */
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    /**
     * Récupère une question par son identifiant.
     *
     * @param questionId l'identifiant de la question à récupérer
     * @return la question trouvée ou une réponse 404 si non trouvée
     */
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") int questionId) {
        Question question = questionService.getQuestionById(questionId);
        return question != null ? new ResponseEntity<>(question, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Enregistre une nouvelle question.
     *
     * @param question la question à enregistrer
     * @return la question enregistrée
     */
    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        Question savedQuestion = questionService.saveQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    /**
     * Supprime une question par son identifiant.
     *
     * @param questionId l'identifiant de la question à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable("id") int questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
