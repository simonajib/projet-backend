package com.example.ecole.services;

import com.example.ecole.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(int subscriptionId);
    Subscription createSubscription(Subscription subscription);
    Subscription updateSubscription(int subscriptionId, Subscription subscriptionDetails);
    void deleteSubscription(int subscriptionId);
    // Business logic methods
    void subscribe(int subscriptionId);
    void unsubscribe(int subscriptionId);
    void reviewSubscription(int subscriptionId);
}