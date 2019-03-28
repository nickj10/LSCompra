package controller;

import model.LSCompra;
import view.VistaClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBotons implements ActionListener {
    private LSCompra model;
    private VistaClient view;

    public ControladorBotons(LSCompra model, VistaClient view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
