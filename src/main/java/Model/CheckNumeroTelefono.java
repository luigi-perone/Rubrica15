/**
 * @file CheckNumeroTelefono.java
 * @brief Interfaccia per la verifica della validità di un numero di telefono.
 * 
 * Questa interfaccia definisce un metodo per controllare se un oggetto di tipo 
 * @c NumeroTelefono rappresenta un numero valido.
 * 
 * @author gruppo15
 * @package Model
 */

package Model;

/**
 * @interface CheckNumeroTelefono
 * @brief Interfaccia per verificare la validità di un numero di telefono.
 * 
 * Fornisce il metodo @c checkNumeroTelefono per validare un numero di telefono 
 * secondo criteri definiti.
 */
public interface CheckNumeroTelefono {

    /**
     * @brief Controlla la validità di un numero di telefono.
     * 
     * Questo metodo verifica se un oggetto di tipo @c NumeroTelefono rappresenta 
     * un numero di telefono valido.
     * 
     */
    public boolean checkNumeroTelefono();
}
