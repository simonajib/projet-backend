package com.example.ecole.services;

import com.example.ecole.entity.Administrator;

import java.util.List;

public interface AdministratorService {
    List<Administrator> getAllAdministrators();
    Administrator getAdministratorById(int adminId);
    Administrator createAdministrator(Administrator administrator);
    Administrator updateAdministrator(int adminId, Administrator administratorDetails);
    void deleteAdministrator(int adminId);
    // Business logic methods
    void manageUsers(int adminId);
    void generateReports(int adminId);
    void configureSettings(int adminId);
    void resolveIssues(int adminId);
}