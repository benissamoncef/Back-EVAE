package com.example.demo.service;

import com.example.demo.model.Formation;
import com.example.demo.repository.FormationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    private final FormationDao formationDao;

    @Autowired
    public FormationService(FormationDao formationDao) {
        this.formationDao = formationDao;
    }

    /**
     * Récupère toutes les formations.
     *
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la liste des formations.
     */
    public ResponseEntity<?> getAllFormations() {
        List<Formation> formations = formationDao.findAll();
        return ResponseEntity.ok().body(formations);
    }

    /**
     * Enregistre une nouvelle formation.
     *
     * @param formation La formation à enregistrer.
     * @return ResponseEntity avec le code de statut HTTP 201 Created et un message indiquant le succès de l'opération.
     */
    public ResponseEntity<?> saveFormation(Formation formation) {
        formationDao.save(formation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Formation enregistrée avec succès");
    }

    /**
     * Récupère une formation par son ID.
     *
     * @param id L'ID de la formation à récupérer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la formation correspondante si trouvée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> getFormationById(Long id) {
        Formation formation = formationDao.findById(id).orElse(null);
        if (formation != null) {
            return ResponseEntity.ok().body(formation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formation non trouvée");
        }
    }

    /**
     * Supprime une formation par son ID.
     *
     * @param id L'ID de la formation à supprimer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et un message indiquant le succès de l'opération si la formation est supprimée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> deleteFormationById(Long id) {
        if (formationDao.existsById(id)) {
            formationDao.deleteById(id);
            return ResponseEntity.ok().body("Formation supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formation non trouvée");
        }
    }

}
