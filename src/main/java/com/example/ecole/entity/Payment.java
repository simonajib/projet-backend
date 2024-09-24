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
 * La classe Payment représente un paiement dans le système.
 * Elle inclut des informations sur le montant, la date, les identifiants de l'étudiant et de la classe,
 * et les relations avec les étudiants et les abonnements.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId; // Identifiant unique pour chaque paiement, généré automatiquement par la base de données

    private float amount;  // Montant du paiement
    private Date date;     // Date du paiement
    @ManyToOne  // Many payments can be linked to one grade level
    @JoinColumn(name = "grade_id", nullable = false)  // Ensures that grade_id is always provided
    private GradeLevel grade;
    @ManyToOne // Relation Many-to-One avec l'entité Student
    private Student student; // Référence à l'étudiant associé à ce paiement

    }
