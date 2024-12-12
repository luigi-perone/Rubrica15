/**
 * @file Rubrica.java
 * @brief Classe che rappresenta una rubrica contenente una lista di contatti.
 * 
 * La classe @c Rubrica gestisce un insieme di contatti, permettendo di aggiungere, 
 * eliminare, cercare e modificare contatti. Inoltre, implementa l'interfaccia @c FileManager 
 * per la gestione dei file di importazione ed esportazione della rubrica.
 * Utilizza una struttura dati @c TreeSet per mantenere i contatti in ordine.
 * 
 * @author gruppo15
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
     * @brief Elimina un contatto dalla rubrica.
     * 
     * Questo metodo elimina un contatto dalla rubrica.
     * 
     * @pre Il contatto selezionato esiste.
     * @post La rubrica è aggiornata, senza il contatto scelto.
     * 
     * @param[in] c Il contatto da eliminare.
     */
    public void eliminaContatto(Contatto c) {
        contatti.remove(c);
    }

    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * Questo metodo aggiunge un nuovo contatto alla rubrica.
     * 
     * @pre Il contatto esiste ed è valido.
     * @post La rubrica è aggiornata con il nuovo contatto.
     * 
     * @param[in] c Il contatto da aggiungere.
     */
    public void aggiungiContatto(Contatto c) {
        contatti.add(c);
    }

    /**
     * @brief Modifica un contatto esistente nella rubrica.
     * 
     * Questo metodo modifica un contatto già presente nella rubrica.
     * 
     * @pre Il contatto esiste, con modifiche valide.
     * @post I dati del contatto sono modificati.
     * 
     * @param[in] c Il contatto da modificare.
     * @param[in] cognome Il nuovo cognome del contatto.
     * @param[in] nome Il nuovo nome del contatto.
     * @param[in] descrizione La nuova descrizione del contatto.
     * @param[in] email Un array di email da associare al contatto.
     * @param[in] num Un array di numeri di telefono da associare al contatto.
     * @return Il contatto modificato.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    public Contatto modificaContatto(Contatto c, String cognome, String nome, String descrizione, Email[] email, NumeroTelefono[] num) {
        Contatto c1 = new Contatto(nome, cognome, descrizione);
        int i = 0;
        for (Email e : email) {
            if(e != null)
            c1.setEmail(e, i);
            i++;
        }
        i = 0;
        for (NumeroTelefono n : num) {
            if(n != null)
            c1.setNumero(n, i);
            i++;
        }
        this.eliminaContatto(c);
        this.aggiungiContatto(c1);
        
        return c1;
    }
    /**
     * @brief Importa una rubrica da un file.
     * 
     * Questo metodo permette di caricare una rubrica da un file specificato dal nome del file.
     * 
     * @pre Il nome del file esiste.
     * @post La rubrica è caricata con i contatti provenienti dal file.
     * 
     * @param[in] namefile Il nome del file da cui importare la rubrica.
     * @return Un oggetto @c Rubrica caricato dal file.
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

            // Estrai i campi con valori predefiniti per i mancanti
            String nome = data.length > 0 ? data[0].trim() : "";
            String cognome = data.length > 1 ? data[1].trim() : "";
            String descrizione = data.length > 2 ? data[2].trim() : "";

            String prefisso1 = data.length > 3 ? data[3].trim() : "";
            String numero1 = data.length > 4 ? data[4].trim() : "";
            String email1 = data.length > 5 ? data[5].trim() : "";

            String prefisso2 = data.length > 6 ? data[6].trim() : "";
            String numero2 = data.length > 7 ? data[7].trim() : "";
            String email2 = data.length > 8 ? data[8].trim() : "";

            String prefisso3 = data.length > 9 ? data[9].trim() : "";
            String numero3 = data.length > 10 ? data[10].trim() : "";
            String email3 = data.length > 11 ? data[11].trim() : "";

            // Crea i numeri di telefono con i prefissi e numeri
            NumeroTelefono numeroTelefono1 = (!prefisso1.isEmpty() && !numero1.isEmpty())
                ? new NumeroTelefono(new Prefisso(prefisso1), numero1)
                : null;
            NumeroTelefono numeroTelefono2 = (!prefisso2.isEmpty() && !numero2.isEmpty())
                ? new NumeroTelefono(new Prefisso(prefisso2), numero2)
                : null;
            NumeroTelefono numeroTelefono3 = (!prefisso3.isEmpty() && !numero3.isEmpty())
                ? new NumeroTelefono(new Prefisso(prefisso3), numero3)
                : null;

            // Crea le email
            Email emailObj1 = !email1.isEmpty() ? new Email(email1) : null;
            Email emailObj2 = !email2.isEmpty() ? new Email(email2) : null;
            Email emailObj3 = !email3.isEmpty() ? new Email(email3) : null;

            // Verifica che almeno il campo Nome sia presente
            if (!(nome.isEmpty()&&cognome.isEmpty())) {
                // Crea il contatto
                Contatto contatto = new Contatto(nome, cognome, descrizione);

                // Assegna i numeri di telefono e le email
                if (numeroTelefono1 != null) contatto.setNumero(numeroTelefono1, 0);
                if (numeroTelefono2 != null) contatto.setNumero(numeroTelefono2, 1);
                if (numeroTelefono3 != null) contatto.setNumero(numeroTelefono3, 2);

                if (emailObj1 != null) contatto.setEmail(emailObj1, 0);
                if (emailObj2 != null) contatto.setEmail(emailObj2, 1);
                if (emailObj3 != null) contatto.setEmail(emailObj3, 2);

                // Aggiungi il contatto alla rubrica
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
     * Questo metodo esporta la rubrica in un file con il nome specificato.
     * 
     * @pre La rubrica esiste.
     * @post Il file specificato contiene la rubrica esportata.
     * 
     * @param[in] namefile Il nome del file su cui esportare la rubrica.
     * @throws UnsupportedOperationException Eccezione lanciata poiché il metodo non è ancora implementato.
     */
    @Override
    public void esportaRubrica(String namefile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namefile))) {
            // Scrivi l'intestazione del file CSV
            writer.write("Nome,Cognome,Indirizzo,Prefisso1,Numero1,Email1,Prefisso2,Numero2,Email2,Prefisso3,Numero3,Email3");
            writer.newLine();

            // Scrivi ogni contatto nel file
            for (Contatto c : contatti) {
                // Estrai i numeri, prefissi e email
                NumeroTelefono nt1 = c.getNumero(0);
                NumeroTelefono nt2 = c.getNumero(1);
                NumeroTelefono nt3 = c.getNumero(2);
                
                Email e1 = c.getEmail(0);
                Email e2 = c.getEmail(1);
                Email e3 = c.getEmail(2);
                // Scrivi i dettagli del contatto nel formato CSV
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                c.getNome() != null ? c.getNome() : "",
                c.getCognome() != null ? c.getCognome() : "",
                c.getDescrizione() != null ? c.getDescrizione() : "",
                nt1 != null && nt1.getPrefisso() != null ? nt1.getPrefisso().getValore() : "",
                nt1 != null ? nt1.getNumero() : "",
                e1 != null ? e1.getEmail() : "",
                nt2 != null && nt2.getPrefisso() != null ? nt2.getPrefisso().getValore() : "",
                nt2 != null ? nt2.getNumero() : "",
                e2 != null ? e2.getEmail() : "",
                nt3 != null && nt3.getPrefisso() != null ? nt3.getPrefisso().getValore() : "",
                nt3 != null ? nt3.getNumero() : "",
                e3 != null ? e3.getEmail() : ""
                ));
                writer.newLine();

            }
            System.out.println("Rubrica esportata correttamente in: " + namefile);
        } catch (IOException e) {
            throw new RuntimeException("Errore durante l'esportazione del file: " + e.getMessage());
        }
    }

    /**
     * @brief Restituisce una rappresentazione in formato stringa della rubrica.
     * 
     * Questo metodo restituisce una rappresentazione stringa della rubrica, 
     * concatenando tutte le informazioni sui contatti.
     * 
     * @return La rappresentazione della rubrica come stringa.
     */
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (Contatto c : contatti)
            s = s.append(c.toString()).append("\n");
        return s.toString();
    }

    /**
     * @brief Restituisce l'insieme di contatti contenuto nella rubrica.
     * 
     * Questo metodo restituisce la struttura dati che contiene tutti i contatti 
     * della rubrica.
     * 
     * @return Il set di contatti nella rubrica.
     */
    public TreeSet<Contatto> getTree() {
        return contatti;
    }
}