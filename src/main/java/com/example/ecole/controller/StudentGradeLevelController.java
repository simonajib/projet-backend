package com.example.ecole.controller;


import com.example.ecole.entity.StudentGradeLevel;

import com.example.ecole.services.StudentGradeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les associations entre les étudiants et les classes.
 */
@RestController
@RequestMapping("/api/student-grade-level")
@CrossOrigin("*")

public class StudentGradeLevelController {

    @Autowired
    private StudentGradeLevelService studentGradeLevelService;

    /**
     * Récupère toutes les associations entre les étudiants et les classes.
     *
     * @return la liste de toutes les associations
     */
    @GetMapping
    public ResponseEntity<List<StudentGradeLevel>> getAllStudentClasses() {
        List<StudentGradeLevel> studentClasses = studentGradeLevelService.getAllStudentClasses();
        return new ResponseEntity<>(studentClasses, HttpStatus.OK);
    }

    /**
     * Récupère une association entre un étudiant et une classe par son identifiant.
     *
     * @param id l'identifiant de l'association à récupérer
     * @return l'association trouvée ou une réponse 404 si elle n'existe pas
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentGradeLevel> getStudentClassById(@PathVariable int id) {
        StudentGradeLevel studentClass = studentGradeLevelService.getStudentClassById(id);
        return studentClass != null ? new ResponseEntity<>(studentClass, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Enregistre une nouvelle association entre un étudiant et une classe.
     *
     * @param studentClass l'association à enregistrer
     * @return l'association enregistrée
     */
    @PostMapping
    public ResponseEntity<StudentGradeLevel> saveStudentClass(@RequestBody StudentGradeLevel studentClass) {
        StudentGradeLevel savedStudentClass = studentGradeLevelService.saveStudentClass(studentClass);
        return new ResponseEntity<>(savedStudentClass, HttpStatus.CREATED);
    }

    /**
     * Met à jour une association existante entre un étudiant et une classe.
     *
     * @param id l'identifiant de l'association à mettre à jour
     * @param studentClass les nouveaux détails de l'association
     * @return l'association mise à jour ou une réponse 404 si elle n'existe pas
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudentGradeLevel> updateStudentClass(@PathVariable int id, @RequestBody StudentGradeLevel studentClass) {
        studentClass.setStudentGradeLevelId(id);
        StudentGradeLevel updatedStudentClass = studentGradeLevelService.updateStudentClass(studentClass);
        return updatedStudentClass != null ? new ResponseEntity<>(updatedStudentClass, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime une association entre un étudiant et une classe par son identifiant.
     *
     * @param id l'identifiant de l'association à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentClass(@PathVariable int id) {
        studentGradeLevelService.deleteStudentClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
