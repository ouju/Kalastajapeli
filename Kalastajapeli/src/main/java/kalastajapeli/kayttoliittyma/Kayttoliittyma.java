package kalastajapeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kalastajapeli.peli.Kalastajapeli;

public class Kayttoliittyma implements Runnable {

    private Kalastajapeli peli;
    private int sivunPituus;
    private JFrame frame;
    private Piirtoalusta alusta;
    private Image kuva;

    public Kayttoliittyma(Kalastajapeli peli, int pituus) {

        this.peli = peli;
        this.sivunPituus = pituus;
        frame = new JFrame("Kalastajapeli");
        int leveys = (peli.getLeveys()+1) * sivunPituus+10;
        int korkeus = (peli.getKorkeus()+2) * sivunPituus+10;

        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        

    }

    @Override
    public void run() {
        while (peli.jatkuu()) {
            peli.paivitaPeli();
            alusta.paivita();
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void luoKomponentit(Container container) {
        alusta = new Piirtoalusta(peli, sivunPituus);
        container.add(alusta);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(peli.getKalastaja());
        getFrame().addKeyListener(nk);
    }

    public JFrame getFrame() {
        return frame;
    }
}
