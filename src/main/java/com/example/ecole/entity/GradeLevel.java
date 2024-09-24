package com.example.ecole.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor  // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec des arguments pour tous les champs
public class GradeLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeLevelId; // Identifiant unique pour chaque niveau de classe, généré automatiquement par la base de données

    private String levelName; // Nom du niveau de classe (ex. "CP", "CE1", "6e", "1ère année")

    private String description; // Description supplémentaire du niveau de classe


}