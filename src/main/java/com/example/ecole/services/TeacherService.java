package com.example.ecole.services;

import com.example.ecole.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int teacherId);
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(int teacherId, Teacher teacherDetails);
    void deleteTeacher(int teacherId);
    // Business logic methods
    void createLesson(int teacherId);
    void gradeAssignment(int teacherId);
    void monitorProgress(int teacherId);
    void provideFeedback(int teacherId);
}