package kalastajapeli.hahmot;

import java.util.ArrayList;

/**
 * Luokka määrittelee kengän ja sen liikkumismetodin
 *
 * @author Outi
 */
public class Kenka extends Pala {

    private Suunta suunta;
    private ArrayList<Pala> palat;

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
        this.palat = new ArrayList<>();
        this.palat.add(new Pala(x, y));
    }

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
        x--;
        palat.add(new Pala(x, y));
    }
}
