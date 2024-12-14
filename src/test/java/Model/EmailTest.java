/**
 * @file EmailTest.java
 * 
 * La classe @c EmailTest contiene i test unitari per verificare il 
 * corretto funzionamento della classe {@link Email}. Utilizza il framework 
 * JUnit 5 per l'implementazione dei test.
 * 
 * @author Gruppo 15
 * @package Model
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
 * @brief Classe di test per la classe Email.
 */
public class EmailTest {
    private Email e;

    /**
     * Costruttore di default della classe {@link EmailTest}.
     */
    public EmailTest() {
    }

    /**
     * Metodo eseguito una sola volta prima di tutti i test della classe.
     * Può essere utilizzato per configurare risorse condivise tra i test.
     * 
     * @test
     */
    @BeforeAll
    public static void setUpEmail() {
    }

    /**
     * Metodo eseguito una sola volta dopo tutti i test della classe.
     * Può essere utilizzato per pulire risorse condivise tra i test.
     * 
     * @test
     */
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Metodo eseguito prima di ogni test per inizializzare le variabili necessarie.
     * Inizializza l'oggetto {@link Email} prima di ogni test.
     * 
     * @test
     */
    @BeforeEach
    public void setUp() {
        e = new Email(""); // Inizializza l'oggetto Email prima di ogni test
    }

    /**
     * Metodo eseguito dopo ogni test per ripulire le risorse.
     * Pulisce l'istanza di {@link Email} dopo ogni test.
     * 
     * @test
     */
    @AfterEach
    public void tearDown() {
        e = null; // Pulisce l'istanza dopo ogni test
    }

    /**
     * Test dei metodi {@link Email#setEmail(String)} e {@link Email#getEmail()}.
     * Verifica che l'indirizzo email impostato sia correttamente restituito.
     * 
     * @test
     */
    @Test
    public void testSetGetEmail() {
        String e1 = "c.panico16@studenti.unisa.it";
        e.setEmail(e1);
        assertEquals(e1, e.getEmail(), "L'email non è stata impostata correttamente");
    }

    /**
     * Test per verificare la validità di un'email corretta.
     * Caso: l'email contiene una chiocciola '@' e un punto '.' dopo la chiocciola.
     * 
     * @test
     */
    @Test
    public void testValid() {
        e.setEmail("u.scassillo1@studenti.unisa.it");
        assertTrue(e.checkEmail(), "L'email dovrebbe essere valida");
    }

    /**
     * Test per verificare che un'email senza chiocciola '@' sia considerata non valida.
     * Caso: l'email manca del simbolo '@'.
     * 
     * @test
     */
    @Test
    public void testInvalid() {
        e.setEmail("u.scassillo1.stduenti.unisa.it");
        assertFalse(e.checkEmail(), "L'email non dovrebbe essere valida (manca '@')");
    }

    /**
     * Test per verificare che un'email senza un punto '.' dopo la chiocciola '@' 
     * sia considerata non valida.
     * Caso: l'email manca del punto dopo il simbolo '@'.
     * 
     * @test
     */
    @Test
    public void testInvalid2() {
        e.setEmail("u.scassillo1@studenti");
        assertFalse(e.checkEmail(), "L'email non dovrebbe essere valida (manca '.' dopo '@')");
    }
}
