/**
 * @file NumeroTelefono.java
 * @brief Classe che rappresenta un numero di telefono associato a un prefisso.
 * 
 * La classe @c NumeroTelefono modella un numero di telefono completo di prefisso. 
 * Include metodi per ottenere e impostare il prefisso e il numero, e una rappresentazione 
 * in formato stringa del numero di telefono.
 * 
 * @package Model
 */

package Model;

public class NumeroTelefono implements CheckNumeroTelefono {

    private Prefisso prefisso; ///< Prefisso associato al numero di telefono.
    private String numero; ///< Numero di telefono.

    /**
     * @brief Costruttore della classe @c NumeroTelefono.
     * 
     * Inizializza un oggetto @c NumeroTelefono con il prefisso e il numero specificati.
     * 
     * @param prefisso Prefisso associato al numero di telefono.
     * @param numero Numero di telefono da associare al prefisso.
     */
    public NumeroTelefono(Prefisso prefisso, String numero) {
        this.prefisso = prefisso;
        this.numero = numero;
    }

    /**
     * @brief Restituisce il prefisso associato al numero di telefono.
     * 
     * Questo metodo restituisce il prefisso dell'oggetto @c NumeroTelefono.
     * 
     * @return Il prefisso associato al numero di telefono.
     */
    public Prefisso getPrefisso() {
        return prefisso;
    }

    /**
     * @brief Imposta il prefisso del numero di telefono.
     * 
     * Questo metodo imposta un nuovo prefisso per il numero di telefono.
     * 
     * @param prefisso Il nuovo prefisso da associare al numero di telefono.
     */
    public void setPrefisso(Prefisso prefisso) {
        this.prefisso = prefisso;
    }

    /**
     * @brief Restituisce il numero di telefono.
     * 
     * Questo metodo restituisce il numero di telefono dell'oggetto @c NumeroTelefono.
     * 
     * @return Il numero di telefono dell'oggetto.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @brief Imposta il numero di telefono.
     * 
     * Questo metodo imposta un nuovo numero di telefono per l'oggetto @c NumeroTelefono.
     * 
     * @param numero Il nuovo numero di telefono da impostare.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @brief Restituisce una rappresentazione in formato stringa del numero di telefono.
     * 
     * Questo metodo restituisce il numero di telefono completo di prefisso in formato 
     * stringa, ad esempio "+39 123456789".
     * 
     * @return La rappresentazione del numero di telefono come stringa.
     */
    @Override
    public String toString(){
        return prefisso.toString() + " " + numero;
    }

    /**
     * @brief Verifica la validità di un numero di telefono.
     * 
     * Questo metodo verifica se un numero di telefono è valido. Attualmente il metodo 
     * non è implementato.
     * 
     * @param n Oggetto @c NumeroTelefono da verificare.
     * @return @c true se il numero di telefono è valido, @c false altrimenti.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public boolean checkNumeroTelefono(NumeroTelefono n) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}