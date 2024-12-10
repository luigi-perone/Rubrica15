/**
 * @file ModificaController.java
 * @brief Controller per la schermata di modifica di un contatto.
 * 
 * La classe @c ModificaController gestisce la schermata di modifica di un contatto
 * nell'applicazione. Gestisce l'interazione dell'utente con i campi di testo per modificare
 * il nome, cognome, descrizione, numeri di telefono, email e prefissi di un contatto
 * esistente. La classe implementa l'interfaccia @c Initializable di JavaFX per l'inizializzazione
 * della vista.
 * 
 * @package Controller
 * 
 * @author scass
 */
package Controller;

import Main.Main;
import Model.Contatto;
import Model.Email;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ModificaController implements Initializable {

    @FXML
    private MenuItem indietro; ///< Menu per tornare indietro alla schermata precedente.
    
    @FXML
    private MenuItem salva; ///< Menu per salvare le modifiche al contatto.
    
    @FXML
    private TextField nome; ///< Campo di testo per modificare il nome del contatto.
    
    @FXML
    private TextField cognome; ///< Campo di testo per modificare il cognome del contatto.
    
    @FXML
    private TextField descrizione; ///< Campo di testo per modificare la descrizione del contatto.
    
    @FXML
    private TextField tel1; ///< Campo di testo per modificare il primo numero di telefono.
    
    @FXML
    private TextField tel2; ///< Campo di testo per modificare il secondo numero di telefono.
    
    @FXML
    private TextField tel3; ///< Campo di testo per modificare il terzo numero di telefono.
    
    @FXML
    private TextField email1; ///< Campo di testo per modificare la prima email.
    
    @FXML
    private TextField email2; ///< Campo di testo per modificare la seconda email.
    
    @FXML
    private TextField email3; ///< Campo di testo per modificare la terza email.
    
    @FXML
    private ChoiceBox<?> pref1; ///< Scelta del prefisso per il primo numero di telefono.
    
    @FXML
    private ChoiceBox<?> pref2; ///< Scelta del prefisso per il secondo numero di telefono.
    
    @FXML
    private ChoiceBox<?> pref3; ///< Scelta del prefisso per il terzo numero di telefono.
    
    @FXML
    private Text iniziale; ///< Testo che può essere usato per mostrare informazioni o istruzioni all'utente.

    /**
     * Metodo di inizializzazione chiamato all'avvio della vista.
     * Questo metodo prepara la schermata, configurando i componenti dell'interfaccia utente
     * prima che l'utente possa interagirvi.
     * 
     * @param url URL utilizzato per caricare la vista (non utilizzato in questo caso).
     * @param rb Risorse per il bundle di lingua (non utilizzato in questo caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: aggiungere l'inizializzazione dei componenti, se necessario
        Contatto contatto=Main.getSelectedItem();
        if(contatto!=null){
            iniziale.setText(contatto.getCognome().substring(0, 1));
            nome.setText(contatto.getNome());
            cognome.setText(contatto.getCognome());
            descrizione.setText(contatto.getDescrizione());
        }
    }

    /**
     * Gestisce l'azione del menu "Indietro", che permette di tornare alla schermata precedente.
     * 
     * @param event L'evento che rappresenta l'azione di tornare indietro.
     */
    @FXML
    private void indietro_f(ActionEvent event) {
        // TODO: logica per tornare indietro alla schermata precedente
        Main.setRoot("visualizza");
    }

    /**
     * Gestisce l'azione del menu "Salva", che permette di salvare le modifiche apportate al contatto.
     * 
     * @param event L'evento che rappresenta l'azione di salvataggio.
     */
    @FXML
    private void salva_f(ActionEvent event) {
            // Ottieni il contatto attualmente selezionato
    Contatto c=new Contatto(nome.getText(),cognome.getText(),descrizione.getText());
    Contatto contattoSelezionato = Main.getSelectedItem();
    
    Main.r.eliminaContatto(contattoSelezionato);
    Main.r.aggiungiContatto(c);
        Main.setRoot("homePage");
   
    }
}
