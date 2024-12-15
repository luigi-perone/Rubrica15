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
 * @author gruppo15
 */

package Controller;

import Main.Main;
import Model.Contatto;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * @class VisualizzaController
 * @brief Controller per gestire la visualizzazione dei dettagli di un contatto.
 * 
 * Questa classe consente di visualizzare le informazioni del contatto selezionato,
 * come nome, cognome, descrizione, numeri di telefono, email e prefissi. 
 * Inoltre, permette di modificare o eliminare il contatto.
 */
public class VisualizzaController implements Initializable {

    /**
     * @brief Bottone per tornare indietro alla schermata precedente.
     */
    @FXML
    private Button indietro;

    /**
     * @brief Bottone per modificare il contatto visualizzato.
     */
    @FXML
    private Button modifica;

    /**
     * @brief Bottone per eliminare il contatto visualizzato.
     */
    @FXML
    private Button elimina;

    /**
     * @brief Etichetta per visualizzare il nome del contatto.
     */
    @FXML
    private Label nome;

    /**
     * @brief Etichetta per visualizzare il cognome del contatto.
     */
    @FXML
    private Label cognome;

    /**
     * @brief Etichetta per visualizzare la descrizione del contatto.
     */
    @FXML
    private Label descrizione;

    /**
     * @brief Etichetta per visualizzare il primo numero di telefono.
     */
    @FXML
    private Label tel1;

    /**
     * @brief Etichetta per visualizzare il secondo numero di telefono.
     */
    @FXML
    private Label tel2;

    /**
     * @brief Etichetta per visualizzare il terzo numero di telefono.
     */
    @FXML
    private Label tel3;

    /**
     * @brief Etichetta per visualizzare la prima email.
     */
    @FXML
    private Label email1;

    /**
     * @brief Etichetta per visualizzare la seconda email.
     */
    @FXML
    private Label email2;

    /**
     * @brief Etichetta per visualizzare la terza email.
     */
    @FXML
    private Label email3;

    /**
     * @brief Etichetta per visualizzare il prefisso del primo numero di telefono.
     */
    @FXML
    private Label pref1;

    /**
     * @brief Etichetta per visualizzare il prefisso del secondo numero di telefono.
     */
    @FXML
    private Label pref2;

    /**
     * @brief Etichetta per visualizzare il prefisso del terzo numero di telefono.
     */
    @FXML
    private Label pref3;

    /**
     * @brief Testo per visualizzare l'iniziale del cognome del contatto.
     */
    @FXML
    private Text iniziale;

    /**
     * @brief Metodo di inizializzazione chiamato all'avvio della vista.
     * 
     * @pre La vista è stata caricata correttamente.
     * @post Le etichette vengono aggiornate con i dati del contatto selezionato.
     * 
     * @param[in] url URL utilizzato per caricare la vista (non utilizzato in questo caso).
     * @param[in] rb Risorse per il bundle di lingua (non utilizzato in questo caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Contatto contatto = Main.getSelectedItem();
        if (contatto != null) {
            if(!contatto.getCognome().isEmpty()){
                iniziale.setText(contatto.getCognome().substring(0, 1).toUpperCase());
                cognome.setText(contatto.getCognome());
            }
            if(!contatto.getNome().isEmpty())
                nome.setText(contatto.getNome());
            if(!contatto.getDescrizione().isEmpty())
                descrizione.setText(contatto.getDescrizione());
            if (contatto.getEmail(0) != null && contatto.getEmail(0).checkEmail())
                email1.setText(contatto.getEmail(0).getEmail());
            if (contatto.getEmail(1) != null && contatto.getEmail(1).checkEmail())
                email2.setText(contatto.getEmail(1).getEmail());
            if (contatto.getEmail(2) != null && contatto.getEmail(2).checkEmail())
                email3.setText(contatto.getEmail(2).getEmail());

            if (contatto.getNumero(0) != null && contatto.getNumero(0).checkNumeroTelefono()) {
                tel1.setText(contatto.getNumero(0).getNumero());
                pref1.setText(contatto.getNumero(0).getPrefisso().toString());
            }
            if (contatto.getNumero(1) != null && contatto.getNumero(1).checkNumeroTelefono()) {
                tel2.setText(contatto.getNumero(1).getNumero());
                pref2.setText(contatto.getNumero(1).getPrefisso().toString());
            }
            if (contatto.getNumero(2) != null && contatto.getNumero(2).checkNumeroTelefono()) {
                tel3.setText(contatto.getNumero(2).getNumero());
                pref3.setText(contatto.getNumero(2).getPrefisso().toString());
            }
        }
    }

    /**
     * @brief Gestisce l'azione del bottone "Indietro" per tornare alla schermata precedente.
     * 
     * @pre L'utente ha cliccato sul pulsante "Indietro".
     * @post La scena viene cambiata per visualizzare la schermata "homePage".
     * 
     * @param[in] event Evento che rappresenta l'azione del bottone.
     */
    @FXML
    private void indietro_f(ActionEvent event) {
        Main.setRoot("homePage");
    }

    /**
     * @brief Gestisce l'azione del bottone "Modifica" per modificare il contatto visualizzato.
     * 
     * @pre L'utente ha cliccato sul pulsante "Modifica".
     * @post La scena viene cambiata per visualizzare la schermata "modifica".
     * 
     * @param[in] event Evento che rappresenta l'azione del bottone.
     */
    @FXML
    private void modifica_f(ActionEvent event) {
        Main.setRoot("modifica");
    }

    /**
     * @brief Gestisce l'azione del bottone "Elimina" per eliminare il contatto visualizzato.
     * 
     * Mostra un'alert di conferma prima di procedere con l'eliminazione.
     * 
     * @pre L'utente ha cliccato sul pulsante "Elimina".
     * @post Se l'utente conferma l'eliminazione, il contatto viene eliminato e 
     * la scena cambia per visualizzare la schermata "homePage" altrimenti la scena rimane non cambia e il contatto non viene eliminato.
     * 
     * 
     * @param[in] event Evento che rappresenta l'azione del bottone.
     */
    @FXML
    private void elimina_f(ActionEvent event) {
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Conferma");
        confirmationAlert.setHeaderText("Sei sicuro?");
        confirmationAlert.setContentText("Il contatto verrà eliminato definitivamente");

        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Main.r.eliminaContatto(Main.getSelectedItem());
        }

        Main.setRoot("homePage");
    }
}
