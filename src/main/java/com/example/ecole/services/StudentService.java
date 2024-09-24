package com.example.ecole.services;

import com.example.ecole.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    Student createStudent(Student student);
    Student updateStudent(int studentId, Student studentDetails);
    void deleteStudent(int studentId);

    // Business logic methods
    void viewLessons(int studentId);
    void takeQuiz(int studentId);
    void trackProgress(int studentId);
    void submitAssignment(int studentId);
    void chooseClass(int studentId);
}