package kalastajapeli.kalastajapeli;

import javax.swing.SwingUtilities;
import kalastajapeli.gui.Kayttoliittyma;
import kalastajapeli.peli.Kalastajapeli;

//Käyttöliittymästä sanottiin ircissä ettei tarvitse tehdä javadocia?
//Siksi tässä paketissa ei niitä ole, eikä kalastajapeli.gui
//-paketissa
public class App {

    public static void main(String[] args) {
        Kalastajapeli peli = new Kalastajapeli(30, 20);

        Kayttoliittyma liittyma = new Kayttoliittyma(peli, 30);
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
