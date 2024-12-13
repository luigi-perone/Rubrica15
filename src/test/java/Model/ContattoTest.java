/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Gruppo 15
 */
public class ContattoTest {
    private Contatto c;
            
    public ContattoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        c = new Contatto("nome", "cognome", "descrizione");
    }
    
    @AfterEach
    public void tearDown() {
    }

    //Test per verificare che il nome impostato sia lo stesso che ritorna
    @Test
    public void testSetGetNome() {
        String nome="Luigi";
        c.setNome(nome);
        assertEquals(nome,c.getNome(), "Nome inserito correttamente");
    }

    //Test per verificare che il cognome impostato sia lo stesso che ritorna
    @Test
    public void testSetGetCognome() {
        String cognome="Panico";
        c.setCognome(cognome);
        assertEquals(cognome,c.getCognome(), "Cognome non inserito correttamente");
    }

    //Test per verificare che la descrizione impostata sia la stessa che ritorna
    @Test
    public void testSetGetDescrizione() {
        String descrizione="studente universitario";
        c.setDescrizione(descrizione);
        assertEquals(descrizione,c.getDescrizione(), "Descrizione non inserita correttamente");
    }

    //Test per verificare che il primo numero impostato sia lo stesso che ritorna
    @Test
    public void testSetGetNumero1() {
        Prefisso p1 = new Prefisso("39");
        NumeroTelefono n1 = new NumeroTelefono(p1,"3333333333");
        c.setNumero(n1, 0);
        assertEquals(n1, c.getNumero(0), "Primo numero non inserito correttamente");
    }
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
        n[0] = new NumeroTelefono(p1,"3333333333");
        Prefisso p2 = new Prefisso("33");
        n[1] = new NumeroTelefono(p2,"444444444");
        Prefisso p3 = new Prefisso("44");
        n[2] = new NumeroTelefono(p1,"1111111111");
        c.setNumero(n[0], 0);
        c.setNumero(n[1], 1);
        c.setNumero(n[2], 2);
        NumeroTelefono[] a ={c.getNumero(0),c.getNumero(1),c.getNumero(2)};
        assertArrayEquals(n, a, "Numeri non inseriti correttamente");

    }

    //Test per verificare che la prima email impostata sia la stessa che ritorna
    @Test
    public void testSetGetEmail1() {
        Email e = new Email("xyz@xyz.com");
        c.setEmail(e, 0);
        assertEquals(e,c.getEmail(0), "Prima e-mail non inserita correttamente");
    }
    //Test per verificare che la seconda email impostata sia la stessa che ritorna
    @Test
    public void testSetGetEmail2() {
        Email e2 = new Email("xyz@xyz.com");
        c.setEmail(e2, 1);
        assertEquals(e2,c.getEmail(1),"Seconda e-mail non inserita correttamente");
    }
    //Test per verificare che la terza email impostata sia la stessa che ritorna
    @Test
    public void testSetGetEmail3() {
        Email e3 = new Email("xyz@xyz.com");
        c.setEmail(e3, 2);
        assertEquals(e3,c.getEmail(2), "Terza e-mail non inserita correttamente");
    }
    //Test per verificare che le 3 email impostate siano le stesse che ritornano
    @Test
    public void testSetGetEmail4() {
        Email [] e = new Email[3];
        e[0] = new Email("xyz@x.it");
        e[1] = new Email("zxy@z.com");
        e[2] = new Email("eee@r.com");
        c.setEmail(e[0], 0);
        c.setEmail(e[1], 1);
        c.setEmail(e[2], 2);
        Email[] a ={c.getEmail(0),c.getEmail(1),c.getEmail(2)};
        assertArrayEquals(e, a, "E-mail non inserite correttamente");

    }

    //Test per verificare che la lunghezza del nome è nei limiti
    //Testiamo il programma inserendo un nome di lunghezza inferiore rispetto quella massima
    @Test
    public void testCheckLunghezza1() {
        String s ="Umberto";
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
    //Testiamo il programma inserendo una lunghezzaMax inferiore a quella del nome effettivo
    @Test
    public void testCheckLunghezza3() {
        String s ="Umberto";
        c.setNome(s);
        int lunghezzaMax = 0;
        assertFalse(c.checkLunghezza(c.getNome(), lunghezzaMax), "Lunghezza del nome non è superiore a quella massima impostata");   //se c.checkLunghezza() ritorna false il test è riuscito
    }
    
    //Test per verificare che un contatto è valido ovvero è stato inserito almeno uno tra nome e cognome
    //Testiamo il programma inserendo sia nome che cognome
    @Test
    public void testContattoValido(){
        String nome = "Luigi";
        String cognome ="Perone";
        String descrizione ="studente";
        c.setNome(nome);
        c.setCognome(cognome);
        c.setDescrizione(descrizione);
        NumeroTelefono[] n = new NumeroTelefono[3];
        Prefisso p1 = new Prefisso("39");
        n[0] = new NumeroTelefono(p1,"3333333333");
        Prefisso p2 = new Prefisso("33");
        n[1] = new NumeroTelefono(p2,"444444444");
        Prefisso p3 = new Prefisso("44");
        n[2] = new NumeroTelefono(p3,"1111111111");
        c.setNumero(n[0], 0);
        c.setNumero(n[1], 1);
        c.setNumero(n[2], 2);
        Email [] e = new Email[3];
        e[0] = new Email("xyz@x.com");
        e[1] = new Email("zxy@z.com");
        e[2] = new Email("eee@r.com");
        c.setEmail(e[0], 0);
        c.setEmail(e[1], 1);
        c.setEmail(e[2], 2);        
        assertTrue(c.contattoValido(), "Il contatto non è valido"); //se c.contattoValido() ritorna false il test è fallito
    }
    //Testiamo il programma non inserendo nome e cognome
    @Test
    public void testContattoValido2(){
        String descrizione ="studente";
        c.setCognome("");
        c.setNome("");
        c.setDescrizione(descrizione);
        NumeroTelefono[] n = new NumeroTelefono[3];
        Prefisso p1 = new Prefisso("39");
        n[0] = new NumeroTelefono(p1,"3333333333");
        Prefisso p2 = new Prefisso("33");
        n[1] = new NumeroTelefono(p2,"444444444");
        Prefisso p3 = new Prefisso("44");
        n[2] = new NumeroTelefono(p3,"1111111111");
        c.setNumero(n[0], 0);
        c.setNumero(n[1], 1);
        c.setNumero(n[2], 2);
        Email [] e = new Email[3];
        e[0] = new Email("xyz@x");
        e[1] = new Email("zxy@z");
        e[2] = new Email("eee@r");
        c.setEmail(e[0], 0);
        c.setEmail(e[1], 1);
        c.setEmail(e[2], 2);  
        assertFalse(c.contattoValido(), "Contatto valido");    //se c.contattoValido() ritorna true il test è fallito
    }
    //Testiamo il programma inserendo solo nome
    @Test
    public void testContattoValido3(){
        String nome = "Luigi";
        String descrizione ="studente";
        c.setNome(nome);
        c.setDescrizione(descrizione);
        NumeroTelefono[] n = new NumeroTelefono[3];
        Prefisso p1 = new Prefisso("39");
        n[0] = new NumeroTelefono(p1,"3333333333");
        Prefisso p2 = new Prefisso("33");
        n[1] = new NumeroTelefono(p2,"444444444");
        Prefisso p3 = new Prefisso("44");
        n[2] = new NumeroTelefono(p3,"1111111111");
        c.setNumero(n[0], 0);
        c.setNumero(n[1], 1);
        c.setNumero(n[2], 2);
        Email [] e = new Email[3];
        e[0] = new Email("xyz@x.com");
        e[1] = new Email("zxy@z.it");
        e[2] = new Email("eee@r.it");
        c.setEmail(e[0], 0);
        c.setEmail(e[1], 1);
        c.setEmail(e[2], 2);        
        assertTrue(c.contattoValido(),"Contatto valido"); //se c.contattoValido() ritorna false il test è fallito 
    }
    //Testiamo il programma inserendo solo cognome
    @Test
    public void testContattoValido4(){
        String cognome ="Perone";
        String descrizione ="studente";
        c.setCognome(cognome);
        c.setDescrizione(descrizione);
        NumeroTelefono[] n = new NumeroTelefono[3];
        Prefisso p1 = new Prefisso("39");
        n[0] = new NumeroTelefono(p1,"3333333333");
        Prefisso p2 = new Prefisso("33");
        n[1] = new NumeroTelefono(p2,"444444444");
        Prefisso p3 = new Prefisso("44");
        n[2] = new NumeroTelefono(p3,"1111111111");
        c.setNumero(n[0], 0);
        c.setNumero(n[1], 1);
        c.setNumero(n[2], 2);
        Email [] e = new Email[3];
        e[0] = new Email("xyz@x.it");
        e[1] = new Email("zxy@z.it");
        e[2] = new Email("eee@r.com");
        c.setEmail(e[0], 0);
        c.setEmail(e[1], 1);
        c.setEmail(e[2], 2);        
        assertTrue(c.contattoValido()); //se c.contattoValido() ritorna false il test è fallito
    }

    
    
    
    /**
     * Test of compareTo method, of class Contatto.
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
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        c.setCognome("Perone");
        c.setNome("Luigi");
        String s = "Perone Luigi";
        assertEquals(s,c.toString());
    }
    
}
