package IU.page_connection;


import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class page_connection_controller {

/**
 * Sample Skeleton for 'page_connection.fxml' Controller Class
 */


        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="champ_nomUtilisateur"
        private TextField champ_nomUtilisateur; // Value injected by FXMLLoader

        @FXML // fx:id="champ_motDePasse"
        private PasswordField champ_motDePasse; // Value injected by FXMLLoader

        @FXML // fx:id="button_seConnecter"
        private Button button_seConnecter; // Value injected by FXMLLoader

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert champ_nomUtilisateur != null : "fx:id=\"champ_nomUtilisateur\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert champ_motDePasse != null : "fx:id=\"champ_motDePasse\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert button_seConnecter != null : "fx:id=\"button_seConnecter\" was not injected: check your FXML file 'page_connection.fxml'.";

        }
    }







