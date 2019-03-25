/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.beans;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elspe
 */
public class BezoekerTest {

    public BezoekerTest() {
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

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {

        Bezoeker bezoeker = new Bezoeker("Donald", "Duck");
        assertEquals("Donald", bezoeker.getVoornaam());
        assertEquals("Duck", bezoeker.getFamilienaam());
        assertEquals(-1, bezoeker.getPretparkcode());
    }

    /**
     * Test of setVoornaam method, of class Bezoeker.
     */
    @Test
    public void testSetVoornaam() {
        Bezoeker bezoeker = new Bezoeker("Donald", "Duck");
        bezoeker.setVoornaam("Mickey");
        assertEquals("Mickey", bezoeker.getVoornaam());
    }

    /**
     * Test of setVoornaam method, of class Bezoeker.
     */
    @Test
    public void testSetFamilienaam() {
        Bezoeker bezoeker = new Bezoeker("Donald", "Duck");
        bezoeker.setFamilienaam("Mouse");
        assertEquals("Mouse", bezoeker.getFamilienaam());
    }

    /**
     * Test of setVoornaam method, of class Bezoeker.
     */
    @Test
    public void testSetPretparkcode() {
        Bezoeker bezoeker = new Bezoeker("Donald", "Duck");
        bezoeker.setPretparkcode(11);
        assertEquals(11, bezoeker.getPretparkcode());
    }

    /**
     * check basic functionality of Visitor: constructor, setters/getters and
     * adding Attraction name to wishlist
     */
    @Test
    public void testWishlistBasics() {
        Bezoeker v1 = new Bezoeker("Donald", "Duck");
        assertEquals(0, v1.getAantalOpWishlist());
        assertTrue(v1.voegToeAanWishlist("Cobra"));
        assertEquals(1, v1.getAantalOpWishlist());
    }

    /**
     * a Visitor can add maximum 5 Attraction names to wishlist
     */
    @Test
    public void testWishlistMax5() {
        Bezoeker v1 = new Bezoeker("Donald", "Duck");
        assertEquals(0, v1.getAantalOpWishlist());
        assertTrue(v1.voegToeAanWishlist("Cobra"));
        assertEquals(1, v1.getAantalOpWishlist());
        assertTrue(v1.voegToeAanWishlist("Cobre"));
        assertEquals(2, v1.getAantalOpWishlist());
        assertTrue(v1.voegToeAanWishlist("Cobri"));
        assertEquals(3, v1.getAantalOpWishlist());
        assertTrue(v1.voegToeAanWishlist("Cobro"));
        assertEquals(4, v1.getAantalOpWishlist());
        assertTrue(v1.voegToeAanWishlist("Cobru"));
        assertEquals(5, v1.getAantalOpWishlist());
        assertFalse(v1.voegToeAanWishlist("Pulsar"));
        assertEquals(5, v1.getAantalOpWishlist());
    }

    /**
     * Test of toString method, of class Bezoeker.
     */
    @Test
    public void testToString() {
        Bezoeker donald = new Bezoeker("Donald", "Duck");
        donald.setPretparkcode(9);
        assertEquals("Bezoeker DUCK donald met pretparkcode 9", donald.toString());
    }
}
