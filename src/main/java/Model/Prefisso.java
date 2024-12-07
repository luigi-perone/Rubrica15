/**
 * @file Prefisso.java
 * @brief Classe che rappresenta un prefisso telefonico.
 * 
 * La classe @c Prefisso modella un prefisso telefonico e la lunghezza del numero
 * associato. Permette di impostare e ottenere il valore del prefisso e la lunghezza
 * del numero di telefono.
 * 
 * @package Model
 */

package Model;

public class Prefisso {

    private String valore; ///< Valore del prefisso telefonico.
    private int lunghezzaNumero; ///< Lunghezza del numero associato al prefisso.

    /**
     * @brief Restituisce il valore del prefisso.
     * 
     * Questo metodo restituisce il valore del prefisso telefonico. Il metodo non è 
     * ancora implementato.
     * 
     * @return Il valore del prefisso.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    public String getValore() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Imposta il valore del prefisso.
     * 
     * Questo metodo imposta il valore del prefisso e calcola la lunghezza del numero
     * associato a questo prefisso.
     * 
     * @param valore Il valore del prefisso da impostare.
     */
    public void setValore(String valore) {
        this.valore = valore;
        //calcolo lunghezza numero (da implementare)
    }

    /**
     * @brief Restituisce la lunghezza del numero associato al prefisso.
     * 
     * Questo metodo restituisce la lunghezza del numero telefonico associato a questo
     * prefisso.
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
     * @return La rappresentazione del prefisso come stringa (es. "+39").
     */
    @Override
    public String toString() {
        return "+" + valore;
    }
}

