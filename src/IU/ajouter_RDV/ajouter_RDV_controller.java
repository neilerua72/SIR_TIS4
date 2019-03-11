/**
 * Sample Skeleton for 'ajouter_RDV.fxml' Controller Class
 */

package IU.ajouter_RDV;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ajouter_RDV_controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="text_IDPatient"
    private Text text_IDPatient; // Value injected by FXMLLoader

    @FXML // fx:id="date_Examen"
    private DatePicker date_Examen; // Value injected by FXMLLoader

    @FXML // fx:id="text_prenomPatient"
    private Text text_prenomPatient; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutPatient_champVille"
    private TextField ajoutPatient_champVille; // Value injected by FXMLLoader

    @FXML // fx:id="button_annuler"
    private Button button_annuler; // Value injected by FXMLLoader

    @FXML // fx:id="text_nomPatient"
    private Text text_nomPatient; // Value injected by FXMLLoader

    @FXML // fx:id="date_RDV"
    private DatePicker date_RDV; // Value injected by FXMLLoader

    @FXML // fx:id="button_valider"
    private Button button_valider; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_Rue"
    private TextField ajoutpatient_champ_Rue; // Value injected by FXMLLoader

    @FXML // fx:id="date_naissancePatient"
    private DatePicker date_naissancePatient; // Value injected by FXMLLoader


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert text_IDPatient != null : "fx:id=\"text_IDPatient\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert date_Examen != null : "fx:id=\"date_Examen\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert text_prenomPatient != null : "fx:id=\"text_prenomPatient\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert ajoutPatient_champVille != null : "fx:id=\"ajoutPatient_champVille\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert button_annuler != null : "fx:id=\"button_annuler\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert text_nomPatient != null : "fx:id=\"text_nomPatient\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert date_RDV != null : "fx:id=\"date_RDV\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert button_valider != null : "fx:id=\"button_valider\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert ajoutpatient_champ_Rue != null : "fx:id=\"ajoutpatient_champ_Rue\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";
        assert date_naissancePatient != null : "fx:id=\"date_naissancePatient\" was not injected: check your FXML file 'ajouter_RDV.fxml'.";

    }
}

