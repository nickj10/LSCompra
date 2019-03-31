package controller;

import model.GestorProductes;
import network.ServerCommunication;
import view.VistaClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBotons implements ActionListener {
    private VistaClient view;
    private ServerCommunication serverCommunication;

    public ControladorBotons(GestorProductes model, VistaClient view, ServerCommunication serverCommunication) {
        this.view = view;
        this.serverCommunication = serverCommunication;

        // Iniciem la recepció d'actualitzacions
        serverCommunication.startServerComunication();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("add")) {
            serverCommunication.enviaProducte(view.getNewProduct(), "add");
        } else {
            if (action.equals("remove")) {
                serverCommunication.enviaProducte(view.getNewProduct(), "remove");
            }
        }
    }
}
