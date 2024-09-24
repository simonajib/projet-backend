package com.example.ecole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La classe Student représente un étudiant dans le système.
 * Elle étend la classe User et ajoute des champs spécifiques aux étudiants.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
@EqualsAndHashCode(callSuper = true) // Annotation Lombok pour générer les méthodes equals et hashCode, incluant les champs de la classe parente
public class Student extends User {


   @ManyToOne
   private GradeLevel gradeLevel; // Niveau scolaire de l'étudiant
    // Relation Many-to-One avec l'entité Parent
    @ManyToOne
    private Parent parent; // Référence au parent associé à cet étudiant
}
