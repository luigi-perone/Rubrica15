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
 * @author luigi
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

    @FXML
    private MenuItem importa; ///< Menu per l'importazione di una rubrica.
    
    @FXML
    private MenuItem esporta; ///< Menu per l'esportazione della rubrica.
    
    @FXML
    private MenuItem nuovoContatto; ///< Menu per aggiungere un nuovo contatto.
    
    @FXML
    private TextField cerca; ///< Campo di testo per la ricerca di contatti.
    
    @FXML
    private Button ordina; ///< Pulsante per ordinare i contatti.
    
    @FXML
    private ListView<Contatto> listView; ///< Lista visualizzabile per i contatti.

    // Aggiungi un riferimento alla Stage principale
    private Stage stage;

    /**
     * Imposta lo stage per il file chooser
     * @param stage Lo stage principale dell'applicazione
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cerca.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 10) {
                cerca.setText(newValue.substring(0, 10)); // Troncamento
            }
        });
        if(Main.alfabetico){
            ordina.setText("Z-A");
            listView.getItems().clear();
            listView.getItems().addAll(r.getTree());
        }else{
            ordina.setText("A-Z");
            TreeSet<Contatto> reversedSet = new TreeSet<>(Collections.reverseOrder());
            reversedSet.addAll(Main.r.getTree());
            listView.getItems().clear();
            listView.getItems().addAll(reversedSet);
        }
        
    // Aggiunta del listener per la ricerca
    cerca.textProperty().addListener((observable, oldValue, newValue) -> {
        // Recupera l'intera rubrica originale
        TreeSet<Contatto> tuttiContatti = Main.r.getTree();
        
        // Filtra i contatti in base al testo inserito
        TreeSet<Contatto> contattiFiltrati = new TreeSet<>();
        for (Contatto contatto : tuttiContatti) {
            // Ricerca case-insensitive su nome, cognome, telefono, email
            if (contatto.getNome().toLowerCase().contains(newValue.toLowerCase()) ||
                contatto.getCognome().toLowerCase().contains(newValue.toLowerCase())) {
                contattiFiltrati.add(contatto);
            }
        }
        
        // Aggiorna la ListView con i contatti filtrati
        if(Main.alfabetico){
            ordina.setText("Z-A");
            listView.getItems().clear();
            listView.getItems().addAll(contattiFiltrati);
        }else{
            ordina.setText("A-Z");
            TreeSet<Contatto> reversedSet = new TreeSet<>(Collections.reverseOrder());
            reversedSet.addAll(contattiFiltrati);
            listView.getItems().clear();
            listView.getItems().addAll(reversedSet);
        }
    });

    // Listener per il doppio click come prima
    listView.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2) { // Doppio click
            Contatto selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                Main.setSelectedItem(selectedItem);
                Main.setRoot("visualizza");
            }
        }
    });
    }

    /**
     * Gestisce l'azione del menu "Importa", che permette di importare una rubrica.
     * 
     * @param event L'evento che rappresenta l'azione di importazione.
     */
    @FXML
    private void importa_f(ActionEvent event) {
        // Verifica che lo stage sia stato impostato
        
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un file");
        
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("File CSV", "*.csv")
        );
        
        File selectedFile = fileChooser.showOpenDialog(stage);
        
        if (selectedFile != null) {
            System.out.println("File selezionato: " + selectedFile.getAbsolutePath());
            // Aggiungi qui la logica per importare il file

            Main.r=Main.r.importaFile(selectedFile.getPath());
            Main.setRoot("homePage");
        }
    }

    @FXML
    private void esporta_f(ActionEvent event) {

    // Crea il FileChooser per selezionare il file di destinazione
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Salva rubrica");
    
    // Imposta un'estensione di file predefinita per il salvataggio
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("File CSV", "*.csv")
    );

    // Mostra la finestra di dialogo per il salvataggio
    File selectedFile = fileChooser.showSaveDialog(stage);
    
    if (selectedFile != null) {
        System.out.println("File selezionato per esportazione: " + selectedFile.getAbsolutePath());
        
        // Esegui l'esportazione
        try {
            Main.r.esportaRubrica(selectedFile.getAbsolutePath());
            System.out.println("Rubrica esportata con successo!");
        } catch (Exception e) {
            System.err.println("Errore durante l'esportazione della rubrica: " + e.getMessage());
        }
    }
    }

    @FXML
    private void nuovo_f(ActionEvent event) {
        Main.setRoot("aggiungi");
    }

    @FXML
    private void ordina_f(ActionEvent event) {
        // TODO: logica per ordinare la lista di contatti
        Main.alfabetico=!Main.alfabetico;
        
        TreeSet<Contatto> contattiFiltrati = new TreeSet<>();
        for (Contatto contatto : Main.r.getTree()) {
            // Ricerca case-insensitive su nome, cognome, telefono, email
            if (contatto.getNome().toLowerCase().contains(cerca.getText().toLowerCase()) ||
                contatto.getCognome().toLowerCase().contains(cerca.getText().toLowerCase())) {
                contattiFiltrati.add(contatto);
            }
        }
        
        // Aggiorna la ListView con i contatti filtrati
        if(Main.alfabetico){
            ordina.setText("Z-A");
            listView.getItems().clear();
            listView.getItems().addAll(contattiFiltrati);
        }else{
            ordina.setText("A-Z");
            TreeSet<Contatto> reversedSet = new TreeSet<>(Collections.reverseOrder());
            reversedSet.addAll(contattiFiltrati);
            listView.getItems().clear();
            listView.getItems().addAll(reversedSet);
        }
            
    }
}