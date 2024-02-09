package com.example.demo.controller;

import com.example.demo.model.Etudiant;
import com.example.demo.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les opérations sur les étudiants.
 */
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    /**
     * Constructeur pour le contrôleur d'étudiant.
     *
     * @param etudiantService Le service d'étudiant à injecter.
     */
    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    /**
     * Récupère tous les étudiants.
     *
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la liste de tous les étudiants.
     */
    @GetMapping
    public ResponseEntity<?> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    /**
     * Récupère un étudiant par son ID.
     *
     * @param id L'ID de l'étudiant à récupérer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et l'étudiant correspondant si trouvé, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    /**
     * Enregistre un nouvel étudiant.
     *
     * @param etudiant L'étudiant à enregistrer.
     * @return ResponseEntity avec le code de statut HTTP 201 Created et un message indiquant le succès de l'opération.
     */
    @PostMapping
    public ResponseEntity<?> saveEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    /**
     * Supprime un étudiant par son ID.
     *
     * @param id L'ID de l'étudiant à supprimer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et un message indiquant le succès de l'opération si l'étudiant est supprimé, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEtudiantById(@PathVariable Long id) {
        return etudiantService.deleteEtudiantById(id);
    }
}
