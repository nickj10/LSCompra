import controller.ControladorBotons;
import model.GestorProductes;
import view.VistaClient;

public class MainClient {
    public static void main(String[] args) {
        // crea la vista
        VistaClient vista = new VistaClient();

        // creem el model
        GestorProductes gestorProductes = new GestorProductes();


        // crea el controlador del botons i estableix la relacio C->V i C->M
        ControladorBotons controladorBotons = new ControladorBotons(gestorProductes, vista);

        // establim la relacio V--->C
        vista.assignaControladorBotons(controladorBotons);

        // fem la vista visible
        vista.setVisible(true);
    }
}
