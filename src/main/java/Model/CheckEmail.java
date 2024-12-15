/**
 * @file CheckEmail.java
 * @brief Interfaccia per la verifica della validità di un'email.
 * 
 * Questa interfaccia definisce un metodo per verificare la validità di un oggetto 
 * di tipo @c Email. Può essere implementata per fornire logiche di controllo specifiche.
 * 
 * @author gruppo15
 * @package Model
 */

package Model;

/**
 * @interface CheckEmail
 * @brief Interfaccia per verificare la validità di un'email.
 * 
 * Fornisce il metodo @c checkEmail per validare un'email in base a criteri definiti.
 */
public interface CheckEmail {

    /**
     * @brief Controlla la validità di un'email.
     * 
     * @pre Email esiste
     * @post Verifica se l'email è valida in base alla presenza della @ seguito da un dominio, 
     * punto seguito da almeno 2 caratteri.
     * 
     * Questo metodo deve essere implementato per verificare se un oggetto 
     * di tipo @c Email rispetta determinati criteri di validità.
     * 
     */
    public boolean checkEmail();
}

