package com.example.ecole.services;

import com.example.ecole.entity.Tutor;

import java.util.List;

public interface TutorService {
    List<Tutor> getAllTutors();
    Tutor getTutorById(int tutorId);
    Tutor createTutor(Tutor tutor);
    Tutor updateTutor(int tutorId, Tutor tutorDetails);
    void deleteTutor(int tutorId);
    void monitorProgress(int tutorId);
    void provideFeedback(int tutorId, String feedback);

}