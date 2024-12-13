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
 * @authors gruppo15
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @class ModificaController
 * @brief Gestisce la schermata di modifica di un contatto.
 */
public class ModificaController implements Initializable {

    @FXML
    private Button indietro; ///< Pulsante per tornare indietro alla schermata precedente.

    @FXML
    private Button salva; ///< Pulsante per salvare le modifiche al contatto.

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
    private Text iniziale; ///< Testo che mostra informazioni iniziali.

    private static final int MAX_LENGTH = 100; ///< Lunghezza massima dei campi di testo.
    private static final Pattern NOME_COGNOME_PATTERN = Pattern.compile("^[\\p{L} '-]+$"); ///< Pattern per validare nome e cognome.
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})*$");

    private static final Pattern TELEFONO_PATTERN = Pattern.compile("^\\d{9,10}$"); ///< Pattern per validare numeri di telefono.

    /**
     * Metodo di inizializzazione chiamato all'avvio della vista.
     * Configura i componenti dell'interfaccia utente e carica i dati del contatto selezionato.
     *
     * @param url URL utilizzato per caricare la vista (non utilizzato in questo caso).
     * @param rb Risorse per il bundle di lingua (non utilizzato in questo caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializePrefissi(pref1);
        initializePrefissi(pref2);
        initializePrefissi(pref3);

        Contatto contatto = Main.getSelectedItem();
        if (contatto != null) {
            loadContactData(contatto);
        }
    }

    /**
     * Inizializza i prefissi per un ChoiceBox.
     *
     * @param prefBox ChoiceBox da inizializzare.
     */
    private void initializePrefissi(ChoiceBox<String> prefBox) {
        prefBox.getItems().addAll(
            "+39", "+1", "+44", "+33", "+49", "+34"
        );
        prefBox.setValue("+39");
    }



    /**
     * Gestisce l'azione del pulsante "Indietro".
     *
     * @param event Evento che rappresenta l'azione.
     */
    @FXML
    private void indietro_f(ActionEvent event) {
        Main.setRoot("visualizza");
    }

    /**
     * Gestisce l'azione del pulsante "Salva".
     *
     * @param event Evento che rappresenta l'azione.
     */
    @FXML
    private void salva_f(ActionEvent event) {
        if (!validateFinalInput()) {
            return;
        }
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
 * Esegue una validazione finale prima del salvataggio.
 *
 * @return true se tutti i campi sono validi, altrimenti false.
 */
private boolean validateFinalInput() {
    boolean isValid = true;

    // Controllo obbligatorio: almeno uno tra nome e cognome deve essere inserito
    if (nome.getText().trim().isEmpty() && cognome.getText().trim().isEmpty()) {
        nome.setStyle("-fx-border-color: red;");
        cognome.setStyle("-fx-border-color: red;");
        isValid = false;
    } else {
        // Validazione individuale per nome
        if (!nome.getText().trim().isEmpty() && !NOME_COGNOME_PATTERN.matcher(nome.getText().trim()).matches()) {
            nome.setStyle("-fx-border-color: red;");
            isValid = false;
        } else {
            nome.setStyle(""); // Rimuovi stile rosso se valido o vuoto
        }

        // Validazione individuale per cognome
        if (!cognome.getText().trim().isEmpty() && !NOME_COGNOME_PATTERN.matcher(cognome.getText().trim()).matches()) {
            cognome.setStyle("-fx-border-color: red;");
            isValid = false;
        } else {
            cognome.setStyle(""); // Rimuovi stile rosso se valido o vuoto
        }
    }

    // Validazione delle email
    if (!email1.getText().trim().isEmpty() && !EMAIL_PATTERN.matcher(email1.getText().trim()).matches()) {
        email1.setStyle("-fx-border-color: red;");
        isValid = false;
    } else {
        email1.setStyle("");
    }

    if (!email2.getText().trim().isEmpty() && !EMAIL_PATTERN.matcher(email2.getText().trim()).matches()) {
        email2.setStyle("-fx-border-color: red;");
        isValid = false;
    } else {
        email2.setStyle("");
    }

    if (!email3.getText().trim().isEmpty() && !EMAIL_PATTERN.matcher(email3.getText().trim()).matches()) {
        email3.setStyle("-fx-border-color: red;");
        isValid = false;
    } else {
        email3.setStyle("");
    }

    // Validazione dei numeri di telefono
    if (tel1.getText().length() > new Prefisso(pref1.getValue().substring(1)).getLunghezzaNumero()&&!tel1.getText().trim().isEmpty() && !TELEFONO_PATTERN.matcher(tel1.getText().trim()).matches()) {
        tel1.setStyle("-fx-border-color: red;");
        isValid = false;
    } else {
        tel1.setStyle("");
    }

    if (tel2.getText().length() > new Prefisso(pref2.getValue().substring(1)).getLunghezzaNumero()&&!tel2.getText().trim().isEmpty() && !TELEFONO_PATTERN.matcher(tel2.getText().trim()).matches()) {
        tel2.setStyle("-fx-border-color: red;");
        isValid = false;
    } else {
        tel2.setStyle("");
    }

    if (tel3.getText().length() > new Prefisso(pref3.getValue().substring(1)).getLunghezzaNumero()&&!tel3.getText().trim().isEmpty() && !TELEFONO_PATTERN.matcher(tel3.getText().trim()).matches()) {
        tel3.setStyle("-fx-border-color: red;");
        isValid = false;
    } else {
        tel3.setStyle("");
    }

    return isValid;
}
    /**
 * Carica i dati del contatto selezionato.
 *
 * @param contatto Contatto da caricare.
 */
private void loadContactData(Contatto contatto) {
    iniziale.setText(contatto.getCognome() != null && !contatto.getCognome().isEmpty() 
                    ? contatto.getCognome().substring(0, 1) 
                    : "");

    nome.setText(contatto.getNome() != null && !contatto.getNome().isEmpty() 
                 ? contatto.getNome() 
                 : "");

    cognome.setText(contatto.getCognome() != null && !contatto.getCognome().isEmpty() 
                    ? contatto.getCognome() 
                    : "");

    descrizione.setText(contatto.getDescrizione() != null && !contatto.getDescrizione().isEmpty() 
                        ? contatto.getDescrizione() 
                        : "");

    if (contatto.getEmail(0) != null && contatto.getEmail(0).checkEmail()) {
        email1.setText(contatto.getEmail(0).getEmail());
    }
    if (contatto.getEmail(1) != null && contatto.getEmail(1).checkEmail()) {
        email2.setText(contatto.getEmail(1).getEmail());
    }
    if (contatto.getEmail(2) != null && contatto.getEmail(2).checkEmail()) {
        email3.setText(contatto.getEmail(2).getEmail());
    }

    if (contatto.getNumero(0) != null && contatto.getNumero(0).checkNumeroTelefono()) {
        tel1.setText(contatto.getNumero(0).getNumero());
        pref1.setValue(contatto.getNumero(0).getPrefisso().toString());
    }
    if (contatto.getNumero(1) != null && contatto.getNumero(1).checkNumeroTelefono()) {
        tel2.setText(contatto.getNumero(1).getNumero());
        pref2.setValue(contatto.getNumero(1).getPrefisso().toString());
    }
    if (contatto.getNumero(2) != null && contatto.getNumero(2).checkNumeroTelefono()) {
        tel3.setText(contatto.getNumero(2).getNumero());
        pref3.setValue(contatto.getNumero(2).getPrefisso().toString());
    }
}

}
