package IU.ajouter_patient;

import BD.ConnexionBase;
import FC.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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


    private Stage ajoutPatientStage;
    private Patient patient;
    private boolean validerClicked = false;

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

  /*  public void setAjoutPatientStage(Stage dialogStage){
        this.ajoutPatientStage = dialogStage;
    }

    public void setPatient(Patient person) {
        this.patient = person;

        ajoutpatient_champ_prenom.setText(patient.getNom());
        ajoutpatient_champ_nom.setText(patient.getPrenom());
    }*/

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
 /*   public boolean isValiderClicked() {
        return validerClicked;
    }

    *//**
     * Called when the user clicks Valider.
     *//*
    private void handleValider() {
        if (isInputValid()) {
            patient.setPrenom(ajoutpatient_champ_prenom.getText());
            patient.setNom( ajoutpatient_champ_nom.getText());

            validerClicked = true;
            ajoutPatientStage.close();
        }
    }*/


    /**
     * Called when the user clicks Annuler.
     */
    @FXML
    private void handleCancel() {
        ajoutPatientStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (ajoutpatient_champ_prenom.getText() == null || ajoutpatient_champ_nom.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(ajoutPatientStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    public void ajoutPatient(ActionEvent actionEvent) throws IOException {
        String nom = ajoutpatient_champ_nom.getText();
        String prenom = ajoutpatient_champ_prenom.getText();
        String idPatient = ajoutpatient_champ_IDPatient.getText();
        String adresse = ajoutpatient_champ_adresse.getText();
        String medecinPrescripteur = ajoutpatient_champ_medecinPrescripteur.getText();
        String nomRadiologue = ajoutpatient_champ_medecinRadiologue.getText();

        Connection connexion = null;
        Statement statement = null;

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete d'écriture
            int statut = statement.executeUpdate("INSERT INTO `Patient` (`nom`, `prenom`, `id`, `dateDeNaissance`, `mail`, `numeroTel`, `rue`, `infoComp`, `codePostal`, `ville`, `pathologie`, `nomMedecinPrescripteur`, `serviceAcceuil`, `dateRDV`) VALUES\n" +
                    "('Techer', 'Leslie', 234567, '1995-02-08', 'Leslie.Techer@gmail.com', 062350563, '26 chemin de la réunion', NULL, 69007, 'Lyon', 'Fracture', 'Cohen', 'Urgence', '2019-02-09 10:00:00');");
            //Récupération des données du statut de la requete d'écriture
            System.out.println("Résultat de la requête d'insertion:" +statut + ".");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (statement != null) {
                try {
                    /* Puis on ferme le Statement */
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connexion != null) {
                try {
                    /* Et enfin on ferme la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }


    }
}


