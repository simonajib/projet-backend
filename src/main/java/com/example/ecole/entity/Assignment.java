package com.example.ecole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * La classe Assignment représente un devoir ou une tâche dans le système.
 * Elle inclut des informations sur le titre, la description, la date limite,
 * et les associations avec des cours et des classes.
 */
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
@NoArgsConstructor  // Annotation Lombok pour générer un constructeur sans arguments
@Data               // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@Entity             // Indique que cette classe est une entité JPA et sera mappée à une table de base de données
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignmentId; // Identifiant unique pour chaque devoir, généré automatiquement par la base de données

    private String title;       // Titre du devoir
    private String description; // Description du devoir

    @ManyToOne // Many-to-One relationship with Cours
    @JsonBackReference // To avoid circular references during serialization
    private Cours cours;

}
