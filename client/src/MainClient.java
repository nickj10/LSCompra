import model.LSCompra;
import model.Producte;

public class MainClient {
    public static void main(String[] args) {
        LSCompra lsCompra = new LSCompra();

        Producte milk = new Producte("Milk", 5);
        Producte hotdog = new Producte("Hotdog", 3);

        lsCompra.afegeixProducte(milk);
        lsCompra.afegeixProducte(hotdog);

        Producte milkAgain = new Producte("Milk", 2);

        lsCompra.afegeixProducte(milkAgain);

        lsCompra.eliminaProducte(milk);
    }
}
