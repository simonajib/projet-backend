package com.example.ecole.controller;

import com.example.ecole.entity.Quiz;
import com.example.ecole.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les quizzes.
 */
@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin("*")

public class QuizController {

    @Autowired
    private QuizService quizService;

    /**
     * Récupère tous les quizzes.
     *
     * @return une liste de tous les quizzes
     */
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuiz();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    /**
     * Récupère un quiz par son identifiant.
     *
     * @param quizId l'identifiant du quiz à récupérer
     * @return le quiz trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        return quiz != null ? new ResponseEntity<>(quiz, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouveau quiz.
     *
     * @param quiz le quiz à créer
     * @return le quiz créé
     */
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.SaveQuiz(quiz);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    /**
     * Met à jour un quiz existant.
     *
     * @param quizId l'identifiant du quiz à mettre à jour
     * @param quizDetails les détails du quiz mis à jour
     * @return le quiz mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") Long quizId, @RequestBody Quiz quizDetails) {
        quizDetails.setQuizId(quizId);
        Quiz updatedQuiz = quizService.UpdateQuiz(quizDetails);
        return updatedQuiz != null ? new ResponseEntity<>(updatedQuiz, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un quiz par son identifiant.
     *
     * @param quizId l'identifiant du quiz à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("id") Long quizId) {
        quizService.DeleteQuizById(quizId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Supprime tous les quizzes.
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteAllQuizzes() {
        quizService.DeleteAllQuiz();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
