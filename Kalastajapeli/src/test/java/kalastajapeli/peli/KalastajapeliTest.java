package kalastajapeli.peli;

import java.util.ArrayList;
import java.util.Random;
import kalastajapeli.oliot.Kala;
import kalastajapeli.oliot.Kalastaja;
import kalastajapeli.oliot.Kenka;
import kalastajapeli.kayttoliittyma.Paivitettava;
import kalastajapeli.oliot.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KalastajapeliTest {

    public KalastajapeliTest() {
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
    public void uusiKalaToimii() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        ArrayList<Kala> k = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            peli.uusiKala();
        }
        int vastaus = peli.getKala().size();
        assertEquals(vastaus, 5);
    }

    @Test
    public void uusiKenkaToimii() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        ArrayList<Kenka> k = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            peli.uusiKenka();
        }
        int vastaus = peli.getKenka().size();
        assertEquals(vastaus, 5);
    }

    @Test
    public void setKalastajaToimiiX() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(1, 2, Suunta.ALAS);
        peli.setKalastaja(k);
        int vastaus = peli.getKalastaja().getX();
        assertEquals(vastaus, 1);
    }

    @Test
    public void setKalastajaToimiiY() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(1, 2, Suunta.ALAS);
        peli.setKalastaja(k);
        int vastaus = peli.getKalastaja().getY();
        assertEquals(vastaus, 2);
    }

    @Test
    public void setKalastajaToimiiSuunta() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(1, 2, Suunta.ALAS);
        peli.setKalastaja(k);
        Suunta vastaus = peli.getKalastaja().getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }
    
    @Test
    public void getKorkeusToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        int vastaus = peli.getKorkeus();
        assertEquals(vastaus, 20);
    }
    
    @Test
    public void getLeveysToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        int vastaus = peli.getLeveys();
        assertEquals(vastaus, 10);
    }
    
    @Test
    public void jatkuuToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        boolean vastaus = peli.jatkuu();
        assertEquals(vastaus,true);
    }
    
    @Test
    public void kalaOsuuVasempaanLaitaanPalauttaaTrue(){
        Kalastajapeli peli = new Kalastajapeli(0, 20);
        peli.uusiKala();
        Kala k = peli.getKala().get(0);
        k.liiku();
        boolean vastaus = peli.kalaOsuuVasempaanLaitaan();
        assertEquals(vastaus,true);
    }
    
    @Test
    public void kalaOsuuVasempaanLaitaanPalauttaaFalse(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kala kala = new Kala(2,1,Suunta.VASEN);
        ArrayList<Kala> k = new ArrayList<>();
        k.add(kala);
        boolean vastaus = peli.kalaOsuuVasempaanLaitaan();
        assertEquals(vastaus,false);
    }
    
    @Test
    public void kalastajaOsuuLaitaanPalauttaaTrue(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(1,-1, Suunta.ALAS);
        peli.setKalastaja(k);
        boolean vastaus = peli.kalastajaOsuuLaitaan();
        assertEquals(vastaus, true);
    }
    
    @Test
    public void kalastajaOsuuLaitaanPalauttaaFalse(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(1,2, Suunta.ALAS);
        peli.setKalastaja(k);
        boolean vastaus = peli.kalastajaOsuuLaitaan();
        assertEquals(vastaus, false);
    }
}
