package com.example.demo.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table
public class Formation {

    @Id
    @Column(name = "CODE_FORMATION", nullable = false, length = 8)
    private String codeFormation;

    @Column(name = "DIPLOME", nullable = false, length = 3)
    private String diplome;

    @Column(name = "N0_ANNEE", nullable = false)
    private Byte n0Annee;

    @Column(name = "NOM_FORMATION", nullable = false, length = 64)
    private String nomFormation;



    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Byte getN0Annee() {
        return n0Annee;
    }

    public void setN0Annee(Byte n0Annee) {
        this.n0Annee = n0Annee;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }
}