package kalastajapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
    Thread saie;

    public Kayttoliittyma(Kalastajapeli peli, int pituus) {
        this.peli = peli;
        this.sivunPituus = pituus;
        JFrame frame = new JFrame("Kalastajapeli");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setResizable(false);
        
        JButton nappi = new JButton("Olen valmis!");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100,60,120,60));
        panel.setLayout(new GridLayout());
        panel.add(nappi, BorderLayout.CENTER);
        frame.add(panel);
        nappi.addActionListener(new Action());
        saie = new Thread(this);
    }

    public void kaynnista() {
        frame = new JFrame("Kalastajapeli");
        int leveys = (peli.getLeveys() + 1) * sivunPituus + 10;
        int korkeus = (peli.getKorkeus() + 2) * sivunPituus + 10;

        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        saie.start();
    }

    public class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Käynnistetään...");
            kaynnista();
        }
    }

    @Override
    public void run() {
        while (peli.jatkuu()) {
            peli.paivitaPeli();
            alusta.paivita();
            try {
                saie.sleep(400);
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
