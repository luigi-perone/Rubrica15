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
        System.out.println("Inizio dei test per la classe Email");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Fine dei test per la classe Email");
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
     * Test del metodo setEmail della classe Email.
     */
    @Test
    public void testSetGetEmail() {
        String e1 = "c.panico16@studenti.unisa.it";
        e.setEmail(e1);
        assertEquals(e1, e.getEmail(), "L'email non è stata impostata correttamente");
    }
    
    /**
     * Test del metodo checkEmail della classe Email.
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
