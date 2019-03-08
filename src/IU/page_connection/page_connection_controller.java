package IU.page_connection;


import FC.SIR;
import FC.Utilisateur;

import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.menu.menu_controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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



    @FXML
    private void SeConnecter(ActionEvent e) throws IOException {
        String id = champ_nomUtilisateur.getText();
        String mdp = champ_motDePasse.getText();
        ActionConnexion connexion=new ActionConnexion(id,mdp,e);

    }
        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert champ_nomUtilisateur != null : "fx:id=\"champ_nomUtilisateur\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert champ_motDePasse != null : "fx:id=\"champ_motDePasse\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert button_seConnecter != null : "fx:id=\"button_seConnecter\" was not injected: check your FXML file 'page_connection.fxml'.";
            champ_motDePasse.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    System.out.println(event.getCode());
                   if(event.getCode().toString().equals("ENTER")){
                       try {
                           ActionConnexion connexion = new ActionConnexion(champ_nomUtilisateur.getText(),champ_motDePasse.getText(),event);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }

                   }
                }
            });

        }




    }







