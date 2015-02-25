package kalastajapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import kalastajapeli.hahmot.Kala;
import kalastajapeli.hahmot.Kenka;
import kalastajapeli.peli.Kalastajapeli;

/**
 * Luo pelille piirrettävät hahmot ja tekstit
 *
 * @author Outi
 */
public class Piirtoalusta extends JPanel {

    private Kalastajapeli peli;
    private int sivu;

    /**
     *
     * @param peli
     * @param palanSivunPituus
     */
    public Piirtoalusta(Kalastajapeli peli, int palanSivunPituus) {
        this.peli = peli;
        this.sivu = palanSivunPituus;
    }

    /**
     * Päivittää alustaa
     *
     */
    public void paivita() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (peli.jatkuu()) {
            g.setColor(Color.cyan);
            g.fillRect(0, 0, sivu * peli.getLeveys() + 25, sivu * peli.getKorkeus() + 25);
            g.setColor(Color.red);
            for (int i = 0; i < peli.getSydamet(); i++) {
                g.fillOval(sivu + i * 30, sivu, 20, 20);
            }
            g.setColor(Color.BLUE);
            for (Kala k : peli.getKala()) {
                g.fillOval(sivu * k.getX(), sivu * k.getY(), sivu + 10, sivu);
            }
            g.setColor(Color.GRAY);
            for (Kenka k : peli.getKenka()) {
                g.fillOval(sivu * k.getX(), sivu * k.getY(), sivu, sivu);
            }
            g.setColor(Color.BLACK);
            g.fillOval(sivu * peli.getKalastaja().getX(), sivu * peli.getKalastaja().getY(), sivu, sivu + 10);
            Font fontti = new Font("Candara", Font.BOLD, 25);
            g.setFont(fontti);
            g.drawString("" + peli.getPisteet(), sivu * peli.getLeveys(), sivu + 10);
        } else {
            Font fontti = new Font("Candara", Font.BOLD, 50);
            g.setFont(fontti);
            g.drawString("Peli päättyi! Pisteesi: " + peli.getPisteet(), 200, 250);

        }
    }
}
