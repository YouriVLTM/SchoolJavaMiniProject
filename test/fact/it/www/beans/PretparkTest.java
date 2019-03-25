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
import fact.it.www.beans.*;
/**
 *
 * @author elspe
 */
public class PretparkTest {

    public PretparkTest() {
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
        Pretpark plopsaland = new Pretpark("Plopsaland");
        assertEquals("Plopsaland", plopsaland.getNaam());
    }

    /**
     * Test of setNaam method, of class Pretpark.
     */
    @Test
    public void testSetNaam() {
        Pretpark walibi = new Pretpark("Walibi");
        walibi.setNaam("Walibi");
        assertEquals("Walibi", walibi.getNaam());
    }

    /**
     * check constructor of LeisurePark + adding of Attractions check if you can
     * find an attraction by name
     */
    @Test
    public void checkToevoegenAttractiesEnOphalenAantal() {
        Pretpark walibi = new Pretpark("Walibi");
        assertEquals(0, walibi.getAantalAttracties());
        Attractie cobra = new Attractie("Cobra", 45);
        walibi.voegAttractieToe(cobra);
        assertEquals(1, walibi.getAantalAttracties());
        Attractie pulsar = new Attractie("Pulsar", 30);
        walibi.voegAttractieToe(pulsar);
        assertEquals(2, walibi.getAantalAttracties());
        Attractie[] lijst = new Attractie[2];
        lijst[0] = cobra;
        lijst[1] = pulsar;
        assertArrayEquals(lijst, walibi.getAttracties().toArray());
    }
    
    

    /**
     * Test of constructor en getters
     */
    @Test
    public void testZoekAttractieOpNaam() {
        Pretpark walibi = new Pretpark("Walibi");
        assertEquals(0, walibi.getAantalAttracties());
        Attractie cobra = new Attractie("Cobra", 45);
        walibi.voegAttractieToe(cobra);
        assertEquals(1, walibi.getAantalAttracties());
        Attractie pulsar = new Attractie("Pulsar", 30);
        walibi.voegAttractieToe(pulsar);
        assertEquals(2, walibi.getAantalAttracties());
        assertNotNull(walibi.zoekAttractieOpNaam("Pulsar"));
        assertEquals(pulsar.getNaam(), walibi.zoekAttractieOpNaam("Pulsar").getNaam());
        assertNull(walibi.zoekAttractieOpNaam("blabla"));
    }

    /**
     * before a Visitor can make his reservations, he has to register to the
     * LeisurePark as result of this registration he will receive a LeisurePark
     * Id (simply the how maniest visitor he is)
     */
    @Test
    public void testRegistreerBezoeker() {
        Bezoeker v1 = new Bezoeker("Donald", "Duck");
        Pretpark walibi = new Pretpark("Walibi");
        walibi.registreerBezoeker(v1);
        assertEquals(1, v1.getPretparkcode());
        Bezoeker v2 = new Bezoeker("Mickey", "Mouse");
        walibi.registreerBezoeker(v2);
        assertEquals(2, v2.getPretparkcode());
    }
}
