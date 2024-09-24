package com.example.ecole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Class représente une classe dans le système.
 * Elle inclut des informations sur le nom, la description, l'identifiant de l'enseignant,
 * et les associations avec des cours et des étudiants.
 */
@Entity
@Data
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public class Classb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId; // Identifiant unique pour chaque classe, généré automatiquement par la base de données
    private String name;        // Nom de la classe
    private String description; // Description de la classe

    @ManyToOne // Relation Many-to-One avec l'entité Teacher
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne // Relation Many-to-One avec l'entité GradeLevel
    @JoinColumn(name = "grade_level_id")
    private GradeLevel gradeLevel; // Le niveau de classe associé



}
