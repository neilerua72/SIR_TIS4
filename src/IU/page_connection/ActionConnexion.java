package IU.page_connection;

import FC.SIR;
import FC.TypeConnexion;
import FC.Utilisateur;
import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.acceuil_secretaire.secretaire_accueil_controller;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Classe qui permet de se connecter au SIR peut importe la manière dont l'action est déclenché (touche entrée ou le bouton)
 * @author Aurélien
 * @version 1.0
 */
public class ActionConnexion {
    /**
     * Constructeur de la classe qui réalise l'action de la connexion, peut importe la manière dont elle a été déclenché
     * @param id id de l'utilisateur
     * @param mdp mdp de l'utilisateur
     * @param e l'eveneement qui é déclenché la connexion
     * @throws IOException
     */
    public ActionConnexion(String id, String mdp, Event e) throws IOException {
        FC.Connexion conn = new FC.Connexion(new Utilisateur(id,mdp));
        SIR sir = new SIR(conn);

        if(conn.isConnect()){
            if(conn.getType().equals(TypeConnexion.SEC)){
                URL url_accreuil_medecin;
                FXMLLoader loadermenu = new FXMLLoader();
                loadermenu.setLocation(getClass().getResource("/IU/menu/menu.fxml"));
                Parent menu = loadermenu.load();
                //url_accreuil_medecin = new File("IU.acceuil_medecin.acceuil_medecin.fxml").toURL();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/IU/acceuil_secretaire/secretaire_accueil.fxml"));
                System.out.println(menu.toString());
                Parent tableViewParent = loader.load();

                Scene tableViewScene = new Scene(tableViewParent);

                //access the controller and call a method
                secretaire_accueil_controller controller = loader.getController();
                System.out.println(controller);
                controller.initData(sir,menu,loadermenu);

                //This line gets the Stage information
                Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.setTitle("Sinpati - Acceuil");
                window.show();
                System.out.println("Connecter");
            }else{


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
               window.setTitle("Sinpati - Acceuil");
            window.show();
            System.out.println("Connecter");


        }}
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mauvaise connexion");
            alert.setHeaderText("Erreur dans la connexion");
            alert.setContentText("Mot de passe ou ID incorrect !");
            System.out.println("Erreur ici");
            alert.showAndWait();
        }

    }
}
