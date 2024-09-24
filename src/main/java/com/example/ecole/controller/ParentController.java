package com.example.ecole.controller;

import com.example.ecole.entity.Parent;
import com.example.ecole.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController pour gérer les parents.
 * Expose des endpoints RESTful pour les opérations CRUD et autres fonctionnalités.
 */
@RestController
@RequestMapping("/api/parents")
@CrossOrigin("*")

public class ParentController {

    @Autowired
    private ParentService parentService;

    /**
     * Récupère tous les parents.
     *
     * @return une liste de tous les parents
     */
    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    /**
     * Récupère un parent par son identifiant.
     *
     * @param parentId l'identifiant du parent à récupérer
     * @return le parent trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable("id") int parentId) {
        Parent parent = parentService.getParentById(parentId);
        return parent != null ? new ResponseEntity<>(parent, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouveau parent.
     *
     * @param parent le parent à créer
     * @return le parent créé
     */
    @PostMapping
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent createdParent = parentService.createParent(parent);
        return new ResponseEntity<>(createdParent, HttpStatus.CREATED);
    }

    /**
     * Met à jour un parent existant.
     *
     * @param parentId l'identifiant du parent à mettre à jour
     * @param parentDetails les nouveaux détails du parent
     * @return le parent mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable("id") int parentId, @RequestBody Parent parentDetails) {
        Parent updatedParent = parentService.updateParent(parentId, parentDetails);
        return updatedParent != null ? new ResponseEntity<>(updatedParent, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un parent par son identifiant.
     *
     * @param parentId l'identifiant du parent à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable("id") int parentId) {
        parentService.deleteParent(parentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Surveille les progrès pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/monitor-progress")
    public ResponseEntity<Void> monitorProgress(@PathVariable("id") int parentId) {
        parentService.monitorProgress(parentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Communique avec les enseignants pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/communicate-with-teacher")
    public ResponseEntity<Void> communicateWithTeacher(@PathVariable("id") int parentId) {
        parentService.communicateWithTeacher(parentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Affiche les rapports pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/view-reports")
    public ResponseEntity<Void> viewReports(@PathVariable("id") int parentId) {
        parentService.viewReports(parentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Reçoit des notifications pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/receive-notifications")
    public ResponseEntity<Void> receiveNotifications(@PathVariable("id") int parentId) {
        parentService.receiveNotifications(parentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Effectue des paiements pour un parent spécifique.
     *
     * @param parentId l'identifiant du parent
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/make-payment")
    public ResponseEntity<Void> makePayment(@PathVariable("id") int parentId) {
        parentService.makePayment(parentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
