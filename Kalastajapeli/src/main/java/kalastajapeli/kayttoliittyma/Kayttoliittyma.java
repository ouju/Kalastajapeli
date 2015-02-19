package kalastajapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import kalastajapeli.peli.Kalastajapeli;

//Käyttöliittymästä sanottiin ircissä ettei tarvitse tehdä javadocia?
//Siksi tässä paketissa ei niitä ole, eikä kalastajapeli.main
//-paketissa
public class Kayttoliittyma implements Runnable {

    private Kalastajapeli peli;
    private int sivunPituus;
    private JFrame frame;
    private Piirtoalusta alusta;
    private JTextField field;

    public Kayttoliittyma(Kalastajapeli peli, int pituus) {

        this.peli = peli;
        this.sivunPituus = pituus;
        frame = new JFrame("Kalastajapeli");
        int leveys = (peli.getLeveys() + 1) * sivunPituus + 10;
        int korkeus = (peli.getKorkeus() + 2) * sivunPituus + 10;

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
                Thread.sleep(500);
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
        if (peli.getSydamet() == 1) {
            JTextField teksti = new JTextField();
            
            Font font = new Font("Helvetica", Font.PLAIN, 30);
            teksti.setFont(font);
            teksti.setForeground(Color.BLACK);
            teksti.setHorizontalAlignment(SwingConstants.CENTER);

            container.add(teksti);
            teksti.setText("Peli päättyi! Pisteesi: " + peli.getPisteet());
            teksti.setEditable(false);
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    /*public Paivitettava getPaivitettava() {
     return alusta;
     }*/
}
