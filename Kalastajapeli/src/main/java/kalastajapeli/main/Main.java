package kalastajapeli.main;

import kalastajapeli.kayttoliittyma.Kayttoliittyma;
import kalastajapeli.peli.Kalastajapeli;

/**
 * Luo pelin, käyttöliittymän ja kutsuu run-metodia
 *
 * @author Outi
 */
public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {        
        Kalastajapeli peli = new Kalastajapeli(30, 20);
        Kayttoliittyma liittyma = new Kayttoliittyma(peli, 30);
        liittyma.run();
    }
}
