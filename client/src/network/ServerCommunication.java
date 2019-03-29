package network;

import model.GestorProductes;
import model.Producte;

import java.io.*;
import java.net.Socket;

public class ServerCommunication extends Thread {
    private Socket socketServer;
    private ObjectOutputStream oos;
    private DataInputStream dis;
    private boolean running;
    private GestorProductes model;

    public ServerCommunication(GestorProductes model) {
        try {
            this.model = model;
            this.socketServer = new Socket(ServerConfiguration.SERVER_IP, ServerConfiguration.SERVER_PORT);
            this.running = false;
            this.dis = new DataInputStream(socketServer.getInputStream());
            this.oos = new ObjectOutputStream(socketServer.getOutputStream());
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
                String rep = dis.readUTF();
                System.out.println("Recibo esto del servidor:" + rep);
                oos.writeUTF("Bitch!");
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
