package kalastajapeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import kalastajapeli.kalastajapeli.Suunta;
import kalastajapeli.domain.Kalastaja;

//Käyttöliittymästä sanottiin ircissä ettei tarvitse tehdä javadocia?
//Siksi tässä paketissa ei niitä ole, eikä kalastajapeli.kalastajapeli
//-paketissa
public class Nappaimistonkuuntelija implements KeyListener {

    Kalastaja kalastaja;

    public Nappaimistonkuuntelija(Kalastaja kalastaja) {
        this.kalastaja = kalastaja;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            kalastaja.setSuunta(Suunta.YLOS);
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            kalastaja.setSuunta(Suunta.ALAS);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
