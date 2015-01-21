package kalastajapeli.kalastajapeli;

import javax.swing.SwingUtilities;
import kalastajapeli.gui.Kayttoliittyma;
import kalastajapeli.peli.Kalastajapeli;

public class App {
    public static void main( String[] args ){
        Kalastajapeli peli = new Kalastajapeli(20, 20);
        
        Kayttoliittyma liittyma = new Kayttoliittyma(peli, 20);
        
    }
}
