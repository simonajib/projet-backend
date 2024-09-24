package com.example.ecole.services.Impl;

import com.example.ecole.entity.Assignment;
import com.example.ecole.repositories.AssignmentRepository;
import com.example.ecole.services.AssignmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface de service pour l'entité Assignment.
 * Cette classe contient la logique métier pour gérer les devoirs.
 */
@Service
public class AssignmentServicesImpl implements AssignmentServices {

    @Autowired
    private AssignmentRepository assignmentRepository;

    /**
     * Enregistre un nouveau devoir.
     *
     * @param assignment le devoir à enregistrer
     * @return le devoir enregistré
     */
    @Override
    public Assignment SaveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    /**
     * Met à jour un devoir existant.
     *
     * @param assignment le devoir à mettre à jour
     * @return le devoir mis à jour
     */
    @Override
    public Assignment UpdateAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    /**
     * Supprime un devoir par son identifiant.
     *
     * @param Id l'identifiant du devoir à supprimer
     */
    @Override
    public void DeleteAssignmentById(Long Id) {
        assignmentRepository.deleteById(Id);
    }

    /**
     * Supprime tous les devoirs.
     */
    @Override
    public void DeleteAllAssignments() {
        assignmentRepository.deleteAll();
    }

    /**
     * Récupère un devoir par son identifiant.
     *
     * @param Id l'identifiant du devoir à récupérer
     * @return le devoir trouvé
     */
    @Override
    public Assignment getAssignmentById(Long Id) {
        return assignmentRepository.findById(Id).get();
    }

    /**
     * Récupère tous les devoirs.
     *
     * @return une liste de tous les devoirs
     */
    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }
}
