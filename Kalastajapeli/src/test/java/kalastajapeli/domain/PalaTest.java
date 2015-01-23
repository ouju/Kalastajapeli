
package kalastajapeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalaTest {
    
    public PalaTest() {
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
    public void PalaLuodaanOikein() {
        Pala pala = new Pala(1, 1);
        String vastaus = pala.toString();
        assertEquals("(1,1)", vastaus);
    }
    
    @Test
    public void KahdenPalanOsuessaPalautuuTrue(){
        Pala pala = new Pala(1, 1);
        boolean vastaus = pala.osuu(pala);
        assertEquals(vastaus, true);
    }
    
    @Test
    public void KahdenPalanEiOsuessaPalautuuFalse(){
        Pala pala1 = new Pala(1, 1);
        Pala pala2 = new Pala(1, 2);
        boolean vastaus = pala1.osuu(pala2);
        assertEquals(vastaus, false);
    }
    
    @Test
    public void getXPalauttaaOikeanArvon(){
        Pala pala = new Pala(1,2);
        int vastaus = pala.getX();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void getYPalauttaaOikeanArvon(){
        Pala pala = new Pala(1,2);
        int vastaus = pala.getY();
        assertEquals(vastaus, 2);
    }
}
