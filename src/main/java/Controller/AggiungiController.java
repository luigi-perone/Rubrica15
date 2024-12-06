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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author scass
 */
public class AggiungiController implements Initializable {

    @FXML
    private Menu indietro;
    @FXML
    private Menu salva;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField descrizione;
    @FXML
    private TextField tel1;
    @FXML
    private TextField tel2;
    @FXML
    private TextField tel3;
    @FXML
    private TextField email1;
    @FXML
    private TextField email2;
    @FXML
    private TextField email3;
    @FXML
    private ChoiceBox<?> pref1;
    @FXML
    private ChoiceBox<?> pref2;
    @FXML
    private ChoiceBox<?> pref3;
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
    private void salva_f(ActionEvent event) {
    }
    
}
