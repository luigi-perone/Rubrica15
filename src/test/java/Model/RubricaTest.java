/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author scass
 */
public class RubricaTest {
    
    private Rubrica r;
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        r = new Rubrica();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of eliminaContatto method, of class Rubrica.
     */
    @Test
    public void testEliminaContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        r.aggiungiContatto(c);
        r.eliminaContatto(c);
        assertFalse(r.getTree().contains(c));
    }

    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        r.aggiungiContatto(c);
        assertTrue(r.getTree().contains(c));
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        Contatto c = new Contatto("Mario", "Rossi", "Collega");
        Email[] e = new Email[3];
        NumeroTelefono[] n = new NumeroTelefono[3];
        r.aggiungiContatto(c);
        Contatto modificato = r.modificaContatto(c, "Matteo", "Matteo", "amico", e, n);
        assertTrue( r.getTree().contains(modificato));
        
    }

    /**
     * Test of importaFile method, of class Rubrica.
     */
    @Test
    public void testImportaFile() throws IOException {
        File file = File.createTempFile("rubrica_test", ".csv");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Nome,Cognome,Indirizzo,Prefisso1,Numero1,Email1,Prefisso2,Numero2,Email2,Prefisso3,Numero3,Email3\n");
            writer.write("Mario,Rossi,Amico,39,1234567890,mario.rossi@example.com,33,9876543210,mario.backup@example.com,44,1122334455,mario.altro@example.com\n");
        }

        Rubrica importata = r.importaFile(file.getAbsolutePath());
        
        Contatto contatto = importata.getTree().first();
        assertEquals("Mario", contatto.getNome());
        
        // Elimina il file temporaneo
        file.delete();
    }

    /**
     * Test of esportaRubrica method, of class Rubrica.
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
        assertTrue(contenuto.contains("Mario,Rossi,Amico di famiglia,39,1234567890,mario.rossi@studenti.unsia.it"));

        // Elimina il file temporaneo
        file.delete();
    }

    /**
     * Test of toString method, of class Rubrica.
     */
    @Test
    public void testToString() {
        r.aggiungiContatto(new Contatto("Mario", "Rossi", "collega"));
        r.aggiungiContatto(new Contatto("Luca", "Ferrari", "amico"));
        
        String rubrica = r.toString();
        
        assertTrue(rubrica.contains("Rossi Mario"));
    }

    /**
     * Test of getTree method, of class Rubrica.
     */
    @Test
    public void testGetTree() {
        Contatto c1 =new Contatto("Mario", "Rossi", "collega");
        Contatto c2 =new Contatto("Luca", "Ferrari", "amico");
        r.aggiungiContatto(c1);
        r.aggiungiContatto(c2);

        assertTrue(r.getTree().contains(c2));
    }
    
}
