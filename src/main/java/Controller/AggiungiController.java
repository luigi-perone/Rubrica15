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

import Main.Main;
import Model.Contatto;
import Model.Email;
import Model.NumeroTelefono;
import Model.Prefisso;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AggiungiController implements Initializable {

    @FXML
    private Button indietro; ///< Menu per il ritorno alla schermata precedente.
    
    @FXML
    private Button salva; ///< Menu per il salvataggio del contatto.
    
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
    private ChoiceBox<String> pref1; ///< Scelta per il prefisso del primo numero di telefono.
    
    @FXML
    private ChoiceBox<String> pref2; ///< Scelta per il prefisso del secondo numero di telefono.
    
    @FXML
    private ChoiceBox<String> pref3; ///< Scelta per il prefisso del terzo numero di telefono.
    
    @FXML
    private Text iniziale; ///< Testo per visualizzare eventuali messaggi iniziali.
    
    @FXML
    private MenuBar menuBar;

    // Regex patterns for validation
    private static final Pattern NOME_PATTERN = Pattern.compile("^[\\p{L}\\s'-]+$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("^\\d+$");

    /**
     * Metodo di inizializzazione chiamato all'avvio della vista.
     * Questo metodo prepara la schermata, impostando valori iniziali
     * e configurando i componenti dell'interfaccia utente.
     * 
     * @param[in] url URL utilizzato per caricare la vista (non utilizzato in questo caso).
     * @param[in] rb Risorse per il bundle di lingua (non utilizzato in questo caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Impostazione dei prefissi telefonici
        String[] prefissi = {"+39", "+1", "+44", "+33", "+49", "+34"};
        for (ChoiceBox<String> pref : new ChoiceBox[]{pref1, pref2, pref3}) {
            pref.getItems().addAll(prefissi);
            pref.setValue("+39");
        }
        
        // Aggiungi listener per la validazione dei campi
        addValidationListeners();
    }

    /**
     * Aggiunge listener per la validazione dei campi di input.
     */
    private void addValidationListeners() {
        // Validazione nome e cognome (campi obbligatori)
        nome.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(nome, newValue, NOME_PATTERN, 100, true);
        });
        
        cognome.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(cognome, newValue, NOME_PATTERN, 100, true);
        });
        
        // Validazione descrizione
        descrizione.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(descrizione, newValue, null, 100, false);
        });
        
        // Validazione email
        email1.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(email1, newValue, EMAIL_PATTERN, 100, false);
        });
        
        email2.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(email2, newValue, EMAIL_PATTERN, 100, false);
        });
        
        email3.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(email3, newValue, EMAIL_PATTERN, 100, false);
        });
        
        // Validazione numeri di telefono
        tel1.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(tel1, newValue, TELEFONO_PATTERN, 100, false);
        });
        
        tel2.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(tel2, newValue, TELEFONO_PATTERN, 100, false);
        });
        
        tel3.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(tel3, newValue, TELEFONO_PATTERN, 100, false);
        });
    }

    /**
     * Convalida un campo di testo con criteri specifici.
     * 
     * @param textField Il campo di testo da convalidare
     * @param newValue Il nuovo valore del campo
     * @param pattern Il pattern regex per la convalida (può essere null)
     * @param maxLength La lunghezza massima consentita
     * @param isRequired Indica se il campo è obbligatorio
     */
    private void validateTextField(TextField textField, String newValue, 
                                    Pattern pattern, int maxLength, boolean isRequired) {
        // Tronca il testo se supera la lunghezza massima
        if (newValue.length() > maxLength) {
            textField.setText(newValue.substring(0, maxLength));
            return;
        }
        
        // Controllo obbligatorietà
        if (isRequired && (newValue == null || newValue.trim().isEmpty())) {
            textField.setStyle("-fx-border-color: red;");
            return;
        }
        
        // Convalida con pattern se presente
        if (pattern != null && !newValue.isEmpty()) {
            if (!pattern.matcher(newValue).matches()) {
                textField.setStyle("-fx-border-color: red;");
                return;
            }
        }
        
        // Ripristina lo stile se la validazione è passata
        textField.setStyle("");
    }

    /**
     * Gestisce l'azione del pulsante "Indietro", che permette di tornare alla schermata precedente.
     * 
     * @param event L'evento che rappresenta il clic sul pulsante "Indietro".
     */
    @FXML
    private void indietro_f(ActionEvent event) {
        Main.setRoot("homePage");
    }

    /**
     * Gestisce l'azione del pulsante "Salva", che permette di salvare le informazioni inserite.
     * 
     * @param event L'evento che rappresenta il clic sul pulsante "Salva".
     */
    @FXML
    private void salva_f(ActionEvent event) {
        // Validazione finale prima del salvataggio
        if (!validateFinalInput()) {
            showValidationAlert();
            return;
        }
        
        // Creazione del contatto
        Contatto c = new Contatto(nome.getText().trim(), cognome.getText().trim(), 
                                  descrizione.getText().trim());
        
        // Impostazione email
        c.setEmail(new Email(email1.getText().trim()), 0);
        c.setEmail(new Email(email2.getText().trim()), 1);
        c.setEmail(new Email(email3.getText().trim()), 2);
        
        // Impostazione numeri di telefono
        c.setNumero(new NumeroTelefono(new Prefisso(pref1.getValue().substring(1)), tel1.getText().trim()), 0);
        c.setNumero(new NumeroTelefono(new Prefisso(pref2.getValue().substring(1)), tel2.getText().trim()), 1);
        c.setNumero(new NumeroTelefono(new Prefisso(pref3.getValue().substring(1)), tel3.getText().trim()), 2);

        // Salvataggio del contatto
        Main.r.aggiungiContatto(c);
        Main.setRoot("homePage");
    }

    /**
     * Esegue una validazione finale prima del salvataggio.
     * 
     * @return true se tutti i campi sono validi, false altrimenti
     */
    private boolean validateFinalInput() {
        // Controllo campi obbligatori
        if (nome.getText().trim().isEmpty() || cognome.getText().trim().isEmpty()) {
            return false;
        }
        
        // Controllo lunghezza e formato per tutti i campi
        return 
            isValidInput(nome, NOME_PATTERN, true) &&
            isValidInput(cognome, NOME_PATTERN, true) &&
            isValidInput(descrizione, null, false) &&
            isValidInput(email1, EMAIL_PATTERN, false) &&
            isValidInput(email2, EMAIL_PATTERN, false) &&
            isValidInput(email3, EMAIL_PATTERN, false) &&
            isValidInput(tel1, TELEFONO_PATTERN, false) &&
            isValidInput(tel2, TELEFONO_PATTERN, false) &&
            isValidInput(tel3, TELEFONO_PATTERN, false);
    }

    /**
     * Convalida un singolo campo di input.
     * 
     * @param textField Il campo di testo da convalidare
     * @param pattern Il pattern regex per la convalida (può essere null)
     * @param isRequired Indica se il campo è obbligatorio
     * @return true se il campo è valido, false altrimenti
     */
    private boolean isValidInput(TextField textField, Pattern pattern, boolean isRequired) {
        String value = textField.getText().trim();
        
        // Controllo lunghezza massima
        if (value.length() > 100) {
            return false;
        }
        
        // Controllo obbligatorietà
        if (isRequired && value.isEmpty()) {
            return false;
        }
        
        // Convalida con pattern se presente e non vuoto
        if (pattern != null && !value.isEmpty()) {
            return pattern.matcher(value).matches();
        }
        
        return true;
    }

    /**
     * Mostra un alert di validazione in caso di input non valido.
     */
    private void showValidationAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore di Validazione");
        alert.setHeaderText("Campi non validi");
        alert.setContentText("Assicurati di aver compilato correttamente nome e cognome. " +
                             "Controlla che i campi rispettino i formati richiesti e non superino 100 caratteri.");
        alert.showAndWait();
    }
}