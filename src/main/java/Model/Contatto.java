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
/**
 * @brief Contatto modella un contatto con attributi come nome, cognome, descrizione, numeri di telefono e email.
 * 
 */

public class Contatto implements CheckLunghezza, checkContattoValido, Comparable<Contatto> {

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
     * @pre Valori passati diversi da null
     * @post Oggetto creato con attributi aggiornati.
     * 
     * @param[in] nome Nome del contatto.
     * @param[in] cognome Cognome del contatto.
     * @param[in] descrizione Descrizione del contatto.
     */
    public Contatto(String nome, String cognome, String descrizione) {
        assert(nome != null);
        assert(cognome != null);
        assert(descrizione != null);
        this.nome = nome;
        this.cognome = cognome;
        this.descrizione = descrizione;
        this.numero = new NumeroTelefono[MAX];
        this.email = new Email[MAX];
        assert(this.nome.equals(nome));
        assert(this.cognome.equals(cognome));
        assert(this.descrizione.equals(descrizione));
    }

    // Getter e Setter per gli attributi della classe.
    
    /**
     * @brief Restituisce il nome del contatto.
     * 
     * @post Restituisce il valore dell'attributo nome 
     * 
     * @return Nome del contatto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Imposta il nome del contatto.
     * 
     * @pre parametro diverso da null
     * @post attributo aggiornato correttamente
     * 
     * @param[in] nome Nuovo nome del contatto.
     */
    public void setNome(String nome) {
        assert(nome != null);
        this.nome = nome;
        assert(this.nome.equals(nome));

    }

    /**
     * @brief Restituisce il cognome del contatto.
     * 
     * @post Restituisce il valore dell'attributo cognome 
     * 
     * @return Cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Imposta il cognome del contatto.
     * 
     * @pre parametro diverso da null
     * @post attributo cognome correttamente aggiornato
     * 
     * @param[in] cognome Nuovo cognome del contatto.
     */
    public void setCognome(String cognome) {
        assert(cognome != null);
        this.cognome = cognome;
        assert(this.cognome.equals(cognome));
    }

    /**
     * @brief Restituisce la descrizione del contatto.
     * 
     * @post restituisce il valore dell'attributo descrizione
     * 
     * @return Descrizione del contatto.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @brief Imposta la descrizione del contatto.
     * 
     * @pre parametro diverso da null
     * @post attributo descrizione correttamente aggiornato
     *
     * @param[in] descrizione Nuova descrizione del contatto.
     */
    public void setDescrizione(String descrizione) {
        assert(descrizione != null);
        this.descrizione = descrizione;
        assert(this.descrizione.equals(descrizione));
    }

    /**
     * @brief Restituisce un numero di telefono del contatto all'indice specificato.
     * 
     * @pre idx deve essere un valore tra 0 e 2
     * @post restituisce il riferimento all' idx-esimo NumeroTelefono associato al contatto
     * 
     * @param[in] idx Indice del numero di telefono nell'array.
     * @return Oggetto @c NumeroTelefono all'indice specificato.
     */
    public NumeroTelefono getNumero(int idx) {
        assert(idx>0);
        assert(idx <=2);
        return numero[idx];
    }

    /**
     * @brief Imposta un numero di telefono per il contatto all'indice specificato.
     * 
     * @pre paremtro numero diverso da null, idx compreso tra 0 e 2
     * @post oggetto aggiornato
     * 
     * @param[in] numero Nuovo numero di telefono.
     * @param[in] idx Indice in cui impostare il numero di telefono.
     */
    public void setNumero(NumeroTelefono numero, int idx) {
        assert(idx>0);
        assert(idx <=2);
        this.numero[idx] = numero;
        assert(this.numero[idx].getNumero().equals(numero.getNumero()));
        assert(this.numero[idx].getPrefisso().equals(numero.getPrefisso()));
    }

    /**
     * @brief Restituisce un'email del contatto all'indice specificato.
     * 
     * @pre idx deve essere un valore tra 0 e 2
     * @post restituisce il riferimento all' idx-esima Email associato al contatto
     * 
     * @param[in] idx Indice dell'email nell'array.
     * @return Oggetto @c Email all'indice specificato.
     */
    public Email getEmail(int idx) {
        assert(idx>0);
        assert(idx <=2);
        return email[idx];
    }

    /**
     * @brief Imposta un'email per il contatto all'indice specificato.
     * 
     * @pre paremtro numero diverso da null, idx compreso tra 0 e 2
     * @post oggetto aggiornato
     * 
     * @param[in] email Nuova email.
     * @param[in] idx Indice in cui impostare l'email.
     */
    public void setEmail(Email email, int idx) {
        assert(idx>0);
        assert(idx <=2);
        this.email[idx] = email;
        assert(this.email[idx].getEmail().equals(email.getEmail()));
    }

    /**
     * @brief Verifica se una stringa non supera una lunghezza massima specificata.
     * 
     * Implementazione del metodo definito nell'interfaccia @c CheckLunghezza.
     * 
     * @pre stringa passata diversa da null e lungMax >= 0
     * @post verifica se la lunghezza della stringa passata è minore 
     * della lunghezza massima consentita
     * 
     * @param[in] s La stringa da verificare.
     * @param[in] lungMax La lunghezza massima consentita.
     * @return @c true se la stringa rispetta la lunghezza, @c false altrimenti.
     */
    @Override
    public boolean checkLunghezza(String s, int lungMax) {
        assert(s != null);
        assert( lungMax >=0);
        return s.length() <= lungMax && lungMax > 0;
    }

    /**
     * @brief Verifica se il contatto è valido.
     * 
     * Implementazione del metodo definito nell'interfaccia @c checkContattoValido.
     * 
     * @pre Contatto esiste
     * @post verifica se il contatto ha almeno uno tra nome e cognome
     * 
     * Un contatto è considerato valido se ha un nome o un cognome obbligatoriamente,
     * e se ogni email e numero di telefono associato è valido. La lunghezza massima
     * consentita per nome, cognome, descrizione è 100 caratteri.
     * 
     * @return @c true se il contatto è valido, @c false altrimenti.
     */
    @Override
    public boolean contattoValido() {
        assert(this != null);
        if(this.getNome()== null && this.getCognome()== null)
            return false;

        if(this.getNome().length() == 0 && this.getCognome().length() == 0)
            return false;

        
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
     * Compara considerando il cognome, a parità di questo compara i nomi. Un contatto senza
     * cognome sarà minore di uno con il cognome
     * 
     * @pre contatto passato esiste, ossia diverso da null
     * @post compara i contatti restituendo -1 se oggetto corrente minore di quello passato,
     * 0 se sono uguali, 1 altrimenti
     * 
     * @param[in] o Oggetto @c Contatto da confrontare.
     * @return Un valore negativo, zero o positivo in base all'ordine lessicografico.
     */
    @Override
    public int compareTo(Contatto o) {
        assert(this != null);
        assert(o != null);
        // Gestione dei contatti senza cognome
        if (this.cognome == null || this.cognome.isEmpty()) {
            if (o.cognome == null || o.cognome.isEmpty()) {
                // Se entrambi i cognomi sono vuoti, confronta i nomi
                return this.nome.compareToIgnoreCase(o.nome);
            }
            // Questo contatto senza cognome va in fondo
            return 1;
        }
        if (o.cognome == null || o.cognome.isEmpty()) {
            // L'altro contatto senza cognome va in fondo
            return -1;
        }

        // Ordinamento normale per cognome
        int compareCognome = this.cognome.compareToIgnoreCase(o.cognome);
        if (compareCognome != 0) {
            return compareCognome;
        }

        // Ordinamento per nome se i cognomi sono uguali
        return this.nome.compareToIgnoreCase(o.nome);
    }

    /**
     * @brief Restituisce una rappresentazione testuale del contatto.
     * 
     * @pre Contatto esiste
     * @post Restituisce un formato stringa del contatto: Cognome Nome
     * 
     * @return Stringa contenente cognome e nome del contatto.
     */
    @Override
    public String toString() {
        assert(this != null);
        return cognome + " " + nome;
    }
}

