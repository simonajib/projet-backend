package com.example.ecole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La classe Cours représente un cours dans le système.
 * Elle inclut des informations sur le titre, le contenu, les dates de création et de mise à jour,
 * ainsi que les relations avec les classes, les quiz, les devoirs et les ressources.
 */
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
@NoArgsConstructor  // Annotation Lombok pour générer un constructeur sans arguments
@Data               // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@Entity             // Indique que cette classe est une entité JPA et sera mappée à une table de base de données
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coursId; // Identifiant unique pour chaque cours, généré automatiquement par la base de données

    private String title;           // Titre du cours
    private String content;         // Contenu du cours
    private Date createdDate;       // Date de création du cours
    private Date lastUpdatedDate;   // Date de la dernière mise à jour du cours

    @ManyToOne // Relation Many-to-One avec l'entité Classb

    private Classb classe;     // Renommé pour éviter le conflit avec le mot-clé réservé `Class`



    // OneToMany relationship with Resource
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true) // Cours is the parent in this relation
    @JsonManagedReference // To manage the reference during serialization
    private List<Resource> resources; // A course can have many resources
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true) // Cours is the parent in this relation
    @JsonManagedReference // To manage the reference during serialization
    private List<Assignment> assignments; // A course can have many assignments
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Quiz> quizzes; // A course can have many quizzes
}
