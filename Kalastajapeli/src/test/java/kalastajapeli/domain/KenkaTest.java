
package kalastajapeli.domain;

import kalastajapeli.kalastajapeli.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KenkaTest {
    
    public KenkaTest() {
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
        Kenka k = new Kenka(2,1,Suunta.VASEN);
        k.liiku();
        int vastaus = k.getX();
        assertEquals(vastaus, 1);
    }
}
