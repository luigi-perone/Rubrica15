/**
 * @file Main.java
 * @brief Classe principale dell'applicazione.
 * 
 * La classe @c Main rappresenta il punto di ingresso dell'applicazione. Si occupa
 * di avviare l'interfaccia grafica, inizializzare i dati della rubrica e gestire
 * il ciclo di vita dell'applicazione.
 * 
 * @author gruppo15
 * @package Main
 */

package Main;

import Model.*;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @brief Main rappresenta il punto di ingresso dell'applicazione. 
 * Si occupa di avviare l'interfaccia grafica, inizializzare i dati della rubrica 
 * e gestire il ciclo di vita dell'applicazione.
 */
public class Main extends Application {

    // Variabile per gestire la scena principale dell'applicazione
    private static Scene scene;

    // Variabile per tracciare l'elemento selezionato nella rubrica
    private static Contatto selectedItem;

    // Istanza della rubrica
    public static Rubrica r;

    // Variabile per determinare l'ordinamento alfabetico dei contatti
    public static boolean alfabetico;

    // Blocco statico per inizializzare la variabile alfabetico
    static {
        alfabetico = true;
    }

    /**
     * Metodo principale per avviare l'applicazione.
     * 
     * @param[in] primaryStage la finestra principale dell'applicazione
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            // Caricamento del file FXML per l'interfaccia utente
            FXMLLoader loader = new FXMLLoader(new File("src/main/java/View/homePage.fxml").toURI().toURL());
            Parent root = loader.load();

            // Imposta il titolo della finestra principale
            primaryStage.setTitle("Rubrica");

            // Gestione dell'evento di chiusura della finestra
            primaryStage.setOnCloseRequest(event -> {
                // Esporta i dati della rubrica in un file CSV alla chiusura
                Main.r.esportaRubrica("src/main/java/Main/default.csv");
            });

            // Impedisce il ridimensionamento della finestra
            primaryStage.setResizable(false);

            // Crea una scena e la imposta nello stage principale
            scene = new Scene(root);
            primaryStage.setScene(scene);

            // Mostra la finestra principale
            primaryStage.show();
        } catch (IOException e) {
            // Gestisce eventuali errori durante il caricamento dell'interfaccia
        }
    }

    /**
     * Imposta la radice della scena principale.
     * 
     * @param[in] fxml il nome del file FXML da caricare
     */
    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carica un file FXML specificato.
     * 
     * @param[in] fxml il nome del file FXML da caricare
     * @return il nodo radice del file FXML caricato
     * @throws IOException in caso di errore durante il caricamento
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(new File("src/main/java/View/" + fxml + ".fxml").toURI().toURL());
        return loader.load();
    }

    /**
     * Metodo main, punto di ingresso dell'applicazione.
     * 
     * @param[in] args argomenti della riga di comando
     */
    public static void main(String[] args) {
        // Inizializza una nuova istanza della rubrica
        r = new Rubrica();

        // Importa i dati dal file CSV predefinito
        r = r.importaFile("src/main/java/Main/default.csv");

        // Avvia l'applicazione JavaFX
        launch(args);
    }

    /**
     * Ottiene l'elemento attualmente selezionato.
     * 
     * @return l'elemento selezionato
     */
    public static Contatto getSelectedItem() {
        return selectedItem;
    }

    /**
     * Imposta l'elemento selezionato.
     * 
     * @param selectedItem l'elemento da impostare come selezionato
     */
    public static void setSelectedItem(Contatto selectedItem) {
        Main.selectedItem = selectedItem;
    }
}
