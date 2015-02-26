package kalastajapeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private boolean kayntiin;

    public Kayttoliittyma(Kalastajapeli peli, int pituus) {
        this.kayntiin = false;
        this.peli = peli;
        this.sivunPituus = pituus;
        JFrame frame = new JFrame("Kalastajapeli");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton nappi = new JButton("Aloita peli");
        panel.add(nappi);
        nappi.addActionListener(new Action());
        System.out.println("1");
        //run();
       
        
    }
    public boolean kayntiin(){
        return kayntiin;
    }

    public void kaynnista() {
        this.kayntiin = true;
        frame = new JFrame("Kalastajapeli");
        int leveys = (peli.getLeveys() + 1) * sivunPituus + 10;
        int korkeus = (peli.getKorkeus() + 2) * sivunPituus + 10;

        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        System.out.println("4");
        //run();
    }

    public class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Käynnistetään...");

            kaynnista();
            System.out.println("2");
        }
    }

    @Override
    public void run() {
        while (peli.jatkuu()) {
            peli.paivitaPeli();
            System.out.println("5");
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
        System.out.println("3");
    }

    public JFrame getFrame() {
        return frame;
    }
}
