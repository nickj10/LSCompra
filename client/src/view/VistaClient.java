package view;

import controller.ControladorBotons;
import model.Producte;

import javax.swing.*;
import java.util.LinkedList;

public class VistaClient extends JFrame {

    private JButton jbAddProduct;
    private JButton jbRemoveProduct;
    private JPanel jpMainPanel;

    public VistaClient() {
        JTabbedPane jtMenu = new JTabbedPane();
        JPanel jpAddProduct = new JPanel();

        JPanel jpRemoveProduct = new JPanel();

        JPanel jpListProducts = new JPanel();

        jtMenu.addTab("Add Product", jpAddProduct);
        jtMenu.addTab("Remove Product", jpRemoveProduct);
        jtMenu.addTab("List products", jpListProducts);
    }

    void refrescaLlistaCompra(LinkedList<Producte> productes) {

    }

    void assignaControladorBotons(ControladorBotons bController) {

    }
}
