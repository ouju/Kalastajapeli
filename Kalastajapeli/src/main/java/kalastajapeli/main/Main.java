package kalastajapeli.main;

import kalastajapeli.kayttoliittyma.Kayttoliittyma;
import kalastajapeli.peli.Kalastajapeli;

public class Main {
    
    public static void main(String[] args) {        
        Kalastajapeli peli = new Kalastajapeli(30, 20);
        Kayttoliittyma liittyma = new Kayttoliittyma(peli, 30);
        liittyma.run();
    }
}
