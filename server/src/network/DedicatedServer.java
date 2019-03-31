package network;

import model.GestorProductes;
import model.Operation;
import model.Producte;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class DedicatedServer extends Thread {
    private boolean running;
    private Socket socketClient;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
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
        // Iniciem el servidor dedicat
        running = true;

        // Executar el thread del client
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
            oos = new ObjectOutputStream(socketClient.getOutputStream());

            // Enviem noves dades
            oos.writeObject(model);

            while (running) {

                ois = new ObjectInputStream(socketClient.getInputStream());

                // Esperem rebre dades del client
                Operation o = (Operation) ois.readObject();

                if (o.getOper().equals("add")) {
                    // Afegim el producte a la llista de productes en el servidor
                    model.afegeixProducte(o.getProducte());
                } else {
                    if (o.getOper().equals("remove")) {
                        model.eliminaProducte(o.getProducte());
                    }
                }

                // Actualitzem els clients
                updateAllClients();

            }
        }catch (IOException e1) {
            // En cas d'error aturem el servidor dedicat
            stopDedicatedServer();

            System.out.println("Aturem el servidor dedicat al client...");
            e1.printStackTrace();
            // Eliminem el servidor dedicat del conjunt de servidors dedicats
            clients.remove(this);

            System.out.println("Hem eliminat el client de la llista.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateAllClients() {
        ObjectOutputStream oStream;
        for (DedicatedServer dServer : clients) {
            // recuperem el canal de sortida del servidor dedicat
            // per tal de contactar amb el client
            oStream = dServer.getOos();
            try {
                // netejem el canal de sortida
                oStream.reset();

                // Enviem noves dades
                oos.writeObject(model);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
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
