/**
 * @file CheckLunghezza.java
 * @brief Interfaccia per la verifica della lunghezza di una stringa.
 * 
 * Questa interfaccia definisce un metodo per controllare se una stringa non supera 
 * una lunghezza massima specificata.
 * 
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
     * @brief Controlla la lunghezza di una stringa.
     * 
     * Questo metodo verifica se una stringa non supera una lunghezza massima specificata.
     * 
     * @param s La stringa da verificare.
     * @param lungMax La lunghezza massima consentita.
     * @return Un valore booleano: @c true se la stringa rispetta il limite, @c false altrimenti.
     */
    public boolean checkLunghezza(String s, int lungMax);
}
