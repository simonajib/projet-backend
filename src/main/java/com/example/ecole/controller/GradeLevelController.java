package com.example.ecole.controller;


import com.example.ecole.entity.GradeLevel;
import com.example.ecole.services.GradeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade-levels")
@CrossOrigin("*")
public class GradeLevelController {

    private final GradeLevelService gradeLevelService;

    @Autowired
    public GradeLevelController(GradeLevelService gradeLevelService) {
        this.gradeLevelService = gradeLevelService;
    }

    @PostMapping
    public ResponseEntity<GradeLevel> createGradeLevel(@RequestBody GradeLevel gradeLevel) {
        return ResponseEntity.ok(gradeLevelService.createGradeLevel(gradeLevel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeLevel> getGradeLevelById(@PathVariable Long id) {
        GradeLevel gradeLevel = gradeLevelService.getGradeLevelById(id);
        if (gradeLevel != null) {
            return ResponseEntity.ok(gradeLevel);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<GradeLevel>> getAllGradeLevels() {
        List<GradeLevel> gradeLevels = gradeLevelService.getAllGradeLevels();
        if (gradeLevels.isEmpty()) {
            return ResponseEntity.noContent().build();  // Returns HTTP 204 No Content
        }
        return ResponseEntity.ok(gradeLevels);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeLevel> updateGradeLevel(@PathVariable Long id, @RequestBody GradeLevel gradeLevel) {
        GradeLevel updatedGradeLevel = gradeLevelService.updateGradeLevel(id, gradeLevel);
        if (updatedGradeLevel != null) {
            return ResponseEntity.ok(updatedGradeLevel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGradeLevel(@PathVariable Long id) {
        gradeLevelService.deleteGradeLevel(id);
        return ResponseEntity.noContent().build();
    }
}