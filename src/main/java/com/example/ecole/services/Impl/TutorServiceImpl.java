package com.example.ecole.services.Impl;

import com.example.ecole.entity.Tutor;
import com.example.ecole.repositories.TutorRepository;
import com.example.ecole.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité Tutor.
 * Cette classe contient la logique métier pour gérer les tuteurs.
 */
@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    /**
     * Récupère tous les tuteurs.
     *
     * @return une liste de tous les tuteurs
     */
    @Override
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    /**
     * Récupère un tuteur par son identifiant.
     *
     * @param tutorId l'identifiant du tuteur à récupérer
     * @return le tuteur trouvé ou null si non trouvé
     */
    @Override
    public Tutor getTutorById(int tutorId) {
        Optional<Tutor> tutor = tutorRepository.findById(tutorId);
        return tutor.orElse(null);
    }

    /**
     * Crée un nouveau tuteur.
     *
     * @param tutor le tuteur à créer
     * @return le tuteur créé
     */
    @Override
    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    /**
     * Met à jour un tuteur existant.
     *
     * @param tutorId l'identifiant du tuteur à mettre à jour
     * @param tutorDetails les nouveaux détails du tuteur
     * @return le tuteur mis à jour ou null si non trouvé
     */
    @Override
    public Tutor updateTutor(int tutorId, Tutor tutorDetails) {
        Optional<Tutor> optionalTutor = tutorRepository.findById(tutorId);
        if (optionalTutor.isPresent()) {
            Tutor tutor = optionalTutor.get();
            tutor.setName(tutorDetails.getName());
            tutor.setEmail(tutorDetails.getEmail());
            tutor.setPassword(tutorDetails.getPassword());
            tutor.setRole(tutorDetails.getRole());
            tutor.setDateJoined(tutorDetails.getDateJoined());
            tutor.setSubject(tutorDetails.getSubject());

            return tutorRepository.save(tutor);
        }
        return null;
    }

    /**
     * Supprime un tuteur par son identifiant.
     *
     * @param tutorId l'identifiant du tuteur à supprimer
     */
    @Override
    public void deleteTutor(int tutorId) {
        tutorRepository.deleteById(tutorId);
    }

    /**
     * Suit les progrès d'un tuteur spécifique.
     *
     * @param tutorId l'identifiant du tuteur
     */
    @Override
    public void monitorProgress(int tutorId) {
        // Implémenter la logique métier pour suivre les progrès
    }

    /**
     * Fournit des retours pour un tuteur spécifique.
     *
     * @param tutorId l'identifiant du tuteur
     * @param feedback les retours à fournir
     */
    @Override
    public void provideFeedback(int tutorId, String feedback) {
        // Implémenter la logique métier pour fournir des retours
    }
}
