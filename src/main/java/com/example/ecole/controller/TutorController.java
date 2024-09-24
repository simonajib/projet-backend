package com.example.ecole.controller;

import com.example.ecole.entity.Tutor;
import com.example.ecole.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les tuteurs.
 */
@RestController
@RequestMapping("/api/tutors")
@CrossOrigin("*")

public class TutorController {

    @Autowired
    private TutorService tutorService;

    /**
     * Récupère tous les tuteurs.
     *
     * @return une liste de tous les tuteurs
     */
    @GetMapping
    public ResponseEntity<List<Tutor>> getAllTutors() {
        List<Tutor> tutors = tutorService.getAllTutors();
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    /**
     * Récupère un tuteur par son identifiant.
     *
     * @param tutorId l'identifiant du tuteur à récupérer
     * @return le tuteur trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{tutorId}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable int tutorId) {
        Tutor tutor = tutorService.getTutorById(tutorId);
        return tutor != null ? new ResponseEntity<>(tutor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouveau tuteur.
     *
     * @param tutor le tuteur à créer
     * @return le tuteur créé
     */
    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor createdTutor = tutorService.createTutor(tutor);
        return new ResponseEntity<>(createdTutor, HttpStatus.CREATED);
    }

    /**
     * Met à jour un tuteur existant.
     *
     * @param tutorId l'identifiant du tuteur à mettre à jour
     * @param tutorDetails les nouveaux détails du tuteur
     * @return le tuteur mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{tutorId}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable int tutorId, @RequestBody Tutor tutorDetails) {
        Tutor updatedTutor = tutorService.updateTutor(tutorId, tutorDetails);
        return updatedTutor != null ? new ResponseEntity<>(updatedTutor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un tuteur par son identifiant.
     *
     * @param tutorId l'identifiant du tuteur à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{tutorId}")
    public ResponseEntity<Void> deleteTutor(@PathVariable int tutorId) {
        tutorService.deleteTutor(tutorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Suit les progrès d'un tuteur spécifique.
     *
     * @param tutorId l'identifiant du tuteur
     * @return une réponse 200 si l'opération est réussie
     */
    @GetMapping("/{tutorId}/monitorProgress")
    public ResponseEntity<Void> monitorProgress(@PathVariable int tutorId) {
        tutorService.monitorProgress(tutorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Fournit des retours pour un tuteur spécifique.
     *
     * @param tutorId l'identifiant du tuteur
     * @param feedback les retours à fournir
     * @return une réponse 200 si l'opération est réussie
     */
    @PostMapping("/{tutorId}/provideFeedback")
    public ResponseEntity<Void> provideFeedback(@PathVariable int tutorId, @RequestParam String feedback) {
        tutorService.provideFeedback(tutorId, feedback);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
