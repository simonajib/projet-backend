package com.example.ecole.services;

import com.example.ecole.entity.StudentGradeLevel;

import java.util.List;

/**
 * Interface de service pour l'entité StudentClass.
 */
public interface StudentGradeLevelService {

    StudentGradeLevel saveStudentClass(StudentGradeLevel studentClass);

    StudentGradeLevel updateStudentClass(StudentGradeLevel studentClass);

    void deleteStudentClass(int id);

    StudentGradeLevel getStudentClassById(int id);

    List<StudentGradeLevel> getAllStudentClasses();
}