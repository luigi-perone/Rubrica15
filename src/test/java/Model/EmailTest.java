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
    System.out.println("Inizializzo l'oggetto Email");
    e = new Email("test@example.com");
    System.out.println("Oggetto Email inizializzato: " + e);
}


    @AfterEach
    public void tearDown() {
        e = null; // Pulisce l'istanza dopo ogni test
    }

    /**
     * Test del metodo setEmail della classe Email.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String newEmail = "new@example.com";
        e.setEmail(newEmail); // Usa l'oggetto `e` condiviso
        assertEquals(newEmail, e.getEmail(), "L'email non è stata impostata correttamente");
    }

    /**
     * Test del metodo getEmail della classe Email.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "test@example.com"; // Valore iniziale impostato in setUp
        String result = e.getEmail(); // Usa l'oggetto `e` condiviso
        assertEquals(expResult, result, "L'email non è stata restituita correttamente");
    }

    /**
     * Test del metodo checkEmail della classe Email.
     */
    @Test
    public void testCheckEmail() {
        System.out.println("checkEmail");

        // Verifica con un'email valida
        assertTrue(e.checkEmail(), "L'email valida non è stata riconosciuta");

        // Verifica con un'email non valida
        e.setEmail("invalid-email");
        assertFalse(e.checkEmail(), "L'email non valida è stata erroneamente accettata");
    }
}
