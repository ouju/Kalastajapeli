package kalastajapeli.hahmot;

import kalastajapeli.peli.Kalastajapeli;

/**
 * Luokka määrittää, palauttaa ja asettaa kalastajan sijainnin ja suunnan,
 * määrittää liikkumistoiminnon ja tarkistaa osuuko kalastaja palaan
 *
 * @author Outi
 */
public class Kalastaja {

    private int x;
    private int y;
    private Suunta suunta;
    private Kalastajapeli peli;

    /**
     * Konstruktori määrittelee Kalastajan ominaisuudet
     *
     * @param peli Kalastajapeli
     * @param x Kalastajan sijainti x-akselilla
     * @param y Kalastajan sijainti y-akselilla
     * @param suunta Kalastajan suunta
     */
    public Kalastaja(Kalastajapeli peli, int x, int y, Suunta suunta) {
        this.x = x;
        this.y = y;
        this.suunta = Suunta.ALAS;
        this.peli = peli;
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
        if (this.getX()+2 == pala.getX() && this.getY() == pala.getY()) {
            return true;
        }
        return false;
    }

    /**
     * Metodi liikuttaa kalastajaa askeleen alas, jos sen suunnaksi on määrätty
     * alas, ja ylös jos suunnaksi määrätty ylös. Kalastajan osuessa laitaan
     * sen suunta vaihtuu
     *
     */
    public void liiku() {
        if (suunta == Suunta.ALAS) {
            y++;
        } else if (suunta == Suunta.YLOS) {
            y--;
        }
        if (kalastajaOsuuLaitaan()) {
            if (suunta == Suunta.ALAS) {
                suunta = Suunta.YLOS;
            } else {
                suunta = Suunta.ALAS;
            }
        }
    }

    /**
     * Metodi tarkistaa osuuko kalastaja ylä- tai alalaitaan
     *
     * @return osumisen totuusarvo
     */
    public boolean kalastajaOsuuLaitaan() {
        if (y >= peli.getKorkeus()-1 || y <= -1) {
            return true;
        }
        return false;
    }
}
