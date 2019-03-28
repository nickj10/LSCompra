package model;

import java.util.LinkedList;

public class LSCompra {
    private LinkedList<Producte> productes;

    // Constructors
    public LSCompra(LinkedList<Producte> productes) {
        this.productes = productes;
    }

    public LSCompra() {
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
        productes.add(producte);
    }

    public void eliminaProducte(Producte producte) {

    }

    public void mostraLlistaCompra() {
        System.out.println("Llista de productes de la compra:");
        for (Producte p: productes) {
            System.out.println(p);
        }
    }
}
