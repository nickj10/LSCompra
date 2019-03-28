import model.GestorProductes;
import model.Producte;

public class MainServidor {
    public static void main(String[] args) {
        GestorProductes gestorProductes = new GestorProductes();

        Producte milk = new Producte("Milk", 5);
        Producte hotdog = new Producte("Hotdog", 3);

        gestorProductes.afegeixProducte(milk);
        gestorProductes.afegeixProducte(hotdog);

        Producte milkAgain = new Producte("Milk", 2);

        gestorProductes.afegeixProducte(milkAgain);

        gestorProductes.eliminaProducte(milk);
    }
}
