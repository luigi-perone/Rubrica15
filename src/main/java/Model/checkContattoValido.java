/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @interface checkContattoValido
 * @brief Interfaccia per verificare la validità di un contatto.
 * 
 * Fornisce il metodo @c checkContattoValido per validare un contatto
 * secondo se contiene almeno nome o cognome e se ogni email e numero di telefono associato è valido.
 */
public interface checkContattoValido {
    
    /**
     * @brief Verifica se il contatto è valido.
     * 
     * Implementazione del metodo definito nell'interfaccia @c checkContattoValido.
     * 
     * @pre Contatto esiste
     * @post verifica se il contatto ha almeno uno tra nome e cognome
     * 
     * Un contatto è considerato valido se ha un nome o un cognome obbligatoriamente,
     * e se ogni email e numero di telefono associato è valido. La lunghezza massima
     * consentita per nome, cognome, descrizione è 100 caratteri.
     */
    boolean contattoValido();
}


