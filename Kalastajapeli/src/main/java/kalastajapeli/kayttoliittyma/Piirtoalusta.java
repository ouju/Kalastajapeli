package kalastajapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import kalastajapeli.oliot.Kala;
import kalastajapeli.oliot.Kenka;
import kalastajapeli.oliot.Pala;
import kalastajapeli.peli.Kalastajapeli;

//Käyttöliittymästä sanottiin ircissä ettei tarvitse tehdä javadocia?
//Siksi tässä paketissa ei niitä ole, eikä kalastajapeli.kalastajapeli
//-paketissa
public class Piirtoalusta extends JPanel //implements Paivitettava {
{
    private Kalastajapeli peli;
    private int sivu;

    public Piirtoalusta(Kalastajapeli peli, int palanSivunPituus) {
        this.peli = peli;
        this.sivu = palanSivunPituus;
    }

    /*@Override
    public void paivita() {
        repaint();
    }*/

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Kala k : peli.getKala()) {
            g.fillOval(sivu * k.getX(), sivu * k.getY(), sivu + 10, sivu);
        }
        g.setColor(Color.GRAY);
        for (Kenka k : peli.getKenka()) {
            g.fillOval(sivu * k.getX(), sivu * k.getY(), sivu, sivu);
        }
        g.setColor(Color.BLACK);
        //for (Pala p : peli.getKalastaja().getPalat()) {
        g.fillOval(sivu * peli.getKalastaja().getX(), sivu * peli.getKalastaja().getY(), sivu, sivu + 10);
        //}
    }
}
