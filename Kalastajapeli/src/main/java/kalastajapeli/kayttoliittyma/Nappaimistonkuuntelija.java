package kalastajapeli.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import kalastajapeli.hahmot.Kalastaja;
import kalastajapeli.hahmot.Suunta;
import kalastajapeli.peli.Kalastajapeli;

public class Nappaimistonkuuntelija implements KeyListener {

    Kalastaja kalastaja;
    Kalastajapeli peli;

    public Nappaimistonkuuntelija(Kalastaja kalastaja, Kalastajapeli peli) {
        this.kalastaja = kalastaja;
        this.peli = peli;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (kalastaja.getY() >= 0 && kalastaja.getY() <= peli.getKorkeus()) {
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                kalastaja.setSuunta(Suunta.YLOS);
            }
            if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                kalastaja.setSuunta(Suunta.ALAS);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
