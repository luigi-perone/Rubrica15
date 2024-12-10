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
    public Contatto modificaContatto(Contatto c,String cognome,String nome,String descrizione,Email[] email, NumeroTelefono[] num) {
        Contatto c1=new Contatto(nome,cognome,descrizione);
        for(Email e:email){
            int i=0;
            c1.setEmail(e, i);
            i++;
        }
        for(NumeroTelefono n:num){
            int i=0;
            c1.setNumero(n, i);
            i++;
        }
        this.eliminaContatto(c);
        this.aggiungiContatto(c1);
        
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
            if (data.length >= 12) { // Ora controlliamo che ci siano almeno 12 campi (3 prefissi, 3 numeri, 3 email)
                String nome = data[0].trim();
                String cognome = data[1].trim();
                String descrizione = data[2].trim();
                
                // Prefissi, numeri ed email
                String prefisso1 = data[3].trim();
                String numero1 = data[4].trim();
                String email1 = data[5].trim();
                
                String prefisso2 = data[6].trim();
                String numero2 = data[7].trim();
                String email2 = data[8].trim();
                
                String prefisso3 = data[9].trim();
                String numero3 = data[10].trim();
                String email3 = data[11].trim();
                
                // Crea i numeri di telefono con i prefissi e numeri
                NumeroTelefono numeroTelefono1 = new NumeroTelefono(new Prefisso(prefisso1), numero1);
                NumeroTelefono numeroTelefono2 = new NumeroTelefono(new Prefisso(prefisso2), numero2);
                NumeroTelefono numeroTelefono3 = new NumeroTelefono(new Prefisso(prefisso3), numero3);
                
                // Crea l'email
                Email emailObj1 = new Email(email1);
                Email emailObj2 = new Email(email2);
                Email emailObj3 = new Email(email3);
                
                // Crea il contatto e aggiungilo alla rubrica
                Contatto contatto = new Contatto(nome, cognome, descrizione);
                contatto.setNumero(numeroTelefono1, 0);
                contatto.setNumero(numeroTelefono2, 1);
                contatto.setNumero(numeroTelefono3, 2);
                contatto.setEmail(emailObj1, 0);
                contatto.setEmail(emailObj2, 1);
                contatto.setEmail(emailObj3, 2);
                
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
                c.getNome(),
                c.getCognome(),
                c.getDescrizione(),
                nt1.getPrefisso(),
                nt1.getNumero(),
                e1.getEmail(),
                nt2.getPrefisso(),
                nt2.getNumero(),
                e2.getEmail(),
                nt3.getPrefisso(),
                nt3.getNumero(),
                e3.getEmail()));
            writer.newLine();
        }
        System.out.println("Rubrica esportata correttamente in: " + namefile);
    } catch (IOException e) {
        throw new RuntimeException("Errore durante l'esportazione del file: " + e.getMessage());
    }
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

    @Override
    public boolean checkFileFormat(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
