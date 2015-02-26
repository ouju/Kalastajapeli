/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalastajapeli.hahmot;

import kalastajapeli.hahmot.Kalastaja;
import kalastajapeli.hahmot.Pala;
import kalastajapeli.hahmot.Suunta;
import kalastajapeli.peli.Kalastajapeli;
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
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 1, Suunta.ALAS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }

    @Test
    public void getSuuntaAlussaPalauttaaAlasVaikkaKalastajanSuuntaOnYlos() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 1, Suunta.YLOS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }

    @Test
    public void kalastajanSuuntaOnAlasKunSeVaihdetaanAlas() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 1, Suunta.YLOS);
        kalastaja.setSuunta(Suunta.ALAS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }

    @Test
    public void kalastajanSuuntaOnYlosKunSeVaihdetaanYlos() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 1, Suunta.ALAS);
        kalastaja.setSuunta(Suunta.YLOS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus, Suunta.YLOS);
    }

    @Test
    public void getXToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        int vastaus = kalastaja.getX();
        assertEquals(vastaus, 1);
    }

    @Test
    public void getYToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        int vastaus = kalastaja.getY();
        assertEquals(vastaus, 2);
    }

    @Test
    public void getSuuntaToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }

    @Test
    public void setXToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 1, Suunta.ALAS);
        kalastaja.setX(2);
        int vastaus = kalastaja.getX();
        assertEquals(vastaus, 2);
    }

    @Test
    public void setSuuntaToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        kalastaja.setSuunta(Suunta.YLOS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus, Suunta.YLOS);
    }

    /*  @Test
     public void setYToimii(){
     Kalastaja kalastaja = new Kalastaja(1,1, Suunta.ALAS);
     kalastaja.setY(2);
     int vastaus = kalastaja.getY();
     assertEquals(vastaus, 2);
     }*/
    @Test
    public void konstruktorinLeveydenMaaritysToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        int vastaus = kalastaja.getX();
        assertEquals(vastaus, 1);
    }

    @Test
    public void konstruktorinKorkeudenMaaritysToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        int vastaus = kalastaja.getY();
        assertEquals(vastaus, 2);
    }

    @Test
    public void konstruktorinSuunnanMaaritysToimii() {
        Kalastaja kalastaja = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        Suunta vastaus = kalastaja.getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }

    @Test
    public void osuuPalauttaaTrueKunPalatOsuu() {
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        Pala p = new Pala(3, 2);
        boolean vastaus = k.osuu(p);
        assertEquals(vastaus, true);
    }

    @Test
    public void osuuPalauttaaFalseKunPalatEiOsu() {
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        Pala p = new Pala(2, 3);
        boolean vastaus = k.osuu(p);
        assertEquals(vastaus, false);
    }

    @Test
    public void liikuLiikuttaaAlas() {
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        k.liiku();
        int vastaus = k.getY();
        assertEquals(vastaus, 3);
    }

    @Test
    public void liikuLiikuttaaYlos() {
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1, 2, Suunta.ALAS);
        k.setSuunta(Suunta.YLOS);
        k.liiku();
        int vastaus = k.getY();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void kalastajaOsuuLaitaanPalauttaaTrue(){
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1,-1, Suunta.ALAS);
        boolean vastaus = k.kalastajaOsuuLaitaan();
        assertEquals(vastaus, true);
    }
    
    @Test
    public void kalastajaOsuuLaitaanPalauttaaFalse(){
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1,2, Suunta.ALAS);
        boolean vastaus = k.kalastajaOsuuLaitaan();
        assertEquals(vastaus, false);
    }
    
    @Test
    public void kalastajaLiikkuuYlosOsuttuaanAlalaitaan(){
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1, 18, Suunta.ALAS);
        k.liiku();
        k.liiku();
        Suunta vastaus = k.getSuunta();
        assertEquals(vastaus, Suunta.YLOS);
    }
    
    @Test
    public void kalastajaLiikkuuAlasOsuttuaanYlalaitaan(){
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1, 0, Suunta.ALAS);
        k.setSuunta(Suunta.YLOS);
        k.liiku();
        //k.liiku();
        Suunta vastaus = k.getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }
    
    @Test
    public void kalastajaLiikkuuAlasOsuttuaanYlalaitaanTrue(){
        Kalastaja k = new Kalastaja(new Kalastajapeli(10,20), 1, 0, Suunta.ALAS);
        k.setSuunta(Suunta.YLOS);
        k.liiku();
        //k.liiku();
        //boolean kalastajaOsuuLaitaan = true;
        Suunta vastaus = k.getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }
}
