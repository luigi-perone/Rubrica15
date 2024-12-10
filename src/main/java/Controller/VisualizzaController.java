/**
 * @file VisualizzaController.java
 * @brief Controller per la visualizzazione di un contatto.
 * 
 * La classe @c VisualizzaController gestisce la visualizzazione di un contatto nell'applicazione.
 * La vista mostra le informazioni del contatto come nome, cognome, descrizione, numeri di telefono,
 * email e prefissi. Consente anche di modificare o eliminare il contatto tramite i menu appositi.
 * 
 * @package Controller
 * 
 * @author scass
 */
package Controller;

import Main.Main;
import Model.Contatto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

public class VisualizzaController implements Initializable {

    @FXML
    private MenuItem indietro; ///< Menu per tornare indietro alla schermata precedente.
    
    @FXML
    private MenuItem modifica; ///< Menu per modificare il contatto.
    
    @FXML
    private MenuItem elimina; ///< Menu per eliminare il contatto.
    
    @FXML
    private Label nome; ///< Etichetta per visualizzare il nome del contatto.
    
    @FXML
    private Label cognome; ///< Etichetta per visualizzare il cognome del contatto.
    
    @FXML
    private Label descrizione; ///< Etichetta per visualizzare la descrizione del contatto.
    
    @FXML
    private Label tel1; ///< Etichetta per visualizzare il primo numero di telefono.
    
    @FXML
    private Label tel2; ///< Etichetta per visualizzare il secondo numero di telefono.
    
    @FXML
    private Label tel3; ///< Etichetta per visualizzare il terzo numero di telefono.
    
    @FXML
    private Label email1; ///< Etichetta per visualizzare la prima email.
    
    @FXML
    private Label email2; ///< Etichetta per visualizzare la seconda email.
    
    @FXML
    private Label email3; ///< Etichetta per visualizzare la terza email.
    
    @FXML
    private Label pref1; ///< Etichetta per visualizzare il prefisso del primo numero di telefono.
    
    @FXML
    private Label pref2; ///< Etichetta per visualizzare il prefisso del secondo numero di telefono.
    
    @FXML
    private Label pref3; ///< Etichetta per visualizzare il prefisso del terzo numero di telefono.
    
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
            iniziale.setText(contatto.getCognome().substring(0, 1).toUpperCase());
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
        Main.setRoot("homePage");
    }

    /**
     * Gestisce l'azione del menu "Modifica", che permette di modificare il contatto.
     * 
     * @param event L'evento che rappresenta l'azione di modifica del contatto.
     */
    @FXML
    private void modifica_f(ActionEvent event) {
        // TODO: logica per modificare il contatto
        Main.setRoot("modifica");
    }

    /**
     * Gestisce l'azione del menu "Elimina", che permette di eliminare il contatto.
     * 
     * @param event L'evento che rappresenta l'azione di eliminazione del contatto.
     */
    @FXML
    private void elimina_f(ActionEvent event) {
        // TODO: logica per eliminare il contatto
        
        //eliminazione
        Main.r.eliminaContatto(Main.getSelectedItem());
        Main.setRoot("homePage");
    }
}
