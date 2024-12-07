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
     * @param email L'indirizzo email da associare all'oggetto.
     */
    public Email(String email) {
        this.email = email;
    }
    /**
     * @brief Imposta l'indirizzo email.
     * 
     * Questo metodo imposta l'indirizzo email dell'oggetto.
     * 
     * @param email L'indirizzo email da impostare.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @brief Restituisce l'indirizzo email.
     * 
     * Questo metodo restituisce l'indirizzo email dell'oggetto.
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
     * @param e L'oggetto @c Email da verificare.
     * @return @c true se l'email è valida, @c false altrimenti. (Non supportato al momento)
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public boolean checkEmail(Email e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * @brief Restituisce una rappresentazione in formato stringa dell'oggetto.
    * 
    * Questo metodo restituisce l'indirizzo email dell'oggetto come stringa.
    * Viene utilizzato per fornire una rappresentazione del contenuto dell'oggetto
    * quando viene chiamato il metodo `toString()`.
    * 
    * @return Una stringa che rappresenta l'indirizzo email dell'oggetto.
    */
    @Override
    public String toString() {
        return email;
    }
    
}

