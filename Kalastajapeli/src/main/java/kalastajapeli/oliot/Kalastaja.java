package kalastajapeli.oliot;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka määrittää, palauttaa ja asettaa kalastajan sijainnin ja suunnan,
 * määrittää liikkumistoiminnon ja tarkistaa osuuko kalastaja palaan
 *
 * @author Outi
 */
public class Kalastaja {

    //private List<Pala> palat;
    private int x;
    private int y;
    private Suunta suunta;

    /**
     * Konstruktori määrittelee Kalastajan ominaisuudet
     *
     * @param x Kalastajan sijainti x-akselilla
     * @param y Kalastajan sijainti y-akselilla
     * @param suunta Kalastajan suunta
     */
    public Kalastaja(int x, int y, Suunta suunta) {
        this.x = x;
        this.y = y;
        //this.palat = new ArrayList<Pala>();
        //this.palat.add(new Pala(x, y));
        this.suunta = Suunta.ALAS;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }
    /*public List<Pala> getPalat() {
     return palat;
     }*/

    /**
     *
     * @return
     */
    public Suunta getSuunta() {
        return suunta;
    }

    /**
     *
     * @param suunta
     */
    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    /**
     * Metodi testaa osuuko kalastaja palaan
     *
     * @param pala Kala tai Kenka
     * @return osumisen totuusarvo
     */
    public boolean osuu(Pala pala) {
        //for (Pala p : palat) {
        if (this.getX() == pala.getX() || this.getY() == pala.getY()) {
            return true;
        }
        //}
        return false;
    }

    /**
     * Metodi liikuttaa kalastajaa askeleen alas, jos sen suunnaksi on määrätty
     * alas, ja ylös jos suunnaksi määrätty ylös
     *
     */
    public void liiku() {
        //int uusiX = palat.get(palat.size() - 1).getX();
        //int uusiY = palat.get(palat.size() - 1).getY();

        if (suunta == Suunta.ALAS) {
            y++;
        } else if (suunta == Suunta.YLOS) {
            y--;
        }
        //palat.remove(0);
        //palat.add(new Pala(x, y));
    }
}
