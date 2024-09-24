package com.example.ecole.services.Impl;

import com.example.ecole.entity.Payment;
import com.example.ecole.repositories.PaymentRepository;
import com.example.ecole.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité Payment.
 * Cette classe contient la logique métier pour gérer les paiements.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * Récupère tous les paiements.
     *
     * @return une liste de tous les paiements
     */
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    /**
     * Récupère un paiement par son identifiant.
     *
     * @param paymentId l'identifiant du paiement à récupérer
     * @return le paiement trouvé ou lance une exception si non trouvé
     */
    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));
    }

    /**
     * Crée un nouveau paiement.
     *
     * @param payment le paiement à créer
     * @return le paiement créé
     */
    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    /**
     * Met à jour un paiement existant.
     *
     * @param paymentId l'identifiant du paiement à mettre à jour
     * @param paymentDetails les nouveaux détails du paiement
     * @return le paiement mis à jour ou lance une exception si non trouvé
     */
    @Override
    public Payment updatePayment(int paymentId, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));

        payment.setAmount(paymentDetails.getAmount());
        payment.setDate(paymentDetails.getDate());
        payment.setGrade(paymentDetails.getGrade());
        payment.setStudent(paymentDetails.getStudent());

        return paymentRepository.save(payment);
    }

    /**
     * Supprime un paiement par son identifiant.
     *
     * @param paymentId l'identifiant du paiement à supprimer
     */
    @Override
    public void deletePayment(int paymentId) {
        if (!paymentRepository.existsById(paymentId)) {
            throw new RuntimeException("Payment not found with id " + paymentId);
        }
        paymentRepository.deleteById(paymentId);
    }

    /**
     * Traite un paiement pour un paiement spécifique.
     *
     * @param paymentId l'identifiant du paiement
     */
    @Override
    public void processPayment(int paymentId) {
        // Implémenter la logique métier pour traiter le paiement
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Rembourse un paiement pour un paiement spécifique.
     *
     * @param paymentId l'identifiant du paiement
     */
    @Override
    public void refundPayment(int paymentId) {
        // Implémenter la logique métier pour rembourser le paiement
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Génère un reçu pour un paiement spécifique.
     *
     * @param paymentId l'identifiant du paiement
     */
    @Override
    public void generateReceipt(int paymentId) {
        // Implémenter la logique métier pour générer un reçu
        throw new UnsupportedOperationException("Method not yet implemented");
    }
}
