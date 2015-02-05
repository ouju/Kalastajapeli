package kalastajapeli.domain;

import java.util.ArrayList;
import kalastajapeli.kalastajapeli.Suunta;

public class Kenka extends Pala {

    private Suunta suunta;
    private ArrayList<Pala> palat;

    public Kenka(int x, int y, Suunta suunta) {
        super(x, y);
        this.suunta = Suunta.VASEN;
        this.palat = new ArrayList<Pala>();
        this.palat.add(new Pala(x, y));
    }
    
    public Suunta getSuunta(){
        return suunta;
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
