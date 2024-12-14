/**
 * @file RubricaTest.java
 * 
 * La classe @c RubricaTest contiene metodi per verificare il corretto funzionamento
 * delle operazioni di gestione di un numero di telefono, inclusi metodi di aggiunta,
 * modifica, eliminazione, importazione, esportazione, e visualizzazione della rubrica.
 * 
 * @author gruppo15
 * @package Model
 */
package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
  * @brief Classe di test per la classe {@link Rubrica}.
  * 
 */
public class RubricaTest {
    
    private Rubrica r;

    /**
     * Costruttore di default della classe {@link RubricaTest}.
     */
    public RubricaTest() {
    }
    
    /**
     * Metodo eseguito una sola volta prima di tutti i test della classe.
     * 
     * @test
     */
    @BeforeAll
    public static void setUpClass() {
    }
    
    /**
     * Metodo eseguito una sola volta dopo tutti i test della classe.
     * 
     * @test
     */
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * Metodo eseguito prima di ogni test per inizializzare le variabili necessarie.
     * Inizializza l'oggetto {@link Rubrica} prima di ogni test.
     * 
     * @test
     */
    @BeforeEach
    public void setUp() {
        r = new Rubrica();
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
     * Test del metodo {@link Rubrica#eliminaContatto(Contatto)}.
     * Verifica che un contatto possa essere eliminato correttamente dalla rubrica.
     * 
     * @test
     */
    @Test
    public void testEliminaContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        r.aggiungiContatto(c);
        r.eliminaContatto(c);
        assertFalse(r.getTree().contains(c), "Il contatto non è stato eliminato correttamente");
    }

    /**
     * Test del metodo {@link Rubrica#aggiungiContatto(Contatto)}.
     * Verifica che un contatto venga aggiunto correttamente alla rubrica.
     * 
     * @test
     */
    @Test
    public void testAggiungiContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        r.aggiungiContatto(c);
        assertTrue(r.getTree().contains(c), "Il contatto non è stato aggiunto correttamente");
    }

    /**
     * Test del metodo {@link Rubrica#modificaContatto(Contatto, String, String, String, Email[], NumeroTelefono[])}.
     * Verifica che un contatto possa essere modificato correttamente.
     * 
     * @test
     */
    @Test
    public void testModificaContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        Email[] e = new Email[3];
        NumeroTelefono[] n = new NumeroTelefono[3];
        r.aggiungiContatto(c);
        Contatto modificato = r.modificaContatto(c, "Matteo", "Matteo", "amico", e, n);
        assertTrue(r.getTree().contains(modificato), "Il contatto modificato non è presente nella rubrica");
    }

    /**
     * Test del metodo {@link Rubrica#importaFile(String)}.
     * Verifica che un file CSV possa essere importato correttamente nella rubrica.
     * 
     * @test
     * @throws IOException Se si verifica un errore durante la lettura del file.
     */
    @Test
    public void testImportaFile() throws IOException {
        File file = File.createTempFile("rubrica_test", ".csv");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Nome,Cognome,Descrizione,Prefisso1,Numero1,Email1,Prefisso2,Numero2,Email2,Prefisso3,Numero3,Email3\n");
            writer.write("Mario,Rossi,Amico,39,1234567890,mario.rossi@example.com,33,9876543210,mario.backup@example.com,44,1122334455,mario.altro@example.com\n");
        }

        Rubrica importata = r.importaFile(file.getAbsolutePath());
        
        Contatto contatto = importata.getTree().first();
        assertEquals("Mario", contatto.getNome(), "Il contatto importato non è corretto");
        
        // Elimina il file temporaneo
        file.delete();
    }

    /**
     * Test del metodo {@link Rubrica#esportaRubrica(String)}.
     * Verifica che la rubrica venga esportata correttamente in un file CSV.
     * 
     * @test
     * @throws IOException Se si verifica un errore durante la scrittura del file.
     */
    @Test
    public void testEsportaRubrica() throws IOException {
        Contatto contatto1 = new Contatto("Mario", "Rossi", "Amico di famiglia");
        NumeroTelefono numero1 = new NumeroTelefono(new Prefisso("39"), "1234567890");
        Email email1 = new Email("mario.rossi@studenti.unsia.it");
        contatto1.setNumero(numero1, 0);
        contatto1.setEmail(email1, 0);

        r.aggiungiContatto(contatto1);

        // Crea un file temporaneo per esportare la rubrica
        File file = File.createTempFile("rubrica_test_export", ".csv");
        r.esportaRubrica(file.getAbsolutePath());

        // Verifica il contenuto del file
        String contenuto = new String(java.nio.file.Files.readAllBytes(file.toPath()));
        assertTrue(contenuto.contains("Mario,Rossi,Amico di famiglia,39,1234567890,mario.rossi@studenti.unsia.it"), "Il file esportato non contiene i dati corretti");

        // Elimina il file temporaneo
        file.delete();
    }

    /**
     * Test del metodo {@link Rubrica#toString()}.
     * Verifica che la rappresentazione in formato stringa della rubrica contenga i contatti.
     * 
     * @test
     */
    @Test
    public void testToString() {
        r.aggiungiContatto(new Contatto("Mario", "Rossi", "collega"));
        r.aggiungiContatto(new Contatto("Luca", "Ferrari", "amico"));
        
        String rubrica = r.toString();
        
        assertTrue(rubrica.contains("Rossi Mario"), "La rappresentazione della rubrica non contiene i contatti correttamente");
    }

    /**
     * Test del metodo {@link Rubrica#getTree()}.
     * Verifica che i contatti siano correttamente presenti nell'albero.
     * 
     * @test
     */
    @Test
    public void testGetTree() {
        Contatto c1 = new Contatto("Mario", "Rossi", "collega");
        Contatto c2 = new Contatto("Luca", "Ferrari", "amico");
        r.aggiungiContatto(c1);
        r.aggiungiContatto(c2);

        assertTrue(r.getTree().contains(c2), "L'albero non contiene il contatto aggiunto");
    }
}
