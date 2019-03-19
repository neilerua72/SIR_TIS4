package IU.afficher_dossiers_patient;


/**
 * Sample Skeleton for 'afficher_dossiers_patient.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ClassTable.TableExamen;
import ClassTable.TablePatient;
import FC.Patient;
import FC.SIR;
import IU.menu.menu_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.swing.text.html.ImageView;

public class afficher_dossiers_patient_controller {

    @FXML
    private ToggleButton toggle_medecinRadiologue;

    @FXML
    private ToggleButton toggle_IDPatient;

    @FXML
    private Text text_comparaisonExamensExterieursCR;

    @FXML
    private TableColumn<?, ?> colonne_nom;

    @FXML
    private Text text_typeContrasteCR;

    @FXML
    private TextField champ_rechercherParNomPatient;

    @FXML
    private TableView<TableExamen> listeExam;

    @FXML
    private TableColumn<?, ?> colonne_prenom;

    @FXML
    private TableColumn<?, ?> colonne_patient;

    @FXML
    private Text text_nomJeuneFilleCR;

    @FXML
    private Text text_prenomPrescripteurCR;

    @FXML
    private Text text_descriptionTechniqueCR;

    @FXML
    private TableView<Patient> tableau_colonnes;

    @FXML
    private Text text_specialiteRadiologueCR;

    @FXML
    private ListView<?> listView_examensRealises;

    @FXML
    private Text date_CRCR;

    @FXML
    private Text text_quantiteContrasteCR;

    @FXML
    private Text text_resumeProblemeCliniqueCR;

    @FXML
    private Text date_examenCR;

    @FXML
    private Text texte_date;

    @FXML
    private Text text_syntheseCR;

    @FXML
    private Text text_prenomPatientCR;

    @FXML
    private Text text_nomPatientCR;

    @FXML
    private ListView<?> listView_imagesExam;

    @FXML
    private Text text_nomRadiologueCR;

    @FXML
    private TableColumn<?, ?> colonne_IDPatient;

    @FXML
    private Text text_typeExamenCR;

    @FXML
    private Text text_nomPrescripteurCR;

    @FXML
    private Text text_specialitePrescripteurCR;

    @FXML
    private Text text_coordonneesPrescripteurCR;

    @FXML
    private Text text_conclusionCR;

    @FXML
    private Text text_sexePatientCR;

    @FXML
    private Text text_protocoleStandardiseCR;

    @FXML
    private ToggleButton toggle_medecinPrescripteur;

    @FXML
    private Text text_resultatCR;

    @FXML
    private Rectangle ractangle_recherche;

    @FXML
    private Text texte_rechercherPar;

    @FXML
    private ToggleButton toggle_nomPatient;

    @FXML
    private DatePicker champ_date;

    @FXML
    private Text date_naissancePatientCR;
    @FXML
    private TableColumn<?, ?> colonne_date;

    @FXML
    private TableColumn<?, ?> colonne_prescri;
    @FXML
    private TableColumn<?, ?> colonne_type;
    @FXML
    private TableColumn<?, ?> colonne_radio;


    FXMLLoader loadermenu;
    Parent menu;
    SIR sir;


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert toggle_medecinRadiologue != null : "fx:id=\"toggle_medecinRadiologue\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_IDPatient != null : "fx:id=\"toggle_IDPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert listView_imagesExam != null : "fx:id=\"listView_imagesExam\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert champ_rechercherParNomPatient != null : "fx:id=\"champ_rechercherParNomPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_medecinPrescripteur != null : "fx:id=\"toggle_medecinPrescripteur\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert ractangle_recherche != null : "fx:id=\"ractangle_recherche\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert texte_rechercherPar != null : "fx:id=\"texte_rechercherPar\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_nomPatient != null : "fx:id=\"toggle_nomPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert tableau_colonnes != null : "fx:id=\"tableau_colonnes\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert champ_date != null : "fx:id=\"champ_date\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert listView_examensRealises != null : "fx:id=\"listView_examensRealises\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert texte_date != null : "fx:id=\"texte_date\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        tableau_colonnes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showListeExam(newValue));

    }


    public void initData(SIR sir, Parent menu, FXMLLoader loadermenu){
        this.sir=sir;
        this.menu=menu;
        this.loadermenu=loadermenu;
        Patient patient =sir.getListePatient().get(0);
        final ObservableList<Patient> data= FXCollections.observableArrayList(patient);

        for(int i=1;i<sir.getListePatient().size();i++){
            data.add(sir.getListePatient().get(i));
        }
        menu_controller menu_controller = loadermenu.getController();
        menu_controller.initData(sir);

        colonne_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableau_colonnes.setItems(data);





    }


    public void showListeExam(Patient patient){
        ArrayList<TableExamen> listetableExamen = new ArrayList<>(sir.getTableExamenFromIdPatient(patient.getId()));
        if(listetableExamen.size()!=0){
            TableExamen tableExamen = listetableExamen.get(0);
            final ObservableList<TableExamen> data= FXCollections.observableArrayList(tableExamen);
            for(int i=1;i<listetableExamen.size();i++){
                data.add(listetableExamen.get(i));
            }
            colonne_date.setCellValueFactory(new PropertyValueFactory<>("dateExamen"));
            colonne_prescri.setCellValueFactory(new PropertyValueFactory<>("medecinprescri"));
            colonne_radio.setCellValueFactory(new PropertyValueFactory<>("medecinradio"));
            colonne_type.setCellValueFactory(new PropertyValueFactory<>("typeExam"));
            listeExam.setItems(data);

        }
    }


}


