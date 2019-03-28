package controller;

import model.GestorProductes;
import view.VistaClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBotons implements ActionListener {
    private GestorProductes model;
    private VistaClient view;

    public ControladorBotons(GestorProductes model, VistaClient view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
