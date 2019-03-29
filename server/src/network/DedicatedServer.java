package network;

import model.GestorProductes;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class DedicatedServer extends Thread {
    private boolean running;
    private Socket socketClient;
    private ObjectInputStream ois;
    private DataOutputStream dos;
    private LinkedList<DedicatedServer> clients;
    private GestorProductes model;
    private Server server;

    public DedicatedServer(Socket socketClient, LinkedList<DedicatedServer> clients, GestorProductes model, Server server) {
        this.running = false;
        this.socketClient = socketClient;
        this.clients = clients;
        this.model = model;
        this.server = server;
    }

    public void startDedicatedServer() {
        // iniciem el servidor dedicat
        running = true;
        this.start();
    }

    public void stopDedicatedServer() {
        // aturem el servidor dedicat
        this.running = false;
        this.interrupt();
    }

    public void run() {
        try {
            // Creem els canals de comunicacio
            ois = new ObjectInputStream(socketClient.getInputStream());
            dos = new DataOutputStream(socketClient.getOutputStream());

            // Aquí enviem l'objecte al client
            dos.writeUTF("Chicken nuggets");

            while (running) {
                // Esperem rebre dades del client
                String in = ois.readUTF();
                System.out.println(in);
            }
        }catch (IOException e1) {
            // en cas derror aturem el servidor dedicat
            stopDedicatedServer();
            // Eliminem el servidor dedicat del conjunt de servidors dedicats
            clients.remove(this);
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Socket getSocketClient() {
        return socketClient;
    }

    public void setSocketClient(Socket socketClient) {
        this.socketClient = socketClient;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public DataOutputStream getDos() {
        return dos;
    }

    public void setDos(DataOutputStream dos) {
        this.dos = dos;
    }

    public LinkedList<DedicatedServer> getClients() {
        return clients;
    }

    public void setClients(LinkedList<DedicatedServer> clients) {
        this.clients = clients;
    }

    public GestorProductes getModel() {
        return model;
    }

    public void setModel(GestorProductes model) {
        this.model = model;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
