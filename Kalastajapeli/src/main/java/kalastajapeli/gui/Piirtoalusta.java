package kalastajapeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import kalastajapeli.domain.Kala;
import kalastajapeli.domain.Kenka;
import kalastajapeli.domain.Pala;
import kalastajapeli.peli.Kalastajapeli;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Kalastajapeli peli;
    private int sivu;

    public Piirtoalusta(Kalastajapeli peli, int palanSivunPituus) {
        this.peli = peli;
        this.sivu = palanSivunPituus;
    }

    public void paivita() {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Kala k : peli.getKala()) {
            g.fillOval(sivu * k.getX(), sivu * k.getY(), sivu+10, sivu);
        }
        g.setColor(Color.GRAY);
        for (Kenka k : peli.getKenka()) {
            g.fillOval(sivu * k.getX(), sivu * k.getY(), sivu, sivu + 10);
        }
        g.setColor(Color.BLACK);
        //for (Pala p : peli.getKalastaja().getPalat()) {
        g.fillOval(sivu * peli.getKalastaja().getX(), sivu * peli.getKalastaja().getY(), sivu, sivu + 10);
        //}
    }
}
