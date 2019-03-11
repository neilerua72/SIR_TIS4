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
import javafx.scene.control.*;
import library.interfaces.Action;
import library.interfaces.ClientHL7;
import library.interfaces.MessageInterface;
import library.interfaces.Patient;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.util.logging.Level;
import IU.acceuil_medecin.acceuil_medecin_controller;
public class TestServeur_controlleur {
    private Patient patient;
    private Action action;
    private char sex = 'X';
    private String card = "cardAdmettre";
    private int nbr;
    private final SimpleDateFormat formateur = new SimpleDateFormat("dd/MM/yyyy");
private acceuil_medecin_controller acceuil;







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
    private TextField Date_Naissance;

    @FXML
    private TextField Date_Exam;

    @FXML //fx:id="Categorie"
    private ComboBox<String> Categorie;

    @FXML //fx:id="Sexe"
    private ComboBox<String> Sexe;

    @FXML //fx:id="Admettre"
    private Button Admettre ;

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


    ObservableList<String> cat = FXCollections.observableArrayList("IRM","Scanner","Radio");
    ObservableList<String> sexe = FXCollections.observableArrayList("Homme","Femme","Autre");

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        Categorie.setItems(cat);
        Sexe.setItems(sexe);

    }

   /* public void RemplirChamps(TableExamen table){
        prenom.setText(table.getPrenom());
    }*/

public void initData(TableExamen table){
    prenom.setText(table.getPrenom());
}
    public void transferMessage(String message) {
        //Display the message
        prenom.setText(message);
    }



    //set couleurs des camps
    private void initBackgroundField() {
        this.identification.setStyle("-fx-background-color: white;");   //changer couleur champ texte
        this.Nom.setStyle("-fx-background-color: white;");
       // this.Date_Exam.setStyle("-fx-background-color: white;");

    }


    private boolean champsPatOk() {
        boolean r = true;
        this.initBackgroundField();

        if (this.Nom.getText().length() == 0) {
            r = false;
            this.Nom.setStyle("-fx-background-color: red;");
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
                this.identification.setStyle("-fx-background-color: red;");
            }
        }
        //Date Decharge
        /*if (this.nbr == 2) {
            String dateDechargeString = this.Date_Exam.getText();
            if (dateDechargeString.equals("  /  /    ")) {
                r = false;
                this.Date_Exam.setStyle("-fx-background-color: red;");
            }
        }*/
        return r;

    }


        private void creePatient() {
        try {
            //Nom de famille
            String surname;
            if (!(this.Nom.getText().length() < 0)) {
                surname = this.Nom.getText();


                Integer id = Integer.parseInt(this.identification.getText());

                int classePat = this.Categorie.getSelectionModel().getSelectedIndex();
                char classe = 'U';

                switch (classePat) {
                    case -1: {
                        break;
                    }
                    case 0: {
                        classe = 'E';
                        break;
                    }
                    case 1: {
                        classe = 'I';
                        break;
                    }
                    case 2: {
                        classe = 'O';
                        break;
                    }
                    case 3: {
                        classe = 'P';
                        break;
                    }
                    case 4: {
                        classe = 'R';
                        break;
                    }
                    case 5: {
                        classe = 'B';
                        break;
                    }
                    case 6: {
                        classe = 'C';
                        break;
                    }
                    case 7: {
                        classe = 'N';
                        break;
                    }
                    case 8: {
                        classe = 'U';
                        break;
                    }
                }

                this.patient = new Patient(id, surname, classe);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur d'identification patient : " + e.getMessage());
        }
    }



    private void setValPatient() {
        //Prénom de famille
        this.patient.setFirstName(this.prenom.getText());


        //Date de naissance
        Date dateBirth = null;
        String s = this.Date_Naissance.getText();
        try {
            if (!s.equals("  /  /    ")) {
                dateBirth = formateur.parse(s);
                this.patient.setBirth(dateBirth);
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestServeur_controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Date Exam

        Date dateDeath = null;
        String dateDeathString = this.Date_Exam.getText();
        try {
            if (!dateDeathString.equals("  /  /    ")) {
                dateDeath = formateur.parse(dateDeathString);
                this.patient.setDeath(dateDeath);
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestServeur_controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Date dateEx ;
        String exam = this.Date_Exam.getText();


        try {
            if (!exam.equals("  /  /    ")) {
                dateEx = formateur.parse(exam);
                this.patient.setDateDicharge(dateEx);
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestServeur_controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        int i = this.Sexe.getSelectionModel().getSelectedIndex();
        switch (i) {
            case 0: {
                this.sex = 'M';
                break;
            }
            case 1: {
                this.sex = 'F';
                break;
            }
            case 2: {
                this.sex = 'O';
                break;
            }
            case 3: {
                this.sex = 'U';
                break;
            }
            case 4: {
                this.sex = 'A';
                break;
            }
        }

        //sexe
        if (this.sex != 'X') {
            this.patient.setSex(this.sex);
        }




        //Date Admission


    }

    @FXML
    private void Admission(ActionEvent e)  throws IOException {
        if (this.champsPatOk()) {

            this.creePatient();

            this.setValPatient();

            //changer de panel
           /* java.awt.CardLayout c = (CardLayout) this.panelCard.getLayout();
            c.show(this.panelCard, "cardAction");
            c = (CardLayout) this.panelSousAction.getLayout();
            c.show(this.panelSousAction, card);*/
            /*URL url_accreuil_medecin;
            //url_accreuil_medecin = new File("IU.acceuil_medecin.acceuil_medecin.fxml").toURL();
            Parent parent = FXMLLoader.load(getClass().getResource("/HL7/TestServeur1.fxml"));

            Scene scene = new Scene(parent);

            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();     //pas compris
            stage.setScene(scene);

            stage.show();*/

            String host = this.host.getText();
            Integer port = Integer.parseInt(this.port.getText());
            ClientHL7 c = new ClientHL7();
            c.connexion(host, port);
            c.admit(patient);
            MessageInterface messageAck = c.getMsg();
            this.l1.setText("ID message : " + messageAck.getId());
            this.l2.setText(messageAck.getAcknowledgmentCodeString());
            this.l3.setText("ID Ack: " + messageAck.getIdAck());
            System.out.println(patient.getDateDicharge().toString());
        }

    }

}
