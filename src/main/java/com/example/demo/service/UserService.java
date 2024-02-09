package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Récupère un utilisateur par son ID.
     *
     * @param id L'ID de l'utilisateur à récupérer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et l'utilisateur correspondant si trouvé, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> getUserById(Long id) {
        Optional<User> userOptional = userDao.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok().body(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé");
        }
    }

    /**
     * Enregistre un nouvel utilisateur.
     *
     * @param user L'utilisateur à enregistrer.
     * @return ResponseEntity avec le code de statut HTTP 201 Created et un message indiquant le succès de l'opération.
     */
    public ResponseEntity<?> saveUser(User user) {
        userDao.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur enregistré avec succès");
    }

    /**
     * Supprime un utilisateur par son ID.
     *
     * @param id L'ID de l'utilisateur à supprimer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et un message indiquant le succès de l'opération si l'utilisateur est supprimé, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> deleteUserById(Long id) {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
            return ResponseEntity.ok().body("Utilisateur supprimé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé");
        }
    }

    // Ajoutez ici d'autres méthodes pour le service utilisateur, telles que getAllUsers, updateUser, etc.
}
