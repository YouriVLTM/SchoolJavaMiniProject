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
public class AttractieTest {

    public AttractieTest() {
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
        Attractie cobra = new Attractie("Cobra", 45);
        assertEquals("Cobra", cobra.getNaam());
        assertEquals(45, cobra.getDuur());
        Attractie speedy = new Attractie("Speedy");
        assertEquals("Speedy", speedy.getNaam());
        assertEquals(0, speedy.getDuur());
    }

    /**
     * Test of setNaam method, of class Attractie.
     */
    @Test
    public void testSetNaam() {
        Attractie python = new Attractie("Slang", 30);
        python.setNaam("Python");
        assertEquals("Python", python.getNaam());
    }

     /**
     * Test of setFotomethod, of class Attractie.
     */
    @Test
    public void testSetFoto() {
        Attractie python = new Attractie("Slang", 30);
        python.setFoto("Python.jpg");
        assertEquals("Python.jpg", python.getFoto());
    }


    /**
     * Test of setDuur method, of class Attractie.
     */
    @Test
    public void testSetDuur() {
        Attractie python = new Attractie("Slang", 30);
        python.setDuur(55);
        assertEquals(55, python.getDuur());
    }

    /**
     * Test of setVerantwoordelijke method, of class Attractie.
     */
    @Test
    public void testVerantwoordelijke() {
        Attractie python = new Attractie("Slang", 30);
        Personeelslid Mickey = new Personeelslid("Mickey", "Mouse");
        python.setVerantwoordelijke(Mickey);
        assertEquals(Mickey, python.getVerantwoordelijke());
    }


}
