package network;

import model.GestorProductes;
import model.Operation;
import model.Producte;
import view.VistaClient;

import java.io.*;
import java.net.Socket;

public class ServerCommunication extends Thread {
    private Socket socketServer;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private boolean running;
    private VistaClient view;

    public ServerCommunication(VistaClient view) {
        try {
            this.view = view;
            this.socketServer = new Socket(ServerConfiguration.SERVER_IP, ServerConfiguration.SERVER_PORT);
            this.running = false;

            this.oos = new ObjectOutputStream(socketServer.getOutputStream());
            this.ois = new ObjectInputStream(socketServer.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServerComunication() {
        // iniciem la comunicacio amb el servidor
        running = true;
        this.start();
    }

    public void stopServerComunication() {
        // aturem la comunicacio amb el servidor
        this.running = false;
        this.interrupt();
    }

    public void run() {
        while (running) {

            try {
                // Esperem dades del servidor
                GestorProductes gestorProductes = (GestorProductes)ois.readObject();

                // Refresquem la llista de productes a la vista
                view.refrescaLlistaCompra(gestorProductes.getProductes());

            } catch (IOException e) {
                e.printStackTrace();
                // Si hi ha algun problema satura la comunicacio amb el servidor
                stopServerComunication();
                System.out.println("*** ESTA EL SERVIDOR EN EXECUCIO? ***");
            }
        }
        stopServerComunication();
    }

    void enviaProducte(Producte producte) {

    }
}
