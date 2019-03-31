package model;

import java.io.Serializable;
import java.util.LinkedList;

public class GestorProductes implements Serializable {
    private LinkedList<Producte> productes;

    // Constructors
    public GestorProductes(LinkedList<Producte> productes) {
        this.productes = productes;
    }

    public GestorProductes() {
        productes = new LinkedList<Producte>();
    }

    // Getters i Setters
    public LinkedList<Producte> getProductes() {
        return productes;
    }

    public void setProductes(LinkedList<Producte> productes) {
        this.productes = productes;
    }

    // Mètodes
    public void afegeixProducte(Producte producte) {

    }

    public void eliminaProducte(Producte producte) {

    }

    public void mostraLlistaCompra() {

    }
}
