package IU;

import java.net.URL;
import java.util.ResourceBundle;

import FC.Patient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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

    /**
     * Toggle Buttons pour la "recherche par"
     **/

    @FXML // fx:id="toggle_IDPatient"
    private ToggleButton toggle_IDPatient = new ToggleButton("ID Patient");// Value injected by FXMLLoader

    @FXML // fx:id="toggle_medecinPrescripteur"
    private ToggleButton toggle_medecinPrescripteur = new ToggleButton("Médecin Prescripteur"); // Value injected by FXMLLoader

    @FXML // fx:id="toggle_nomPatient"
    private ToggleButton toggle_nomPatient = new ToggleButton("Nom patient)"); // Value injected by FXMLLoader

    @FXML // fx:id="toggle_medecinRadiologue"
    private ToggleButton toggle_medecinRadiologue = new ToggleButton("Médecin Radiologue");

    @FXML // fx:id="toggle_IDExamen"
    private ToggleButton toggle_IDExamen = new ToggleButton("ID Examen");


    /**
     * Bouton consulter tous les DP et bouton ajouter un patient
     * **/
    @FXML // fx:id="button_consulterTousLesDP"
    private Button button_consulterTousLesDP; // Value injected by FXMLLoader

    @FXML // fx:id="button_ajouterPatient"
    private Button button_ajouterPatient = new Button("Ajouter Patient"); // Value injected by FXMLLoader

    /**
     * Colones du tableau
     * **/
    @FXML // fx:id="colonne_IDExamen"
    private TableColumn<?, ?> colonne_IDExamen; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_typeExamen"
    private TableColumn<?, ?> colonne_typeExamen; // Value injected by FXMLLoader

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

    @FXML // fx:id="colonne_patient"
    private TableColumn<?, ?> colonne_patient; // Value injected by FXMLLoader

    @FXML // fx:id="ractangle_recherche"
    private Rectangle ractangle_recherche; // Value injected by FXMLLoader

    @FXML // fx:id="texte_rechercherPar"
    private Text texte_rechercherPar; // Value injected by FXMLLoader

    @FXML // fx:id="tableau_colonnes"
    private TableView<?> tableau_colonnes; // Value injected by FXMLLoader

    @FXML // fx:id="champ_date"
    private DatePicker champ_date; // Value injected by FXMLLoader

    @FXML // fx:id="texte_date"
    private Text texte_date; // Value injected by FXMLLoader


    /**
     * test
     */
    final ObservableList<FC.Patient> data = FXCollections.observableArrayList(
            new Patient("Jacob", "Smith"),
            new Patient("Isabella", "Johnson"),
            new Patient("Ethan", "Williams"),
            new Patient("Emma", "Jones"),
            new Patient("Michael", "Brown")


    @FXML
    void b8cada00(ActionEvent event) {

    }

   /* @FXML
    void 6f6e6ead(ActionEvent event) {

    } */

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
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

        ToggleGroup groupe_toggle_rechercherPar = new ToggleGroup();
        toggle_nomPatient.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_IDPatient.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_medecinPrescripteur.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_medecinRadiologue.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_IDExamen.setToggleGroup(groupe_toggle_rechercherPar);


        public void pressButton_AjouterPatient(ActionEvent e) throws Exception {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IU.ajouter_patient.ajouter_patient.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}







