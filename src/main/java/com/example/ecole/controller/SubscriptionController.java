package com.example.ecole.controller;

import com.example.ecole.entity.Subscription;
import com.example.ecole.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les abonnements.
 */
@RestController
@RequestMapping("/api/subscriptions")
@CrossOrigin("*")

public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    /**
     * Récupère toutes les abonnements.
     *
     * @return une liste de toutes les abonnements
     */
    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    /**
     * Récupère un abonnement par son identifiant.
     *
     * @param subscriptionId l'identifiant de l'abonnement à récupérer
     * @return l'abonnement trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{subscriptionId}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable int subscriptionId) {
        Subscription subscription = subscriptionService.getSubscriptionById(subscriptionId);
        return subscription != null ? new ResponseEntity<>(subscription, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouvel abonnement.
     *
     * @param subscription l'abonnement à créer
     * @return l'abonnement créé
     */
    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription createdSubscription = subscriptionService.createSubscription(subscription);
        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
    }

    /**
     * Met à jour un abonnement existant.
     *
     * @param subscriptionId l'identifiant de l'abonnement à mettre à jour
     * @param subscriptionDetails les nouveaux détails de l'abonnement
     * @return l'abonnement mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{subscriptionId}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable int subscriptionId, @RequestBody Subscription subscriptionDetails) {
        Subscription updatedSubscription = subscriptionService.updateSubscription(subscriptionId, subscriptionDetails);
        return updatedSubscription != null ? new ResponseEntity<>(updatedSubscription, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un abonnement par son identifiant.
     *
     * @param subscriptionId l'identifiant de l'abonnement à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable int subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Abonne un utilisateur spécifique.
     *
     * @param subscriptionId l'identifiant de l'abonnement
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{subscriptionId}/subscribe")
    public ResponseEntity<Void> subscribe(@PathVariable int subscriptionId) {
        subscriptionService.subscribe(subscriptionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Désabonne un utilisateur spécifique.
     *
     * @param subscriptionId l'identifiant de l'abonnement
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{subscriptionId}/unsubscribe")
    public ResponseEntity<Void> unsubscribe(@PathVariable int subscriptionId) {
        subscriptionService.unsubscribe(subscriptionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Examine un abonnement spécifique.
     *
     * @param subscriptionId l'identifiant de l'abonnement
     * @return une réponse 200 si l'opération est réussie
     */
    @GetMapping("/{subscriptionId}/review")
    public ResponseEntity<Void> reviewSubscription(@PathVariable int subscriptionId) {
        subscriptionService.reviewSubscription(subscriptionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
