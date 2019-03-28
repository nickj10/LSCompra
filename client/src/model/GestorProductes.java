package model;

import java.util.LinkedList;

public class GestorProductes {
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
        // Fer la petició al servidor per afegir productes
    }

    public void eliminaProducte(Producte producte) {
        // Fer la petició al servidor per eliminar productes
    }

    public void mostraLlistaCompra() {
        // Fer la petició al servidor per mostrar productes
    }
}
