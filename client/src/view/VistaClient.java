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
    private int[] unitats = new int[10];

    public VistaClient() {
        JTabbedPane jtMenu = new JTabbedPane();
        JPanel jpAddProduct = new JPanel();

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
        for(int i = 0; i < 10; i++) {
            unitats[i] = i + 1;
        }
        JComboBox<int[]> jcbUnitats = new JComboBox<int[]>();
        jpProductUnits.add(jlUnits);

        // Botó per afegir productes
        JPanel jpAddProductButton = new JPanel(new BorderLayout());
        jbAddProduct = new JButton("Add Product");
        jpAddProductButton.add(jbAddProduct, BorderLayout.LINE_END);

        // Afegir els panells de cada part al panell general de la pestaña "Add Product"
        jpAddProduct.add(jpProductName);
        jpAddProduct.add(jpProductUnits);
        jpAddProduct.add(jpAddProductButton);


        JPanel jpRemoveProduct = new JPanel();

        JPanel jpListProducts = new JPanel();

        jtMenu.addTab("Add Product", jpAddProduct);
        jtMenu.addTab("Remove Product", jpRemoveProduct);
        jtMenu.addTab("List products", jpListProducts);


        getContentPane().add(jtMenu, BorderLayout.CENTER);

        // Donem una mida a la finestra
        setSize(500, 300);
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
