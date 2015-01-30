package kalastajapeli.domain;

import kalastajapeli.kalastajapeli.Suunta;
import java.util.ArrayList;
import java.util.List;

public class Kala extends Pala {
    private Suunta suunta;
    private List<Pala> palat;

    public Kala(int x, int y, Suunta suunta) {
        super(x, y);
        this.suunta = Suunta.VASEN;
        this.palat = new ArrayList<Pala>();
        this.palat.add(new Pala(x, y));
    }
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
