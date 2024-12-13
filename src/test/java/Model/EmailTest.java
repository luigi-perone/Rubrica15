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
    
    //Test per verificare che un'email sia valida 
    //Testiamo il programma inserendo un email con la chiocciola e col punto successivo alla chiocciola
    @Test
    public void testValid() {
        e.setEmail("u.scassillo1@stduenti.unsia.it");
        assertTrue(e.checkEmail(), "L'email inserita non è valida"); //se e.checkEmail() ritorna true il test è riuscito
    }
    //Testiamo il programma inserendo un email priva di chiocciola
    @Test
    public void testInvalid() {
        e.setEmail("u.scassillo1.stduenti.unsia.it");
        assertFalse(e.checkEmail(), "L'email inserita è valida");    //se e.checkEmail() ritorna false il test è riuscito
    }
    //Testiamo il programma inserendo un email priva di punto nella parte successiva alla chiocchiola
    @Test
    public void testInvalid2() {
        e.setEmail("u.scassillo1@stduenti");
        assertFalse(e.checkEmail(), "L'email inserita è valida");    //se e.checkEmail() ritorna false il test è riuscito
    }
}
