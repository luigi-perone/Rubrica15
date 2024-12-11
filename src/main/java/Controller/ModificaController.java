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
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    // Costanti per la validazione
    private static final int MAX_LENGTH = 100;
    private static final Pattern NOME_COGNOME_PATTERN = Pattern.compile("^[\\p{L} '-]+$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("^\\d{9,10}$");

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
        // Inizializzazione dei prefissi (come nel codice originale)
        initializePrefissi(pref1);
        initializePrefissi(pref2);
        initializePrefissi(pref3);

        // Aggiungi listener per la validazione dei campi
        addValidationListeners();

        // Caricamento dei dati del contatto selezionato
        Contatto contatto = Main.getSelectedItem();
        if(contatto != null) {
            loadContactData(contatto);
        }
    }

    /**
     * Inizializza i prefissi per un ChoiceBox
     * 
     * @param prefBox ChoiceBox da inizializzare
     */
    private void initializePrefissi(ChoiceBox<String> prefBox) {
        prefBox.getItems().addAll(
            "+39",  // Italia
            "+1",   // Stati Uniti
            "+44",  // Regno Unito
            "+33",  // Francia
            "+49",  // Germania
            "+34"   // Spagna
        );
        prefBox.setValue("+39");
    }

    /**
     * Aggiunge listener per la validazione dei campi di input
     */
    private void addValidationListeners() {
        // Listener per nome e cognome (campi obbligatori)
        nome.textProperty().addListener((observable, oldValue, newValue) -> {
            validateNomeCognome(nome, newValue);
            limitLength(nome, newValue);
        });

        cognome.textProperty().addListener((observable, oldValue, newValue) -> {
            validateNomeCognome(cognome, newValue);
            limitLength(cognome, newValue);
        });

        // Listener per descrizione
        descrizione.textProperty().addListener((observable, oldValue, newValue) -> {
            limitLength(descrizione, newValue);
        });

        // Listener per email
        email1.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail(email1, newValue);
            limitLength(email1, newValue);
        });
        email2.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail(email2, newValue);
            limitLength(email2, newValue);
        });
        email3.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail(email3, newValue);
            limitLength(email3, newValue);
        });

        // Listener per numeri di telefono
        tel1.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTelefono(tel1, newValue);
        });
        tel2.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTelefono(tel2, newValue);
        });
        tel3.textProperty().addListener((observable, oldValue, newValue) -> {
            validateTelefono(tel3, newValue);
        });
    }

    /**
     * Limita la lunghezza del campo di testo a MAX_LENGTH
     * 
     * @param textField Campo di testo da limitare
     * @param newValue Nuovo valore del campo
     */
    private void limitLength(TextField textField, String newValue) {
        if (newValue != null && newValue.length() > MAX_LENGTH) {
            textField.setText(newValue.substring(0, MAX_LENGTH));
        }
    }

    /**
     * Valida il campo nome o cognome
     * 
     * @param textField Campo di testo da validare
     * @param value Valore del campo
     */
    private void validateNomeCognome(TextField textField, String value) {
        if (value == null || value.trim().isEmpty()) {
            textField.setStyle("-fx-border-color: red;");
        } else if (!NOME_COGNOME_PATTERN.matcher(value.trim()).matches()) {
            textField.setStyle("-fx-border-color: red;");
        } else {
            textField.setStyle("");
        }
    }

    /**
     * Valida il campo email
     * 
     * @param textField Campo di testo da validare
     * @param value Valore del campo
     */
    private void validateEmail(TextField textField, String value) {
        // Se il campo è vuoto, rimuovi lo stile di errore
        if (value == null || value.trim().isEmpty()) {
            textField.setStyle("");
            return;
        }

        // Controlla il formato dell'email
        if (!EMAIL_PATTERN.matcher(value.trim()).matches()) {
            textField.setStyle("-fx-border-color: red;");
        } else {
            textField.setStyle("");
        }
    }

    /**
     * Valida il campo numero di telefono
     * 
     * @param textField Campo di testo da validare
     * @param value Valore del campo
     */
    private void validateTelefono(TextField textField, String value) {
        // Se il campo è vuoto, rimuovi lo stile di errore
        if (value == null || value.trim().isEmpty()) {
            textField.setStyle("");
            return;
        }

        // Controlla il formato del numero di telefono
        if (!TELEFONO_PATTERN.matcher(value.trim()).matches()) {
            textField.setStyle("-fx-border-color: red;");
        } else {
            textField.setStyle("");
        }
    }

    /**
     * Carica i dati del contatto selezionato
     * 
     * @param contatto Contatto da caricare
     */
    private void loadContactData(Contatto contatto) {
        iniziale.setText(contatto.getCognome().substring(0, 1));
        nome.setText(contatto.getNome());
        cognome.setText(contatto.getCognome());
        descrizione.setText(contatto.getDescrizione());

        // Carica email
        if(contatto.getEmail(0) != null && contatto.getEmail(0).checkEmail())
            email1.setText(contatto.getEmail(0).getEmail());
        if(contatto.getEmail(1) != null && contatto.getEmail(1).checkEmail())
            email2.setText(contatto.getEmail(1).getEmail());
        if(contatto.getEmail(2) != null && contatto.getEmail(2).checkEmail())
            email3.setText(contatto.getEmail(2).getEmail());

        // Carica numeri di telefono
        if(contatto.getNumero(0) != null && contatto.getNumero(0).checkNumeroTelefono()) {
            tel1.setText(contatto.getNumero(0).getNumero());
            pref1.setValue(contatto.getNumero(0).getPrefisso().toString());
        }
        if(contatto.getNumero(1) != null && contatto.getNumero(1).checkNumeroTelefono()) {
            tel2.setText(contatto.getNumero(1).getNumero());
            pref2.setValue(contatto.getNumero(1).getPrefisso().toString());
        }
        if(contatto.getNumero(2) != null && contatto.getNumero(2).checkNumeroTelefono()) {
            tel3.setText(contatto.getNumero(2).getNumero());
            pref3.setValue(contatto.getNumero(2).getPrefisso().toString());
        }
    }

    /**
     * Gestisce l'azione del menu "Indietro", che permette di tornare alla schermata precedente.
     * 
     * @param event L'evento che rappresenta l'azione di tornare indietro.
     */
    @FXML
    private void indietro_f(ActionEvent event) {
        Main.setRoot("visualizza");
    }

    /**
     * Gestisce l'azione del menu "Salva", che permette di salvare le modifiche apportate al contatto.
     * 
     * @param event L'evento che rappresenta l'azione di salvataggio.
     */
    @FXML
    private void salva_f(ActionEvent event) {
        // Validazione finale prima del salvataggio
        if (!validateFinalInput()) {
            return;
        }

        // Ottieni il contatto attualmente selezionato
        Contatto contatto = Main.getSelectedItem();
        Email[] e = new Email[3];
        NumeroTelefono[] num = new NumeroTelefono[3];
        
        e[0] = new Email(email1.getText());
        e[1] = new Email(email2.getText());
        e[2] = new Email(email3.getText());
        
        num[0] = new NumeroTelefono(new Prefisso(pref1.getValue().substring(1)), tel1.getText());
        num[1] = new NumeroTelefono(new Prefisso(pref2.getValue().substring(1)), tel2.getText());
        num[2] = new NumeroTelefono(new Prefisso(pref3.getValue().substring(1)), tel3.getText());
        
        Main.r.modificaContatto(contatto, cognome.getText(), nome.getText(), descrizione.getText(), e, num);
        Main.setRoot("homePage");
    }

    /**
     * Esegue una validazione finale prima del salvataggio
     * 
     * @return true se tutti i campi sono validi, false altrimenti
     */
    private boolean validateFinalInput() {
        boolean isValid = true;

        // Controllo nome e cognome (campi obbligatori)
        if (nome.getText() == null || nome.getText().trim().isEmpty()) {
            nome.setStyle("-fx-border-color: red;");
            isValid = false;
        }

        if (cognome.getText() == null || cognome.getText().trim().isEmpty()) {
            cognome.setStyle("-fx-border-color: red;");
            isValid = false;
        }

        // Controllo email (se non vuote)
        if (!email1.getText().trim().isEmpty() && !EMAIL_PATTERN.matcher(email1.getText().trim()).matches()) {
            email1.setStyle("-fx-border-color: red;");
            isValid = false;
        }

        if (!email2.getText().trim().isEmpty() && !EMAIL_PATTERN.matcher(email2.getText().trim()).matches()) {
            email2.setStyle("-fx-border-color: red;");
            isValid = false;
        }

        if (!email3.getText().trim().isEmpty() && !EMAIL_PATTERN.matcher(email3.getText().trim()).matches()) {
            email3.setStyle("-fx-border-color: red");
            isValid = false;
        }

        // Controllo numeri di telefono (se non vuoti)
        if (!tel1.getText().trim().isEmpty() && !TELEFONO_PATTERN.matcher(tel1.getText().trim()).matches()) {
            tel1.setStyle("-fx-border-color: red");
            isValid = false;
        }

        if (!tel2.getText().trim().isEmpty() && !TELEFONO_PATTERN.matcher(tel2.getText().trim()).matches()) {
            tel2.setStyle("-fx-border-color: red");
            isValid = false;
        }

        if (!tel3.getText().trim().isEmpty() && !TELEFONO_PATTERN.matcher(tel3.getText().trim()).matches()) {
            tel3.setStyle("-fx-border-color: red");
            isValid = false;
        }

        // Mostra un alert se ci sono errori di validazione
        if (!isValid) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore di Validazione");
            alert.setHeaderText("Alcuni campi non sono compilati correttamente");
            alert.setContentText("Controlla i campi evidenziati in rosso e assicurati che siano validi.");
            alert.showAndWait();
        }

        return isValid;
    }
}