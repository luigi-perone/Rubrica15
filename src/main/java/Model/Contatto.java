/**
 * @file Contatto.java
 * @brief Classe che rappresenta un contatto e verifica la sua validità.
 * 
 * La classe @c Contatto modella un contatto con attributi come nome, cognome, 
 * descrizione, numeri di telefono e email. Implementa le interfacce @c CheckLunghezza 
 * e @c ContattoValido per verificare la lunghezza delle stringhe e la validità 
 * complessiva del contatto.
 * 
 * @package Model
 */

package Model;

public class Contatto implements CheckLunghezza, ContattoValido {

    private String nome; ///< Nome del contatto.
    private String cognome; ///< Cognome del contatto.
    private String descrizione; ///< Descrizione del contatto.
    private NumeroTelefono[] numero; ///< Array di numeri di telefono associati al contatto.
    private Email[] email; ///< Array di email associate al contatto.
    private static final int MAX; ///< Numero massimo di numeri di telefono o email consentiti.

    // Inizializzazione della costante MAX.
    static {
        MAX = 3;
    }
    
    /**
     * @brief Costruttore della classe @c Contatto.
     * 
     * Inizializza un oggetto @c Contatto con nome, cognome e descrizione. Gli array 
     * di numeri di telefono e email sono inizializzati con dimensione massima pari a @c MAX.
     * 
     * @param nome Nome del contatto.
     * @param cognome Cognome del contatto.
     * @param descrizione Descrizione del contatto.
     */
    public Contatto(String nome, String cognome, String descrizione) {
        this.nome = nome;
        this.cognome = cognome;
        this.descrizione = descrizione;
        this.numero = new NumeroTelefono[MAX];
        this.email = new Email[MAX];
    }

    // Getter e Setter per gli attributi della classe.
    /**
     * @brief Restituisce il nome del contatto.
     * @return Nome del contatto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Imposta il nome del contatto.
     * @param nome Nuovo nome del contatto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce il cognome del contatto.
     * @return Cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Imposta il cognome del contatto.
     * @param cognome Nuovo cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief Restituisce la descrizione del contatto.
     * @return Descrizione del contatto.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @brief Imposta la descrizione del contatto.
     * @param descrizione Nuova descrizione del contatto.
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @brief Restituisce un numero di telefono del contatto.
     * 
     * @param idx Indice del numero di telefono nell'array.
     * @return Oggetto @c NumeroTelefono all'indice specificato.
     */
    public NumeroTelefono getNumero(int idx) {
        return numero[idx];
    }

    /**
     * @brief Imposta un numero di telefono per il contatto.
     * 
     * @param numero Nuovo numero di telefono.
     * @param idx Indice in cui impostare il numero di telefono.
     */
    public void setNumero(NumeroTelefono numero, int idx) {
        this.numero[idx] = numero;
    }

    /**
     * @brief Restituisce un'email del contatto.
     * 
     * @param idx Indice dell'email nell'array.
     * @return Oggetto @c Email all'indice specificato.
     */
    public Email getEmail(int idx) {
        return email[idx];
    }

    /**
     * @brief Imposta un'email per il contatto.
     * 
     * @param email Nuova email.
     * @param idx Indice in cui impostare l'email.
     */
    public void setEmail(Email email, int idx) {
        this.email[idx] = email;
    }

    /**
     * @brief Verifica se una stringa non supera una lunghezza massima specificata.
     * 
     * Implementazione del metodo definito nell'interfaccia @c CheckLunghezza.
     * 
     * @param s La stringa da verificare.
     * @param lungMax La lunghezza massima consentita.
     * @return @c true se la stringa rispetta la lunghezza, @c false altrimenti.
     */
    @Override
    public boolean checkLunghezza(String s, int lungMax) {
        return s.length() <= lungMax && lungMax > 0;
    }

    /**
     * @brief Verifica la validità complessiva del contatto.
     * 
     * Metodo da implementare per determinare la validità del contatto in base 
     * a criteri definiti.
     * 
     * @return @c true se il contatto è valido, @c false altrimenti.
     * @throws UnsupportedOperationException Eccezione lanciata se il metodo non è implementato.
     */
    @Override
    public boolean contattoValido() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }
}
