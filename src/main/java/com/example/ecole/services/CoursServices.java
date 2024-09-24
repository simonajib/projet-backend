package com.example.ecole.services;

import com.example.ecole.entity.Cours;

import java.util.List;
import java.util.Optional;

public interface CoursServices {
    Optional<Cours> findByTitle(String title);

    Cours SaveCours(Cours cours);
    Cours UpdateCours(Cours cours);
    void DeleteCoursById(Long Id);
    void DeleteAllCours();
    Cours getCoursById(Long Id);
    List<Cours> getAllCours();


    Long countCourses();
}