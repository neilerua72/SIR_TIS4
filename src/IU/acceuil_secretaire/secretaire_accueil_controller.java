/**
 * Sample Skeleton for 'secretaire_accueil_controller.fxml' Controller Class
 */


package IU.acceuil_secretaire;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class secretaire_accueil_controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="colonne_CR"
    private TableColumn<?, ?> colonne_CR; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_nomPatient"
    private TableColumn<?, ?> colonne_nomPatient; // Value injected by FXMLLoader

    @FXML // fx:id="button_creationRDV"
    private Button button_creationRDV; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinRadiologue"
    private TableColumn<?, ?> colonne_medecinRadiologue; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinPrescripteur"
    private TableColumn<?, ?> colonne_medecinPrescripteur; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_patient"
    private TableColumn<?, ?> colonne_patient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_dateRDV"
    private TableColumn<?, ?> colonne_dateRDV; // Value injected by FXMLLoader

    @FXML // fx:id="button_ajoutPatient"
    private Button button_ajoutPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_IDPatient"
    private TableColumn<?, ?> colonne_IDPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_prenomPatient"
    private TableColumn<?, ?> colonne_prenomPatient; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert colonne_CR != null : "fx:id=\"colonne_CR\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_nomPatient != null : "fx:id=\"colonne_nomPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert button_creationRDV != null : "fx:id=\"button_creationRDV\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_medecinRadiologue != null : "fx:id=\"colonne_medecinRadiologue\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_medecinPrescripteur != null : "fx:id=\"colonne_medecinPrescripteur\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_dateRDV != null : "fx:id=\"colonne_dateRDV\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert button_ajoutPatient != null : "fx:id=\"button_ajoutPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_prenomPatient != null : "fx:id=\"colonne_prenomPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";

    }
}

