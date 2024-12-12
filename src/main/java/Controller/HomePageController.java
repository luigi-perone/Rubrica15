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
     * Imposta lo stage principale per il file chooser.
     * @param stage Lo stage principale dell'applicazione.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Aggiunge un listener per limitare il campo di testo della ricerca a 10 caratteri
        cerca.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 10) {
                cerca.setText(newValue.substring(0, 10)); // Troncamento
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

            // Filtra i contatti per nome o cognome
            for (Contatto contatto : tuttiContatti) {
                if (contatto.getNome().toLowerCase().contains(newValue.toLowerCase()) ||
                    contatto.getCognome().toLowerCase().contains(newValue.toLowerCase())) {
                    contattiFiltrati.add(contatto);
                }
            }

            // Aggiorna la vista con i contatti filtrati
            if (Main.alfabetico) {
                listView.getItems().clear();
                listView.getItems().addAll(contattiFiltrati);
            } else {
                TreeSet<Contatto> reversedSet = new TreeSet<>(Collections.reverseOrder());
                reversedSet.addAll(contattiFiltrati);
                listView.getItems().clear();
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
     * Gestisce l'importazione di una rubrica da un file CSV.
     * @param event L'evento associato al pulsante "Importa".
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
     * Gestisce l'esportazione della rubrica in un file CSV.
     * @param event L'evento associato al pulsante "Esporta".
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
     * Gestisce l'azione per creare un nuovo contatto.
     * @param event L'evento associato al pulsante "Nuovo Contatto".
     */
    @FXML
    private void nuovo_f(ActionEvent event) {
        Main.setRoot("aggiungi");
    }

    /**
     * Alterna l'ordinamento tra A-Z e Z-A per la lista dei contatti.
     * @param event L'evento associato al pulsante "Ordina".
     */
    @FXML
    private void ordina_f(ActionEvent event) {
        Main.alfabetico = !Main.alfabetico;

        TreeSet<Contatto> contattiFiltrati = new TreeSet<>();
        for (Contatto contatto : Main.r.getTree()) {
            if (contatto.getNome().toLowerCase().contains(cerca.getText().toLowerCase()) ||
                contatto.getCognome().toLowerCase().contains(cerca.getText().toLowerCase())) {
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
