/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.beans;

import java.time.LocalTime;
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
public class PersoneelslidTest {

    public PersoneelslidTest() {
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

        Personeelslid personeel = new Personeelslid("Juul", "Kabas");
        assertEquals("Juul", personeel.getVoornaam());
        assertEquals("Kabas", personeel.getFamilienaam());
    }


    /**
     * Test of toString method, of class Personeelslid.
     */
    @Test
    public void testToString() {
        Personeelslid donald = new Personeelslid("Donald", "Duck");
        assertEquals("Personeelslid DUCK donald", donald.toString());
    }
    
}
