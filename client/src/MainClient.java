import controller.ControladorBotons;
import model.GestorProductes;
import network.ServerCommunication;
import view.VistaClient;

public class MainClient {
    public static void main(String[] args) {
        // crea la vista
        VistaClient vista = new VistaClient();

        // creem el model
        GestorProductes gestorProductes = new GestorProductes();

        // Creem la connexió al servidor
        ServerCommunication sCommunication = new ServerCommunication(vista);

        // crea el controlador del botons i estableix la relacio C->V i C->M
        ControladorBotons controladorBotons = new ControladorBotons(gestorProductes, vista, sCommunication);

        // establim la relacio V--->C
        vista.assignaControladorBotons(controladorBotons);

        // fem la vista visible
        vista.setVisible(true);
    }
}
