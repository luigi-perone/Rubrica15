/**
 * @file CheckLunghezza.java
 * @brief Interfaccia per la verifica della lunghezza di una stringa.
 * 
 * Questa interfaccia definisce un metodo per controllare se una stringa non supera 
 * una lunghezza massima specificata.
 * 
 * @author gruppo15
 * @package Model
 */

package Model;

/**
 * @interface CheckLunghezza
 * @brief Interfaccia per verificare la lunghezza di una stringa.
 * 
 * Fornisce il metodo @c checkLunghezza per determinare se una stringa rispetta 
 * un limite massimo di lunghezza.
 */
public interface CheckLunghezza {

    /**
     * 
     * @brief Controlla la lunghezza di una stringa.
     * 
     * Questo metodo verifica se una stringa non supera una lunghezza massima specificata.
     * 
     * @pre stringa passata diversa da null e lungMax >= 0
     * @post verifica se la lunghezza della stringa passata è minore 
     * della lunghezza massima consentita
     
     * @param s[in] La stringa da verificare.
     * @param lungMax[in] La lunghezza massima consentita per la stringa.
     * @return true se s ha una lunghezza minore di lungMax
     */
    public boolean checkLunghezza(String s, int lungMax);
}

