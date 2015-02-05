
package kalastajapeli.peli;

import java.util.ArrayList;
import java.util.Random;
import kalastajapeli.domain.Kalastaja;
import kalastajapeli.domain.Kenka;
import kalastajapeli.kalastajapeli.Suunta;
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
    public void uusiKenkaKorkeusToimii() {
        Random r = new Random();
        int korkeus = r.nextInt(10);
        Kenka k = new Kenka(1,korkeus,Suunta.VASEN);
        int vastaus = k.getY();
        assertEquals(vastaus, korkeus);
    }
    
    @Test
    public void uusiKenkaLeveysToimii() {
        Random r = new Random();
        Kenka k = new Kenka(1,r.nextInt(),Suunta.VASEN);
        int vastaus = k.getX();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void uusiKenkaListaToimiiHaettaessaX(){
        ArrayList<Kenka> k = new ArrayList<>();
        k.add(new Kenka(1,2,Suunta.VASEN));
        int vastaus = k.get(0).getX();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void uusiKenkaListaToimiiHaettaessaY(){
        ArrayList<Kenka> k = new ArrayList<>();
        k.add(new Kenka(1,2,Suunta.VASEN));
        int vastaus = k.get(0).getY();
        assertEquals(vastaus, 2);
    }
    
    @Test
    public void uusiKenkaListaToimiiHaettaessaSuunta(){
        ArrayList<Kenka> k = new ArrayList<>();
        k.add(new Kenka(1,2,Suunta.VASEN));
        Suunta vastaus = k.get(0).getSuunta();
        assertEquals(vastaus, Suunta.VASEN);
    }
    
    @Test
    public void uusiKenkaLisaaListaanKengan(){
        ArrayList<Kenka> k = new ArrayList<>();
        Kenka kenka = new Kenka(1,2,Suunta.VASEN);
        k.add(kenka);
        boolean vastaus = k.contains(kenka);
        assertEquals(vastaus, true);
    }
    
    @Test
    public void setKalastajaToimiiX(){
        Kalastajapeli peli = new Kalastajapeli(10,20);
        Kalastaja k = new Kalastaja(1,2,Suunta.ALAS);
        peli.setKalastaja(k);
        int vastaus = peli.getKalastaja().getX();
        assertEquals(vastaus, 1);
    }
    
    @Test
    public void setKalastajaToimiiY(){
        Kalastajapeli peli = new Kalastajapeli(10,20);
        Kalastaja k = new Kalastaja(1,2,Suunta.ALAS);
        peli.setKalastaja(k);
        int vastaus = peli.getKalastaja().getY();
        assertEquals(vastaus, 2);
    }
    
    @Test
    public void setKalastajaToimiiSuunta(){
        Kalastajapeli peli = new Kalastajapeli(10,20);
        Kalastaja k = new Kalastaja(1,2,Suunta.ALAS);
        peli.setKalastaja(k);
        Suunta vastaus = peli.getKalastaja().getSuunta();
        assertEquals(vastaus, Suunta.ALAS);
    }
}
