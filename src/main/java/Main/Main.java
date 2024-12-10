package Main;



/**
 * @file Main.java
 * @brief Classe principale dell'applicazione.
 * 
 * La classe @c Main è il punto di ingresso dell'applicazione. Attualmente, la classe
 * non contiene alcun codice, ma potrebbe essere utilizzata per avviare l'applicazione
 * o eseguire altre operazioni principali, come l'inizializzazione di componenti o
 * la gestione delle interazioni con l'utente.
 * 
 * @author luigi
 */

import Controller.HomePageController;
import Model.*;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;
    private static Contatto selectedItem;
    public static Rubrica r;
    public static boolean alfabetico;
    static{
        alfabetico=true;
    }
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(new File("src/main/java/View/homePage.fxml").toURI().toURL());
            Parent root = loader.load();

            // Set the title of the window
            primaryStage.setTitle("Rubrica");

            // Create a Scene and set it on the Stage
            scene = new Scene(root);
            primaryStage.setScene(scene);

            // Show the Stage
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(new File("src/main/java/View/"+fxml+".fxml").toURI().toURL());
        return loader.load();
    }

    public static void main(String[] args) {
        r=new Rubrica();
        launch(args);
        
        
    }

    public static Contatto getSelectedItem() {
        return selectedItem;
    }

    public static void setSelectedItem(Contatto selectedItem) {
        Main.selectedItem = selectedItem;
    }
    
    
}

