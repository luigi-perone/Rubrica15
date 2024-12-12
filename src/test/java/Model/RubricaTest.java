/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.TreeSet;
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
public class RubricaTest {
    
    private Rubrica r;
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        r = new Rubrica();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of eliminaContatto method, of class Rubrica.
     */
    @Test
    public void testEliminaContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        r.aggiungiContatto(c);
        r.eliminaContatto(c);
        assertFalse(r.getTree().contains(c));
    }

    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        r.aggiungiContatto(c);
        assertTrue(r.getTree().contains(c));
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        r.modificaContatto(c, "Matteo", "Matteo", "amico", null, null);
        assertTrue(r.getTree().contains(c));
        assertEquals("Matteo", c.getNome());

    }

    /**
     * Test of importaFile method, of class Rubrica.
     */
    @Test
    public void testImportaFile() {
        String namefile="rubrica.csv";
        r.importaFile(namefile);
        Contatto c = r.getTree().first();
    }

    /**
     * Test of esportaRubrica method, of class Rubrica.
     */
    @Test
    public void testEsportaRubrica() {
        System.out.println("esportaRubrica");
        String namefile = "";
        Rubrica instance = new Rubrica();
        instance.esportaRubrica(namefile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Rubrica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rubrica instance = new Rubrica();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTree method, of class Rubrica.
     */
    @Test
    public void testGetTree() {
        System.out.println("getTree");
        Rubrica instance = new Rubrica();
        TreeSet<Contatto> expResult = null;
        TreeSet<Contatto> result = instance.getTree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
