package IU.page_connection;


import FC.Connexion;
import FC.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
        String nom = champ_nomUtilisateur.getText();
        String mdp = champ_motDePasse.getText();
        Utilisateur user = new Utilisateur(nom,mdp);
        ArrayList<Utilisateur> listeUsers = new ArrayList<>();
        Utilisateur user1 = new Utilisateur("Walton","Jack","1","123");
        listeUsers.add(user1);
        Connexion connexion = new Connexion(user,listeUsers);
        if(champ_nomUtilisateur.getText().isEmpty() || champ_motDePasse.getText().isEmpty()){
            button_seConnecter.setText("Erreur");
        }
        else if(connexion.isConnect()){
            URL url_accreuil_medecin;
            //url_accreuil_medecin = new File("IU.acceuil_medecin.acceuil_medecin.fxml").toURL();
            Parent parent = FXMLLoader.load(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();     //pas compris
            stage.setScene(scene);
            stage.show();

        }
        else{
            System.out.println("Erreur mdp");

        }
    }
        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert champ_nomUtilisateur != null : "fx:id=\"champ_nomUtilisateur\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert champ_motDePasse != null : "fx:id=\"champ_motDePasse\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert button_seConnecter != null : "fx:id=\"button_seConnecter\" was not injected: check your FXML file 'page_connection.fxml'.";

        }

    }







