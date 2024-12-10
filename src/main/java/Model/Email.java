/**
 * @file Email.java
 * @brief Classe che rappresenta un'email e fornisce metodi per la sua gestione.
 * 
 * La classe @c Email modella un'email e implementa l'interfaccia @c CheckEmail per 
 * la validazione di un oggetto email. I metodi permettono di impostare e ottenere 
 * l'indirizzo email.
 * 
 * @package Model
 */

package Model;

public class Email implements CheckEmail {

    private String email; ///< Indirizzo email dell'oggetto.

    
    /**
     * @brief Costruttore della classe @c Email.
     * 
     * Inizializza un oggetto @c Email con un indirizzo email specificato.
     * 
     * @per Valori passati diversi da null
     * @post Oggetto creato
     * 
     * @param[in] email L'indirizzo email da associare all'oggetto.
     */
    public Email(String email) {
        this.email = email;
        
        
    }
    /**
     * @brief Imposta l'indirizzo email.
     * 
     * Questo metodo imposta l'indirizzo email dell'oggetto.
     * 
     * @pre Il valore passato diverso da null
     * @post viene assegnato all'attributo email il valore passato
     * 
     * @param[in] email L'indirizzo email da impostare.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @brief Restituisce l'indirizzo email.
     * 
     * Questo metodo restituisce l'indirizzo email dell'oggetto.
     * 
     * @post restituisce il contenuto dell'attributo email
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
     * non è ancora implementato.
     * 
     * @pre email passata diverso da null
     * @post verifica se email è valida, true se ha la @
     * 
     * @param[in] e L'oggetto @c Email da verificare.
     * @return @c true se l'email è valida, @c false altrimenti. (Non supportato al momento)
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public boolean checkEmail() {
        if ( this.getEmail() == null) {
            return false; // Email non valida se l'oggetto o l'indirizzo è null
        }

        // Espressione regolare per verificare l'email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return this.getEmail().matches(emailRegex);
    }

}

