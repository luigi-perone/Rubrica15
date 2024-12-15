/**
 * @file NumeroTelefono.java
 * @brief Classe che rappresenta un numero di telefono associato a un prefisso.
 * 
 * La classe @c NumeroTelefono modella un numero di telefono completo di prefisso. 
 * Include metodi per ottenere e impostare il prefisso e il numero, e una rappresentazione 
 * in formato stringa del numero di telefono.
 * 
 * @author gruppo15
 * @package Model
 */

package Model;
/**
 * @brief Modella un numero di telefono completo di prefisso
 */
public class NumeroTelefono implements CheckNumeroTelefono {

    private Prefisso prefisso; ///< Prefisso associato al numero di telefono.
    private String numero; ///< Numero di telefono.

    /**
     * @brief Costruttore della classe @c NumeroTelefono.
     * 
     * Inizializza un oggetto @c NumeroTelefono con il prefisso e il numero specificati.
     * 
     * @pre I valori passati devono essere diversi da null.
     * @post Oggetto creato con gli attributi inizializzati ai valori passati.
     * 
     * @param[in] prefisso Prefisso associato al numero di telefono.
     * @param[in] numero Numero di telefono da associare al prefisso.
     */
    public NumeroTelefono(Prefisso prefisso, String numero) {
        assert(prefisso != null);
        assert(numero != null);
        this.prefisso = prefisso;
        this.numero = numero;

    }
    
    /**
     * @brief Restituisce il prefisso associato al numero di telefono.
     * 
     * Questo metodo restituisce il prefisso dell'oggetto @c NumeroTelefono.
     * 
     * @post Restituisce il contenuto dell'attributo prefisso.
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
     * @pre Il valore passato deve essere diverso da null.
     * @post Il prefisso è aggiornato con il valore passato.
     * 
     * @param[in] prefisso Il nuovo prefisso da associare al numero di telefono.
     */
    public void setPrefisso(Prefisso prefisso) {
        assert(prefisso != null);
        this.prefisso = prefisso;
    }

    /**
     * @brief Restituisce il numero di telefono.
     * 
     * Questo metodo restituisce il numero di telefono dell'oggetto @c NumeroTelefono.
     * 
     * @post Restituisce il contenuto dell'attributo numero.
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
     * @pre Il valore passato deve essere diverso da null.
     * @post Il numero è aggiornato con il valore passato.
     * 
     * @param[in] numero Il nuovo numero di telefono da impostare.
     */
    public void setNumero(String numero) {
        assert(numero != null);
        this.numero = numero;

    }

    /**
     * @brief Restituisce una rappresentazione in formato stringa del numero di telefono.
     * 
     * Questo metodo restituisce il numero di telefono completo di prefisso in formato 
     * stringa, ad esempio "+39 123456789".
     * 
     * @pre L'oggetto NumeroTelefono deve esistere.
     * 
     * @return La rappresentazione del numero di telefono come stringa.
     */
    @Override
    public String toString(){
        assert(this != null);
        return prefisso.toString() + " " + numero;
    }

    /**
     * @brief Verifica la validità di un numero di telefono.
     * 
     * Questo metodo verifica se un numero di telefono è valido. La validità dipende 
     * dal fatto che il numero contenga solo cifre e segua il formato corretto.
     * 
     * @post Verifica se il numero è valido in base alla lunghezza e al formato.
     * 
     * @param[in] n Oggetto @c NumeroTelefono da verificare.
     * @return @c true se il numero di telefono è valido, @c false altrimenti.
     * @throws UnsupportedOperationException Se il metodo non è ancora implementato.
     */
    @Override
    public boolean checkNumeroTelefono() {
        if (this.getPrefisso() == null||this.getNumero().length() == 0||this.getPrefisso().getValore().length() == 0) {
            return false; // I suoi attributi non devono essere null o vuoti.
        }
        
        String numero = this.getNumero();

        // Controlla che il numero contenga solo cifre, spazi o trattini opzionali.
        if (!numero.matches("[0-9\\- ]+")) {
            return false;
        }

        // Rimuove spazi e trattini per verificare la lunghezza effettiva.
        String numeroPulito = numero.replaceAll("[\\- ]", "");

        // Controlla che la lunghezza del numero sia corretta per il prefisso.
        if (numeroPulito.length() != prefisso.getLunghezzaNumero()) {
            return false;
        }

        return true; // Tutti i controlli superati, il numero è valido.
    }
}

