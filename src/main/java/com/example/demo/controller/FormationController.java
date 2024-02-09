package com.example.demo.controller;

import com.example.demo.model.Formation;
import com.example.demo.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les opérations sur les formations.
 */
@RestController
@RequestMapping("/api/formations")
public class FormationController {

    private final FormationService formationService;

    /**
     * Constructeur pour le contrôleur de formation.
     *
     * @param formationService Le service de formation à injecter.
     */
    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    /**
     * Récupère toutes les formations.
     *
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la liste de toutes les formations.
     */
    @GetMapping
    public ResponseEntity<?> getAllFormations() {
        return formationService.getAllFormations();
    }

    /**
     * Récupère une formation par son ID.
     *
     * @param id L'ID de la formation à récupérer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la formation correspondante si trouvée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getFormationById(@PathVariable Long id) {
        return formationService.getFormationById(id);
    }

    /**
     * Enregistre une nouvelle formation.
     *
     * @param formation La formation à enregistrer.
     * @return ResponseEntity avec le code de statut HTTP 201 Created et un message indiquant le succès de l'opération.
     */
    @PostMapping
    public ResponseEntity<?> saveFormation(@RequestBody Formation formation) {
        return formationService.saveFormation(formation);
    }


    /**
     * Supprime une formation par son ID.
     *
     * @param id L'ID de la formation à supprimer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et un message indiquant le succès de l'opération si la formation est supprimée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFormationById(@PathVariable Long id) {
        return formationService.deleteFormationById(id);
    }
}
