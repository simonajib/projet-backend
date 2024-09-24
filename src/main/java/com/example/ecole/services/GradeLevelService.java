package com.example.ecole.services;

import com.example.ecole.entity.GradeLevel;

import java.util.List;

public interface GradeLevelService {
    GradeLevel createGradeLevel(GradeLevel gradeLevel);
    GradeLevel getGradeLevelById(Long id);
    List<GradeLevel> getAllGradeLevels();
    GradeLevel updateGradeLevel(Long id, GradeLevel gradeLevel);
    void deleteGradeLevel(Long id);
    Long countGradeLevels();
}