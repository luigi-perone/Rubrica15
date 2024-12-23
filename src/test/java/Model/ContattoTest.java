/**
 * @file ContattoTest.java
 * @brief Classe di test per la classe Contatto.
 * 
 * La classe @c ContattoTest contiene i test unitari per verificare il 
 * corretto funzionamento della classe Contatto. Utilizza il framework 
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
 * @class ContattoTest
 * @brief Classe di test per validare i metodi della classe @c Contatto.
 */
public class ContattoTest {

    private Contatto c;

    /**
     * Costruttore della classe ContattoTest.
     */
    public ContattoTest() {
    }

    /**
     * Metodo eseguito una sola volta prima dell'esecuzione di tutti i test.
     */
    @BeforeAll
    public static void setUpClass() {
    }

    /**
     * Metodo eseguito una sola volta dopo l'esecuzione di tutti i test.
     */
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Metodo eseguito prima di ogni test per preparare l'ambiente di test.
     */
    @BeforeEach
    public void setUp() {
        c = new Contatto("nome", "cognome", "descrizione");
    }

    /**
     * Metodo eseguito dopo ogni test per pulire l'ambiente di test.
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * @test Verifica che il nome impostato sia corretto.
     */
    @Test
    public void testSetGetNome() {
        String nome = "Luigi";
        c.setNome(nome);

        assertEquals(nome,c.getNome(), "Nome inserito correttamente");

    }

    /**
     * @test Verifica che il cognome impostato sia corretto.
     */
    @Test
    public void testSetGetCognome() {
        String cognome = "Panico";
        c.setCognome(cognome);
        assertEquals(cognome,c.getCognome(), "Cognome non inserito correttamente");

    }

    /**
     * @test Verifica che la descrizione impostata sia corretta.
     */
    @Test
    public void testSetGetDescrizione() {
        String descrizione = "studente universitario";
        c.setDescrizione(descrizione);

        assertEquals(descrizione,c.getDescrizione(), "Descrizione non inserita correttamente");

    }

    /**
     * @test Verifica che il primo numero di telefono impostato sia corretto.
     */
    @Test
    public void testSetGetNumero1() {
        Prefisso p1 = new Prefisso("39");
        NumeroTelefono n1 = new NumeroTelefono(p1, "1111111111");
        c.setNumero(n1, 0);
        assertEquals(n1, c.getNumero(0), "Primo numero non inserito correttamente");
    }


    /**
     * @test Verifica che tutti i numeri di telefono impostati siano corretti.
     */

    //Test per verificare che il secondo numero impostato sia lo stesso che ritorna
    @Test
    public void testSetGetNumero2() {
        Prefisso p2 = new Prefisso("33");
        NumeroTelefono n2 = new NumeroTelefono(p2,"444444444");
        c.setNumero(n2, 1);
        assertEquals(n2, c.getNumero(1), "Secondo numero non inserito correttamente");
    }
    //Test per verificare che il terzo numero impostato sia lo stesso che ritorna
    @Test
    public void testSetGetNumero3() {
        Prefisso p3 = new Prefisso("44");
        NumeroTelefono n3 = new NumeroTelefono(p3,"1111111111");
        c.setNumero(n3, 2);
        assertEquals(n3, c.getNumero(2), "Terzo numero non inserito correttamente");
        
    }
    //Test per verificare che i 3 numeri di telefono impostati siano gli stessi che ritornano

    @Test
    public void testSetGetNumero4() {
        NumeroTelefono[] n = new NumeroTelefono[3];
        Prefisso p1 = new Prefisso("39");
        n[0] = new NumeroTelefono(p1, "2222222222");
        Prefisso p2 = new Prefisso("33");
        n[1] = new NumeroTelefono(p2, "444444444");
        Prefisso p3 = new Prefisso("44");
        n[2] = new NumeroTelefono(p3, "1111111111");
        c.setNumero(n[0], 0);
        c.setNumero(n[1], 1);
        c.setNumero(n[2], 2);

        NumeroTelefono[] a ={c.getNumero(0),c.getNumero(1),c.getNumero(2)};
        assertArrayEquals(n, a, "Numeri non inseriti correttamente");
    }


    /**
     * @test Verifica che la lunghezza del nome sia nei limiti specificati.
     */
    @Test
    public void testCheckLunghezza1() {
        String s = "Umberto";
        c.setNome(s);
        int lunghezzaMax = 100;
        assertTrue(c.checkLunghezza(c.getNome(), lunghezzaMax), "Lunghezza del nome è superiore a quella massima impostata");    //se c.checkLunghezza() ritorna true il test è riuscito
    }
    //Testiamo il programma inserendo una lunghezzaMax inferiore a quella del nome effettivo
    @Test
    public void testCheckLunghezza2() {
        String s ="Umberto";
        c.setNome(s);
        int lunghezzaMax = 3;
        assertFalse(c.checkLunghezza(c.getNome(), lunghezzaMax), "Lunghezza del nome non è superiore a quella massima impostata");   //se c.checkLunghezza() ritorna false il test è riuscito
    }

    /**
     * @test Verifica che un contatto è valido quando nome e cognome sono forniti.
     */
    @Test
    public void testContattoValido() {
        String nome = "Luigi";
        String cognome = "Perone";
        c.setNome(nome);
        c.setCognome(cognome);
        assertTrue(c.contattoValido());
    }

    /**
     * @test Verifica il metodo compareTo con un confronto maggiore.
     */
    @Test
    public void testCompareTo() {
        c.setCognome("Scassillo");
        c.setNome("Umberto");
        Contatto altroContatto = new Contatto("Claudio", "Panico", "Collega");
        assertTrue(c.compareTo(altroContatto) > 0, "L'altro contatto è \"maggiore\" del contatto che richiama la funzione"); 
    }

    @Test
    public void testCompareTo1() {
        c.setCognome("Scassillo");
        c.setNome("Umberto");
        Contatto altroContatto = new Contatto("Claudio", "Panico", "Collega");
        assertFalse(c.compareTo(altroContatto) < 0, "L'altro contatto è \"minore\" del contatto che richiama la funzione"); 
    }

    /**
     * @test Verifica la rappresentazione testuale del contatto.
     */
    @Test
    public void testToString() {
        c.setCognome("Perone");
        c.setNome("Luigi");
        String s = "Perone Luigi";
        assertEquals(s, c.toString());
    }
}

