package com.example.demo.controller;
import com.example.demo.model.Promotion;
import com.example.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Contrôleur pour gérer les opérations sur les promotions.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    /**
     * Constructeur pour le contrôleur de promotion.
     *
     * @param promotionService Le service de promotion à injecter.
     */
    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    /**
     * Récupère toutes les promotions.
     *
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la liste de toutes les promotions.
     */
    @GetMapping
    public ResponseEntity<?> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    /**
     * Récupère une promotion par son ID.
     *
     * @param id L'ID de la promotion à récupérer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et la promotion correspondante si trouvée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPromotionById(@PathVariable Long id) {
        return promotionService.getPromotionById(id);
    }

    /**
     * Enregistre une nouvelle promotion.
     *
     * @param promotion La promotion à enregistrer.
     * @return ResponseEntity avec le code de statut HTTP 201 Created et un message indiquant le succès de l'opération.
     */
    @PostMapping
    public ResponseEntity<?> savePromotion(@RequestBody Promotion promotion) {
        return promotionService.savePromotion(promotion);
    }

    /**
     * Supprime une promotion par son ID.
     *
     * @param id L'ID de la promotion à supprimer.
     * @return ResponseEntity avec le code de statut HTTP 200 OK et un message indiquant le succès de l'opération si la promotion est supprimée, sinon ResponseEntity avec le code de statut HTTP 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromotionById(@PathVariable Long id) {
        return promotionService.deletePromotionById(id);
    }
}
