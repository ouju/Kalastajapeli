package kalastajapeli.main;

import kalastajapeli.kayttoliittyma.Kayttoliittyma;
import kalastajapeli.peli.Kalastajapeli;

/**
 * Luo pelin ja käyttöliittymän
 *
 * @author Outi
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Kalastajapeli peli = new Kalastajapeli(25, 18);
        Kayttoliittyma l = new Kayttoliittyma(peli, 30);
    }
}
