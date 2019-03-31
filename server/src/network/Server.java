package network;

import model.GestorProductes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server extends Thread {
    private String IP;
    private int port;
    private boolean running;
    private ServerSocket serverSocket;
    private GestorProductes model;
    private LinkedList<DedicatedServer> dedicatedServers;


    public Server(GestorProductes model) {
        try {
            this.running = false;
            this.model = model;
            // Obrim un socket per al servidor
            this.serverSocket = new ServerSocket(10069);
            this.dedicatedServers = new LinkedList<DedicatedServer>();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        // Iniciem el thread del servidor
        running = true;
        this.start();
    }

    public void stopServer() {
        // Aturem el thread del servidor
        running = false;
        this.interrupt();
    }

    public void run()  {
        while (running) {
            try {
                // Esperem les peticions per poder acceptar-les
                // Es bloqueja
                System.out.println("Esperant petició...");
                Socket socketClient = serverSocket.accept();

                // Creem un nou servidor dedicat per atendre les peticions del client
                DedicatedServer client = new DedicatedServer(socketClient, dedicatedServers, model, this);
                dedicatedServers.add(client);
                System.out.println("Petició acceptada!");

                // Arrencar el servidor dedicat
                client.startDedicatedServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Aturem tots els servidors dedicats creats quan ja no atenem més peticions
        for (DedicatedServer d : dedicatedServers) {
            d.stopDedicatedServer();
        }
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public GestorProductes getModel() {
        return model;
    }

    public void setModel(GestorProductes model) {
        this.model = model;
    }

    public LinkedList<DedicatedServer> getDedicatedServers() {
        return dedicatedServers;
    }

    public void setDedicatedServers(LinkedList<DedicatedServer> dedicatedServers) {
        this.dedicatedServers = dedicatedServers;
    }
}
