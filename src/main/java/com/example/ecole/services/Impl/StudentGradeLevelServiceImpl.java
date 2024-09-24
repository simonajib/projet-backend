package com.example.ecole.services.Impl;


import com.example.ecole.entity.StudentGradeLevel;
import com.example.ecole.repositories.StudentClassRepository;

import com.example.ecole.services.StudentGradeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité StudentClass.
 * Cette classe contient la logique métier pour gérer les associations entre les étudiants et les classes.
 */
@Service
public class StudentGradeLevelServiceImpl implements StudentGradeLevelService {

    @Autowired
    private StudentClassRepository studentClassRepository;

    /**
     * Enregistre une nouvelle association entre un étudiant et une classe.
     *
     * @param studentClass l'association à enregistrer
     * @return l'association enregistrée
     */
    @Override
    public StudentGradeLevel saveStudentClass(StudentGradeLevel studentClass) {
        return studentClassRepository.save(studentClass);
    }

    /**
     * Met à jour une association existante entre un étudiant et une classe.
     *
     * @param studentClass l'association à mettre à jour
     * @return l'association mise à jour
     */
    @Override
    public StudentGradeLevel updateStudentClass(StudentGradeLevel studentClass) {
        return studentClassRepository.save(studentClass);
    }

    /**
     * Supprime une association entre un étudiant et une classe par son identifiant.
     *
     * @param id l'identifiant de l'association à supprimer
     */
    @Override
    public void deleteStudentClass(int id) {
        studentClassRepository.deleteById(id);
    }

    /**
     * Récupère une association entre un étudiant et une classe par son identifiant.
     *
     * @param id l'identifiant de l'association à récupérer
     * @return l'association trouvée ou null si elle n'existe pas
     */
    @Override
    public StudentGradeLevel getStudentClassById(int id) {
        Optional<StudentGradeLevel> studentClassOptional = studentClassRepository.findById(id);
        return studentClassOptional.orElse(null);
    }

    /**
     * Récupère toutes les associations entre les étudiants et les classes.
     *
     * @return la liste de toutes les associations
     */
    @Override
    public List<StudentGradeLevel> getAllStudentClasses() {
        return studentClassRepository.findAll();
    }
}