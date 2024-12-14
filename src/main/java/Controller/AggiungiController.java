/**
 * @file AggiungiController.java
 * @brief Controller per la schermata di aggiunta di un contatto.
 * 
 * Questa classe gestisce l'interfaccia grafica e le funzionalità associate
 * alla schermata di aggiunta di un nuovo contatto nell'applicazione.
 * Gestisce eventi, validazioni e salvataggio dei dati inseriti.
 * 
 * @package Controller
 * 
 * @author gruppo15
 */
package Controller;

import Main.Main;
import Model.Contatto;
import Model.Email;
import Model.NumeroTelefono;
import Model.Prefisso;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @class AggiungiController
 * @brief Controller per gestire la schermata di aggiunta di contatti.
 *
 * Questa classe rappresenta il controller della schermata di aggiunta di contatti
 * nell'applicazione. Si occupa di:
 * - Inizializzare i componenti dell'interfaccia utente.
 * - Validare i dati inseriti dall'utente.
 * - Creare e salvare il contatto nella struttura dati.
 * 
 * La classe utilizza il pattern MVC e comunica con il modello per salvare i contatti.
 */

public class AggiungiController implements Initializable {

    @FXML
    private Button indietro; ///< Pulsante per tornare alla schermata precedente.

    @FXML
    private Button salva; ///< Pulsante per salvare il contatto inserito.

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
    private ChoiceBox<String> pref1; ///< ChoiceBox per selezionare il prefisso del primo numero.

    @FXML
    private ChoiceBox<String> pref2; ///< ChoiceBox per selezionare il prefisso del secondo numero.

    @FXML
    private ChoiceBox<String> pref3; ///< ChoiceBox per selezionare il prefisso del terzo numero.

    @FXML
    private Text iniziale; ///< Testo per visualizzare eventuali messaggi iniziali.


    private static final Pattern NOME_PATTERN = Pattern.compile("^[\\p{L}\\s'-]+$"); ///< Pattern regex per il nome.
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})*$");
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("^\\d+$"); ///< Pattern regex per il numero di telefono.

    /**
     * @brief Inizializza la vista impostando i valori iniziali dei componenti.
     * 
     * @param[in] url URL utilizzato per caricare la vista.
     * @param[in] rb Risorse per il bundle di lingua.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Imposta i prefissi telefonici disponibili
        String[] prefissi = {"+39", "+1", "+44", "+33", "+49", "+34"};
        for (ChoiceBox<String> pref : new ChoiceBox[]{pref1, pref2, pref3}) {
            pref.getItems().addAll(prefissi);
            pref.setValue("+39");
        }

        // Aggiunge listener per validare i campi di input
        addValidationListeners();
    }

    /**
     * @brief Torna alla schermata precedente.
     * 
     * @param[in] event Evento associato al pulsante "Indietro".
     */
    @FXML
    private void indietro_f(ActionEvent event) {
        Main.setRoot("homePage");
    }

    /**
     * @brief Salva il contatto inserito dopo aver effettuato la validazione.
     * 
     * @param[in] event Evento associato al pulsante "Salva".
     */
    @FXML
    private void salva_f(ActionEvent event) {
        // Controlla la validità dei campi
        if (!validateFinalInput()) {
            showValidationAlert();
            return;
        }

        // Crea il nuovo contatto
        Contatto c = new Contatto(nome.getText().trim(), cognome.getText().trim(), 
                                  descrizione.getText().trim());

        // Aggiunge le email
        c.setEmail(new Email(email1.getText().trim()), 0);
        c.setEmail(new Email(email2.getText().trim()), 1);
        c.setEmail(new Email(email3.getText().trim()), 2);

        // Aggiunge i numeri di telefono
        c.setNumero(new NumeroTelefono(new Prefisso(pref1.getValue().substring(1)), tel1.getText().trim()), 0);
        c.setNumero(new NumeroTelefono(new Prefisso(pref2.getValue().substring(1)), tel2.getText().trim()), 1);
        c.setNumero(new NumeroTelefono(new Prefisso(pref3.getValue().substring(1)), tel3.getText().trim()), 2);
        
        if(Main.r.getTree().contains(c)){
            showDuplicateAlert();
            return;
        }
        // Salva il contatto e torna alla home
        Main.r.aggiungiContatto(c);
        Main.setRoot("homePage");
    }

    /**
     * @brief Aggiunge listener per la validazione dei campi di input.
     */
    private void addValidationListeners() {
        nome.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(nome, newValue, NOME_PATTERN, 100, true);
        });
        cognome.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(cognome, newValue, NOME_PATTERN, 100, true);
        });
        descrizione.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(descrizione, newValue, null, 100, false);
        });
        email1.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(email1, newValue, EMAIL_PATTERN, 100, false);
        });
        email2.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(email2, newValue, EMAIL_PATTERN, 100, false);
        });
        email3.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(email3, newValue, EMAIL_PATTERN, 100, false);
        });
        tel1.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(tel1, newValue, TELEFONO_PATTERN, new Prefisso(pref1.getValue().substring(1)).getLunghezzaNumero(), false);
        });
        tel2.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(tel2, newValue, TELEFONO_PATTERN, new Prefisso(pref2.getValue().substring(1)).getLunghezzaNumero(), false);
        });
        tel3.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTextField(tel3, newValue, TELEFONO_PATTERN, new Prefisso(pref3.getValue().substring(1)).getLunghezzaNumero(), false);
        });
    }

    /**
     * @brief Valida un campo di testo.
     * 
     * @param[in] textField Campo di testo da validare.
     * @param[in] newValue Nuovo valore del campo.
     * @param[in] pattern Pattern regex per la validazione.
     * @param[in] maxLength Lunghezza massima consentita.
     * @param[in] isRequired Indica se il campo è obbligatorio.
     */
    private void validateTextField(TextField textField, String newValue, 
                                    Pattern pattern, int maxLength, boolean isRequired) {
        salva.setDisable(false);
        if (newValue.length() > maxLength) {
            textField.setText(newValue.substring(0, maxLength));
            return;
        }
        if(newValue.length() != maxLength&&newValue.length()!=0&&pattern==TELEFONO_PATTERN){
            salva.setDisable(true);
            return;
        }                                      
                                    
        if (isRequired && (newValue == null || newValue.trim().isEmpty())) {
            textField.setStyle("-fx-border-color: red;");
            salva.setDisable(true);
            return;
        }
        if (pattern != null && !newValue.isEmpty() && !pattern.matcher(newValue).matches()) {
            textField.setStyle("-fx-border-color: red;");
            salva.setDisable(true);
            return;
        }
        textField.setStyle("");
    }

    /**
     * @brief Convalida un singolo campo di input.
     * 
     * @param[in] textField Campo di testo da validare.
     * @param[in] pattern Pattern regex per la validazione.
     * @param[in] isRequired Indica se il campo è obbligatorio.
     * @return true se il campo è valido, false altrimenti.
     */
    private boolean isValidInput(TextField textField, Pattern pattern, boolean isRequired) {
        String value = textField.getText().trim();
        if (value.length() > 100) {
            return false;
        }
        if (isRequired && value.isEmpty()) {
            return false;
        }
        if (pattern != null && !value.isEmpty()) {
            return pattern.matcher(value).matches();
        }
        return true;
    }

    /**
     * @brief Valida l'input finale prima del salvataggio.
     * 
     * @return true se tutti i campi sono validi, false altrimenti.
     */
    private boolean validateFinalInput() {
        boolean isNameOrSurnameFilled =
            !nome.getText().trim().isEmpty() || !cognome.getText().trim().isEmpty();

        return 
            isNameOrSurnameFilled &&
            isValidInput(nome, NOME_PATTERN, false) &&
            isValidInput(cognome, NOME_PATTERN, false) &&
            isValidInput(descrizione, null, false) &&
            isValidInput(email1, EMAIL_PATTERN, false) &&
            isValidInput(email2, EMAIL_PATTERN, false) &&
            isValidInput(email3, EMAIL_PATTERN, false) &&
            isValidInput(tel1, TELEFONO_PATTERN, false) &&
            isValidInput(tel2, TELEFONO_PATTERN, false) &&
            isValidInput(tel3, TELEFONO_PATTERN, false);
    }

    /**
     * @brief Mostra un avviso in caso di errori di validazione.
     */
    private void showValidationAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore di Validazione");
        alert.setHeaderText("Campi non validi");

        StringBuilder message = new StringBuilder("Assicurati di aver compilato almeno uno tra Nome o Cognome.\n");
        message.append("Controlla che i campi rispettino i formati richiesti.");

        alert.setContentText(message.toString());
        alert.showAndWait();
    }
    
     /**
     * @brief Mostra un avviso in caso di contatto gia presente.
     */
    private void showDuplicateAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore di Validazione");
        alert.setHeaderText("Contatto già presente");

        StringBuilder message = new StringBuilder("Questo nome e cognome sono già in uso");

        alert.setContentText(message.toString());
        alert.showAndWait();
    }   

}
