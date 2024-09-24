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
 * La classe Quiz représente un quiz dans le système.
 * Elle inclut des informations sur le titre, l'identifiant du cours, l'identifiant de l'enseignant,
 * la date limite, l'accessibilité, la description et les relations avec les questions et les cours.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quizId; // Identifiant unique pour chaque quiz, généré automatiquement par la base de données

    private String title; // Titre du quiz
    @ManyToOne
    @JoinColumn(name = "coursId")
    @JsonBackReference // To handle serialization and prevent infinite loops
    private Cours cours;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Question> questions = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private  QuizType quizType;
    private Date dueDate; // Date limite pour compléter le quiz
    private boolean isAccessible; // Indique si le quiz est accessible
    private String quizDescription; // Description du quiz



}