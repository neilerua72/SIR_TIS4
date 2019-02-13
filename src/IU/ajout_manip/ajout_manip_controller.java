package IU.ajout_manip;

/**
 * Sample Skeleton for 'ajout_manip.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ajout_manip_controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button_editionImage"
    private Button button_editionImage; // Value injected by FXMLLoader

    @FXML // fx:id="champ_vueManip"
    private TextField champ_vueManip; // Value injected by FXMLLoader

    @FXML // fx:id="button_validerManipulation"
    private Button button_validerManipulation; // Value injected by FXMLLoader

    @FXML // fx:id="choice_uniteDoseManip"
    private ChoiceBox<?> choice_uniteDoseManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_doseRecueManip"
    private TextField champ_doseRecueManip; // Value injected by FXMLLoader

    @FXML // fx:id="choice_sexePatientManip"
    private ChoiceBox<?> choice_sexePatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="choice_typeExamManip"
    private ChoiceBox<?> choice_typeExamManip; // Value injected by FXMLLoader

    @FXML // fx:id="button_acquisitionImage"
    private Button button_acquisitionImage; // Value injected by FXMLLoader

    @FXML // fx:id="champ_nomPatientManip"
    private TextField champ_nomPatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="date_examenManip"
    private DatePicker date_examenManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_idExamManip"
    private TextField champ_idExamManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_lateraliteManip"
    private TextField champ_lateraliteManip; // Value injected by FXMLLoader

    @FXML // fx:id="button_annulerEdition"
    private Button button_annulerEdition; // Value injected by FXMLLoader

    @FXML // fx:id="date_naissancePatientManip"
    private DatePicker date_naissancePatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_manipulateurManip"
    private TextField champ_manipulateurManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_idPatienManip"
    private TextField champ_idPatienManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_medecinPrescripteurManip"
    private TextField champ_medecinPrescripteurManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_prenomPatientManip"
    private TextField champ_prenomPatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_medecinRadiologueManip"
    private TextField champ_medecinRadiologueManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_zoneEtudieeManip"
    private TextField champ_zoneEtudieeManip; // Value injected by FXMLLoader


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert button_editionImage != null : "fx:id=\"button_editionImage\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_vueManip != null : "fx:id=\"champ_vueManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert button_validerManipulation != null : "fx:id=\"button_validerManipulation\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert choice_uniteDoseManip != null : "fx:id=\"choice_uniteDoseManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_doseRecueManip != null : "fx:id=\"champ_doseRecueManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert choice_sexePatientManip != null : "fx:id=\"choice_sexePatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert choice_typeExamManip != null : "fx:id=\"choice_typeExamManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert button_acquisitionImage != null : "fx:id=\"button_acquisitionImage\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_nomPatientManip != null : "fx:id=\"champ_nomPatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert date_examenManip != null : "fx:id=\"date_examenManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_idExamManip != null : "fx:id=\"champ_idExamManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_lateraliteManip != null : "fx:id=\"champ_lateraliteManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert button_annulerEdition != null : "fx:id=\"button_annulerEdition\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert date_naissancePatientManip != null : "fx:id=\"date_naissancePatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_manipulateurManip != null : "fx:id=\"champ_manipulateurManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_idPatienManip != null : "fx:id=\"champ_idPatienManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_medecinPrescripteurManip != null : "fx:id=\"champ_medecinPrescripteurManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_prenomPatientManip != null : "fx:id=\"champ_prenomPatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_medecinRadiologueManip != null : "fx:id=\"champ_medecinRadiologueManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_zoneEtudieeManip != null : "fx:id=\"champ_zoneEtudieeManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";

    }
}
