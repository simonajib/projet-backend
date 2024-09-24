package com.example.ecole.services.Impl;

import com.example.ecole.entity.Parent;
import com.example.ecole.repositories.ParentRepository;
import com.example.ecole.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité Parent.
 * Cette classe contient la logique métier pour gérer les parents.
 */
@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;

    /**
     * Récupère tous les parents.
     *
     * @return une liste de tous les parents
     */
    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    /**
     * Récupère un parent par son identifiant.
     *
     * @param parentId l'identifiant du parent à récupérer
     * @return le parent trouvé ou null si non trouvé
     */
    @Override
    public Parent getParentById(int parentId) {
        Optional<Parent> parent = parentRepository.findById(parentId);
        return parent.orElse(null);
    }

    /**
     * Crée un nouveau parent.
     *
     * @param parent le parent à créer
     * @return le parent créé
     */
    @Override
    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    /**
     * Met à jour un parent existant.
     *
     * @param parentId l'identifiant du parent à mettre à jour
     * @param parentDetails les nouveaux détails du parent
     * @return le parent mis à jour ou null si non trouvé
     */
    @Override
    public Parent updateParent(int parentId, Parent parentDetails) {
        Optional<Parent> optionalParent = parentRepository.findById(parentId);
        if (optionalParent.isPresent()) {
            Parent parent = optionalParent.get();
            parent.setName(parentDetails.getName());
            parent.setEmail(parentDetails.getEmail());
            parent.setPassword(parentDetails.getPassword());
            parent.setRole(parentDetails.getRole());
            parent.setDateJoined(parentDetails.getDateJoined());
            return parentRepository.save(parent);
        }
        return null;
    }

    /**
     * Supprime un parent par son identifiant.
     *
     * @param parentId l'identifiant du parent à supprimer
     */
    @Override
    public void deleteParent(int parentId) {
        parentRepository.deleteById(parentId);
    }

    /**
     * Surveille les progrès pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     */
    @Override
    public void monitorProgress(int parentId) {
        // Implémenter la logique métier pour surveiller les progrès
    }

    /**
     * Communique avec les enseignants pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     */
    @Override
    public void communicateWithTeacher(int parentId) {
        // Implémenter la logique métier pour communiquer avec les enseignants
    }

    /**
     * Affiche les rapports pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     */
    @Override
    public void viewReports(int parentId) {
        // Implémenter la logique métier pour afficher les rapports
    }

    /**
     * Reçoit des notifications pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     */
    @Override
    public void receiveNotifications(int parentId) {
        // Implémenter la logique métier pour recevoir des notifications
    }

    /**
     * Effectue des paiements pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     */
    @Override
    public void makePayment(int parentId) {
        // Implémenter la logique métier pour effectuer des paiements
    }
}
