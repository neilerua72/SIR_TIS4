package IU.ajouter_patient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class ajouter_patient_controller {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private DocFlavor.URL location;

    @FXML // fx:id="ajoutpatient_champ_nom"
    private TextField ajoutpatient_champ_nom; // Value injected by FXMLLoader

    @FXML // fx:id="button_annuler"
    private Button button_annuler; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_adresse"
    private TextField ajoutpatient_champ_adresse; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_medecinRadiologue"
    private TextField ajoutpatient_champ_medecinRadiologue; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_prenom"
    private TextField ajoutpatient_champ_prenom; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_medecinPrescripteur"
    private TextField ajoutpatient_champ_medecinPrescripteur; // Value injected by FXMLLoader

    @FXML // fx:id="button_valider"
    private Button button_valider; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_IDPatient"
    private TextField ajoutpatient_champ_IDPatient; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ajoutpatient_champ_nom != null : "fx:id=\"ajoutpatient_champ_nom\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert button_annuler != null : "fx:id=\"button_annuler\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_adresse != null : "fx:id=\"ajoutpatient_champ_adresse\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_medecinRadiologue != null : "fx:id=\"ajoutpatient_champ_medecinRadiologue\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_prenom != null : "fx:id=\"ajoutpatient_champ_prenom\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_medecinPrescripteur != null : "fx:id=\"ajoutpatient_champ_medecinPrescripteur\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert button_valider != null : "fx:id=\"button_valider\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_IDPatient != null : "fx:id=\"ajoutpatient_champ_IDPatient\" was not injected: check your FXML file 'ajouter_patient.fxml'.";

    }

}


