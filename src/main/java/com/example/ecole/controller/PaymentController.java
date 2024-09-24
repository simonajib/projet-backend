package com.example.ecole.controller;

import com.example.ecole.entity.Payment;
import com.example.ecole.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour l'entité Payment.
 * Cette classe expose les API pour gérer les paiements.
 */
@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * Récupère tous les paiements.
     *
     * @return une liste de tous les paiements
     */
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Récupère un paiement par son identifiant.
     *
     * @param paymentId l'identifiant du paiement à récupérer
     * @return le paiement trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int paymentId) {
        try {
            Payment payment = paymentService.getPaymentById(paymentId);
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Crée un nouveau paiement.
     *
     * @param payment le paiement à créer
     * @return le paiement créé
     */
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    /**
     * Met à jour un paiement existant.
     *
     * @param paymentId l'identifiant du paiement à mettre à jour
     * @param paymentDetails les nouveaux détails du paiement
     * @return le paiement mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int paymentId, @RequestBody Payment paymentDetails) {
        try {
            Payment updatedPayment = paymentService.updatePayment(paymentId, paymentDetails);
            return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Supprime un paiement par son identifiant.
     *
     * @param paymentId l'identifiant du paiement à supprimer
     * @return une réponse 204 si supprimé avec succès ou une réponse 404 si non trouvé
     */
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable int paymentId) {
        try {
            paymentService.deletePayment(paymentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Traite un paiement pour un paiement spécifique.
     *
     * @param paymentId l'identifiant du paiement
     */
    @PostMapping("/{paymentId}/process")
    public ResponseEntity<Void> processPayment(@PathVariable int paymentId) {
        try {
            paymentService.processPayment(paymentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    /**
     * Rembourse un paiement pour un paiement spécifique.
     *
     * @param paymentId l'identifiant du paiement
     */
    @PostMapping("/{paymentId}/refund")
    public ResponseEntity<Void> refundPayment(@PathVariable int paymentId) {
        try {
            paymentService.refundPayment(paymentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    /**
     * Génère un reçu pour un paiement spécifique.
     *
     * @param paymentId l'identifiant du paiement
     */
    @PostMapping("/{paymentId}/receipt")
    public ResponseEntity<Void> generateReceipt(@PathVariable int paymentId) {
        try {
            paymentService.generateReceipt(paymentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
