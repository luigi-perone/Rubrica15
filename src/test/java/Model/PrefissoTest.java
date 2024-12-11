/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author scass
 */
public class PrefissoTest {
    private Prefisso p;
    public PrefissoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        p = new Prefisso("39");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getValore method, of class Prefisso.
     */
    @Test
    public void testConstructor() {
        assertEquals(10, p.getLunghezzaNumero());
    }

    /**
     * Test of setValore method, of class Prefisso.
     */
    @Test
    public void testSetGetValore() {
        p.setValore("49");
        assertEquals("49", p.getValore());
    }

    /**
     * Test of getLunghezzaNumero method, of class Prefisso.
     */
    @Test
    public void testGetLunghezzaNumero() {
      p.setValore("44");
      assertEquals(p.getLunghezzaNumero(), 10);
    }

    /**
     * Test of toString method, of class Prefisso.
     */
    @Test
    public void testToString() {
        p.setValore("8");
        String s = "+8";
        assertEquals(s,p.toString());
   
    }
    
}
