package IU;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;



public class acceuil_medecin_controller {

/**
 * Sample Skeleton for 'acceuil_medecin.fxml' Controller Class
 */


@FXML // ResourceBundle that was given to the FXMLLoader
private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="colonne_CR"
    private TableColumn<?, ?> colonne_CR; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_dossierPatient"
    private TableColumn<?, ?> colonne_dossierPatient; // Value injected by FXMLLoader

    @FXML // fx:id="toggle_IDPatient"
    private ToggleButton toggle_IDPatient;// Value injected by FXMLLoader

    @FXML // fx:id="button_ajouterPatient"
    private Button button_ajouterPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_IDExamen"
    private TableColumn<?, ?> colonne_IDExamen; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_typeExamen"
    private TableColumn<?, ?> colonne_typeExamen; // Value injected by FXMLLoader

    @FXML // fx:id="button_consulterTousLesDP"
    private Button button_consulterTousLesDP; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_IDPatient"
    private TableColumn<?, ?> colonne_IDPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_image"
    private TableColumn<?, ?> colonne_image; // Value injected by FXMLLoader

    @FXML // fx:id="champ_rechercherParNomPatient"
    private TextField champ_rechercherParNomPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_dateExamen"
    private TableColumn<?, ?> colonne_dateExamen; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinRadiologue"
    private TableColumn<?, ?> colonne_medecinRadiologue; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinPrescripteur"
    private TableColumn<?, ?> colonne_medecinPrescripteur; // Value injected by FXMLLoader

    @FXML // fx:id="toggle_medecinPrescripteur"
    private ToggleButton toggle_medecinPrescripteur; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_patient"
    private TableColumn<?, ?> colonne_patient; // Value injected by FXMLLoader

    @FXML // fx:id="ractangle_recherche"
    private Rectangle ractangle_recherche; // Value injected by FXMLLoader

    @FXML // fx:id="texte_rechercherPar"
    private Text texte_rechercherPar; // Value injected by FXMLLoader

    @FXML // fx:id="toggle_nomPatient"
    private ToggleButton toggle_nomPatient; // Value injected by FXMLLoader

    @FXML // fx:id="tableau_colonnes"
    private TableView<?> tableau_colonnes; // Value injected by FXMLLoader

    @FXML // fx:id="champ_date"
    private DatePicker champ_date; // Value injected by FXMLLoader

    @FXML // fx:id="texte_date"
    private Text texte_date; // Value injected by FXMLLoader

    @FXML
    void b8cada00(ActionEvent event) {

    }

   /* @FXML
    void 6f6e6ead(ActionEvent event) {

    } */

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert colonne_CR != null : "fx:id=\"colonne_CR\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_dossierPatient != null : "fx:id=\"colonne_dossierPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert toggle_IDPatient != null : "fx:id=\"toggle_IDPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert button_ajouterPatient != null : "fx:id=\"button_ajouterPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_IDExamen != null : "fx:id=\"colonne_IDExamen\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_typeExamen != null : "fx:id=\"colonne_typeExamen\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert button_consulterTousLesDP != null : "fx:id=\"button_consulterTousLesDP\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_image != null : "fx:id=\"colonne_image\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert champ_rechercherParNomPatient != null : "fx:id=\"champ_rechercherParNomPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_dateExamen != null : "fx:id=\"colonne_dateExamen\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_medecinRadiologue != null : "fx:id=\"colonne_medecinRadiologue\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_medecinPrescripteur != null : "fx:id=\"colonne_medecinPrescripteur\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert toggle_medecinPrescripteur != null : "fx:id=\"toggle_medecinPrescripteur\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert ractangle_recherche != null : "fx:id=\"ractangle_recherche\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert texte_rechercherPar != null : "fx:id=\"texte_rechercherPar\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert toggle_nomPatient != null : "fx:id=\"toggle_nomPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert tableau_colonnes != null : "fx:id=\"tableau_colonnes\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert champ_date != null : "fx:id=\"champ_date\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert texte_date != null : "fx:id=\"texte_date\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";

    }



    }




