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
public class NumeroTelefonoTest {
    private NumeroTelefono n;
    private Prefisso p;
    
    public NumeroTelefonoTest() {
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
        n = new NumeroTelefono(p,"0123456789");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPrefisso method, of class NumeroTelefono.
     */
    @Test
    public void testSetGetPrefisso() {
        n.setPrefisso(p);
        assertEquals(n.getPrefisso(),p);
    }

    /**
     * Test of getNumero method, of class NumeroTelefono.
     */
    @Test
    public void tesSetGetNumero() {
        String numero ="1234567890";
        n.setNumero(numero);
        assertEquals(n.getNumero(),numero);
    }

    /**
     * Test of toString method, of class NumeroTelefono.
     */
    @Test
    public void testToString() {
        assertEquals("+39 0123456789", n.toString());
    }

    /**
     * Test of checkNumeroTelefono method, of class NumeroTelefono.
     */
    @Test
    public void testCheckNumeroTelefonoValid() {
        n.setNumero("1234567890");
        p.setValore("44");
        n.setPrefisso(p);
        assertTrue(n.checkNumeroTelefono());
    }
    @Test
    public void testCheckNumeroTelefonoInvalid() {
        n.setNumero("123456");
        p.setValore("44");
        n.setPrefisso(p);
        assertFalse(n.checkNumeroTelefono());

    }
    @Test
    public void testCheckNumeroTelefonoInvalid1() {
        n.setNumero("");
        p.setValore("44");
        n.setPrefisso(p);
        assertFalse(n.checkNumeroTelefono());

    }
    @Test
    public void testCheckNumeroTelefonoInvalid2() {
        n.setNumero("012a456789");
        p.setValore("44");
        n.setPrefisso(p);
        assertFalse(n.checkNumeroTelefono());

    }
    
}
