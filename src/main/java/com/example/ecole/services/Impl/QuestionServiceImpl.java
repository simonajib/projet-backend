package com.example.ecole.services.Impl;

import com.example.ecole.entity.Question;
import com.example.ecole.repositories.QuestionRepository;
import com.example.ecole.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface de service pour l'entité Question.
 * Cette classe contient la logique métier pour gérer les questions.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Récupère toutes les questions.
     *
     * @return une liste de toutes les questions
     */
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    /**
     * Récupère une question par son identifiant.
     *
     * @param questionId l'identifiant de la question à récupérer
     * @return la question trouvée ou null si non trouvée
     */
    @Override
    public Question getQuestionById(int questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    /**
     * Enregistre une nouvelle question.
     *
     * @param question la question à enregistrer
     * @return la question enregistrée
     */
    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    /**
     * Supprime une question par son identifiant.
     *
     * @param questionId l'identifiant de la question à supprimer
     */
    @Override
    public void deleteQuestion(int questionId) {
        questionRepository.deleteById(questionId);
    }
}
