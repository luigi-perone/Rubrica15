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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
     *
     * @post Ritorna una Rubrica contenente l'insieme di contatti con cognome e nome inseriti
     * 
     * @param[in] cognome Cognome del contatto da cercare.
     * @param[in] nome Nome del contatto da cercare.
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
     *@pre Il contatto selezionato esiste
     *@post Rubrica aggiornata, senza il contatto scelto
     * 
     * @param[in] c Il contatto da eliminare.
     */
    public void eliminaContatto(Contatto c) {
        contatti.remove(c);
    }

    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * Questo metodo aggiunge un nuovo contatto alla rubrica. Il metodo non è ancora implementato.
     * 
     * @pre Contatto esiste ed è valido
     * @post Rubrica aggiornata con il nuovo contatto
     * 
     * @param[in] c Il contatto da aggiungere.
     */
    public void aggiungiContatto(Contatto c) {
        contatti.add(c);
    }

    /**
     * @brief Modifica un contatto esistente nella rubrica.
     * 
     * Questo metodo modifica un contatto già presente nella rubrica. Il metodo non è ancora implementato.
     * 
     * @pre Il contatto esiste, con modifiche valide
     * @post I dati del contatto sono modificati
     * 
     * @param[in] c Il contatto da modificare.
     * @return Il contatto modificato (non implementato).
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    public Contatto modificaContatto(Contatto c,String cognome,String nome,String descrizione) {
        Contatto c1=new Contatto(nome,cognome,descrizione);
        
        contatti.remove(c);
        contatti.add(c1);
        
        return c;
    }

    /**
     * @brief Importa una rubrica da un file.
     * 
     * Questo metodo permette di caricare una rubrica da un file specificato dal nome del file.
     * Il metodo non è ancora implementato.
     * 
     * @pre Il nome del file esiste
     * @post La rubrica è caricata con i contatti provenienti dal file
     * 
     * @param[in] namefile Il nome del file da cui importare la rubrica.
     * @return Un oggetto @c Rubrica caricato dal file (non implementato).
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public Rubrica importaFile(String namefile) {
    Rubrica rubrica = new Rubrica();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(namefile))) {
        String line;
        // Salta la prima riga (intestazione del CSV)
        reader.readLine();
        
        while ((line = reader.readLine()) != null) {
            // Split della riga usando la virgola come separatore
            String[] data = line.split(",");
            
            // Assicurati che ci siano abbastanza campi nella riga
            if (data.length >= 6) {
                String nome = data[0].trim();
                String cognome = data[1].trim();
                String descrizione = data[2].trim();
                String prefisso = data[3].trim();
                String numero = data[4].trim();
                String email = data[5].trim();
                
                // Crea il NumeroTelefono con prefisso e numero
                NumeroTelefono numeroTelefono = new NumeroTelefono(new Prefisso(prefisso), numero);
                
                // Crea il contatto e aggiungilo alla rubrica
                Contatto contatto = new Contatto(nome, cognome, descrizione);
                contatto.setNumero(numeroTelefono,0);
                contatto.setEmail(new Email(email), 0);
                rubrica.aggiungiContatto(contatto);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return rubrica;
    }

    /**
     * @brief Esporta la rubrica su un file.
     * 
     * Questo metodo esporta la rubrica in un file con il nome specificato. Il metodo non è ancora implementato.
     * 
     * @pre Rubrica esiste
     * @post il file che faceva riferimento il namefile contiene la rubrica
     * 
     * @param[in] namefile Il nome del file su cui esportare la rubrica.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public void esportaRubrica(String namefile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namefile))) {
        // Scrivi l'intestazione del file CSV
        writer.write("Nome,Cognome,Indirizzo,Prefisso,Numero,Email");
        writer.newLine();

        // Scrivi ogni contatto nel file
        for (Contatto c : contatti) {
            NumeroTelefono nt = c.getNumero(0);
            writer.write(String.format("%s,%s,%s,%s,%s,%s",
                c.getNome(),
                c.getCognome(),
                c.getDescrizione(),
                nt.getPrefisso(),
                nt.getNumero(),
                c.getEmail(0).getEmail()));
            writer.newLine();
        }
        System.out.println("Rubrica esportata correttamente in: " + namefile);
    } catch (IOException e) {
        throw new RuntimeException("Errore durante l'esportazione del file: " + e.getMessage());
    }
    }

    /**
     * @brief Verifica la validità del nome del file.
     * 
     * Questo metodo verifica la validità del nome del file (ad esempio, controllando l'estensione o il formato).
     * Il metodo non è ancora implementato.
     * @pre file esiste
     * @post verifica nome file
     * @param[in] namefile Il nome del file da verificare.
     * @return @c true se il nome del file è valido, @c false altrimenti.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public boolean checkFileName(String namefile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        String s=new String();
        for(Contatto c:contatti)
            s=s+c.toString();
        return s;
    }
    
    public TreeSet<Contatto> getTree(){
        return contatti;
    }
    
}
