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
import Model.NumeroTelefono;
import Model.Prefisso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ModificaController implements Initializable {

    @FXML
    private Button indietro; ///< Menu per tornare indietro alla schermata precedente.
    
    @FXML
    private Button salva; ///< Menu per salvare le modifiche al contatto.
    
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
    private ChoiceBox<String> pref1; ///< Scelta del prefisso per il primo numero di telefono.
    
    @FXML
    private ChoiceBox<String> pref2; ///< Scelta del prefisso per il secondo numero di telefono.
    
    @FXML
    private ChoiceBox<String> pref3; ///< Scelta del prefisso per il terzo numero di telefono.
    
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
        // Aggiungi i prefissi comuni
        pref1.getItems().addAll(
            "+39",  // Italia
            "+1",   // Stati Uniti
            "+44",  // Regno Unito
            "+33",  // Francia
            "+49",  // Germania
            "+34",  // Spagna
            "+55",  // Brasile
            "+91",  // India
            "+81",  // Giappone
            "+61",  // Australia
            "+7",   // Russia
            "+52"   // Messico
        );

        // Imposta un valore di default
        pref1.setValue("+39");
        pref2.getItems().addAll(
            "+39",  // Italia
            "+1",   // Stati Uniti
            "+44",  // Regno Unito
            "+33",  // Francia
            "+49",  // Germania
            "+34",  // Spagna
            "+55",  // Brasile
            "+91",  // India
            "+81",  // Giappone
            "+61",  // Australia
            "+7",   // Russia
            "+52"   // Messico
        );

        // Imposta un valore di default
        pref2.setValue("+39");
        pref3.getItems().addAll(
            "+39",  // Italia
            "+1",   // Stati Uniti
            "+44",  // Regno Unito
            "+33",  // Francia
            "+49",  // Germania
            "+34",  // Spagna
            "+55",  // Brasile
            "+91",  // India
            "+81",  // Giappone
            "+61",  // Australia
            "+7",   // Russia
            "+52"   // Messico
        );

        // Imposta un valore di default
        pref3.setValue("+39");
        Contatto contatto=Main.getSelectedItem();
        if(contatto!=null){
            iniziale.setText(contatto.getCognome().substring(0, 1));
            nome.setText(contatto.getNome());
            cognome.setText(contatto.getCognome());
            descrizione.setText(contatto.getDescrizione());
            if(contatto.getEmail(0)!=null&&contatto.getEmail(0).checkEmail())
                email1.setText(contatto.getEmail(0).getEmail());
            if(contatto.getEmail(1)!=null&&contatto.getEmail(1).checkEmail())
                email2.setText(contatto.getEmail(1).getEmail());
            if(contatto.getEmail(2)!=null&&contatto.getEmail(2).checkEmail())
                email3.setText(contatto.getEmail(2).getEmail());
            if(contatto.getNumero(0)!=null&&contatto.getNumero(0).checkNumeroTelefono()){
                tel1.setText(contatto.getNumero(0).getNumero());
                pref1.setValue(contatto.getNumero(0).getPrefisso().toString());
            }
            if(contatto.getNumero(1)!=null&&contatto.getNumero(1).checkNumeroTelefono()){
                tel2.setText(contatto.getNumero(1).getNumero());
                pref2.setValue(contatto.getNumero(1).getPrefisso().toString());
            }
            if(contatto.getNumero(2)!=null&&contatto.getNumero(2).checkNumeroTelefono()){
                tel3.setText(contatto.getNumero(2).getNumero());
                pref3.setValue(contatto.getNumero(2).getPrefisso().toString());
            }   
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
        Contatto contatto=Main.getSelectedItem();
        Email[] e=new Email[3];
        NumeroTelefono[] num=new NumeroTelefono[3];
        
        e[0]=new Email(email1.getText());
        e[1]=new Email(email2.getText());
        e[2]=new Email(email3.getText());
        
        num[0]=new NumeroTelefono(new Prefisso(pref1.getValue().substring(1)),tel1.getText());
        num[1]=new NumeroTelefono(new Prefisso(pref2.getValue().substring(1)),tel2.getText());
        num[2]=new NumeroTelefono(new Prefisso(pref3.getValue().substring(1)),tel3.getText());
        
        Main.r.modificaContatto(contatto, cognome.getText(), nome.getText(),descrizione.getText(),e,num );
        Main.setRoot("homePage");
   
    }
}
