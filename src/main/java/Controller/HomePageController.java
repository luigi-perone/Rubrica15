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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author luigi
 */
public class HomePageController implements Initializable {

    @FXML
    private Menu importa;
    @FXML
    private Menu esporta;
    @FXML
    private Menu nuovoContatto;
    @FXML
    private TextField cerca;
    @FXML
    private Button ordina;
    @FXML
    private ListView<?> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void importa_f(ActionEvent event) {
    }

    @FXML
    private void esporta_f(ActionEvent event) {
    }

    @FXML
    private void nuovo_f(ActionEvent event) {
    }

    @FXML
    private void ordina_f(ActionEvent event) {
    }
    
}