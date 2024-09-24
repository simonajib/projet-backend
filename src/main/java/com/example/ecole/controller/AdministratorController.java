package com.example.ecole.controller;

import com.example.ecole.entity.Administrator;
import com.example.ecole.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les administrateurs.
 */
@RestController
@RequestMapping("/api/administrators")
@CrossOrigin("*")

public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    /**
     * Récupère tous les administrateurs.
     *
     * @return une liste de tous les administrateurs
     */
    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> administrators = administratorService.getAllAdministrators();
        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }

    /**
     * Récupère un administrateur par son identifiant.
     *
     * @param adminId l'identifiant de l'administrateur à récupérer
     * @return l'administrateur trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable("id") int adminId) {
        Administrator administrator = administratorService.getAdministratorById(adminId);
        return administrator != null ? new ResponseEntity<>(administrator, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouvel administrateur.
     *
     * @param administrator les détails de l'administrateur à créer
     * @return l'administrateur créé
     */
    @PostMapping
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        Administrator createdAdministrator = administratorService.createAdministrator(administrator);
        return new ResponseEntity<>(createdAdministrator, HttpStatus.CREATED);
    }

    /**
     * Met à jour un administrateur existant.
     *
     * @param adminId l'identifiant de l'administrateur à mettre à jour
     * @param administratorDetails les nouveaux détails de l'administrateur
     * @return l'administrateur mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable("id") int adminId, @RequestBody Administrator administratorDetails) {
        Administrator updatedAdministrator = administratorService.updateAdministrator(adminId, administratorDetails);
        return updatedAdministrator != null ? new ResponseEntity<>(updatedAdministrator, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un administrateur par son identifiant.
     *
     * @param adminId l'identifiant de l'administrateur à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable("id") int adminId) {
        administratorService.deleteAdministrator(adminId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Gère les utilisateurs pour un administrateur spécifique.
     *
     * @param adminId l'identifiant de l'administrateur
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/manage-users")
    public ResponseEntity<Void> manageUsers(@PathVariable("id") int adminId) {
        administratorService.manageUsers(adminId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Génère des rapports pour un administrateur spécifique.
     *
     * @param adminId l'identifiant de l'administrateur
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/generate-reports")
    public ResponseEntity<Void> generateReports(@PathVariable("id") int adminId) {
        administratorService.generateReports(adminId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Configure les paramètres pour un administrateur spécifique.
     *
     * @param adminId l'identifiant de l'administrateur
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/configure-settings")
    public ResponseEntity<Void> configureSettings(@PathVariable("id") int adminId) {
        administratorService.configureSettings(adminId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Résout les problèmes pour un administrateur spécifique.
     *
     * @param adminId l'identifiant de l'administrateur
     * @return une réponse indiquant le succès de l'opération
     */
    @PostMapping("/{id}/resolve-issues")
    public ResponseEntity<Void> resolveIssues(@PathVariable("id") int adminId) {
        administratorService.resolveIssues(adminId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
