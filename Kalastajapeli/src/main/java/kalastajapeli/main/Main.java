package kalastajapeli.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        JFrame frame = new JFrame("Kalastajapeli");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton nappi = new JButton("Aloita peli");
        panel.add(nappi);
        //nappi.addActionListener(new Action());

        Kalastajapeli peli = new Kalastajapeli(25, 19);
        Kayttoliittyma liittyma = new Kayttoliittyma(peli, 30);
        liittyma.run();
    }

    /*static class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Käynnistetään...");
            Kalastajapeli peli = new Kalastajapeli(25, 19);
            Kayttoliittyma liittyma = new Kayttoliittyma(peli, 30);
            liittyma.run();
        }

        
    }*/
}
