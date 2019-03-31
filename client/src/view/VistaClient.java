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
    private JComboBox<Integer> jcbUnitats;
    private JComboBox<String> jcbNomProductes;
    private JTextArea jtaListProducts;
    private JTextField jtfProductName;
    private JPanel jpListProducts;


    public VistaClient() {
        JTabbedPane jtMenu = new JTabbedPane();

        // Panell per afegir un producte
        JPanel jpAddProduct = new JPanel(new BorderLayout());

        // El nom del producte
        JPanel jpProductName = new JPanel(new FlowLayout());
        JLabel jlProduct = new JLabel("Product Name");
        jtfProductName = new JTextField();
        jtfProductName.setPreferredSize(new Dimension(213, 25));
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
        jcbUnitats = new JComboBox<Integer>(unitats);
        jcbUnitats.setPreferredSize(new Dimension(213, 25));
        jpProductUnits.add(jlUnits);
        jpProductUnits.add(jcbUnitats);

        // Botó per afegir productes
        JPanel jpAddProductButton = new JPanel(new FlowLayout());
        jbAddProduct = new JButton("Add Product");
        jbAddProduct.setActionCommand("add");
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
        jcbNomProductes.setPreferredSize(new Dimension(250, 25));
        jpNomProducte.add(jpTitleProduct);
        jpNomProducte.add(jcbNomProductes);

        // Botó per afegir productes
        JPanel jpRemoveProductButton = new JPanel(new FlowLayout());
        jbRemoveProduct = new JButton("Remove Product");
        jbRemoveProduct.setActionCommand("remove");
        jpRemoveProductButton.add(jbRemoveProduct);
        JPanel jpCenterRemoveButton = new JPanel(new GridLayout(1, 2));
        jpCenterRemoveButton.add(new JPanel());
        jpCenterRemoveButton.add(jpRemoveProductButton);

        // Afegir els panells de cada part al panell general de la tab "Remove Product"
        JPanel jpCenterRemoveProduct = new JPanel(new BorderLayout());
        jpCenterRemoveProduct.add(jpNomProducte, BorderLayout.NORTH);
        jpCenterRemoveProduct.add(jpCenterRemoveButton, BorderLayout.CENTER);

        jpRemoveProduct.add(jpCenterRemoveProduct, BorderLayout.CENTER);

        jpListProducts = new JPanel(new BorderLayout());
        JScrollPane jspListProducts = new JScrollPane(jpListProducts);
        jtaListProducts = new JTextArea();
        jpListProducts.add(jtaListProducts);

        jtMenu.addTab("Add Product", jpAddProduct);
        jtMenu.addTab("Remove Product", jpRemoveProduct);
        jtMenu.addTab("List products", jspListProducts);


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
        jbRemoveProduct.addActionListener(bController);
    }
}
