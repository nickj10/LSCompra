package controller;

import model.GestorProductes;
import network.ServerCommunication;
import view.VistaClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBotons implements ActionListener {
    private GestorProductes model;
    private VistaClient view;
    private ServerCommunication serverCommunication;

    public ControladorBotons(GestorProductes model, VistaClient view, ServerCommunication serverCommunication) {
        this.model = model;
        this.view = view;
        this.serverCommunication = serverCommunication;

        // Iniciem la recepció d'actualitzacions
        serverCommunication.startServerComunication();
        System.out.println("----- CLIENT TO SERVER COM STARTED ----");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
