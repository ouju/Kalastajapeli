/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalastajapeli.domain;

import kalastajapeli.kalastajapeli.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Outi
 */
public class KalastajaTest {

    public KalastajaTest() {
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
    public void getSuuntaPalauttaaAlasKunKalastajanSuuntaOnAlas() {
        Kalastaja kalastaja = new Kalastaja(1,1, Suunta.ALAS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus,Suunta.ALAS);
    }
    
    @Test
    public void getSuuntaAlussaPalauttaaAlasVaikkaKalastajanSuuntaOnYlos() {
        Kalastaja kalastaja = new Kalastaja(1,1, Suunta.YLOS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus,Suunta.ALAS);
    }
    
    @Test
    public void kalastajanSuuntaOnAlasKunSeVaihdetaanAlas() {
        Kalastaja kalastaja = new Kalastaja(1,1, Suunta.YLOS);
        kalastaja.setSuunta(Suunta.ALAS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus,Suunta.ALAS);
    }
    
    @Test
    public void kalastajanSuuntaOnYlosKunSeVaihdetaanYlos() {
        Kalastaja kalastaja = new Kalastaja(1,1, Suunta.ALAS);
        kalastaja.setSuunta(Suunta.YLOS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus,Suunta.YLOS);
    }
    @Test
    public void getXToimii(){
        Kalastaja kalastaja = new Kalastaja(1,1, Suunta.ALAS);
        int vastaus = kalastaja.getX();
        assertEquals(vastaus, 1);
    }
    @Test
    public void setXToimii(){
        Kalastaja kalastaja = new Kalastaja(1,1, Suunta.ALAS);
        kalastaja.setX(2);
        int vastaus = kalastaja.getX();
        assertEquals(vastaus, 2);
    }
}
