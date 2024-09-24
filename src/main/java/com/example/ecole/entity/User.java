package com.example.ecole.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * La classe User représente un utilisateur dans le système.
 * C'est une classe abstraite qui sert de base pour d'autres types d'utilisateurs comme les étudiants, les enseignants, etc.
 * Elle inclut des informations sur l'identifiant, le nom, l'email, le mot de passe, le rôle et la date d'inscription.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Spécifie que la stratégie d'héritage est JOINED
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId; // Identifiant unique pour chaque utilisateur, généré automatiquement par la base de données
    private String name; // Nom de l'utilisateur
    private String email; // Email de l'utilisateur
    private String password; // Mot de passe de l'utilisateur
    @Enumerated(EnumType.STRING) // Stocke l'énumération en tant que chaîne dans la base de données
    private Role role; // Rôle de l'utilisateur (par exemple, étudiant, enseignant, etc.)

    private Date dateJoined; // Date d'inscription de l'utilisateur




}
