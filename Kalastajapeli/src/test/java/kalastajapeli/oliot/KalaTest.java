
package kalastajapeli.oliot;

import java.util.ArrayList;
import kalastajapeli.hahmot.Kala;
import kalastajapeli.hahmot.Suunta;
import kalastajapeli.peli.Kalastajapeli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KalaTest {
    
    public KalaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void liikuToimiiOikein() {
        Kala k = new Kala(2,1,Suunta.VASEN);
        k.liiku();
        int vastaus = k.getX();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void kalaOsuuVasempaanLaitaanPalauttaaTrue(){
        Kala k = new Kala(0,1,Suunta.VASEN);
        k.liiku();
        boolean vastaus = k.kalaOsuuVasempaanLaitaan();
        assertEquals(vastaus,true);
    }
    
    @Test
    public void kalaOsuuVasempaanLaitaanPalauttaaFalse(){
        Kala k = new Kala(2,1,Suunta.VASEN);
        boolean vastaus = k.kalaOsuuVasempaanLaitaan();
        assertEquals(vastaus,false);
    }
}
