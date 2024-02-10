package com.example.demo.service;

import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantService {
    private final EtudiantDao etudiantDao;

    @Autowired
    public EtudiantService(EtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }


    /**
     * Récuperer la liste des Etudiants
     *
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la liste des formations.
     */
    public ResponseEntity<?> getAllEtudiants(){
        List<Etudiant> etudiants = etudiantDao.findAll();
        return ResponseEntity.ok().body(etudiants);
    }

    /**
     * Récupère un étudiant par son ID.
     *
     * @param id L'ID de l'étudiant à récupérer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et l'étudiant correspondant si trouvé, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> getEtudiantById(Long id) {
        Etudiant etudiant = etudiantDao.findById(id).orElse(null);
        if (etudiant != null) {
            return ResponseEntity.ok().body(etudiant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant non trouvé");
        }
    }

    public Etudiant getEtudiantByNE(String id) {
        Etudiant etudiant = etudiantDao.findByNoEtudiantNat(id);

            return etudiant;

    }


    /**
     * Enregistre un nouveau Etudiant.
     *
     * @param etudiant L'étudiant à enregistrer.
     * @return ResponseEntity avec le code de statut HTTP 201 Created et un message indiquant le succès de l'opération.
     */
    public ResponseEntity<?> saveEtudiant(Etudiant etudiant) {
        etudiantDao.save(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body("Etudiant enregistré avec succès");
    }


    /**
     * Supprime un étudiant par son ID.
     *
     * @param id L'ID de l'étudiant à supprimer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et un message indiquant le succès de l'opération si l'étudiant est supprimé, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> deleteEtudiantById(Long id) {
        if (etudiantDao.existsById(id)) {
            etudiantDao.deleteById(id);
            return ResponseEntity.ok().body("Étudiant supprimé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant non trouvé");
        }
    }



}
