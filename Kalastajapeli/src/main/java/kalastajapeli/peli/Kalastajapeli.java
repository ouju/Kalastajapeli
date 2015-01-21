
package kalastajapeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import kalastajapeli.kalastajapeli.Suunta;
import kalastajapeli.domain.Kalastaja;
import kalastajapeli.domain.Kala;
import kalastajapeli.domain.Kenka;
import kalastajapeli.domain.Pala;
import kalastajapeli.gui.Paivitettava;

public class Kalastajapeli extends Timer implements ActionListener {
    private boolean jatkuu;
    private Kalastaja kalastaja;
    private Kala kala;
    
    public Kalastajapeli(int leveys, int korkeus){
        super(1000, null);
    }
    public void setKalastaja(Kalastaja kalastaja){
        this.kalastaja = kalastaja;
    }
    public void setKala(Kala kala){
        this.kala = kala;
    }
    public Kalastaja getKalastaja(){
        return kalastaja;
    }
    public Kala getKala(){
        return kala;
    }
    public boolean jatkuu(){
        return jatkuu;
    }
    
    public void actionPerformed(ActionEvent ae){
        if(!jatkuu){
            return;
        }
        
    }
}
