
package kalastajapeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import kalastajapeli.kalastajapeli.Suunta;
import kalastajapeli.kalastajapeli.domain.Kalastaja;

public class Nappaimistonkuuntelija implements KeyListener {
    Kalastaja kalastaja;
    
    public Nappaimistonkuuntelija(Kalastaja kalastaja){
        this.kalastaja = kalastaja;
    }
    
    public void keyTyped(KeyEvent ke){
        
    }
    
    public void keyPressed(KeyEvent ke){
        if (ke.getKeyCode()==KeyEvent.VK_UP){
            
        }
    }
    
    public void keyReleased(KeyEvent ke){
        
    }
}
