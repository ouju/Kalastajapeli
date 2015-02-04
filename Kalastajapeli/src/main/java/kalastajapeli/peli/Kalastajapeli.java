package kalastajapeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import kalastajapeli.kalastajapeli.Suunta;
import kalastajapeli.domain.Kalastaja;
import kalastajapeli.domain.Kala;
import kalastajapeli.domain.Kenka;
import kalastajapeli.domain.Pala;
import kalastajapeli.gui.Paivitettava;
import javax.swing.*;

public class Kalastajapeli extends Timer implements ActionListener {

    private boolean jatkuu;
    private Kalastaja kalastaja;
    private ArrayList<Kala> kalat;
    private ArrayList<Kenka> kengat;
    private int korkeus;
    private int leveys;
    private Paivitettava paivitettava;
    private int paivitysmaara;

    public Kalastajapeli(int leveys, int korkeus) {
        super(1000, null);
        this.paivitysmaara = 0;
        this.kalat = new ArrayList<Kala>();
        this.kengat = new ArrayList<Kenka>();
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        addActionListener(this);
        setInitialDelay(2000);

        kalastaja = new Kalastaja(1, korkeus / 2, Suunta.ALAS);

    }

    private void uusiKenka() {
        Random random = new Random();
        kengat.add(new Kenka(leveys, random.nextInt(korkeus), Suunta.VASEN));
    }

    private void uusiKala() {
        // while (true) {

        Random random = new Random();
        kalat.add(new Kala(leveys, random.nextInt(korkeus), Suunta.VASEN));
        /*  if (!kalastaja.osuu(kala)) {
         break;
         }
         if (kalaOsuuVasempaanLaitaan()) {
         break;
         }*/
        //  }
    }

    public void setKalastaja(Kalastaja kalastaja) {
        this.kalastaja = kalastaja;
    }

    /*   public void setKala(Kala kala) {
     this.kala = kala;
     }*/
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public Kalastaja getKalastaja() {
        return kalastaja;
    }

    public ArrayList<Kala> getKala() {
        return kalat;
    }

    public ArrayList<Kenka> getKenka() {
        return kengat;
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
    //Timer timer = new Timer(1000, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!jatkuu) {
            return;
        }
        for (Kala k : kalat) {
            k.liiku();
        }
        for (Kenka k : kengat) {
            k.liiku();
        }
        if (paivitysmaara % 5 == 0) {
            uusiKala();
        }
        if (paivitysmaara % 10 == 0) {
            uusiKenka();
        }
        kalastaja.liiku();
        if (kalastajaOsuuLaitaan()) {
            if (kalastaja.getSuunta() == Suunta.ALAS) {
                kalastaja.setSuunta(Suunta.YLOS);
            } else {
                kalastaja.setSuunta(Suunta.ALAS);
            }
        }
        paivitettava.paivita();
        setDelay(500);
        paivitysmaara++;
    }

    private boolean kalaOsuuVasempaanLaitaan() {
        for (Kala k : kalat) {
            if (k.getX() == -1) {
                return true;
            }
        }
        return false;
    }

    private boolean kalastajaOsuuLaitaan() {
        if (kalastaja.getY() == korkeus || kalastaja.getX() == leveys || kalastaja.getX() == -1 || kalastaja.getY() == -1) {
            return true;
        }
        /*for (Pala p : kalastaja.getPalat()) {
         if (p.getY() == korkeus || p.getX() == leveys || p.getX() == -1 || p.getY() == -1) {
         return true;
         }
         }*/
        return false;
    }
}
