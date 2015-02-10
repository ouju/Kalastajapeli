package kalastajapeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import kalastajapeli.oliot.Suunta;
import kalastajapeli.oliot.Kalastaja;
import kalastajapeli.oliot.Kala;
import kalastajapeli.oliot.Kenka;
import kalastajapeli.oliot.Pala;
import kalastajapeli.kayttoliittyma.Paivitettava;
import javax.swing.*;

/**
 *
 * @author Outi
 */
public class Kalastajapeli extends Timer implements ActionListener {

    private boolean jatkuu;
    private Kalastaja kalastaja;
    private ArrayList<Kala> kalat;
    private ArrayList<Kenka> kengat;
    private int korkeus;
    private int leveys;
    private Paivitettava paivitettava;
    private int paivitysmaara;
    private Pala kala;

    /**
     * Konstruktori määrittää ikkunalle leveyden ja korkeuden ja muuttujat, luo
     * alas päin kulkevan kalastajan vasempaan yläkulmaan ja kutsuu
     * actionPerformed-metodia
     *
     * @param leveys Peli-ikkunan leveys
     * @param korkeus Peli-kkunan korkeus
     */
    public Kalastajapeli(int leveys, int korkeus) {
        super(1000, null);
        this.paivitysmaara = 0;
        this.kalat = new ArrayList<Kala>();
        this.kengat = new ArrayList<Kenka>();
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        addActionListener(this);
        //setInitialDelay(2000);

        kalastaja = new Kalastaja(1, 1, Suunta.ALAS);

    }

    /**
     * Metodi luo uuden kengän ikkunan oikeaan laitaan, arpoo korkeuden ja
     * määrittää suunnaksi vasen
     *
     */
    public void uusiKenka() {
        Random random = new Random();
        kengat.add(new Kenka(leveys, random.nextInt(korkeus), Suunta.VASEN));
    }

    /**
     * Metodi luo uuden kalan ikkunan oikeaan laitaan, arpoo korkeuden ja
     * määrittää suunnaksi vasen
     *
     */
    public void uusiKala() {
        // while (true) {
        do {
        Random random = new Random();
        Kala kala = new Kala(leveys, random.nextInt(korkeus), Suunta.VASEN);
        kalat.add(kala);
        }while (kalastaja.osuu(kala));
        
        /* break;
         }
         if (kalaOsuuVasempaanLaitaan()) {
         break;
         }*/
        //  }
    }

    /**
     *
     * @param kalastaja
     */
    public void setKalastaja(Kalastaja kalastaja) {
        this.kalastaja = kalastaja;
    }

    /*   public void setKala(Kala kala) {
     this.kala = kala;
     }*/
    /**
     *
     * @param paivitettava
     */
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    /**
     *
     * @return
     */
    public Kalastaja getKalastaja() {
        return kalastaja;
    }

    /**
     *
     * @return
     */
    public ArrayList<Kala> getKala() {
        return kalat;
    }

    /**
     *
     * @return
     */
    public ArrayList<Kenka> getKenka() {
        return kengat;
    }

    /**
     *
     * @return
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     *
     * @return
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Metodi määrittää suoritetaanko actionPerformed-metodi
     *
     * @return jatkumisen totuusarvo
     */
    public boolean jatkuu() {
        return jatkuu;
    }

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
        if (paivitysmaara % 9 == 0) {
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

    /**
     * Metodi tarkistaa milloin kala saavuttaa vasemman laidan
     *
     * @return osumisen totuusarvo
     */
    public boolean kalaOsuuVasempaanLaitaan() {
        for (Kala k : kalat) {
            if (k.getX() == -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa osuuko kalastaja ylä- tai alalaitaan
     *
     * @return osumisen totuusarvo
     */
    public boolean kalastajaOsuuLaitaan() {
        if (kalastaja.getY() == korkeus || kalastaja.getY() == -1) {
            return true;
        }
        return false;
    }
}
