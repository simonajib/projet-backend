package com.example.ecole.controller;

import com.example.ecole.entity.Cours;
import com.example.ecole.services.CoursServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController pour gérer les cours.
 * Expose des endpoints RESTful pour les opérations CRUD.
 */
@RestController
@RequestMapping("/api/cours")
@CrossOrigin("*")
public class CoursController {

    @Autowired
    private CoursServices coursServices;

    /**
     * Enregistre un nouveau cours.
     *
     * @param cours le cours à enregistrer
     * @return le cours enregistré
     */
    @PostMapping
    public ResponseEntity<Cours> saveCours(@RequestBody Cours cours) {
        Cours savedCours = coursServices.SaveCours(cours);
        return new ResponseEntity<>(savedCours, HttpStatus.CREATED);
    }

    /**
     * Met à jour un cours existant.
     *
     * @param cours le cours à mettre à jour
     * @return le cours mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping
    public ResponseEntity<Cours> updateCours(@RequestBody Cours cours) {
        Cours updatedCours = coursServices.UpdateCours(cours);
        return updatedCours != null ? new ResponseEntity<>(updatedCours, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un cours par son identifiant.
     *
     * @param id l'identifiant du cours à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoursById(@PathVariable("id") Long id) {
        coursServices.DeleteCoursById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Supprime tous les cours.
     *
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteAllCours() {
        coursServices.DeleteAllCours();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère un cours par son identifiant.
     *
     * @param id l'identifiant du cours à récupérer
     * @return le cours trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursById(@PathVariable("id") Long id) {
        Cours cours = coursServices.getCoursById(id);
        return cours != null ? new ResponseEntity<>(cours, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Récupère tous les cours.
     *
     * @return une liste de tous les cours
     */
    @GetMapping
    public ResponseEntity<List<Cours>> getAllCours() {
        List<Cours> cours = coursServices.getAllCours();
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }
}
