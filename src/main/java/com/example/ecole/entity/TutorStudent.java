package com.example.ecole.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La classe TutorStudent représente une association entre un tuteur et un étudiant.
 * Elle inclut des informations sur les relations avec les entités Tutor et Student.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public class TutorStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tutorStudentId; // Identifiant unique pour chaque association, généré automatiquement par la base de données

    // Relation Many-to-One avec l'entité Tutor
    @ManyToOne
    private Tutor tutor; // Référence au tuteur associé à cette association

    // Relation Many-to-One avec l'entité Student
    @ManyToOne
    private Student student; // Référence à l'étudiant associé à cette association
}
