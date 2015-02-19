package kalastajapeli.peli;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import kalastajapeli.oliot.Kala;
import kalastajapeli.oliot.Kalastaja;
import kalastajapeli.oliot.Kenka;
import kalastajapeli.oliot.Suunta;
//import kalastajapeli.oliot.Pala;
//import kalastajapeli.kayttoliittyma.Paivitettava;
//import javax.swing.*;

/**
 * Luokka määrittää pelin päivittämisen, eli luo ja liikuttaa kaloja, kenkiä ja
 * kalastajaa sekä pitää laskua päivitysmääristä
 *
 * @author Outi
 */
public class Kalastajapeli {

    private Kalastaja kalastaja;
    private ArrayList<Kala> kalat;
    private ArrayList<Kenka> kengat;
    private int korkeus;
    private int leveys;
    private boolean jatkuu;
    //private Paivitettava paivitettava;
    private int paivitysmaara;
    //private Kala kala;
    //private Kenka kenka;
    private int pisteet;
    private int sydamet;

    /**
     * Konstruktori määrittää ikkunalle leveyden ja korkeuden ja muuttujat, luo
     * alas päin kulkevan kalastajan vasempaan yläkulmaan ja kutsuu
     * actionPerformed-metodia
     *
     * @param leveys Peli-ikkunan leveys
     * @param korkeus Peli-kkunan korkeus
     */
    public Kalastajapeli(int leveys, int korkeus) {
        //super(1000, null);
        this.paivitysmaara = 0;
        this.kalat = new ArrayList<>();
        this.kengat = new ArrayList<>();
        this.leveys = leveys;
        this.korkeus = korkeus;
        //this.jatkuu = true;
        this.pisteet = 0;
        this.sydamet = 3;

        //addActionListener(this);
        //setInitialDelay(2000);
        kalastaja = new Kalastaja(this, 1, 1, Suunta.ALAS);

    }

    /**
     *
     * @return
     */
    public int getSydamet() {
        return sydamet;
    }

    /**
     *
     * @param sydamet Kalastajan elämien määrä
     */
    public void setSydamet(int sydamet) {
        this.sydamet = sydamet;
    }

    /**
     *
     * @return
     */
    public int getPisteet() {
        return pisteet;
    }

    /**
     *
     * @return
     */
    public int getPaivitysmaara() {
        return this.paivitysmaara;
    }

    /**
     * Metodi luo uuden kengän ikkunan oikeaan laitaan, arpoo korkeuden ja
     * määrittää suunnaksi vasen
     *
     */
    public void uusiKenka() {
        if (paivitysmaara % 9 == 0) {
            Random random = new Random();
            kengat.add(new Kenka(leveys, random.nextInt(korkeus), Suunta.VASEN));
        }
    }

    /**
     * Metodi luo uuden kalan ikkunan oikeaan laitaan, arpoo korkeuden ja
     * määrittää suunnaksi vasen
     *
     */
    public void uusiKala() {
        // while (true) {
        if (paivitysmaara % 5 == 0) {

            Random random = new Random();
            Kala kala = new Kala(leveys, random.nextInt(korkeus), Suunta.VASEN);
            kalat.add(kala);
        }
    }

    /**
     *
     * @param kalastaja
     */
    public void setKalastaja(Kalastaja kalastaja) {
        this.kalastaja = kalastaja;
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
     * Peli jatkuu kunnes sydämiä ei ole enää jäljellä
     *
     * @return jatkumisen totuusarvo
     */
    public boolean jatkuu() {
        if (sydamet == 0) {
            return false;
        }
        return true;
    }

    /**
     * Metodi käy läpi kaikki kalat ja kutsuu Kala-luokan liiku-metodia
     *
     */
    public void liikutaKalaa() {
        for (Kala k : kalat) {
            k.liiku();
        }
    }

    /**
     * Metodi käy läpi kaikki kengät ja kutsuu Kenkä-luokan liiku-metodia
     *
     */
    public void liikutaKenkaa() {
        for (Kenka k : kengat) {
            k.liiku();
        }
    }

    /**
     * Paivittaa pisteet ja sydänmäärät, luo ja liikuttaa kaloja ja kenkiä 
     * ja liikuttaa kalastajaa, sekä lisää päivitysmäärää aina tätä metodia 
     * kutsuttaessa
     *
     */
    public void paivitaPeli() {
        paivitaPisteet();
        paivitaSydamet();

        uusiKala();
        uusiKenka();
        liikutaKalaa();
        liikutaKenkaa();
        kalastaja.liiku();

        paivitysmaara++;
    }

    /**
     * Kalastajan osuessa kalaan se saa yhden pisteen
     *
     */
    public void paivitaPisteet() {
        for (Kala k : kalat) {
            if (kalastaja.osuu(k)) {
                pisteet++;
                //kalat.remove(k);
                //kalat.remove(kalat.indexOf(k));
            }
        }
    }

    /**
     * Kalastajan osuessa kenkään se menettää yhden sydämen
     *
     */
    public void paivitaSydamet() {
        for (Kenka k : kengat) {
            if (kalastaja.osuu(k)) {
                sydamet--;
                //kengat.remove(k);
            }
        }
    }
}
