package com.example.ecole.entity;


import jakarta.persistence.*;
import lombok.*;


/**
 * La classe Administrator représente un utilisateur administratif dans le système.
 * Cette classe étend la classe User et hérite de ses propriétés.
 * Elle inclut des champs supplémentaires spécifiques aux administrateurs.
 */
@Entity
@Data
@NoArgsConstructor  // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
@EqualsAndHashCode(callSuper = true) // Annotation Lombok pour générer les méthodes equals et hashCode, incluant les champs de la classe parente
public class Administrator extends User {

        private String department; // Département auquel l'administrateur est affecté
        private String officeNumber; // Numéro de bureau de l'administrateur
        private String phoneExtension; // Extension téléphonique de l'administrateur

}

