package com.example.ecole.services;

import com.example.ecole.entity.Parent;

import java.util.List;

public interface ParentService {
    List<Parent> getAllParents();
    Parent getParentById(int parentId);
    Parent createParent(Parent parent);
    Parent updateParent(int parentId, Parent parentDetails);
    void deleteParent(int parentId);
    // Business logic methods
    void monitorProgress(int parentId);
    void communicateWithTeacher(int parentId);
    void viewReports(int parentId);
    void receiveNotifications(int parentId);
    void makePayment(int parentId);
}