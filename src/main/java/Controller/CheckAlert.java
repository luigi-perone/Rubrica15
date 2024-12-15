/**
 * @file CheckAlert.java
 * @class CheckAlert
 * @brief Interfaccia per la gestione di alert specifici come validazione e duplicati.
 * @author gruppo 15
 */
package Controller;

/**
 * @brief Definisce i metodi per mostrare alert di validazione e duplicati.
 */
public interface CheckAlert {
    /**
     * @brief Mostra un alert di validazione.
     */
    void showValidationAlert();

    /**
     * @brief Mostra un alert per la gestione di duplicati.
     */
    void showDuplicateAlert();
}
