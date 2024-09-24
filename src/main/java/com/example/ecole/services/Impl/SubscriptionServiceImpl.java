package com.example.ecole.services.Impl;

import com.example.ecole.entity.Subscription;
import com.example.ecole.repositories.SubscriptionRepository;
import com.example.ecole.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité Subscription.
 * Cette classe contient la logique métier pour gérer les abonnements.
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    /**
     * Récupère toutes les abonnements.
     *
     * @return une liste de toutes les abonnements
     */
    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    /**
     * Récupère un abonnement par son identifiant.
     *
     * @param subscriptionId l'identifiant de l'abonnement à récupérer
     * @return l'abonnement trouvé ou null si non trouvé
     */
    @Override
    public Subscription getSubscriptionById(int subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepository.findById(subscriptionId);
        return subscription.orElse(null);
    }

    /**
     * Crée un nouvel abonnement.
     *
     * @param subscription l'abonnement à créer
     * @return l'abonnement créé
     */
    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    /**
     * Met à jour un abonnement existant.
     *
     * @param subscriptionId l'identifiant de l'abonnement à mettre à jour
     * @param subscriptionDetails les nouveaux détails de l'abonnement
     * @return l'abonnement mis à jour ou null si non trouvé
     */
    @Override
    public Subscription updateSubscription(int subscriptionId, Subscription subscriptionDetails) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(subscriptionId);
        if (optionalSubscription.isPresent()) {
            Subscription subscription = optionalSubscription.get();
            subscription.setType(subscriptionDetails.getType());
            subscription.setStartDate(subscriptionDetails.getStartDate());
            subscription.setEndDate(subscriptionDetails.getEndDate());
            subscription.setPayment(subscriptionDetails.getPayment());
            return subscriptionRepository.save(subscription);
        }
        return null;
    }

    /**
     * Supprime un abonnement par son identifiant.
     *
     * @param subscriptionId l'identifiant de l'abonnement à supprimer
     */
    @Override
    public void deleteSubscription(int subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    /**
     * Abonne un utilisateur spécifique.
     *
     * @param subscriptionId l'identifiant de l'abonnement
     */
    @Override
    public void subscribe(int subscriptionId) {
        // Implémenter la logique métier pour s'abonner
    }

    /**
     * Désabonne un utilisateur spécifique.
     *
     * @param subscriptionId l'identifiant de l'abonnement
     */
    @Override
    public void unsubscribe(int subscriptionId) {
        // Implémenter la logique métier pour se désabonner
    }

    /**
     * Examine un abonnement spécifique.
     *
     * @param subscriptionId l'identifiant de l'abonnement
     */
    @Override
    public void reviewSubscription(int subscriptionId) {
        // Implémenter la logique métier pour examiner l'abonnement
    }
}
