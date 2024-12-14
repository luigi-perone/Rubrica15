/**
 * @file NumeroTelefonoTest.java
 * La classe @c NumeroTelefonoTest 
 * contiene metodi per verificare il corretto funzionamento delle operazioni di gestione di un numero di telefono.
 * 
 * @author gruppo15
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
  * @brief Classe di test per la classe {@link NumeroTelefono}.
 */
public class NumeroTelefonoTest {
    private NumeroTelefono n;
    private Prefisso p;
    
    /**
     * Costruttore di default della classe {@link NumeroTelefonoTest}.
     */
    public NumeroTelefonoTest() {
    }
    
    /**
     * Metodo eseguito una sola volta prima di tutti i test della classe.
     * Può essere utilizzato per configurare risorse condivise tra i test.
     * 
     * @test
     */
    @BeforeAll
    public static void setUpClass() {
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
     * Inizializza l'oggetto {@link NumeroTelefono} e {@link Prefisso} prima di ogni test.
     * 
     * @test
     */
    @BeforeEach
    public void setUp() {
        p = new Prefisso("39");
        n = new NumeroTelefono(p, "0123456789");
    }
    
    /**
     * Metodo eseguito dopo ogni test per ripulire le risorse.
     * 
     * @test
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test dei metodi {@link NumeroTelefono#setPrefisso(Prefisso)} e {@link NumeroTelefono#getPrefisso()}.
     * Verifica che il prefisso impostato sia correttamente restituito.
     * 
     * @test
     */
    @Test
    public void testSetGetPrefisso() {
        p.setValore("44");
        n.setPrefisso(p);
        assertEquals(n.getPrefisso(), p, "Il prefisso non è stato impostato correttamente");

    }

    /**
     * Test dei metodi {@link NumeroTelefono#setNumero(String)} e {@link NumeroTelefono#getNumero()}.
     * Verifica che il numero di telefono impostato sia correttamente restituito.
     * 
     * @test
     */
    @Test
    public void tesSetGetNumero() {
        String numero = "1234567890";
        n.setNumero(numero);
        assertEquals(n.getNumero(), numero, "Il numero di telefono non è stato impostato correttamente");

    }

    /**
     * Test del metodo {@link NumeroTelefono#toString()}.
     * Verifica che la rappresentazione in formato stringa del numero di telefono sia corretta.
     * 
     * @test
     */
    @Test
    public void testToString() {
        assertEquals("+39 0123456789", n.toString(), "La rappresentazione in formato stringa non è corretta");
    }

    /**
     * Test del metodo {@link NumeroTelefono#checkNumeroTelefono()} per verificare un numero di telefono valido.
     * 
     * @test
     */
    @Test
    public void testCheckNumeroTelefonoValid() {
        n.setNumero("1234567890");
        p.setValore("44");
        n.setPrefisso(p);
        assertTrue(n.checkNumeroTelefono(), "Il numero di telefono dovrebbe essere valido");

    }

    /**
     * Test del metodo {@link NumeroTelefono#checkNumeroTelefono()} per verificare un numero di telefono non valido.
     * Caso: il numero di telefono è troppo corto.
     * 
     * @test
     */
    @Test
    public void testCheckNumeroTelefonoInvalid() {
        n.setNumero("123456");
        p.setValore("44");
        n.setPrefisso(p);
        assertFalse(n.checkNumeroTelefono(), "Il numero di telefono non dovrebbe essere valido (troppo corto)");

    }

    /**
     * Test del metodo {@link NumeroTelefono#checkNumeroTelefono()} per verificare un numero di telefono non valido.
     * Caso: il numero di telefono è vuoto.
     * 
     * @test
     */
    @Test
    public void testCheckNumeroTelefonoInvalid1() {
        n.setNumero("");
        p.setValore("44");
        n.setPrefisso(p);
        assertFalse(n.checkNumeroTelefono(), "Il numero di telefono non dovrebbe essere valido (vuoto)");

    }

    /**
     * Test del metodo {@link NumeroTelefono#checkNumeroTelefono()} per verificare un numero di telefono non valido.
     * Caso: il numero di telefono contiene caratteri non numerici.
     * 
     * @test
     */
    @Test
    public void testCheckNumeroTelefonoInvalid2() {
        n.setNumero("012a456789");
        p.setValore("44");
        n.setPrefisso(p);
        assertFalse(n.checkNumeroTelefono(), "Il numero di telefono non dovrebbe essere valido (contiene caratteri non numerici)");

    }
}
