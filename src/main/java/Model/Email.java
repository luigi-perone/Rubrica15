/**
 * @file Email.java
 * @brief Classe che rappresenta un'email e fornisce metodi per la sua gestione.
 * 
 * La classe @c Email modella un'email e implementa l'interfaccia @c CheckEmail per 
 * la validazione di un oggetto email. I metodi permettono di impostare e ottenere 
 * l'indirizzo email.
 * 
 * @author gruppo15
 * @package Model
 */

package Model;
/**
 * @brief modella un'email
 * 
 */


public class Email implements CheckEmail {

    private String email; ///< Indirizzo email dell'oggetto.

    
    /**
     * @brief Costruttore della classe @c Email.
     * 
     * Inizializza un oggetto @c Email con un indirizzo email specificato.
     * 
     * @pre Valore passato diverso da null
     * @post Oggetto creato con attributo inizializzato al valore passato
     * 
     * @param[in] email L'indirizzo email da associare all'oggetto.
     */
    public Email(String email) {
        assert(email != null);
        this.email = email;
    }
    
    /**
     * @brief Imposta l'indirizzo email.
     * 
     * Questo metodo imposta l'indirizzo email dell'oggetto.
     * 
     * @pre Il valore passato diverso da null
     * @post Viene assegnato all'attributo email il valore passato
     * 
     * @param[in] email L'indirizzo email da impostare.
     */
    public void setEmail(String email) {
        assert(email != null);
        this.email = email;

    }

    /**
     * @brief Restituisce l'indirizzo email.
     * 
     * Questo metodo restituisce l'indirizzo email dell'oggetto.
     * 
     * @post Restituisce il contenuto dell'attributo email.
     * 
     * @return L'indirizzo email dell'oggetto.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @brief Verifica la validità di un'email.
     * 
     * Implementazione del metodo definito nell'interfaccia @c CheckEmail. Questo metodo 
     * verifica se l'email è valida seguendo una semplice espressione regolare per controllare
     * la presenza di una "@" nell'indirizzo email e dalla successiva presenza di un dominio,
     * ossia un punto seguito da almeno 2 caratteri.
     * 
     * @pre Email esiste
     * @post Verifica se l'email è valida in base alla presenza della @ seguito da un dominio, 
     * punto seguito da almeno 2 caratteri.
     * 
     * @param[in] e L'oggetto @c Email da verificare.
     * @return @c true se l'email è valida, @c false altrimenti.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public boolean checkEmail() {
        assert(this != null);
        if (this.getEmail() == null||this.getEmail().length() == 0) {
            return false; // Email non valida se l'oggetto o l'indirizzo è null o vuoto
        }
        
        // Espressione regolare per verificare l'email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return this.getEmail().matches(emailRegex);
    }

}

