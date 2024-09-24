package com.example.ecole.controller;

import com.example.ecole.entity.TutorStudent;
import com.example.ecole.services.TutorStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les associations entre les tuteurs et les étudiants.
 */
@RestController
@RequestMapping("/api/tutorStudents")
@CrossOrigin("*")

public class TutorStudentController {

    @Autowired
    private TutorStudentService tutorStudentService;

    /**
     * Récupère toutes les associations entre les tuteurs et les étudiants.
     *
     * @return une liste de toutes les associations
     */
    @GetMapping
    public ResponseEntity<List<TutorStudent>> getAllTutorStudents() {
        List<TutorStudent> tutorStudents = tutorStudentService.getAllTutorStudents();
        return new ResponseEntity<>(tutorStudents, HttpStatus.OK);
    }

    /**
     * Récupère une association entre un tuteur et un étudiant par son identifiant.
     *
     * @param id l'identifiant de l'association à récupérer
     * @return l'association trouvée ou une réponse 404 si elle n'existe pas
     */
    @GetMapping("/{id}")
    public ResponseEntity<TutorStudent> getTutorStudentById(@PathVariable long id) {
        TutorStudent tutorStudent = tutorStudentService.getTutorStudentById(id);
        return tutorStudent != null ? new ResponseEntity<>(tutorStudent, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Enregistre une nouvelle association entre un tuteur et un étudiant.
     *
     * @param tutorStudent l'association à enregistrer
     * @return l'association enregistrée
     */
    @PostMapping
    public ResponseEntity<TutorStudent> saveTutorStudent(@RequestBody TutorStudent tutorStudent) {
        TutorStudent savedTutorStudent = tutorStudentService.saveTutorStudent(tutorStudent);
        return new ResponseEntity<>(savedTutorStudent, HttpStatus.CREATED);
    }

    /**
     * Met à jour une association existante entre un tuteur et un étudiant.
     *
     * @param id l'identifiant de l'association à mettre à jour
     * @param tutorStudent les nouveaux détails de l'association
     * @return l'association mise à jour ou une réponse 404 si non trouvée
     */
    @PutMapping("/{id}")
    public ResponseEntity<TutorStudent> updateTutorStudent(@PathVariable long id, @RequestBody TutorStudent tutorStudent) {
        tutorStudent.setTutorStudentId(id);
        TutorStudent updatedTutorStudent = tutorStudentService.updateTutorStudent(tutorStudent);
        return updatedTutorStudent != null ? new ResponseEntity<>(updatedTutorStudent, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime une association entre un tuteur et un étudiant par son identifiant.
     *
     * @param id l'identifiant de l'association à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutorStudent(@PathVariable long id) {
        tutorStudentService.deleteTutorStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
