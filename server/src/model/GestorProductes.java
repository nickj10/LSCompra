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
        if (!productes.isEmpty()) {
            for (int i = 0; i < productes.size(); i++) {
                if(productes.get(i).getNom().equals(producte.getNom())) {
                    productes.remove(i);
                }
            }
        }
    }

    public void mostraLlistaCompra() {
        System.out.println("Llista de productes de la compra:");
        for (Producte p: productes) {
            System.out.println(p);
        }
    }
}
