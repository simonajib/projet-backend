package com.example.ecole.controller;

import com.example.ecole.entity.Student;
import com.example.ecole.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les étudiants.
 */
@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")

public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Récupère tous les étudiants.
     *
     * @return une liste de tous les étudiants
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Récupère un étudiant par son identifiant.
     *
     * @param studentId l'identifiant de l'étudiant à récupérer
     * @return l'étudiant trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        return student != null ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouvel étudiant.
     *
     * @param student les détails de l'étudiant à créer
     * @return l'étudiant créé
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    /**
     * Met à jour un étudiant existant.
     *
     * @param studentId l'identifiant de l'étudiant à mettre à jour
     * @param studentDetails les nouveaux détails de l'étudiant
     * @return l'étudiant mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(studentId, studentDetails);
        return updatedStudent != null ? new ResponseEntity<>(updatedStudent, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un étudiant par son identifiant.
     *
     * @param studentId l'identifiant de l'étudiant à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Affiche les leçons pour un étudiant spécifique.
     *
     * @param studentId l'identifiant de l'étudiant
     * @return une réponse 200 si l'opération est réussie
     */
    @GetMapping("/{studentId}/lessons")
    public ResponseEntity<Void> viewLessons(@PathVariable int studentId) {
        studentService.viewLessons(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Permet à un étudiant de passer un quiz.
     *
     * @param studentId l'identifiant de l'étudiant
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{studentId}/quiz")
    public ResponseEntity<Void> takeQuiz(@PathVariable int studentId) {
        studentService.takeQuiz(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Suit les progrès d'un étudiant spécifique.
     *
     * @param studentId l'identifiant de l'étudiant
     * @return une réponse 200 si l'opération est réussie
     */
    @GetMapping("/{studentId}/progress")
    public ResponseEntity<Void> trackProgress(@PathVariable int studentId) {
        studentService.trackProgress(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Permet à un étudiant de soumettre un devoir.
     *
     * @param studentId l'identifiant de l'étudiant
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{studentId}/assignment")
    public ResponseEntity<Void> submitAssignment(@PathVariable int studentId) {
        studentService.submitAssignment(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Permet à un étudiant de choisir une classe.
     *
     * @param studentId l'identifiant de l'étudiant
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{studentId}/choose-class")
    public ResponseEntity<Void> chooseClass(@PathVariable int studentId) {
        studentService.chooseClass(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
