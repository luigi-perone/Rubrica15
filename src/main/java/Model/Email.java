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

public class Email implements CheckEmail {

    private String email; ///< Indirizzo email dell'oggetto.

    
    /**
     * @brief Costruttore della classe @c Email.
     * 
     * Inizializza un oggetto @c Email con un indirizzo email specificato.
     * 
     * @pre Valori passati diversi da null
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
     * @post Viene assegnato all'attributo email il valore passato
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
     * la presenza di una "@" nell'indirizzo email.
     * 
     * @pre email passata diversa da null
     * @post Verifica se l'email è valida.
     * 
     * @param[in] e L'oggetto @c Email da verificare.
     * @return @c true se l'email è valida, @c false altrimenti.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public boolean checkEmail() {
        if (this.getEmail() == null) {
            return false; // Email non valida se l'oggetto o l'indirizzo è null
        }
        if (this.getEmail().length() < 0)
            return false;

        // Espressione regolare per verificare l'email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return this.getEmail().matches(emailRegex);
    }

    /**
     * @brief Verifica la lunghezza di una stringa.
     * 
     * Questo metodo implementa l'interfaccia @c CheckLunghezza. Verifica se la lunghezza 
     * della stringa fornita è maggiore della lunghezza massima consentita.
     * 
     * @pre La stringa passata come parametro deve essere non null.
     * @post Verifica se la lunghezza della stringa è superiore al limite specificato.
     * 
     * @param[in] s La stringa da verificare.
     * @param[in] lungMax La lunghezza massima consentita.
     * @return @c true se la lunghezza della stringa è maggiore di 0 e supera il limite massimo, 
     *         @c false altrimenti.
     */
}

