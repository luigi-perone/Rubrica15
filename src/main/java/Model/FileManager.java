/**
 * @file FileManager.java
 * @brief Interfaccia per la gestione dei file relativi alla rubrica.
 * 
 * Questa interfaccia definisce i metodi per importare ed esportare file contenenti
 * i dati di una rubrica. Include anche un metodo per verificare il nome di un file.
 * 
 * @package Model
 */

package Model;

/**
 * @interface FileManager
 * @brief Interfaccia per la gestione dei file della rubrica.
 * 
 * Fornisce metodi per importare una rubrica da un file, esportare una rubrica su un file 
 * e verificare la validità del nome del file.
 */
public interface FileManager {

    /**
     * @brief Importa una rubrica da un file.
     * 
     * Questo metodo permette di caricare una rubrica da un file specificato dal 
     * nome del file.
     * 
     * @param namefile Il nome del file da cui importare la rubrica.
     * @return Oggetto @c Rubrica caricato dal file.
     */
    public Rubrica importaFile(String namefile);

    /**
     * @brief Esporta la rubrica su un file.
     * 
     * Questo metodo esporta i dati della rubrica in un file con il nome specificato.
     * 
     * @param namefile Il nome del file su cui esportare la rubrica.
     */
    public void esportaRubrica(String namefile);

    /**
     * @brief Verifica la validità del nome di un file.
     * 
     * Questo metodo verifica se il nome del file è valido, ad esempio controllando
     * l'estensione o il formato.
     * 
     * @param namefile Il nome del file da verificare.
     * @return @c true se il nome del file è valido, @c false altrimenti.
     */
    public boolean checkFileName(String namefile);
}

