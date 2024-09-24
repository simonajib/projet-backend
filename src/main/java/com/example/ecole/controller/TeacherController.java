package com.example.ecole.controller;

import com.example.ecole.entity.Teacher;
import com.example.ecole.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les enseignants.
 */
@RestController
@RequestMapping("/api/teachers")
@CrossOrigin("*")

public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * Récupère tous les enseignants.
     *
     * @return une liste de tous les enseignants
     */
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    /**
     * Récupère un enseignant par son identifiant.
     *
     * @param teacherId l'identifiant de l'enseignant à récupérer
     * @return l'enseignant trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return teacher != null ? new ResponseEntity<>(teacher, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouvel enseignant.
     *
     * @param teacher l'enseignant à créer
     * @return l'enseignant créé
     */
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    /**
     * Met à jour un enseignant existant.
     *
     * @param teacherId l'identifiant de l'enseignant à mettre à jour
     * @param teacherDetails les nouveaux détails de l'enseignant
     * @return l'enseignant mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable int teacherId, @RequestBody Teacher teacherDetails) {
        Teacher updatedTeacher = teacherService.updateTeacher(teacherId, teacherDetails);
        return updatedTeacher != null ? new ResponseEntity<>(updatedTeacher, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un enseignant par son identifiant.
     *
     * @param teacherId l'identifiant de l'enseignant à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int teacherId) {
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Crée une leçon pour un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{teacherId}/createLesson")
    public ResponseEntity<Void> createLesson(@PathVariable int teacherId) {
        teacherService.createLesson(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Note un devoir pour un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{teacherId}/gradeAssignment")
    public ResponseEntity<Void> gradeAssignment(@PathVariable int teacherId) {
        teacherService.gradeAssignment(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Suit les progrès d'un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     * @return une réponse 200 si l'opération est réussie
     */
    @GetMapping("/{teacherId}/monitorProgress")
    public ResponseEntity<Void> monitorProgress(@PathVariable int teacherId) {
        teacherService.monitorProgress(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Fournit des retours pour un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{teacherId}/provideFeedback")
    public ResponseEntity<Void> provideFeedback(@PathVariable int teacherId) {
        teacherService.provideFeedback(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
