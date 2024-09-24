package com.example.ecole.services.Impl;

import com.example.ecole.entity.Teacher;
import com.example.ecole.repositories.TeacherRepository;
import com.example.ecole.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité Teacher.
 * Cette classe contient la logique métier pour gérer les enseignants.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * Récupère tous les enseignants.
     *
     * @return une liste de tous les enseignants
     */
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    /**
     * Récupère un enseignant par son identifiant.
     *
     * @param teacherId l'identifiant de l'enseignant à récupérer
     * @return l'enseignant trouvé ou null si non trouvé
     */
    @Override
    public Teacher getTeacherById(int teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        return teacher.orElse(null);
    }

    /**
     * Crée un nouvel enseignant.
     *
     * @param teacher l'enseignant à créer
     * @return l'enseignant créé
     */
    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    /**
     * Met à jour un enseignant existant.
     *
     * @param teacherId l'identifiant de l'enseignant à mettre à jour
     * @param teacherDetails les nouveaux détails de l'enseignant
     * @return l'enseignant mis à jour ou null si non trouvé
     */
    @Override
    public Teacher updateTeacher(int teacherId, Teacher teacherDetails) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setName(teacherDetails.getName());
            teacher.setEmail(teacherDetails.getEmail());
            teacher.setPassword(teacherDetails.getPassword());
            teacher.setRole(teacherDetails.getRole());
            teacher.setDateJoined(teacherDetails.getDateJoined());
            teacher.setSubject(teacherDetails.getSubject());
            teacher.setHireDate(teacherDetails.getHireDate());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    /**
     * Supprime un enseignant par son identifiant.
     *
     * @param teacherId l'identifiant de l'enseignant à supprimer
     */
    @Override
    public void deleteTeacher(int teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    /**
     * Crée une leçon pour un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     */
    @Override
    public void createLesson(int teacherId) {
        // Implémenter la logique métier pour créer une leçon
    }

    /**
     * Note un devoir pour un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     */
    @Override
    public void gradeAssignment(int teacherId) {
        // Implémenter la logique métier pour noter un devoir
    }

    /**
     * Suit les progrès d'un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     */
    @Override
    public void monitorProgress(int teacherId) {
        // Implémenter la logique métier pour suivre les progrès
    }

    /**
     * Fournit des retours pour un enseignant spécifique.
     *
     * @param teacherId l'identifiant de l'enseignant
     */
    @Override
    public void provideFeedback(int teacherId) {
        // Implémenter la logique métier pour fournir des retours
    }
}
