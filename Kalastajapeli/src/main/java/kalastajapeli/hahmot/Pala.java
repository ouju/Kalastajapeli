package kalastajapeli.hahmot;

/**
 * Luokka määrittää ja hakee palan sijainnin ja testaa osuuko kaksi palaa
 * toisiinsa
 *
 * @author Outi
 */
public class Pala {

    int x;
    int y;

    /**
     * Konstruktori määrittää palalle sijainnin
     *
     * @param x Palan sijainti x-akselilla
     * @param y Palan sijainti y-akselilla
     */
    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
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
     * @return
     */
    public int getY() {
        return y;
    }

    /*public boolean osuu(Pala toinen) {
        return x == toinen.x && y == toinen.y;
    }
*/
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
