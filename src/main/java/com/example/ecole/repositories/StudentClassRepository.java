package com.example.ecole.repositories;

import com.example.ecole.entity.StudentGradeLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentGradeLevel, Integer> {
}