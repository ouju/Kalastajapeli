package kalastajapeli.peli;

import java.util.ArrayList;
import java.util.Random;
import kalastajapeli.hahmot.Kala;
import kalastajapeli.hahmot.Kalastaja;
import kalastajapeli.hahmot.Kenka;
import kalastajapeli.hahmot.Suunta;

/**
 * Luokka määrittää pelin päivittämisen, eli luo ja liikuttaa kaloja, kenkiä ja
 * kalastajaa sekä pitää laskua päivitysmääristä, pisteistä, elämistä
 * ja milloin kenkiä tulee luoda enemmän
 *
 * @author Outi
 */
public class Kalastajapeli {

    private Kalastaja kalastaja;
    private ArrayList<Kala> kalat;
    private ArrayList<Kenka> kengat;
    private int korkeus;
    private int leveys;
    private int paivitysmaara;
    private int pisteet;
    private int sydamet;
    private int uusinta;

    /**
     * Konstruktori määrittää ikkunalle leveyden ja korkeuden ja muuttujat, luo
     * alas päin kulkevan kalastajan vasempaan yläkulmaan, määrittää alkuun
     * pistemääräksi nolla ja sydänmääräksi kolme ja alustaa kalat- ja
     * kengät-listat ja uusinnoiksi yhdeksän
     *
     * @param leveys Peli-ikkunan leveys
     * @param korkeus Peli-kkunan korkeus
     */
    public Kalastajapeli(int leveys, int korkeus) {
        this.paivitysmaara = 0;
        this.kalat = new ArrayList<>();
        this.kengat = new ArrayList<>();
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pisteet = 0;
        this.sydamet = 3;
        this.uusinta = 9;

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
     * @return
     */
    public int getUusinta(){
        return uusinta;
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
     * määrittää suunnaksi vasen. Vaikeuttaa peliä luodessa enemmän kenkiä
     * päivitysmäärien ollessa jaollisia kuudellakymmenellä
     *
     */
    public void uusiKenka() {

        if (paivitysmaara % 60 == 0 && uusinta > 1) {
            uusinta--;
        }
        if (paivitysmaara % uusinta == 0) {
            Random random = new Random();
            kengat.add(new Kenka(leveys, random.nextInt(korkeus), Suunta.VASEN));
        }
    }

    /**
     * Metodi luo uuden kalan ikkunan oikeaan laitaan, arpoo korkeuden ja
     * määrittää suunnaksi vasen aina päivitysmäärän ollessa jaollinen viidellä
     *
     */
    public void uusiKala() {
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
     * Paivittaa pisteet ja sydänmäärät, luo ja liikuttaa kaloja ja kenkiä ja
     * liikuttaa kalastajaa, sekä lisää päivitysmäärää aina tätä metodia
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
     * Kalastajan osuessa kalaan se saa yhden pisteen ja kala poistuu näkyvistä
     *
     */
    public void paivitaPisteet() {
        ArrayList<Kala> poistettavat = new ArrayList<>();
        for (Kala k : kalat) {
            if (kalastaja.osuu(k)) {
                pisteet++;
                poistettavat.add(k);
            }
        }
        if (!poistettavat.isEmpty()) {
            kalat.remove(poistettavat.get(0));
        }
    }

    /**
     * Kalastajan osuessa kenkään se menettää yhden sydämen ja kenkä poistuu
     * näkyvistä
     *
     */
    public void paivitaSydamet() {
        ArrayList<Kenka> poistettavat = new ArrayList<>();
        for (Kenka k : kengat) {
            if (kalastaja.osuu(k)) {
                sydamet--;
                poistettavat.add(k);
            }
        }
        if (!poistettavat.isEmpty()) {
            kengat.remove(poistettavat.get(0));
        }
    }
}
