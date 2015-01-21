
package kalastajapeli.domain;

import java.util.ArrayList;
import java.util.List;
import kalastajapeli.kalastajapeli.Suunta;

public class Kalastaja {
    private List<Pala> palat;
    private int x;
    private int y;
    private Suunta suunta;
    
    public Kalastaja(int x, int y, Suunta suunta){
        this.x = 1;
        this.y = y;
        this.suunta = suunta;
        this.palat = new ArrayList<Pala>();
        this.palat.add(new Pala(x, y));
    }
    public Suunta getSuunta(){
        return suunta;
    }
    public void setSuunta(Suunta suunta){
        this.suunta = suunta;
    }
}
