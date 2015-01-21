
package kalastajapeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import kalastajapeli.kalastajapeli.domain.Kala;
import kalastajapeli.kalastajapeli.domain.Kenka;
import kalastajapeli.kalastajapeli.domain.Pala;
import kalastajapeli.peli.Kalastajapeli;

public class Piirtoalusta extends JPanel implements Paivitettava {
    
    
    public void paivita(){
        repaint();
    }
}
