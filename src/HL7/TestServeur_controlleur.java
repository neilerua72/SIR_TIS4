package HL7;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import ClassTable.TableExamen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.interfaces.*;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.util.logging.Level;
import IU.acceuil_medecin.acceuil_medecin_controller;
public class TestServeur_controlleur {
    private Patient patient;
    private final SimpleDateFormat formateur = new SimpleDateFormat("yyyy-MM-dd");







    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Nom"
    private TextField Nom;

    @FXML // fx:id="identification"
    private TextField identification;

    @FXML //fx:id="prenom"
    private TextField prenom;

    @FXML //fx:id="Date_Naissance"
    private TextField Date_Exam;

    @FXML
    private TextField TypeExamen;

    @FXML
    private TextField MedPrescripteur;

    @FXML
    private TextField MedRadio;

    @FXML
    private TextField IDExam;

    @FXML //fx:id="Admettre"
    private Button Admettre ;

    @FXML
    private Button Connecter ;

    @FXML
    private Label l1 ;

    @FXML
    private Label l2 ;

    @FXML
    private Label l3 ;

    @FXML
    private TextField host;

    @FXML
    private TextField port;


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }

    //remplissage champs texte avec les données de la table acceuil medecin
    public void transferNom(String message) {

        Nom.setText(message);
    }
    public void transferPrenom(String message) {
        prenom.setText(message);
    }

    public void transferID(int message) {
        identification.setText(String.valueOf(message));
    }

    public void transferIDExam(String message) {
        IDExam.setText(String.valueOf(message));
    }
    public void transferDate(Date message) {
        Date_Exam.setText(message.toString());
    }
    public void transferMedPresc(String message) {
        MedPrescripteur.setText(message);
    }
    public void transferMedRadio(String message) {
        MedRadio.setText(message);
    }
    public void transferType(String message) {
        TypeExamen.setText(message);
    }

    //set couleurs des camps par defaut
    private void initBackgroundField() {
        this.identification.setStyle("-fx-background-color: white;");   //changer couleur champ texte
        this.Nom.setStyle("-fx-background-color: white;");
       // this.Date_Exam.setStyle("-fx-background-color: white;");

    }

//methode qui verifie si les champs sont bien remplis avant d'envoyer le message
    private boolean champsPatOk() {
        boolean r = true;
        this.initBackgroundField();

        if (this.Nom.getText().length() == 0) {
            r = false;
            this.Nom.setStyle("-fx-background-color: red;"); //met le champ en rouge si pas rempli
        }
        String s = this.identification.getText();
        int t = s.length();
        if (t == 0) {
            r = false;
            this.identification.setStyle("-fx-background-color: red;");
        }

        for (int i = 0; i < t; i++) {
            if (s.charAt(i) != '0' & s.charAt(i) != '1' & s.charAt(i) != '2' &
                    s.charAt(i) != '3' & s.charAt(i) != '4' & s.charAt(i) != '5' &
                    s.charAt(i) != '6' & s.charAt(i) != '7' & s.charAt(i) != '8' & s.charAt(i) != '9') {
                r = false;
                this.identification.setStyle("-fx-background-color: red;"); //met champs en rouge si rempli avec autres caracteres que les chiffres
            }
        }
        return r;

    }

//cree le patien qui sera ensuite envoyé
        private void creePatient() {
        try {
            //Nom de famille
            String surname;
            if (!(this.Nom.getText().length() < 0)) {
                surname = this.Nom.getText();


                Integer id = Integer.parseInt(this.identification.getText());

                String classePat = this.TypeExamen.getText();
                char classe = 'U';

                if(classePat == "IRM"){
                    classe = 'E';
                }
                if(classePat == "Scanner"){
                    classe = 'I';
                }

                if(classePat == "Radio"){
                    classe = 'O';
                }

                this.patient = new Patient(id, surname, classe); //creation du patient avec id, nom et type d'examen
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur d'identification patient : " + e.getMessage());
        }

    }
//methode pour recuperer les infos qui seront envoyés
    private PatientLocation setValPatLoc(PatientLocation patLocation) {

        //Type examen
        String field = this.TypeExamen.getText();
        if (field != null) {
            patLocation.setPointOfCare(field);
        }
        //Medecin Radiologue
        field = this.MedRadio.getText();
        if (field != null) {
            patLocation.setRoom(field);
        }

        //Medecin prescripteur
        field = this.MedPrescripteur.getText();
        if (field != null) {
            patLocation.setBed(field);
        }
        //id examen
        field = this.IDExam.getText();
        if (field != null) {
            patLocation.setBuilding(field);
        }
        return patLocation;
    }


//set prenom du patient et la date de son examen
    private void setValPatient() {
        //Prénom de famille
        this.patient.setFirstName(this.prenom.getText());


        //Date de Exam
        Date dateBirth = null;
        String s = this.Date_Exam.getText();
        try {
            if (!s.equals("  /  /    ")) {
                dateBirth = formateur.parse(s);
                this.patient.setBirth(dateBirth);
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestServeur_controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }

        PatientLocation assignedLocation = new PatientLocation(this.patient);
        assignedLocation = this.setValPatLoc(assignedLocation);
        this.patient.setAssignedPatLocation(assignedLocation);
    }


   /* @FXML
    private void Connecter()  throws IOException{
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TestClient.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();
    }*/

   //envoie du message
    @FXML
    private void Admission() {
        if (this.champsPatOk()) {

            this.creePatient();

            this.setValPatient();




            String host = this.host.getText();
            Integer port = Integer.parseInt(this.port.getText());
            ClientHL7 c = new ClientHL7();
            c.connexion(host, port);
            c.admit(patient);
           // MessageInterface messageAck = c.getMsg();
          /*  this.l1.setText("ID message : " + messageAck.getId());
            this.l2.setText(messageAck.getAcknowledgmentCodeString());
            this.l3.setText("ID Ack: " + messageAck.getIdAck());*/

        }

    }

}
