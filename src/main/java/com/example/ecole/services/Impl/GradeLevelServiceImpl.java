package com.example.ecole.services.Impl;


import com.example.ecole.entity.GradeLevel;
import com.example.ecole.repositories.GradeLevelRepository;
import com.example.ecole.services.GradeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeLevelServiceImpl implements GradeLevelService {

    private final GradeLevelRepository gradeLevelRepository;

    @Autowired
    public GradeLevelServiceImpl(GradeLevelRepository gradeLevelRepository) {
        this.gradeLevelRepository = gradeLevelRepository;
    }

    @Override
    public GradeLevel createGradeLevel(GradeLevel gradeLevel) {
        return gradeLevelRepository.save(gradeLevel);
    }

    @Override
    public GradeLevel getGradeLevelById(Long id) {
        return gradeLevelRepository.findById(id).orElse(null);
    }

    @Override
    public List<GradeLevel> getAllGradeLevels() {
        return gradeLevelRepository.findAll();
    }

    @Override
    public GradeLevel updateGradeLevel(Long id, GradeLevel gradeLevel) {
        Optional<GradeLevel> existingGradeLevel = gradeLevelRepository.findById(id);
        if (existingGradeLevel.isPresent()) {
            GradeLevel updatedGradeLevel = existingGradeLevel.get();
            updatedGradeLevel.setLevelName(gradeLevel.getLevelName());
            updatedGradeLevel.setDescription(gradeLevel.getDescription());
            return gradeLevelRepository.save(updatedGradeLevel);
        }
        return null;
    }

    @Override
    public void deleteGradeLevel(Long id) {
        gradeLevelRepository.deleteById(id);
    }
    public Long countGradeLevels() {
        return gradeLevelRepository.count();
    }
}