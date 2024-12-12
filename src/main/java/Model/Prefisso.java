/**
 * @file Prefisso.java
 * @brief Classe che rappresenta un prefisso telefonico.
 * 
 * La classe @c Prefisso modella un prefisso telefonico e la lunghezza del numero
 * associato. Permette di impostare e ottenere il valore del prefisso e la lunghezza
 * del numero di telefono.
 * 
 * @author gruppo15
 * @package Model
 */

package Model;

public class Prefisso {

    private String valore; ///< Valore del prefisso telefonico.
    private int lunghezzaNumero; ///< Lunghezza del numero associato al prefisso.

    /**
     * @brief Costruttore della classe @c Prefisso.
     * 
     * Inizializza un oggetto @c Prefisso con il valore del prefisso e calcola
     * la lunghezza del numero associato in base al prefisso.
     * 
     * @pre Il valore del prefisso passato è valido.
     * @post Oggetto creato con il prefisso e la lunghezza del numero associato.
     * 
     * @param[in] valore Il valore del prefisso telefonico da associare.
     */
    public Prefisso(String valore) {
        this.valore = valore;
        switch (valore) {
        case "39": // Italia
            lunghezzaNumero = 10;
            break;
        case "1": // Stati Uniti
            lunghezzaNumero = 10;
            break;
        case "44": // Regno Unito
            lunghezzaNumero = 10;
            break;
        case "33": // Francia
            lunghezzaNumero = 9;
            break;
        case "49": // Germania
            lunghezzaNumero = 10;
            break;
        case "34": // Spagna
            lunghezzaNumero = 9;
            break;
        default: // Prefisso non riconosciuto
            lunghezzaNumero = -1; // Valore di default per prefissi sconosciuti
            break;
        }
    }

    /**
     * @brief Restituisce il valore del prefisso.
     * 
     * Questo metodo restituisce il valore del prefisso telefonico.
     * 
     * @post Restituisce il contenuto dell'attributo valore.
     * 
     * @return Il valore del prefisso.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    public String getValore() {
        return valore;
    }

    /**
     * @brief Imposta il valore del prefisso.
     * 
     * Questo metodo imposta il valore del prefisso e calcola la lunghezza del numero
     * associato a questo prefisso.
     * 
     * @pre Il valore passato in input è diverso da null.
     * @post Viene assegnato all'attributo valore il valore passato e, se necessario, 
     *       aggiorna la lunghezza del numero associato.
     * 
     * @param[in] valore Il valore del prefisso da impostare.
     */
    public void setValore(String valore) {
        this.valore = valore;
    switch (valore) {
        case "39": // Italia
            lunghezzaNumero = 10;
            break;
        case "1": // Stati Uniti
            lunghezzaNumero = 10;
            break;
        case "44": // Regno Unito
            lunghezzaNumero = 10;
            break;
        case "33": // Francia
            lunghezzaNumero = 9;
            break;
        case "49": // Germania
            lunghezzaNumero = 10;
            break;
        case "34": // Spagna
            lunghezzaNumero = 9;
            break;
        default: // Prefisso non riconosciuto
            lunghezzaNumero = -1; // Valore di default per prefissi sconosciuti
            break;
        }
        }

    /**
     * @brief Restituisce la lunghezza del numero associato al prefisso.
     * 
     * Questo metodo restituisce la lunghezza del numero telefonico associato a questo
     * prefisso.
     * 
     * @post Restituisce il contenuto dell'attributo lunghezzaNumero.
     * 
     * @return La lunghezza del numero associato al prefisso.
     */
    public int getLunghezzaNumero() {
        return lunghezzaNumero;
    }

    /**
     * @brief Restituisce una rappresentazione in formato stringa del prefisso.
     * 
     * Questo metodo restituisce una rappresentazione stringa del prefisso, preceduto dal simbolo "+".
     * 
     * @pre Prefisso esiste.
     * 
     * @return La rappresentazione del prefisso come stringa (es. "+39").
     */
    @Override
    public String toString() {
        return "+" + valore;
    }
}
