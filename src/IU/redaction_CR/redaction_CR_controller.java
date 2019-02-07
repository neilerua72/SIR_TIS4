package IU.redaction_CR;

/**
 * Sample Skeleton for 'redaction_CR.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class redaction_CR_controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private DocFlavor.URL location;

    @FXML // fx:id="champ_typeExamenCR"
    private TextField champ_typeExamenCR; // Value injected by FXMLLoader

    @FXML // fx:id="enum_specialitePrescripteurCR"
    private ChoiceBox<?> enum_specialitePrescripteurCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_nomPatientCR"
    private TextField champ_nomPatientCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_coordonneesPrescripteurCR"
    private TextField champ_coordonneesPrescripteurCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_descriptionTechniqueCR"
    private TextArea champ_descriptionTechniqueCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_typeContrasteCR"
    private TextField champ_typeContrasteCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_fonctionRadiologueCR"
    private TextField champ_fonctionRadiologueCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_conclusionCR"
    private TextArea champ_conclusionCR; // Value injected by FXMLLoader

    @FXML // fx:id="toggle_editerCR"
    private ToggleButton toggle_editerCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_prenomPatientCR"
    private TextField champ_prenomPatientCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_resultatCR"
    private TextArea champ_resultatCR; // Value injected by FXMLLoader

    @FXML // fx:id="date_CRCR"
    private DatePicker date_CRCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_prenomPrescripteurCR"
    private TextField champ_prenomPrescripteurCR; // Value injected by FXMLLoader

    @FXML // fx:id="date_examenCR"
    private DatePicker date_examenCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_quantiteContrasteCR"
    private TextField champ_quantiteContrasteCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_resumeProblemeCliniqueCR"
    private TextArea champ_resumeProblemeCliniqueCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_nomJeuneFilleCR"
    private TextField champ_nomJeuneFilleCR; // Value injected by FXMLLoader

    @FXML // fx:id="button_annulerCR"
    private Button button_annulerCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_protocoleStandardiseCR"
    private TextArea champ_protocoleStandardiseCR; // Value injected by FXMLLoader

    @FXML // fx:id="button_validerCR"
    private Button button_validerCR; // Value injected by FXMLLoader

    @FXML // fx:id="enum_sexePatientCR"
    private ChoiceBox<?> enum_sexePatientCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_nomPrescripteurCR"
    private TextField champ_nomPrescripteurCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_comparaisonExamensExterieursCR"
    private TextArea champ_comparaisonExamensExterieursCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_nomRadiologueCR"
    private TextField champ_nomRadiologueCR; // Value injected by FXMLLoader

    @FXML // fx:id="champ_syntheseCR"
    private TextArea champ_syntheseCR; // Value injected by FXMLLoader

    @FXML // fx:id="button_validerBisCR"
    private Button button_validerBisCR; // Value injected by FXMLLoader

    @FXML // fx:id="date_naissancePatientCR"
    private DatePicker date_naissancePatientCR; // Value injected by FXMLLoader


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert champ_typeExamenCR != null : "fx:id=\"champ_typeExamenCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert enum_specialitePrescripteurCR != null : "fx:id=\"enum_specialitePrescripteurCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_nomPatientCR != null : "fx:id=\"champ_nomPatientCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_coordonneesPrescripteurCR != null : "fx:id=\"champ_coordonneesPrescripteurCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_descriptionTechniqueCR != null : "fx:id=\"champ_descriptionTechniqueCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_typeContrasteCR != null : "fx:id=\"champ_typeContrasteCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_fonctionRadiologueCR != null : "fx:id=\"champ_fonctionRadiologueCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_conclusionCR != null : "fx:id=\"champ_conclusionCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert toggle_editerCR != null : "fx:id=\"toggle_editerCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_prenomPatientCR != null : "fx:id=\"champ_prenomPatientCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_resultatCR != null : "fx:id=\"champ_resultatCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert date_CRCR != null : "fx:id=\"date_CRCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_prenomPrescripteurCR != null : "fx:id=\"champ_prenomPrescripteurCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert date_examenCR != null : "fx:id=\"date_examenCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_quantiteContrasteCR != null : "fx:id=\"champ_quantiteContrasteCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_resumeProblemeCliniqueCR != null : "fx:id=\"champ_resumeProblemeCliniqueCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_nomJeuneFilleCR != null : "fx:id=\"champ_nomJeuneFilleCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert button_annulerCR != null : "fx:id=\"button_annulerCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_protocoleStandardiseCR != null : "fx:id=\"champ_protocoleStandardiseCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert button_validerCR != null : "fx:id=\"button_validerCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert enum_sexePatientCR != null : "fx:id=\"enum_sexePatientCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_nomPrescripteurCR != null : "fx:id=\"champ_nomPrescripteurCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_comparaisonExamensExterieursCR != null : "fx:id=\"champ_comparaisonExamensExterieursCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_nomRadiologueCR != null : "fx:id=\"champ_nomRadiologueCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert champ_syntheseCR != null : "fx:id=\"champ_syntheseCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert button_validerBisCR != null : "fx:id=\"button_validerBisCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";
        assert date_naissancePatientCR != null : "fx:id=\"date_naissancePatientCR\" was not injected: check your FXML file 'redaction_CR.fxml'.";

    }

}
