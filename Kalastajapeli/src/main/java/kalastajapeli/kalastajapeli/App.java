package kalastajapeli.kalastajapeli;

import javax.swing.SwingUtilities;
import kalastajapeli.gui.Kayttoliittyma;
import kalastajapeli.peli.Kalastajapeli;

public class App {

    public static void main(String[] args) {
        Kalastajapeli peli = new Kalastajapeli(20, 20);

        Kayttoliittyma liittyma = new Kayttoliittyma(peli, 20);
        SwingUtilities.invokeLater(liittyma);
        while (liittyma.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        peli.setPaivitettava(liittyma.getPaivitettava());
        peli.start();
    }
}
