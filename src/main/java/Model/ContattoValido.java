/**
 * @file ContattoValido.java
 * @brief Interfaccia per la verifica della validità di un contatto.
 * 
 * Questa interfaccia definisce un metodo per controllare se un contatto è valido 
 * in base a criteri specifici.
 * 
 * @package Model
 */

package Model;

/**
 * @interface ContattoValido
 * @brief Interfaccia per verificare la validità di un contatto.
 * 
 * Fornisce il metodo @c contattoValido per determinare se un oggetto contatto 
 * soddisfa determinati criteri di validità.
 */
public interface ContattoValido {

    /**
     * @brief Verifica la validità di un contatto.
     * 
     * Questo metodo deve essere implementato per verificare se un contatto è valido.
     * 
     * @return Un valore booleano: @c true se il contatto è valido, @c false altrimenti.
     */
    public boolean contattoValido();
}
