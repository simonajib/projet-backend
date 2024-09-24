package com.example.ecole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * La classe Question représente une question dans un quiz.
 * Elle inclut des informations sur le contenu de la question, les choix de réponse,
 * la réponse correcte, l'explication et la relation avec un quiz.
 */
@Entity
@Table(name = "questions") // Spécifie le nom de la table dans la base de données
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId; // Identifiant unique pour chaque question, généré automatiquement par la base de données

    private String content; // Contenu de la question

    @ElementCollection // Indique qu'il s'agit d'une collection d'éléments intégrés
    private List<String> choices; // Liste des choix de réponse

    private String correctAnswer; // Réponse correcte à la question
    private String explanation; // Explication de la réponse correcte
    @ManyToOne // Relation Many-to-One avec l'entité Quiz
    @JsonBackReference
    private Quiz quiz; // Référence au quiz associé à cette question
}
