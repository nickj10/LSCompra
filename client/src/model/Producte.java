package model;

import java.io.Serializable;

public class Producte implements Serializable {
    private String nom;
    private int quantitat;

    public Producte(String nom, int quantitat) {
        this.nom = nom;
        this.quantitat = quantitat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
}
