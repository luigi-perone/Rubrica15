/**
 * @file Rubrica.java
 * @brief Classe che rappresenta una rubrica contenente una lista di contatti.
 * 
 * La classe @c Rubrica gestisce un insieme di contatti, permettendo di aggiungere, 
 * eliminare, cercare e modificare contatti. Inoltre, implementa l'interfaccia @c FileManager 
 * per la gestione dei file di importazione ed esportazione della rubrica.
 * Utilizza una struttura dati @c TreeSet per mantenere i contatti in ordine.
 * 
 * @package Model
 */

package Model;

import java.util.TreeSet;

public class Rubrica implements FileManager {

    private TreeSet<Contatto> contatti; ///< Set di contatti memorizzato nella rubrica.

    /**
     * @brief Costruttore della classe @c Rubrica.
     * 
     * Inizializza la rubrica con un @c TreeSet vuoto di contatti.
     */
    public Rubrica() {
        this.contatti = new TreeSet<Contatto>();
    }

    /**
     * @brief Ricerca un contatto nella rubrica in base al cognome e al nome.
     * 
     * Questo metodo cerca un contatto all'interno della rubrica usando il cognome 
     * e il nome come chiavi di ricerca. Il metodo non è ancora implementato.
     * 
     * @param cognome Cognome del contatto da cercare.
     * @param nome Nome del contatto da cercare.
     * @return Un oggetto @c Rubrica contenente il contatto trovato (non implementato).
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    public Rubrica ricercaContatto(String cognome, String nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Elimina un contatto dalla rubrica.
     * 
     * Questo metodo elimina un contatto dalla rubrica. Il metodo non è ancora implementato.
     * 
     * @param c Il contatto da eliminare.
     */
    public void eliminaContatto(Contatto c) {
    }

    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * Questo metodo aggiunge un nuovo contatto alla rubrica. Il metodo non è ancora implementato.
     * 
     * @param c Il contatto da aggiungere.
     */
    public void aggiungiContatto(Contatto c) {
    }

    /**
     * @brief Modifica un contatto esistente nella rubrica.
     * 
     * Questo metodo modifica un contatto già presente nella rubrica. Il metodo non è ancora implementato.
     * 
     * @param c Il contatto da modificare.
     * @return Il contatto modificato (non implementato).
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    public Contatto modificaContatto(Contatto c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Importa una rubrica da un file.
     * 
     * Questo metodo permette di caricare una rubrica da un file specificato dal nome del file.
     * Il metodo non è ancora implementato.
     * 
     * @param namefile Il nome del file da cui importare la rubrica.
     * @return Un oggetto @c Rubrica caricato dal file (non implementato).
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public Rubrica importaFile(String namefile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Esporta la rubrica su un file.
     * 
     * Questo metodo esporta la rubrica in un file con il nome specificato. Il metodo non è ancora implementato.
     * 
     * @param namefile Il nome del file su cui esportare la rubrica.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public void esportaRubrica(String namefile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Verifica la validità del nome del file.
     * 
     * Questo metodo verifica la validità del nome del file (ad esempio, controllando l'estensione o il formato).
     * Il metodo non è ancora implementato.
     * 
     * @param namefile Il nome del file da verificare.
     * @return @c true se il nome del file è valido, @c false altrimenti.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public boolean checkFileName(String namefile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
