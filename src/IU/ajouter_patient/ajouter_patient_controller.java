package IU.ajouter_patient;

import BD.ConnexionBase;
import FC.*;
import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.acceuil_secretaire.secretaire_accueil_controller;
import IU.liste_patient_secretaire.liste_patient_secretaire_controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;




public class ajouter_patient_controller implements Initializable {
    SIR sir;

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

    @FXML // fx:id="ajoutpatient_champ_serviceAcceuil"
    private TextField ajoutpatient_champ_serviceAcceuil; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_prenom"
    private TextField ajoutpatient_champ_prenom; // Value injected by FXMLLoader

    @FXML // fx:id="ajoutpatient_champ_medecinPrescripteur"
    private TextField ajoutpatient_champ_medecinPrescripteur; // Value injected by FXMLLoader

    @FXML // fx:id="button_valider"
    private Button button_valider; // Value injected by FXMLLoader

    @FXML //fx:id ="ajoutpatient_champ_Rue"
    private TextField ajoutpatient_champ_Rue;

    @FXML //fx:id="ajoutPatient_champ_InfoComp"
    private TextField ajoutPatient_champ_InfoComp;

    @FXML //fx:id="date_naissancePatient""
    private DatePicker date_naissancePatient;

    @FXML // fx:id="ajoutpatient_champ_IDPatient"
    private TextField ajoutpatient_champ_IDPatient; // Value injected by FXMLLoader

    @FXML //fx:id="ajoutPatient_champVille"
    private TextField ajoutPatient_champVille;

    @FXML //fx:id="ajoutPatient_champ_CodePostal"
    private TextField ajoutPatient_champ_CodePostal;

    @FXML //fx:id="ajoutpatient_champ_email"
    private TextField ajoutpatient_champ_email;

    @FXML //fx:id="ajoutpatient_champ_telephonePortable"
    private TextField ajoutpatient_champ_telephonePortable;


    private Stage ajoutPatientStage;
    private Patient patient;
    private boolean validerClicked = false;
    Parent menu;
    FXMLLoader loader;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources) {
        assert ajoutpatient_champ_nom != null : "fx:id=\"ajoutpatient_champ_nom\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert button_annuler != null : "fx:id=\"button_annuler\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_adresse != null : "fx:id=\"ajoutpatient_champ_adresse\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_serviceAcceuil != null : "fx:id=\"ajoutpatient_champ_serviceAcceuil\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_prenom != null : "fx:id=\"ajoutpatient_champ_prenom\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_medecinPrescripteur != null : "fx:id=\"ajoutpatient_champ_medecinPrescripteur\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert button_valider != null : "fx:id=\"button_valider\" was not injected: check your FXML file 'ajouter_patient.fxml'.";
        assert ajoutpatient_champ_IDPatient != null : "fx:id=\"ajoutpatient_champ_IDPatient\" was not injected: check your FXML file 'ajouter_patient.fxml'.";

    }

    public void initData(SIR sir,Parent menu, FXMLLoader loader){
        this.sir=sir;
        this.menu=menu;
        this.loader=loader;
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

        String rue = ajoutpatient_champ_Rue.getText();
        String medecinPrescripteur = ajoutpatient_champ_medecinPrescripteur.getText();
        String serviceAcceuil = ajoutpatient_champ_serviceAcceuil.getText();
        LocalDate dateNaissancePatient = date_naissancePatient.getValue();
        Date resultDate = Date.from(dateNaissancePatient.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        java.sql.Date gooddate = new java.sql.Date(resultDate.getTime());
        String ville = ajoutPatient_champVille.getText();
        String info= ajoutPatient_champ_InfoComp.getText();
        String codeP= ajoutPatient_champ_CodePostal.getText();
        String email= ajoutpatient_champ_email.getText();
        String telephone = ajoutpatient_champ_telephonePortable.getText();

        if(nom.length()==0||prenom.length()==0||rue.length()==0||medecinPrescripteur.length()==0||serviceAcceuil.length()==0||gooddate.toString().length()==0||ville.length()==0||codeP.length()==0||email.length()==0||telephone.length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Impossible de rajouter le patient");
            alert.setHeaderText("Erreur de saisie");
            alert.setContentText("Une des cases n'est pas remplie");

            alert.showAndWait();
        }

        else if(!codeP.matches("[0-9]+")||codeP.length()>5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Impossible de rajouter le patient");
            alert.setHeaderText("Erreur de saisie");
            alert.setContentText("Le code postale que vous avez tapez ne contient pas uniquement des chiffres, ou dépasse 5 caractères");

            alert.showAndWait();
        }else if (!telephone.matches("[0-9]+")||telephone.length()>10){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Impossible de rajouter le patient");
            alert.setHeaderText("Erreur de saisie");
            alert.setContentText("Le numéro de téléphone que vous avez tapez ne contient pas uniquement des chiffres, ou dépasse 10 caractères");

        }
        else{
        int idPat=(int)(Math.random() * ( 999999 - 100000 )+1);
        while(sir.checkIdPatient(idPat)){
            idPat = 0+(int)(Math.random()*((999999-0)+1));
        }
        System.out.println(idPat);
        String idPatient= String.valueOf(idPat);
        Patient p = new Patient(nom,prenom,idPat,gooddate,email,Integer.valueOf(telephone),new Adresse(rue,info,Integer.parseInt(codeP),ville),serviceAcceuil,medecinPrescripteur);
        sir.getListePatient().add(p);
        System.out.println(idPatient);
        Connection connexion = null;
        Statement statement = null;

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete d'écriture
            int statut = statement.executeUpdate("INSERT INTO `Patient` (`nom`, `prenom`, `id`, `dateDeNaissance`, `mail`, `numeroTel`, `rue`, `infoComp`, `codePostal`, `ville`, `pathologie`, `nomMedecinPrescripteur`, `serviceAcceuil`, `dateRDV`) VALUES\n" +
                    "('"+nom+"', '"+prenom+"','"+idPatient+"','"+dateNaissancePatient+"','"+email+"','"+telephone+"','"+rue+"','"+info+"','"+codeP+"','"+ville+"', NULL,'"+medecinPrescripteur+"','"+serviceAcceuil+"', NULL);");
            //Récupération des données du statut de la requete d'écriture
            System.out.println("Résultat de la requête d'insertion:" +statut + ".");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }


        }

        if(sir.getConnexion().getType().equals(TypeConnexion.SEC)) {
            FXMLLoader loadera = new FXMLLoader();
            loadera.setLocation(getClass().getResource("/IU/liste_patient_secretaire/liste_patient_secretaire.fxml"));
            Parent root = loadera.load();
            liste_patient_secretaire_controller secretaire_accueil_controller = loadera.getController();
            secretaire_accueil_controller.initData(sir, menu, loader);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();     //pas compris
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText("Le patient a bien été ajouté");


            alert.showAndWait();
            stage.setScene(scene);

            stage.show();
        }
        else{
            FXMLLoader loadera = new FXMLLoader();
            loadera.setLocation(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
            Parent root = loadera.load();
            acceuil_medecin_controller acceuil_medecin_controller= loadera.getController();
            acceuil_medecin_controller.initData(sir, menu, loader);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();     //pas compris

            stage.setScene(scene);
            stage.show();
        }
    }
    }
}


