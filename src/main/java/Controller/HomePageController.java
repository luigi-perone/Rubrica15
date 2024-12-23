/**
 * @file HomePageController.java
 * @brief Controller per la schermata principale dell'applicazione.
 * 
 * La classe @c HomePageController gestisce la schermata principale dell'applicazione,
 * inclusi gli eventi di interazione con l'interfaccia utente come l'importazione,
 * l'esportazione, l'aggiunta di nuovi contatti, la ricerca e l'ordinamento dei contatti.
 * La classe implementa l'interfaccia @c Initializable di JavaFX per l'inizializzazione della vista.
 * 
 * @package Controller
 * 
 * @author gruppo15
 */
package Controller;

import Main.Main;
import static Main.Main.r;
import Model.Contatto;
import Model.Rubrica;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import java.util.Collections;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @class HomePageController
 * @brief Controller per la schermata principale dell'applicazione di gestione rubrica.
 *
 * La classe gestisce la schermata principale, fornendo funzionalità come
 * l'importazione, l'esportazione, l'aggiunta, la ricerca e l'ordinamento dei contatti.
 * Implementa l'interfaccia `Initializable` per configurare l'interfaccia utente 
 * al momento dell'avvio.
 *
 * La classe utilizza il pattern MVC per separare la logica della vista dalla logica
 * del modello e comunica con il modello tramite il pacchetto `Model`.
 * .
 * @warning L'applicazione non supporta file di rubrica in formati diversi dal CSV.
 */

public class HomePageController implements Initializable {

    @FXML
    private Button importa; ///< Pulsante per l'importazione di una rubrica.

    @FXML
    private Button esporta; ///< Pulsante per l'esportazione della rubrica.

    @FXML
    private Button nuovoContatto; ///< Pulsante per aggiungere un nuovo contatto.

    @FXML
    private TextField cerca; ///< Campo di testo per la ricerca di contatti.

    @FXML
    private Button ordina; ///< Pulsante per ordinare i contatti.

    @FXML
    private ListView<Contatto> listView; ///< Lista visualizzabile per i contatti.

    private Stage stage; ///< Riferimento allo stage principale per l'utilizzo di dialoghi.

    /**
     * @brief Imposta lo stage principale per il file chooser.
     * 
     * @post viene assegnato allo stage principale il valore del parametro
     * 
     * @param stage Lo stage principale dell'applicazione.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    /**
    * @brief Metodo initialize eseguito all'inizializzazione del controller.
    * Imposta i listener per la ricerca, la gestione del doppio clic e 
    * inizializza la vista basandosi sull'ordinamento alfabetico.
    *
    * @post imposta i listener e inizializza la visita basandosi sull'ordinamento alfabetico
    * 
    * @param[in] url URL utilizzato per risolvere percorsi relativi del file FXML
    * @param[in] rb ResourceBundle contenente le risorse localizzate per il controller
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Aggiunge un listener per limitare il campo di testo della ricerca a 201 caratteri
        cerca.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 201) {
                cerca.setText(newValue.substring(0, 201)); // Troncamento
            }
        });

        // Inizializza la vista in base alla modalità di ordinamento (A-Z o Z-A)
        if (Main.alfabetico) {
            ordina.setText("Z-A");
            listView.getItems().clear();
            listView.getItems().addAll(r.getTree());
        } else {
            ordina.setText("A-Z");
            TreeSet<Contatto> reversedSet = new TreeSet<>(Collections.reverseOrder());
            reversedSet.addAll(Main.r.getTree());
            listView.getItems().clear();
            listView.getItems().addAll(reversedSet);
        }

        // Aggiunge un listener per filtrare i contatti durante la ricerca
        cerca.textProperty().addListener((observable, oldValue, newValue) -> {
            TreeSet<Contatto> tuttiContatti = Main.r.getTree();
            TreeSet<Contatto> contattiFiltrati = new TreeSet<>();

            // Filtra i contatti per nome o cognome, considerando solo le sottostringhe iniziali
            for (Contatto contatto : tuttiContatti) {
                if (contatto.getNome().toLowerCase().startsWith(newValue.toLowerCase()) ||
                    contatto.getCognome().toLowerCase().startsWith(newValue.toLowerCase())) {
                    contattiFiltrati.add(contatto);
                }
            }

            // Aggiorna la vista con i contatti filtrati dalla ricerca
            listView.getItems().clear();
            if (Main.alfabetico) {
                listView.getItems().addAll(contattiFiltrati);
            } else {
                TreeSet<Contatto> reversedSet = new TreeSet<>(Collections.reverseOrder());
                reversedSet.addAll(contattiFiltrati);
                listView.getItems().addAll(reversedSet);
            }
        });


        // Gestisce il doppio clic su un contatto nella lista per visualizzarlo
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Contatto selectedItem = listView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    Main.setSelectedItem(selectedItem);
                    Main.setRoot("visualizza");
                }
            }
        });
    }

    /**
     * @brief Gestisce l'importazione di una rubrica da un file CSV.
     * 
     * @pre L'utente preme il pulsante "Importa"
     * @post La rubrica viene caricata dei contatti del file se questo è corretto
     * 
     * @param[in] event L'evento associato al pulsante "Importa".
     */
    @FXML
    private void importa_f(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            Rubrica temp = Main.r.importaFile(selectedFile.getPath());
            if (temp != null && !temp.getTree().isEmpty()) {
                Main.r = temp;
                Main.setRoot("homePage");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText("Importazione fallita");
                alert.setContentText("Il formato del file non è valido.");
                alert.showAndWait();
            }
        }
    }

    /**
     * @brief Gestisce l'esportazione della rubrica in un file CSV.
     * 
     * @pre L'utente preme il pulsante "Esporta"
     * @post La rubrica viene esportata sul file indicato.
     * 
     * @param[in] event L'evento associato al pulsante "Esporta".
     */
    @FXML
    private void esporta_f(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salva rubrica");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile != null) {
            try {
                Main.r.esportaRubrica(selectedFile.getAbsolutePath());
                System.out.println("Rubrica esportata con successo!");
            } catch (Exception e) {
                System.err.println("Errore durante l'esportazione: " + e.getMessage());
            }
        }
    }

    /**
     * @brief Gestisce l'azione per creare un nuovo contatto.
     * 
     * @pre L'utente preme il pulsante "Nuovo Contatto"
     * @post La scena viene cambiata per visualizzare la schermata "aggiungi".
     * 
     * @param[in] event L'evento associato al pulsante "Nuovo Contatto".
     */
    @FXML
    private void nuovo_f(ActionEvent event) {
        Main.setRoot("aggiungi");
    }

    /**
     * @brief Alterna l'ordinamento tra A-Z e Z-A per la lista dei contatti.
     * 
     * @pre L'utente preme il pulsante per  l'ordinamento
     * @post La rubrica viene invertita rispetto l'ordine precedente
     * 
     * @param[in] event L'evento associato al pulsante "Ordina".
     */
    @FXML
    private void ordina_f(ActionEvent event) {
        Main.alfabetico = !Main.alfabetico;

        TreeSet<Contatto> contattiFiltrati = new TreeSet<>();
        TreeSet<Contatto> tuttiContatti = new TreeSet<>(Main.r.getTree());
        for (Contatto contatto : tuttiContatti) {
            if (contatto.getNome().toLowerCase().startsWith(cerca.getText().toLowerCase()) ||
                contatto.getCognome().toLowerCase().startsWith(cerca.getText().toLowerCase())) {
                contattiFiltrati.add(contatto);
            }
        }

        if (Main.alfabetico) {
            ordina.setText("Z-A");
            listView.getItems().clear();
            listView.getItems().addAll(contattiFiltrati);
        } else {
            ordina.setText("A-Z");
            TreeSet<Contatto> reversedSet = new TreeSet<>(Collections.reverseOrder());
            reversedSet.addAll(contattiFiltrati);
            listView.getItems().clear();
            listView.getItems().addAll(reversedSet);
        }
    }
}
