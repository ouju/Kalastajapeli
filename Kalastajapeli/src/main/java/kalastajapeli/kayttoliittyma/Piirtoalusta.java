package kalastajapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
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
        ImageIcon tausta = new ImageIcon(this.getClass().getResource("/vesi.jpg"));
        g.drawImage(tausta.getImage(), 0, 0, null);
        if (peli.jatkuu()) {
            g.setColor(Color.red);
            for (int i = 0; i < peli.getSydamet(); i++) {
                //g.fillOval(sivu + i * 30, sivu, 20, 20);
                ImageIcon sydan = new ImageIcon(this.getClass().getResource("/sydan.gif"));
                g.drawImage(sydan.getImage(), sivu+i*30, sivu, null);
            }
            g.setColor(Color.BLUE);
            for (Kala k : peli.getKala()) {
                ImageIcon kalastaja = new ImageIcon(this.getClass().getResource("/kala.gif"));
                g.drawImage(kalastaja.getImage(), sivu * k.getX(), sivu * k.getY(), null);
            }
            g.setColor(Color.GRAY);
            for (Kenka k : peli.getKenka()) {
                ImageIcon kalastaja = new ImageIcon(this.getClass().getResource("/kenka.gif"));
                g.drawImage(kalastaja.getImage(), sivu * k.getX(), sivu * k.getY(), null);
            }
            g.setColor(Color.BLACK);
            ImageIcon kalastaja = new ImageIcon(this.getClass().getResource("/kalastaja.gif"));
            g.drawImage(kalastaja.getImage(), sivu * peli.getKalastaja().getX(), sivu * peli.getKalastaja().getY(), null);
            
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
