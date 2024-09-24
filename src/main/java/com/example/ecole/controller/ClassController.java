package com.example.ecole.controller;

import com.example.ecole.entity.Classb;
import com.example.ecole.services.ClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController pour gérer les classes.
 * Expose des endpoints RESTful pour les opérations CRUD.
 */
@RestController
@RequestMapping("/api/classes")

@CrossOrigin("*")

public class ClassController {

    @Autowired
    private ClassServices classServices;

    /**
     * Enregistre une nouvelle classe.
     *
     * @param classe la classe à enregistrer
     * @return la classe enregistrée
     */
    @PostMapping
    public ResponseEntity<Classb> saveClass(@RequestBody Classb classe) {
        Classb savedClass = classServices.SaveClass(classe);
        return new ResponseEntity<>(savedClass, HttpStatus.CREATED);
    }

    /**
     * Met à jour une classe existante.
     *
     * @param classe la classe à mettre à jour
     * @return la classe mise à jour ou une réponse 404 si non trouvée
     */
    @PutMapping
    public ResponseEntity<Classb> updateClass(@RequestBody Classb classe) {
        Classb updatedClass = classServices.UpdateClass(classe);
        return updatedClass != null ? new ResponseEntity<>(updatedClass, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime une classe par son identifiant.
     *
     * @param id l'identifiant de la classe à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassById(@PathVariable("id") Long id) {
        classServices.DeleteClassById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Supprime toutes les classes.
     *
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteAllClasses() {
        classServices.DeleteAllClasss();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère une classe par son identifiant.
     *
     * @param id l'identifiant de la classe à récupérer
     * @return la classe trouvée ou une réponse 404 si non trouvée
     */
    @GetMapping("/{id}")
    public ResponseEntity<Classb> getClassById(@PathVariable("id") Long id) {
        Classb classe = classServices.getClassById(id);
        return classe != null ? new ResponseEntity<>(classe, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Récupère toutes les classes.
     *
     * @return une liste de toutes les classes
     */
    @GetMapping
    public ResponseEntity<List<Classb>> getAllClasses() {
        List<Classb> classes = classServices.getAllClasss();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }
}
