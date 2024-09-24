package com.example.ecole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * La classe Subscription représente un abonnement dans le système.
 * Elle inclut des informations sur le type, les dates de début et de fin,
 * et les relations avec les paiements.
 */
@Entity
@Data // Annotation Lombok qui génère les méthodes getters, setters, toString, equals et hashCode
@NoArgsConstructor // Annotation Lombok pour générer un constructeur sans arguments
@AllArgsConstructor // Annotation Lombok pour générer un constructeur avec des arguments pour tous les champs
@Builder // Annotation Lombok pour permettre l'utilisation du pattern Builder pour cette classe
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionId; // Identifiant unique pour chaque abonnement, généré automatiquement par la base de données

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;
    private Date startDate; // Date de début de l'abonnement
    private Date endDate; // Date de fin de l'abonnement

    @ManyToOne // Relation Many-to-One avec l'entité Payment
    private Payment payment; // Référence au paiement associé à cet abonnement
}
