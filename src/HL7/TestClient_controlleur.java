package HL7;

import api.Generator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import library.interfaces.Patient;
import library.interfaces.ServeurHL7;
import library.structure.groupe.messages.Message;

public class TestClient_controlleur {
    @FXML
    private Button connect;

    @FXML
    private Button deconnect;

    @FXML
    private TextField port;

    @FXML
    private Label id;

    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    @FXML
    private Label datenaiss;

    @FXML
    private Label sexe;

    @FXML
    private Label typeexam;

    private Patient patient;
    private Message message;
    private ServeurHL7 c;
    private Generator g;

    void initialize() {
        this.patient = null;
        this.message = null;
    }

    @FXML
    private void Connecter(){
        Integer port = Integer.parseInt(this.port.getText());
        c = new ServeurHL7();
        c.connection(port);
        c.ecoute();
        String messageHL7 = c.protocole();

        if(messageHL7.contains("Emergency")){
            System.out.println("erreur");
           // System.out.println("Reçu :" + messageHL7.replace("Emergency", "IRM"));
        }

        this.patient = c.getPatient();
        this.message = c.getMessage();

        //type d'examen radiologique
        if(patient.getPatClass() == "Emergency"){
        this.typeexam.setText("Type Examen: " + "IRM");}
        if(patient.getPatClass() == "Inpatient"){
            this.typeexam.setText("Type Examen: " + "Scanner");}
        if(patient.getPatClass() == "Outpatient"){
            this.typeexam.setText("Type Examen: " + "Radio");}
        this.id.setText("Id Patient :" + patient.getID());
        this.nom.setText("Nom : " + patient.getFamillyName());

        if (patient.getFirstName() != null) {
            this.prenom.setText("Prénom : " + patient.getFirstName());
        }

        if (patient.getBirth() != null) {
            this.datenaiss.setText("Né le : " + patient.getBirth().toString());
        }

        if (patient.getSex() != null) {
            this.sexe.setText("Sexe : " + patient.getSex());}

    }
}
