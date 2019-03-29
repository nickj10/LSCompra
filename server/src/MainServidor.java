import model.GestorProductes;
import network.Server;

import javax.swing.*;


public class MainServidor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Creem el model
                GestorProductes model = new GestorProductes();

                // Creem el servidor
                Server server = new Server(model);
                server.startServer();

                System.out.println("---- SERVER STARTED ----");

        /* TEST
        Producte milk = new Producte("Milk", 5);
        Producte hotdog = new Producte("Hotdog", 3);

        gestorProductes.afegeixProducte(milk);
        gestorProductes.afegeixProducte(hotdog);

        Producte milkAgain = new Producte("Milk", 2);

        gestorProductes.afegeixProducte(milkAgain);
        gestorProductes.eliminaProducte(milk); */
            }
        });
    }
}
