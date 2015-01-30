package kalastajapeli.domain;

import java.util.ArrayList;
import java.util.List;
import kalastajapeli.kalastajapeli.Suunta;

public class Kalastaja {

    private List<Pala> palat;
    private int x;
    private int y;
    private Suunta suunta;

    public Kalastaja(int x, int y) {
        this.x = x;
        this.y = y;
        this.palat = new ArrayList<Pala>();
        this.palat.add(new Pala(x, y));
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public List<Pala> getPalat() {
        return palat;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public boolean osuu(Pala pala) {
        for (Pala p : palat) {
            if (p.getX() == pala.getX() && p.getY() == pala.getY()) {
                return true;
            }
        }
        return false;
    }

    public void liiku() {
        int uusiX = palat.get(palat.size() - 1).getX();
        int uusiY = palat.get(palat.size() - 1).getY();

        if (suunta == Suunta.ALAS) {
            uusiY++;
        } else if (suunta == Suunta.YLOS) {
            uusiY--;
        }
        palat.remove(0);
        palat.add(new Pala(uusiX, uusiY));
    }
}
