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
public class PersoonTest {
    
    public PersoonTest() {
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

        Persoon leonie = new Persoon("Leonie", "Pelgroms");
        assertEquals("Leonie", leonie.getVoornaam());
        assertEquals("Pelgroms", leonie.getFamilienaam());
        Persoon persoon = new Persoon();
        assertNull(persoon.getVoornaam());
        assertNull(persoon.getFamilienaam());
    }

    /**
     * Test of setVoornaam method, of class Persoon.
     */
    @Test
    public void testSetVoornaam() {
        Persoon persoon = new Persoon();
        persoon.setVoornaam("Frans");
        assertEquals("Frans", persoon.getVoornaam());
    }
    
        /**
     * Test of setVoornaam method, of class Persoon.
     */
    @Test
    public void testSetFamilienaam() {
        Persoon persoon = new Persoon();
        persoon.setFamilienaam("Caers");
        assertEquals("Caers", persoon.getFamilienaam());
    }
    
    /**
     * Test of toString method, of class Persoon.
     */
    @Test
    public void testToString() {
        Persoon leonie = new Persoon("Leonie", "Pelgroms");
        assertEquals("PELGROMS leonie", leonie.toString());
        Persoon frans = new Persoon("Frans", "Caers");
        assertEquals("CAERS frans", frans.toString());
    }
    
   
    
}
