/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author scass
 */
public class VisualizzaController implements Initializable {

    @FXML
    private Menu indietro;
    @FXML
    private Menu modifica;
    @FXML
    private Menu elimina;
    @FXML
    private Label nome;
    @FXML
    private Label cognome;
    @FXML
    private Label descrizione;
    @FXML
    private Label tel1;
    @FXML
    private Label tel2;
    @FXML
    private Label tel3;
    @FXML
    private Label email1;
    @FXML
    private Label email2;
    @FXML
    private Label email3;
    @FXML
    private Label pref1;
    @FXML
    private Label pref2;
    @FXML
    private Label pref3;
    @FXML
    private Text iniziale;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void indietro_f(ActionEvent event) {
    }

    @FXML
    private void modifica_f(ActionEvent event) {
    }

    @FXML
    private void elimina_f(ActionEvent event) {
    }
    
}
