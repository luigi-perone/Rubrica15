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

public class Contatto implements CheckLunghezza,Comparable<Contatto> {

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
     * @param[in] nome Nome del contatto.
     * @param[in] cognome Cognome del contatto.
     * @param[in] descrizione Descrizione del contatto.
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
     * 
     * @post restituisce il contenuto dell'attributo nome
     * 
     * @return Nome del contatto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Imposta il nome del contatto.
     * 
     * @pre Il valore passato diverso da null
     * @post viene assegnato all'attributo nome il valore passato
     *       
     * @param nome Nuovo nome del contatto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce il cognome del contatto.
     * 
     * @post restituisce il contenuto dell'attributo cognome
     * 
     * @return Cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Imposta il cognome del contatto.
     *
     * @pre Il valore passato diverso da null
     * @post viene assegnato all'attributo cognome il valore passato
     *
     * @param cognome Nuovo cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief Restituisce la descrizione del contatto.
     * 
     * @post restituisce il contenuto dell'attributo descrizione
     * 
     * 
     * @return Descrizione del contatto.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @brief Imposta la descrizione del contatto.
     * 
     * @pre Il valore passato diverso da null
     * @post viene assegnato all'attributo descrizione il valore passato
     *
     * @param[in]  descrizione Nuova descrizione del contatto.
     * 
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @brief Restituisce un numero di telefono del contatto.
     * 
     * @pre idx >0
     * @post restituisce il contenuto dell'attributo numero all'indice passato
     * 
     * 
     * @param[in]  idx Indice del numero di telefono nell'array.
     * @return Oggetto @c NumeroTelefono all'indice specificato.
     */
    public NumeroTelefono getNumero(int idx) {
        return numero[idx];
    }

    /**
     * @brief Imposta un numero di telefono per il contatto.
     * 
     * 
     * @pre numero diverso da null e idx >0
     * @post viene assegnato all'attributo numero il valore passato, all'indice dato
     *
     * @param[in] numero Nuovo numero di telefono.
     * @param[in]  idx Indice in cui impostare il numero di telefono.
     */
    public void setNumero(NumeroTelefono numero, int idx) {
        this.numero[idx] = numero;
    }

    /**
     * @brief Restituisce un'email del contatto.
     * 
     * @pre idx >0
     * @post restituisce il contenuto dell'attributo email all'indice passato
     * 
     * @param[in]  idx Indice dell'email nell'array.
     * @return Oggetto @c Email all'indice specificato.
     */
    public Email getEmail(int idx) {
        return email[idx];
    }

    /**
     * @brief Imposta un'email per il contatto.
     * 
     * @pre email diverso da null e idx >0
     * @post viene assegnato all'attributo email il valore passato, all'indice dato
     *
     * @param[in] email Nuova email.
     * @param[in] idx Indice in cui impostare l'email.
     */
    public void setEmail(Email email, int idx) {
        this.email[idx] = email;
    }

    /**
     * @brief Verifica se una stringa non supera una lunghezza massima specificata.
     * 
     * Implementazione del metodo definito nell'interfaccia @c CheckLunghezza.
     * 
     * @pre lungMax > 0 e s diverso da null
     * @post verifica se s ha una dimensione maggiore di quella supportata
     * 
     * @param[in] s La stringa da verificare.
     * @param[in] lungMax La lunghezza massima consentita.
     * @return @c true se la stringa rispetta la lunghezza, @c false altrimenti.
     */
    @Override
    public boolean checkLunghezza(String s, int lungMax) {
        return s.length() <= lungMax && lungMax > 0;
    }

    @Override
    public int compareTo(Contatto o) {
        String cognomeNome=new String(this.cognome+" "+this.nome);
        return cognomeNome.compareTo(o.cognome+" "+o.nome);
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
    
}
