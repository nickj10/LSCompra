package view;

import controller.ControladorBotons;
import model.Producte;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.LinkedList;

public class VistaClient extends JFrame {

    private JButton jbAddProduct;
    private JButton jbRemoveProduct;
    private JPanel jpMainPanel;
    private JComboBox<String> jcbNomProductes;

    public VistaClient() {
        JTabbedPane jtMenu = new JTabbedPane();

        // Panell per afegir un producte
        JPanel jpAddProduct = new JPanel(new BorderLayout());

        // El nom del producte
        JPanel jpProductName = new JPanel(new FlowLayout());
        JLabel jlProduct = new JLabel("Product Name");
        JTextField jtfProductName = new JTextField();
        jtfProductName.setPreferredSize(new Dimension(200, 25));
        jtfProductName.setEditable(true);
        jpProductName.add(jlProduct);
        jpProductName.add(jtfProductName);


        // Unitats del producte
        JPanel jpProductUnits = new JPanel(new FlowLayout());
        JLabel jlUnits = new JLabel("Product Units");
        Integer[] unitats = new Integer[10];
        for(int i = 0; i < 10; i++) {
            unitats[i] = i + 1;
        }
        JComboBox<Integer> jcbUnitats = new JComboBox<Integer>(unitats);
        jcbUnitats.setPreferredSize(new Dimension(200, 25));
        jpProductUnits.add(jlUnits);
        jpProductUnits.add(jcbUnitats);

        // Botó per afegir productes
        JPanel jpAddProductButton = new JPanel(new FlowLayout());
        jbAddProduct = new JButton("Add Product");
        jpAddProductButton.add(jbAddProduct);

        // Afegir els panells de cada part al panell general de la pestaña "Add Product"
        jpAddProduct.add(jpProductName, BorderLayout.PAGE_START);

        JPanel jpCenter = new JPanel(new BorderLayout());
        jpCenter.add(jpProductUnits, BorderLayout.NORTH);

        JPanel jpCenterButton = new JPanel(new GridLayout(1, 2));
        jpCenterButton.add(new JPanel());
        jpCenterButton.add(jpAddProductButton);
        jpCenter.add(jpCenterButton, BorderLayout.CENTER);

        jpAddProduct.add(jpCenter, BorderLayout.CENTER);


        // Panell per eliminar un producte
        JPanel jpRemoveProduct = new JPanel();
        JPanel jpNomProducte = new JPanel(new FlowLayout());
        JLabel jpTitleProduct = new JLabel("Product");
        jcbNomProductes = new JComboBox<String>();
        jcbNomProductes.setPreferredSize(new Dimension(200, 25));
        jpNomProducte.add(jpTitleProduct);
        jpNomProducte.add(jcbNomProductes);

        // Botó per afegir productes
        JPanel jpRemoveProductButton = new JPanel(new BorderLayout());
        jbRemoveProduct = new JButton("Remove Product");
        jpRemoveProductButton.add(jbRemoveProduct);

        // Afegir els panells de cada part al panell general de la tab "Remove Product"
        jpRemoveProduct.add(jpNomProducte, BorderLayout.PAGE_START);
        jpRemoveProduct.add(jpRemoveProductButton, BorderLayout.CENTER);

        JPanel jpListProducts = new JPanel();

        jtMenu.addTab("Add Product", jpAddProduct);
        jtMenu.addTab("Remove Product", jpRemoveProduct);
        jtMenu.addTab("List products", jpListProducts);


        getContentPane().add(jtMenu, BorderLayout.CENTER);

        // Donem una mida a la finestra
        setSize(400, 250);
        setResizable(false);

        // Li posem un títol
        setTitle("OOPD - 1819 - S2 Midterm");

        // Indiquem que s'aturi el programa si fab clic a la "X" de la finestra
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Indiquem que la finestra se situï al centre de la pantalla
        setLocationRelativeTo(null);
    }

    public void refrescaLlistaCompra(LinkedList<Producte> productes) {

    }

    public void assignaControladorBotons(ControladorBotons bController) {
        jbAddProduct.addActionListener(bController);
        //jbRemoveProduct.addActionListener(bController);
    }
}
