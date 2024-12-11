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
public class ContattoTest {
    private Contatto c;
    private NumeroTelefono[] n;
    private Prefisso p;
    private Prefisso p1;
    private Prefisso p2;
    private Email[] e;
            
    public ContattoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        e = new Email[3];
        e[0] = new Email("u.scassillo1@studenti.unisa.it");
        e[1] = new Email("l.perone3@studenti.unisa.it");
        e[2] = new Email("c.panico16@studenti.unisa.it");
        p = new Prefisso("39");
        p1 = new Prefisso("44");
        p2 = new Prefisso("33");
        n = new NumeroTelefono[3];
        n[0] = new NumeroTelefono(p, "0123456789");
        n[1] = new NumeroTelefono(p1, "1234567890");
        n[2] = new NumeroTelefono(p2, "123456789");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testSetGetNome() {
        String nome="Umberto";
        c.setNome(nome);
        assertEquals(nome,c.getNome());
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testSetGetCognome() {
        String cognome="Scassillo";
        c.setCognome(cognome);
        assertEquals(cognome,c.getCognome());
    }

    /**
     * Test of getDescrizione method, of class Contatto.
     */
    @Test
    public void testSetGetDescrizione() {
        String descrizione="studente universitario";
        c.setCognome(descrizione);
        assertEquals(descrizione,c.getDescrizione());
    }

    /**
     * Test of getNumero method, of class Contatto.
     */
    @Test
    public void testSetGetNumero1() {
    }
    @Test
    public void testSetGetNumero2() {
        
    }
    @Test
    public void testSetGetNumero3() {
        
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        int idx = 0;
        Contatto instance = null;
        Email expResult = null;
        Email result = instance.getEmail(idx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Contatto.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        Email email = null;
        int idx = 0;
        Contatto instance = null;
        instance.setEmail(email, idx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLunghezza method, of class Contatto.
     */
    @Test
    public void testCheckLunghezza() {
        System.out.println("checkLunghezza");
        String s = "";
        int lungMax = 0;
        Contatto instance = null;
        boolean expResult = false;
        boolean result = instance.checkLunghezza(s, lungMax);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Contatto o = null;
        Contatto instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contatto instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
