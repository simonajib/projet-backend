package com.example.ecole.services;

import com.example.ecole.entity.Assignment;

import java.util.List;


public interface AssignmentServices {
    Assignment SaveAssignment(Assignment assignment);
    Assignment UpdateAssignment(Assignment assignment);
    void DeleteAssignmentById(Long Id);
    void DeleteAllAssignments();
    Assignment getAssignmentById(Long Id);
    List<Assignment> getAllAssignments();
}