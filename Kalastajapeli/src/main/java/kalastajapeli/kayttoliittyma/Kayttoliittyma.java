package kalastajapeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import kalastajapeli.peli.Kalastajapeli;

public class Kayttoliittyma implements Runnable {

    private Kalastajapeli peli;
    private int sivunPituus;
    private JFrame frame;
    private Piirtoalusta alusta;

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
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(peli.getKalastaja(), peli);
        getFrame().addKeyListener(nk);
    }

    public JFrame getFrame() {
        return frame;
    }
}
