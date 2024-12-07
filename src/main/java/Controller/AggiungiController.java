/**
 * @file AggiungiController.java
 * @brief Controller per la schermata di aggiunta di un contatto.
 * 
 * Questa classe funge da controller per la schermata di aggiunta di un nuovo contatto nell'applicazione.
 * Gestisce gli eventi di interazione con la UI, come l'aggiunta di numeri di telefono, email e la
 * gestione di opzioni relative ai prefissi telefonici. Include anche azioni per salvare e navigare indietro.
 * 
 * La classe implementa l'interfaccia @c Initializable di JavaFX per inizializzare la vista quando la schermata
 * viene caricata.
 * 
 * @package Controller
 * 
 * @author scass
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AggiungiController implements Initializable {

    @FXML
    private Menu indietro; ///< Menu per il ritorno alla schermata precedente.
    
    @FXML
    private Menu salva; ///< Menu per il salvataggio del contatto.
    
    @FXML
    private TextField nome; ///< Campo di testo per il nome del contatto.
    
    @FXML
    private TextField cognome; ///< Campo di testo per il cognome del contatto.
    
    @FXML
    private TextField descrizione; ///< Campo di testo per la descrizione del contatto.
    
    @FXML
    private TextField tel1; ///< Campo di testo per il primo numero di telefono.
    
    @FXML
    private TextField tel2; ///< Campo di testo per il secondo numero di telefono.
    
    @FXML
    private TextField tel3; ///< Campo di testo per il terzo numero di telefono.
    
    @FXML
    private TextField email1; ///< Campo di testo per la prima email.
    
    @FXML
    private TextField email2; ///< Campo di testo per la seconda email.
    
    @FXML
    private TextField email3; ///< Campo di testo per la terza email.
    
    @FXML
    private ChoiceBox<?> pref1; ///< Scelta per il prefisso del primo numero di telefono.
    
    @FXML
    private ChoiceBox<?> pref2; ///< Scelta per il prefisso del secondo numero di telefono.
    
    @FXML
    private ChoiceBox<?> pref3; ///< Scelta per il prefisso del terzo numero di telefono.
    
    @FXML
    private Text iniziale; ///< Testo per visualizzare eventuali messaggi iniziali.

    /**
     * Metodo di inizializzazione chiamato all'avvio della vista.
     * Questo metodo prepara la schermata, ad esempio, impostando valori iniziali
     * o configurando i componenti dell'interfaccia utente.
     * 
     * 
     * @param[in] url URL utilizzato per caricare la vista (non utilizzato in questo caso).
     * @param[in] rb Risorse per il bundle di lingua (non utilizzato in questo caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: aggiungere l'inizializzazione dei componenti, se necessario
    }

    /**
     * Gestisce l'azione del pulsante "Indietro", che permette di tornare alla schermata precedente.
     * 
     * 
     * @param event L'evento che rappresenta il clic sul pulsante "Indietro".
     */
    @FXML
    private void indietro_f(ActionEvent event) {
        // TODO: logica per tornare indietro alla schermata precedente
    }

    /**
     * Gestisce l'azione del pulsante "Salva", che permette di salvare le informazioni inserite.
     * 
     * @param event L'evento che rappresenta il clic sul pulsante "Salva".
     */
    @FXML
    private void salva_f(ActionEvent event) {
        // TODO: logica per salvare il contatto
    }
}
