package com.example.ecole.repositories;

import com.example.ecole.entity.TutorStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorStudentRepository extends JpaRepository<TutorStudent, Long> {
}