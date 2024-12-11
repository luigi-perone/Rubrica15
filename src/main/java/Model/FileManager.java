/**
 * @file FileManager.java
 * @brief Interfaccia per la gestione dei file relativi alla rubrica.
 * 
 * Questa interfaccia definisce i metodi per importare ed esportare file contenenti
 * i dati di una rubrica. Include anche un metodo per verificare il nome di un file.
 * 
 * @author gruppo15
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
     * @pre Il nome del file inserito deve essere associato a un file esistente.
     * @post Restituisce un oggetto @c Rubrica contenente l'insieme dei contatti presenti nel file.
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
     * @pre La rubrica deve esistere e contenere dei dati.
     * @post Il file specificato dal parametro @c namefile contiene la rubrica.
     * 
     * @param[in] namefile Il nome del file su cui esportare la rubrica.
     */
    public void esportaRubrica(String namefile);
}
