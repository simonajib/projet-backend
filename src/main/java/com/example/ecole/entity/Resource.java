package com.example.ecole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.File;

/**
 * La classe Resource représente une ressource dans le système.
 * Elle est abstraite et sert de classe de base pour d'autres types de ressources.
 * Elle inclut des informations sur le titre, l'URL et les relations avec les cours.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public  class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;
    private String title;
    private String path;   // This is the path to the resource file
    @Enumerated(EnumType.STRING) // Stocke l'énumération en tant que chaîne dans la base de données
    private Category type; // The type of the resource (DOCUMENT or VIDEO)

    @ManyToOne
    @JsonBackReference // To avoid circular references during serialization
    private Cours cours;




}
