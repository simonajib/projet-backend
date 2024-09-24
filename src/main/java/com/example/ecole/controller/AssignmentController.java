package com.example.ecole.controller;

import com.example.ecole.entity.Assignment;
import com.example.ecole.services.AssignmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController pour gérer les devoirs.
 * Expose des endpoints RESTful pour les opérations CRUD.
 */
@RestController
@RequestMapping("/api/assignments")
@CrossOrigin("*")

public class AssignmentController {

    @Autowired
    private AssignmentServices assignmentServices;

    /**
     * Enregistre un nouveau devoir.
     *
     * @param assignment le devoir à enregistrer
     * @return le devoir enregistré
     */
    @PostMapping
    public ResponseEntity<Assignment> saveAssignment(@RequestBody Assignment assignment) {
        Assignment savedAssignment = assignmentServices.SaveAssignment(assignment);
        return new ResponseEntity<>(savedAssignment, HttpStatus.CREATED);
    }

    /**
     * Met à jour un devoir existant.
     *
     * @param assignment le devoir à mettre à jour
     * @return le devoir mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment) {
        Assignment updatedAssignment = assignmentServices.UpdateAssignment(assignment);
        return updatedAssignment != null ? new ResponseEntity<>(updatedAssignment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un devoir par son identifiant.
     *
     * @param id l'identifiant du devoir à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignmentById(@PathVariable("id") Long id) {
        assignmentServices.DeleteAssignmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Supprime tous les devoirs.
     *
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteAllAssignments() {
        assignmentServices.DeleteAllAssignments();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère un devoir par son identifiant.
     *
     * @param id l'identifiant du devoir à récupérer
     * @return le devoir trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable("id") Long id) {
        Assignment assignment = assignmentServices.getAssignmentById(id);
        return assignment != null ? new ResponseEntity<>(assignment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Récupère tous les devoirs.
     *
     * @return une liste de tous les devoirs
     */
    @GetMapping
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        List<Assignment> assignments = assignmentServices.getAllAssignments();
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }
}
