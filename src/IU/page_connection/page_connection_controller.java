package IU.page_connection;


import FC.Connexion;
import FC.SIR;
import FC.Utilisateur;

import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.menu.menu_controller;
import javafx.event.ActionEvent;
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
        Connexion conn = new Connexion(new Utilisateur(id,mdp));
        SIR sir = new SIR(conn);

        if(conn.isConnect()){
            URL url_accreuil_medecin;
            FXMLLoader loadermenu = new FXMLLoader();
            loadermenu.setLocation(getClass().getResource("/IU/menu/menu.fxml"));
            Parent menu = loadermenu.load();
            //url_accreuil_medecin = new File("IU.acceuil_medecin.acceuil_medecin.fxml").toURL();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
            System.out.println(menu.toString());
            Parent tableViewParent = loader.load();

            Scene tableViewScene = new Scene(tableViewParent);

            //access the controller and call a method
            acceuil_medecin_controller controller = loader.getController();
            System.out.println(controller);
            controller.initData(sir,menu,loadermenu);

            //This line gets the Stage information
            Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
            System.out.println("Connecter");


        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mauvaise connexion");
            alert.setHeaderText("Erreur dans la connexion");
            alert.setContentText("Mot de passe ou ID incorrect !");
            System.out.println("Erreur ici");
            alert.showAndWait();
        }


        /*Utilisateur user = new Utilisateur(nom,mdp);
        ArrayList<Utilisateur> listeMed = new ArrayList<>();
        ArrayList<Utilisateur> listeMan = new ArrayList<>();
        Utilisateur user1 = new Utilisateur("Walton","Jack","1","123");
        Utilisateur user2 = new Utilisateur("Dalton","Max","2","321");
        listeMed.add(user1);
        listeMan.add(user2);
        Connexion connexion = new Connexion(user,listeMed,listeMan);
        if(champ_nomUtilisateur.getText().isEmpty() || champ_motDePasse.getText().isEmpty()){
            button_seConnecter.setText("Erreur");
        }
        else if(connexion.isConnectMed() == true && connexion.isConnectMan() == false){
            URL url_accreuil_medecin;
            //url_accreuil_medecin = new File("IU.acceuil_medecin.acceuil_medecin.fxml").toURL();
            Parent parent = FXMLLoader.load(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();     //pas compris
            stage.setScene(scene);
            stage.show();

            System.out.println("Medecin");

        }
        else{
            if(connexion.isConnectMan() == true && connexion.isConnectMed() == false){
                URL url_accreuil_medecin;
                //url_accreuil_medecin = new File("IU.acceuil_medecin.acceuil_medecin.fxml").toURL();
                Parent parent = FXMLLoader.load(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();     //pas compris
                stage.setScene(scene);
                stage.show();

                System.out.println("Manipulateur");
            }


        }
        if(connexion.isConnectMan() == false && connexion.isConnectMed() == false) {
            System.out.println("Erreur connexion");
        }*/
    }
        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert champ_nomUtilisateur != null : "fx:id=\"champ_nomUtilisateur\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert champ_motDePasse != null : "fx:id=\"champ_motDePasse\" was not injected: check your FXML file 'page_connection.fxml'.";
            assert button_seConnecter != null : "fx:id=\"button_seConnecter\" was not injected: check your FXML file 'page_connection.fxml'.";

        }




    }







