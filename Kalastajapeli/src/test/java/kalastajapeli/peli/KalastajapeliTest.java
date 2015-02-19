package kalastajapeli.peli;

import java.util.ArrayList;
import java.util.Random;
import kalastajapeli.kayttoliittyma.Kayttoliittyma;
import kalastajapeli.oliot.Kala;
import kalastajapeli.oliot.Kalastaja;
import kalastajapeli.oliot.Kenka;
//import kalastajapeli.kayttoliittyma.Paivitettava;
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
        for (int i = 0; i < 5; i++) {
            peli.uusiKala();
        }
        int vastaus = peli.getKala().size();
        assertEquals(vastaus, 5);
    }

    @Test
    public void uusiKenkaToimii() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        for (int i = 0; i < 5; i++) {
            peli.uusiKenka();
        }
        int vastaus = peli.getKenka().size();
        assertEquals(vastaus, 5);
    }

    @Test
    public void setKalastajaToimiiX() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(peli, 1, 2, Suunta.ALAS);
        peli.setKalastaja(k);
        int vastaus = peli.getKalastaja().getX();
        assertEquals(vastaus, 1);
    }

    @Test
    public void setKalastajaToimiiY() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(peli, 1, 2, Suunta.ALAS);
        peli.setKalastaja(k);
        int vastaus = peli.getKalastaja().getY();
        assertEquals(vastaus, 2);
    }

    @Test
    public void setKalastajaToimiiSuunta() {
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        Kalastaja k = new Kalastaja(peli, 1, 2, Suunta.ALAS);
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
    public void jatkuuPalauttaaTrue(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        boolean vastaus = peli.jatkuu();
        assertEquals(vastaus,true);
    }
    
    @Test
    public void jatkuuPalauttaaFalse(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.setSydamet(0);
        boolean vastaus = peli.jatkuu();
        assertEquals(vastaus,false);
    }
    
    @Test
    public void liikutaKalaaToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.uusiKala();
        peli.liikutaKalaa();
        int vastaus = peli.getKala().get(0).getX();
        assertEquals(vastaus, 9);
    }
    
    @Test
    public void liikutaKenkaaToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.uusiKenka();
        peli.liikutaKenkaa();
        int vastaus = peli.getKenka().get(0).getX();
        assertEquals(vastaus, 9);
    }
    
    @Test
    public void paivitaPelinLiikutaKalaaToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.uusiKala();
        peli.paivitaPeli();
        int vastaus = peli.getKala().get(0).getX();
        
        assertEquals(vastaus, 9);
    }
    
    @Test
    public void paivitaPelinLiikutaKenkaaToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.uusiKenka();
        peli.paivitaPeli();
        int vastaus = peli.getKenka().get(0).getX();
        
        assertEquals(vastaus, 9);
    }
    
    @Test
    public void paivitaPelinUusiKalaToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.paivitaPeli();
        int vastaus = peli.getKala().size();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void paivitaPelinUusiKenkaToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.paivitaPeli();
        boolean vastaus = peli.getKenka().contains(peli.getKenka().get(0));
        assertEquals(vastaus, true);
    }
    
    @Test
    public void paivitaPelinKalastajanLiikutusToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.paivitaPeli();
        int vastaus = peli.getKalastaja().getY();
        assertEquals(vastaus, 2);
    }
    
    @Test
    public void paivitaPelinPaivitysmaaraToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.paivitaPeli();
        int vastaus = peli.getPaivitysmaara();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void getPaivitysmaaraToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        int vastaus = peli.getPaivitysmaara();
        assertEquals(vastaus, 0);
    }
    
    @Test
    public void getPisteetToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        int vastaus = peli.getPisteet();
        assertEquals(vastaus, 0);
    }
    
    @Test
    public void getSydametToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        int vastaus = peli.getSydamet();
        assertEquals(vastaus, 3);
    }
    
    @Test
    public void setSydametToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.setSydamet(2);
        int vastaus = peli.getSydamet();
        assertEquals(vastaus, 2);
    }
    
    @Test
    public void paivitaPisteetToimii(){
        Kalastajapeli peli = new Kalastajapeli(10, 20);
        peli.uusiKala();
        int x = peli.getKala().get(0).getX();
        int y = peli.getKala().get(0).getY();
        Kalastaja k = new Kalastaja(peli, x, y,Suunta.ALAS);
        peli.paivitaPisteet();
        int vastaus = peli.getPisteet();
        assertEquals(vastaus, 1);
    }
}
