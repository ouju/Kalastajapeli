package kalastajapeli.oliot;

import java.util.ArrayList;
import java.util.Random;
import kalastajapeli.peli.Kalastajapeli;

/**
 * Luokka määrittelee kengän ja sen liikkumismetodin
 *
 * @author Outi
 */
public class Kenka extends Pala {

    private Suunta suunta;
    private ArrayList<Pala> palat;
    private ArrayList<Kenka> kengat;
    private Kalastajapeli peli;

    /**
     * Konstruktori määrittää kengän ominaisuudet
     *
     * @param x Kengän sijainti x-akselilla
     * @param y Kengän sijainti y-akselilla
     * @param suunta Kengän suunta
     */
    public Kenka(int x, int y, Suunta suunta) {
        super(x, y);
        this.suunta = Suunta.VASEN;
        this.palat = new ArrayList<Pala>();
        this.palat.add(new Pala(x, y));
        //this.kengat = new ArrayList<Kenka>();
    }
    
    /*public void uusiKenka() {
        Random random = new Random();
        kengat.add(new Kenka(peli.getLeveys(), random.nextInt(peli.getKorkeus()), Suunta.VASEN));
    }*/
    /**
     *
     * @return
     */
    public Suunta getSuunta() {
        return suunta;
    }

    /**
     * Metodi liikuttaa kenkää vasemmalle ja tallentaa sen sijainnin listaan
     *
     */
    public void liiku() {
        //int uusiX = palat.get(palat.size() - 1).getX();
        //int uusiY = palat.get(palat.size() - 1).getY();

        if (suunta == Suunta.VASEN) {
            x--;
        }
        //palat.remove(0);
        palat.add(new Pala(x, y));
    }
}
