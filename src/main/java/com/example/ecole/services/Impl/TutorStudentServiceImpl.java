package com.example.ecole.services.Impl;


import com.example.ecole.entity.TutorStudent;
import com.example.ecole.repositories.TutorStudentRepository;
import com.example.ecole.services.TutorStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité TutorStudent.
 * Cette classe contient la logique métier pour gérer les associations entre les tuteurs et les étudiants.
 */
@Service
public class TutorStudentServiceImpl implements TutorStudentService {

    @Autowired
    private TutorStudentRepository tutorStudentRepository;

    /**
     * Enregistre une nouvelle association entre un tuteur et un étudiant.
     *
     * @param tutorStudent l'association à enregistrer
     * @return l'association enregistrée
     */
    @Override
    public TutorStudent saveTutorStudent(TutorStudent tutorStudent) {
        return tutorStudentRepository.save(tutorStudent);
    }

    /**
     * Met à jour une association existante entre un tuteur et un étudiant.
     *
     * @param tutorStudent l'association à mettre à jour
     * @return l'association mise à jour
     */
    @Override
    public TutorStudent updateTutorStudent(TutorStudent tutorStudent) {
        return tutorStudentRepository.save(tutorStudent);
    }

    /**
     * Supprime une association entre un tuteur et un étudiant par son identifiant.
     *
     * @param id l'identifiant de l'association à supprimer
     */
    @Override
    public void deleteTutorStudent(long id) {
        tutorStudentRepository.deleteById(id);
    }

    /**
     * Récupère une association entre un tuteur et un étudiant par son identifiant.
     *
     * @param id l'identifiant de l'association à récupérer
     * @return l'association trouvée ou null si elle n'existe pas
     */
    @Override
    public TutorStudent getTutorStudentById(long id) {
        Optional<TutorStudent> tutorStudentOptional = tutorStudentRepository.findById(id);
        return tutorStudentOptional.orElse(null);
    }

    /**
     * Récupère toutes les associations entre les tuteurs et les étudiants.
     *
     * @return la liste de toutes les associations
     */
    @Override
    public List<TutorStudent> getAllTutorStudents() {
        return tutorStudentRepository.findAll();
    }
}