/**
 * @file Contatto.java
 * @brief Classe che rappresenta un contatto e ne verifica la validità.
 * 
 * La classe @c Contatto modella un contatto con attributi come nome, cognome, 
 * descrizione, numeri di telefono e email. Implementa le interfacce @c CheckLunghezza 
 * e @c Comparable<Contatto> per verificare la lunghezza delle stringhe e fornire un ordinamento.
 * 
 * @author gruppo15
 * @package Model
 */

package Model;

public class Contatto implements CheckLunghezza, Comparable<Contatto> {

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
     * @return Nome del contatto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Imposta il nome del contatto.
     * 
     * @param[in] nome Nuovo nome del contatto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce il cognome del contatto.
     * 
     * @return Cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Imposta il cognome del contatto.
     * 
     * @param[in] cognome Nuovo cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief Restituisce la descrizione del contatto.
     * 
     * @return Descrizione del contatto.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @brief Imposta la descrizione del contatto.
     * 
     * @param[in] descrizione Nuova descrizione del contatto.
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @brief Restituisce un numero di telefono del contatto all'indice specificato.
     * 
     * @param[in] idx Indice del numero di telefono nell'array.
     * @return Oggetto @c NumeroTelefono all'indice specificato.
     */
    public NumeroTelefono getNumero(int idx) {
        return numero[idx];
    }

    /**
     * @brief Imposta un numero di telefono per il contatto all'indice specificato.
     * 
     * @param numero Nuovo numero di telefono.
     * @param idx Indice in cui impostare il numero di telefono.
     */
    public void setNumero(NumeroTelefono numero, int idx) {
        this.numero[idx] = numero;
    }

    /**
     * @brief Restituisce un'email del contatto all'indice specificato.
     * 
     * @param[in] idx Indice dell'email nell'array.
     * @return Oggetto @c Email all'indice specificato.
     */
    public Email getEmail(int idx) {
        return email[idx];
    }

    /**
     * @brief Imposta un'email per il contatto all'indice specificato.
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
     * @param[in] s La stringa da verificare.
     * @param[in] lungMax La lunghezza massima consentita.
     * @return @c true se la stringa rispetta la lunghezza, @c false altrimenti.
     */
    @Override
    public boolean checkLunghezza(String s, int lungMax) {
        return s.length() <= lungMax && lungMax > 0;
    }

    /**
     * @brief Verifica se il contatto è valido.
     * 
     * Un contatto è considerato valido se ha un nome e un cognome obbligatoriamente,
     * e se ogni email e numero di telefono associato è valido. La lunghezza massima
     * consentita per nome, cognome, descrizione è 100 caratteri.
     * 
     * @return @c true se il contatto è valido, @c false altrimenti.
     */
    public boolean contattoValido() {
        if (!checkLunghezza(nome, 100) || !checkLunghezza(cognome, 100)||!checkLunghezza(descrizione, 100)) {
            return false;
        }

        for (NumeroTelefono n : numero) {
            if (n != null &&!n.checkNumeroTelefono()) {
                return false;
            }
        }

        for (Email e : email) {
            if (e != null &&!e.checkEmail()) {
                return false;
            }
        }

        return true;
    }

    /**
     * @brief Confronta il contatto corrente con un altro in base a cognome e nome.
     * 
     * @param[in] o Oggetto @c Contatto da confrontare.
     * @return Un valore negativo, zero o positivo in base all'ordine lessicografico.
     */
    @Override
    public int compareTo(Contatto o) {
        String cognomeNome = this.cognome + " " + this.nome;
        return cognomeNome.compareTo(o.cognome + " " + o.nome);
    }

    /**
     * @brief Restituisce una rappresentazione testuale del contatto.
     * 
     * @return Stringa contenente cognome e nome del contatto.
     */
    @Override
    public String toString() {
        return cognome + " " + nome;
    }
}

