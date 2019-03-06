package IU.afficher_dossiers_patient;


/**
 * Sample Skeleton for 'afficher_dossiers_patient.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.swing.text.html.ImageView;

public class afficher_dossiers_patient_controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="toggle_medecinRadiologue"
    private ToggleButton toggle_medecinRadiologue; // Value injected by FXMLLoader

    @FXML // fx:id="toggle_IDPatient"
    private ToggleButton toggle_IDPatient; // Value injected by FXMLLoader

    @FXML // fx:id="listView_imagesExam"
    private ListView<ImageView> listView_imagesExam = new ListView<ImageView>(); // Value injected by FXMLLoader

    ;
    ObservableList<ImageView> items = FXCollections.observableArrayList();

    @FXML // fx:id="colonne_IDPatient"
    private TableColumn<?, ?> colonne_IDPatient; // Value injected by FXMLLoader

    @FXML // fx:id="champ_rechercherParNomPatient"
    private TextField champ_rechercherParNomPatient; // Value injected by FXMLLoader

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

    @FXML // fx:id="listView_examensRealises"
    private ListView<?> listView_examensRealises; // Value injected by FXMLLoader

    @FXML // fx:id="texte_date"
    private Text texte_date; // Value injected by FXMLLoader


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert toggle_medecinRadiologue != null : "fx:id=\"toggle_medecinRadiologue\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_IDPatient != null : "fx:id=\"toggle_IDPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert listView_imagesExam != null : "fx:id=\"listView_imagesExam\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert champ_rechercherParNomPatient != null : "fx:id=\"champ_rechercherParNomPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_medecinRadiologue != null : "fx:id=\"colonne_medecinRadiologue\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_medecinPrescripteur != null : "fx:id=\"colonne_medecinPrescripteur\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_medecinPrescripteur != null : "fx:id=\"toggle_medecinPrescripteur\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert ractangle_recherche != null : "fx:id=\"ractangle_recherche\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert texte_rechercherPar != null : "fx:id=\"texte_rechercherPar\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_nomPatient != null : "fx:id=\"toggle_nomPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert tableau_colonnes != null : "fx:id=\"tableau_colonnes\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert champ_date != null : "fx:id=\"champ_date\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert listView_examensRealises != null : "fx:id=\"listView_examensRealises\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert texte_date != null : "fx:id=\"texte_date\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";

    }
}


