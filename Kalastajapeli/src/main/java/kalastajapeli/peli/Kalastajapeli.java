package kalastajapeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import kalastajapeli.kalastajapeli.Suunta;
import kalastajapeli.domain.Kalastaja;
import kalastajapeli.domain.Kala;
import kalastajapeli.domain.Kenka;
import kalastajapeli.domain.Pala;
import kalastajapeli.gui.Paivitettava;

public class Kalastajapeli extends Timer implements ActionListener {

    private boolean jatkuu;
    private Kalastaja kalastaja;
    private Kala kala;
    private int korkeus;
    private int leveys;
    private Paivitettava paivitettava;

    public Kalastajapeli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        addActionListener(this);
        setInitialDelay(2000);

        kalastaja = new Kalastaja(1, korkeus / 2);
        uusiKala();
    }

    private void uusiKala() {
        while (true) {
            Random random = new Random();
            kala = new Kala(leveys, random.nextInt(korkeus), Suunta.VASEN);
            if (!kalastaja.osuu(kala)) {
                break;
            }
        }
    }

    public void setKalastaja(Kalastaja kalastaja) {
        this.kalastaja = kalastaja;
    }

    public void setKala(Kala kala) {
        this.kala = kala;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public Kalastaja getKalastaja() {
        return kalastaja;
    }

    public Kala getKala() {
        return kala;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public boolean jatkuu() {
        return jatkuu;
    }

    public void actionPerformed(ActionEvent ae) {
        if (!jatkuu) {
            return;
        }
        kala.liiku();
        kalastaja.liiku();
        paivitettava.paivita();
    }

    private boolean kalastajaOsuuLaitaan() {
        for (Pala p : kalastaja.getPalat()) {
            if (p.getY() == korkeus || p.getX() == leveys || p.getX() == -1 || p.getY() == -1) {
                return true;
            }
        }
        return false;
    }
}
