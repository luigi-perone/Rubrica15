/**
 * @file PrefissoTest.java
 * 
 * La classe @c PrefissoTest contiene i test unitari per verificare il 
 * corretto funzionamento della classe {@link Prefisso}. Utilizza il framework 
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
  * @brief Classe di test per la classe {@link Prefisso}.
 */
public class PrefissoTest {
    private Prefisso p;

    /**
     * Costruttore di default della classe {@link PrefissoTest}.
     */
    public PrefissoTest() {
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
     * Inizializza l'oggetto {@link Prefisso} prima di ogni test.
     * 
     * @test
     */
    @BeforeEach
    public void setUp() {
        p = new Prefisso("39");
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
     * Test del costruttore della classe {@link Prefisso}.
     * Verifica che il valore predefinito della lunghezza del numero sia 10.
     * 
     * @test
     */
    @Test
    public void testConstructor() {
        assertEquals(10, p.getLunghezzaNumero(), "La lunghezza del numero dovrebbe essere 10");
    }

    /**
     * Test dei metodi {@link Prefisso#setValore(String)} e {@link Prefisso#getValore()}.
     * Verifica che il valore del prefisso impostato sia correttamente restituito.
     * 
     * @test
     */
    @Test
    public void testSetGetValore() {
        p.setValore("49");
        assertEquals("49", p.getValore(), "Il valore del prefisso non è stato impostato correttamente");

    }

    /**
     * Test del metodo {@link Prefisso#getLunghezzaNumero()}.
     * Verifica che la lunghezza del numero sia corretta.
     * 
     * @test
     */
    @Test
    public void testGetLunghezzaNumero() {
        p.setValore("44");
        assertEquals(p.getLunghezzaNumero(), 10, "La lunghezza del numero dovrebbe essere 10");

    }

    /**
     * Test del metodo {@link Prefisso#toString()}.
     * Verifica che la rappresentazione in formato stringa del prefisso sia corretta.
     * 
     * @test
     */
    @Test
    public void testToString() {
        p.setValore("8");
        String s = "+8";
        assertEquals(s, p.toString(), "La rappresentazione in formato stringa non è corretta");
    }
}
