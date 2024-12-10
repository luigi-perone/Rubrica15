/**
 * @file CheckEmail.java
 * @brief Interfaccia per la verifica della validità di un'email.
 * 
 * Questa interfaccia definisce un metodo per verificare la validità di un oggetto 
 * di tipo @c Email. Può essere implementata per fornire logiche di controllo specifiche.
 * 
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
     * Questo metodo deve essere implementato per verificare se un oggetto 
     * di tipo @c Email rispetta determinati criteri di validità.
     * 
     * @pre email passato diverso da null
     * @post verifica se email è valida
     * 
     * @param[in] e Oggetto di tipo @c Email da verificare.
     * @return Un valore booleano: @c true se l'email è valida, @c false altrimenti.
     */
    public boolean checkEmail();
}

