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
        if (!productes.isEmpty()) {
            for (Producte p : productes) {
                // Mirem si ja existeix el producte a la llista
                if (p.getNom().equals(producte.getNom())) {
                    p.setQuantitat(p.getQuantitat() + producte.getQuantitat());
                    return;
                }
            }
        }
        // Si no existeix el producte, l'afegim a la llista
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
