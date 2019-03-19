package HL7;

import api.Generator;
import com.sun.xml.internal.ws.server.ServerRtException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import library.interfaces.Patient;
import library.interfaces.PatientLocation;
import library.interfaces.ServeurHL7;
import library.structure.groupe.messages.Message;
import sun.util.calendar.BaseCalendar;

import java.awt.image.ImagingOpException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

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
    private Label idExamen;

    @FXML
    private Label typeexam;


    @FXML
    private Label DateExamen;

    @FXML
    private Label medradio;

    @FXML
    private Label medpresc;

    @FXML
    private TextField MessageCode;


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
           System.out.println("Reçu :" + messageHL7);
        }

        this.patient = c.getPatient();
        this.message = c.getMessage();

        //type d'examen radiologique
        /*if(patient.getPatClass() == "Emergency"){
        this.typeexam.setText("Type Examen: " + "IRM");}
        if(patient.getPatClass() == "Inpatient"){
            this.typeexam.setText("Type Examen: " + "Scanner");}
        if(patient.getPatClass() == "Outpatient"){
            this.typeexam.setText("Type Examen: " + "Radio");}
*/
        //"Id Patient :" +
        this.id.setText(patient.getID().toString());

        //"Nom : " +
        this.nom.setText(patient.getFamillyName());

        if (patient.getFirstName() != null) {
            this.prenom.setText(patient.getFirstName());
        }

        //"Examen fait le " +
        if (patient.getBirth() != null) {
            this.DateExamen.setText(patient.getBirth().toString());
        }

        PatientLocation locPat = patient.getAssignedPatLocation();
        //"Type Examen : " +
            this.typeexam.setText(locPat.getPointOfCare().toUpperCase());
            //"Medecin radiologue : " +
        this.medradio.setText(locPat.getRoom());


        //"Medecin prescripteur : " +
        this.medpresc.setText(locPat.getBed());
        //"Id de l'examen : " +
        this.idExamen.setText(locPat.getBuilding());

        this.MessageCode.setText(Code());
    }
    public String Code(){
        String message = "|||";


        if(typeexam.getText().equals("SCANNER")){
            message = message + "SC" + "|||";
        }

        if(typeexam.getText().equals("RADIO")){
            message =message +"RA" + "|||";
        }

        if(typeexam.getText().equals("IRM")){
            message =message +"IR" + "|||";
        }
         message = message + DateExamen.getText() + "|||";

         message = message + idExamen.getText() + "|||";
        return message;
    }

    @FXML
    private void OuvrirText() {
        String FILENAME = "C:\\Users\\glebb\\Desktop\\projet SIS\\examRadio.txt";



            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                String content ="Patient "  + nom.getText() + "   "    +  prenom.getText()+  "\n"  + "Infos Examen " + "\n" + "ID Examen :" + idExamen.getText() + "\n" + "Type Examen :" + typeexam.getText() + "\n" + "Date Examen :" + DateExamen.getText() + "\n" + "Medecin Prescripteur : " + medpresc.getText() + "\n" + "Medecin Radiologue :" + medradio.getText();


                fw = new FileWriter(FILENAME);
                bw = new BufferedWriter(fw);
                bw.write(content);

                System.out.println("Done");

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (bw != null)
                        bw.close();

                    if (fw != null)
                        fw.close();

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

            }

        }


    }


