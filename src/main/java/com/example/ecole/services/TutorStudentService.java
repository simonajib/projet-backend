package com.example.ecole.services;

import com.example.ecole.entity.TutorStudent;

import java.util.List;

public interface TutorStudentService {

    TutorStudent saveTutorStudent(TutorStudent tutorStudent);

    TutorStudent updateTutorStudent(TutorStudent tutorStudent);

    void deleteTutorStudent(long id);

    TutorStudent getTutorStudentById(long id);

    List<TutorStudent> getAllTutorStudents();
}