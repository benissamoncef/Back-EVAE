package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Promotion {

    @Id
    @Column(name = "ANNEE_PRO", nullable = false, length = 10)
    private String anneePro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODE_FORMATION", nullable = false)
    private Formation formation;

    @Column(name = "SIGLE_PRO", nullable = false, length = 5)
    private String siglePro;


    public String getAnneePro() {
        return anneePro;
    }

    public void setAnneePro(String anneePro) {
        this.anneePro = anneePro;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public String getSiglePro() {
        return siglePro;
    }

    public void setSiglePro(String siglePro) {
        this.siglePro = siglePro;
    }


}