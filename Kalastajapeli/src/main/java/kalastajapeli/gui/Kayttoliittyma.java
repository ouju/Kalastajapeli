
package kalastajapeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kalastajapeli.peli.Kalastajapeli;

public class Kayttoliittyma {
    private Kalastajapeli peli;
    private int sivunPituus;
    private JFrame frame;
    private Piirtoalusta alusta;
    
    public Kayttoliittyma(Kalastajapeli peli, int pituus){
        this.peli = peli;
        this.sivunPituus = pituus;
    }
}
