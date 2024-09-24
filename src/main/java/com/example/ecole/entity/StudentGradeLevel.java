package com.example.ecole.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La classe StudentClass représente une association entre un étudiant et une classe.
 * Elle inclut des informations sur les relations avec les entités Student et Classb.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public class StudentGradeLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentGradeLevelId; // Identifiant unique pour chaque association, généré automatiquement par la base de données

    @ManyToOne // Relation Many-to-One avec l'entité Student
    private Student student; // Référence à l'étudiant associé à cette association

    @ManyToOne // Relation Many-to-One avec l'entité Classb
    private GradeLevel gradeLevel; // Référence à la classe associée à cette association
}
