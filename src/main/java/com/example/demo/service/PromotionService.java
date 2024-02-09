package com.example.demo.service;

import com.example.demo.model.Formation;
import com.example.demo.model.Promotion;
import com.example.demo.repository.PromotionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    private final PromotionDao promotionDao;

    @Autowired
    public PromotionService(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }


    /**
     * Récupère toutes les promotions.
     *
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la liste des promotions.
     */
    public ResponseEntity<?> getAllPromotions() {
        List<Promotion> promotions = promotionDao.findAll();
        return ResponseEntity.ok().body(promotions);
    }

    /**
     * Récupère une promotion par son ID.
     *
     * @param id L'ID de la promotion à récupérer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la promotion correspondante si trouvée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> getPromotionById(Long id) {
        Optional<Promotion> promotionOptional = promotionDao.findById(id);
        if (promotionOptional.isPresent()) {
            return ResponseEntity.ok().body(promotionOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promotion non trouvée");
        }
    }

    /**
     * Enregistre une nouvelle promotion.
     *
     * @param promotion La promotion à enregistrer.
     * @return ResponseEntity avec le code de statut HTTP 201 Created et un message indiquant le succès de l'opération.
     */
    public ResponseEntity<?> savePromotion(Promotion promotion) {
        promotionDao.save(promotion);
        return ResponseEntity.status(HttpStatus.CREATED).body("Promotion enregistrée avec succès");
    }

    /**
     * Supprime une promotion par son ID.
     *
     * @param id L'ID de la promotion à supprimer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et un message indiquant le succès de l'opération si la promotion est supprimée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    public ResponseEntity<?> deletePromotionById(Long id) {
        if (promotionDao.existsById(id)) {
            promotionDao.deleteById(id);
            return ResponseEntity.ok().body("Promotion supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promotion non trouvée");
        }
    }

    // Vous pouvez ajouter ici d'autres méthodes pour le service de promotion, telles que getAllPromotions, updatePromotion, etc.
}
