package com.example.ecole.services.Impl;

import com.example.ecole.entity.Quiz;
import com.example.ecole.repositories.QuizRepository;
import com.example.ecole.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface de service pour l'entité Quiz.
 * Cette classe contient la logique métier pour gérer les quizzes.
 */
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    /**
     * Enregistre un nouveau quiz.
     *
     * @param quiz le quiz à enregistrer
     * @return le quiz enregistré
     */
    @Override
    public Quiz SaveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    /**
     * Met à jour un quiz existant.
     *
     * @param quiz le quiz à mettre à jour
     * @return le quiz mis à jour
     */
    @Override
    public Quiz UpdateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    /**
     * Supprime un quiz par son identifiant.
     *
     * @param Id l'identifiant du quiz à supprimer
     */
    @Override
    public void DeleteQuizById(Long Id) {
        quizRepository.deleteById(Id);
    }

    /**
     * Supprime tous les quizzes.
     */
    @Override
    public void DeleteAllQuiz() {
        quizRepository.deleteAll();
    }

    /**
     * Récupère un quiz par son identifiant.
     *
     * @param Id l'identifiant du quiz à récupérer
     * @return le quiz trouvé
     */
    @Override
    public Quiz getQuizById(Long Id) {
        return quizRepository.findById(Id).get();
    }

    /**
     * Récupère tous les quizzes.
     *
     * @return une liste de tous les quizzes
     */
    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }
}
