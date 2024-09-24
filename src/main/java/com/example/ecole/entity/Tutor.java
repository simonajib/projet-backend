package com.example.ecole.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Tutor représente un tuteur dans le système.
 * Elle étend la classe User et ajoute des champs spécifiques aux tuteurs.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
@EqualsAndHashCode(callSuper = true) // Annotation Lombok pour générer les méthodes equals et hashCode, incluant les champs de la classe parente
public class Tutor extends User {

    private String subject; // Matière enseignée par le tuteur


}
