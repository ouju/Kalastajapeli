package kalastajapeli.hahmot;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka määrittää kalan sijainnin ja sen liikkumismetodin
 *
 * @author Outi
 */
public class Kala extends Pala {

    private Suunta suunta;
    private List<Pala> palat;

    /**
     * Konstruktori määrittelee kalan ominaisuudet
     *
     * @param x Kalan sijainti x-akselilla
     * @param y Kalan sijainti y-akselilla
     * @param suunta Kalan suunta
     */
    public Kala(int x, int y, Suunta suunta) {
        super(x, y);
        this.suunta = Suunta.VASEN;
        this.palat = new ArrayList<>();
        this.palat.add(new Pala(x, y));
    }

    /**
     * Metodi liikuttaa kalaa vasemmalle ja tallettaa sen uuden sijainnin
     * palat-listaan
     */
    public void liiku() {
        x--;
        palat.add(new Pala(x, y));
    }

    /**
     * Metodi tarkistaa milloin kala saavuttaa vasemman laidan
     *
     * @return osumisen totuusarvo
     */
    public boolean kalaOsuuVasempaanLaitaan() {
        if (x == -1) {
            return true;
        }

        return false;
    }
}
