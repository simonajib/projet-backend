package com.example.ecole.controller;

import com.example.ecole.entity.User;
import com.example.ecole.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les utilisateurs.
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")

public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Récupère tous les utilisateurs.
     *
     * @return une liste de tous les utilisateurs
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param userId l'identifiant de l'utilisateur à récupérer
     * @return l'utilisateur trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Crée un nouvel utilisateur.
     *
     * @param user les détails de l'utilisateur à créer
     * @return l'utilisateur créé
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * Met à jour un utilisateur existant.
     *
     * @param userId les détails de l'utilisateur à mettre à jour
     * @param userDetails les nouveaux détails de l'utilisateur
     * @return l'utilisateur mis à jour ou une réponse 404 si non trouvé
     */
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(userId, userDetails);
        return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un utilisateur par son identifiant.
     *
     * @param userId l'identifiant de l'utilisateur à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère un utilisateur par son email.
     *
     * @param email l'email de l'utilisateur à récupérer
     * @return l'utilisateur trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/email")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
