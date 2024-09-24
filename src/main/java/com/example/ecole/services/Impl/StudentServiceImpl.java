package com.example.ecole.services.Impl;

import com.example.ecole.entity.Student;
import com.example.ecole.repositories.StudentRepository;
import com.example.ecole.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité Student.
 * Cette classe contient la logique métier pour gérer les étudiants.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Récupère tous les étudiants.
     *
     * @return une liste de tous les étudiants
     */
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Récupère un étudiant par son identifiant.
     *
     * @param studentId l'identifiant de l'étudiant à récupérer
     * @return l'étudiant trouvé ou null si non trouvé
     */
    @Override
    public Student getStudentById(int studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElse(null);
    }

    /**
     * Crée un nouvel étudiant.
     *
     * @param student l'étudiant à créer
     * @return l'étudiant créé
     */
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Met à jour un étudiant existant.
     *
     * @param studentId l'identifiant de l'étudiant à mettre à jour
     * @param studentDetails les nouveaux détails de l'étudiant
     * @return l'étudiant mis à jour ou null si non trouvé
     */
    @Override
    public Student updateStudent(int studentId, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setPassword(studentDetails.getPassword());
            student.setRole(studentDetails.getRole());
            student.setDateJoined(studentDetails.getDateJoined());
            student.setGradeLevel(studentDetails.getGradeLevel());

            student.setParent(studentDetails.getParent());
            return studentRepository.save(student);
        }
        return null;
    }

    /**
     * Supprime un étudiant par son identifiant.
     *
     * @param studentId l'identifiant de l'étudiant à supprimer
     */
    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    /**
     * Affiche les leçons pour un étudiant spécifique.
     *
     * @param studentId l'identifiant de l'étudiant
     */
    @Override
    public void viewLessons(int studentId) {
        // Implémenter la logique métier pour afficher les leçons
    }

    /**
     * Permet à un étudiant de passer un quiz.
     *
     * @param studentId l'identifiant de l'étudiant
     */
    @Override
    public void takeQuiz(int studentId) {
        // Implémenter la logique métier pour passer un quiz
    }

    /**
     * Suit les progrès d'un étudiant spécifique.
     *
     * @param studentId l'identifiant de l'étudiant
     */
    @Override
    public void trackProgress(int studentId) {
        // Implémenter la logique métier pour suivre les progrès
    }

    /**
     * Permet à un étudiant de soumettre un devoir.
     *
     * @param studentId l'identifiant de l'étudiant
     */
    @Override
    public void submitAssignment(int studentId) {
        // Implémenter la logique métier pour soumettre un devoir
    }

    /**
     * Permet à un étudiant de choisir une classe.
     *
     * @param studentId l'identifiant de l'étudiant
     */
    @Override
    public void chooseClass(int studentId) {
        // Implémenter la logique métier pour choisir une classe
    }
}
