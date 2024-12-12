package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    private Email e;

    public EmailTest() {
    }

    @BeforeAll
    public static void setUpEmail() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        e = new Email("");
    }


    @AfterEach
    public void tearDown() {
        e = null; // Pulisce l'istanza dopo ogni test
    }

    /**
     * Test of setEmail and getEmail method, of class Email.
     */
    @Test
    public void testSetGetEmail() {
        String e1 = "c.panico16@studenti.unisa.it";
        e.setEmail(e1);
        assertEquals(e1, e.getEmail(), "L'email non è stata impostata correttamente");
    }
    
    /**
     * Tests of checkEmail method, of class Email.
     */
    @Test
    public void testValid() {
        e.setEmail("u.scassillo1@stduenti.unsia.it");
        assertTrue(e.checkEmail());
    }
    @Test
    public void testInvalid() {
        e.setEmail("u.scassillo1.stduenti.unsia.it");
        assertFalse(e.checkEmail());
    }
}
