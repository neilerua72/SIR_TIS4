package IU.liste_patient_secretaire;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import ClassTable.TableExamen;
import ClassTable.TableRDV;
import FC.Patient;
import FC.RDV;
import FC.SIR;
import FC.TypeExamen;
import IU.acceuil_secretaire.secretaire_accueil_controller;
import IU.menu.menu_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class liste_patient_secretaire_controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date_RDV;
    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane ajoutRDV;

    @FXML
    private TableColumn<?, ?> colonne_nomPatient;

    @FXML
    private Button button_creationRDV;

    @FXML
    private TableView<Patient> tableau;

    @FXML
    private AnchorPane top;

    @FXML
    private Button button_ajoutPatient;

    @FXML
    private TableColumn<?, ?> colonne_IDPatient;

    @FXML
    private Button button_ajoutPatient1;

    @FXML
    private TableColumn<?, ?> colonne_prenomPatient;

    @FXML
    private Text idPatient;
    @FXML
    private Text nom;
    @FXML
    private Text prenom;
    @FXML
    private ComboBox typeExam;
    @FXML
    private TextField salle_champ;
    @FXML
    private TextField ajoutpatient_champ_Rue;
    SIR sir;
    @FXML
    private Button retour;

    private Parent menu;
    private FXMLLoader loader;
    private Patient p;
    @FXML
    void AjouterPat(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert colonne_nomPatient != null : "fx:id=\"colonne_nomPatient\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        assert button_creationRDV != null : "fx:id=\"button_creationRDV\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        assert tableau != null : "fx:id=\"tableau\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        assert top != null : "fx:id=\"top\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        assert button_ajoutPatient != null : "fx:id=\"button_ajoutPatient\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        assert button_ajoutPatient1 != null : "fx:id=\"button_ajoutPatient1\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        assert colonne_prenomPatient != null : "fx:id=\"colonne_prenomPatient\" was not injected: check your FXML file 'liste_patient_secretaire.fxml'.";
        tableau.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> addRDV(newValue));


    }

    public void initData(SIR sir, Parent menu, FXMLLoader loader){
        this.menu=menu;
        this.sir=sir;
        this.loader=loader;
        Patient p =  sir.getListePatient().get(0);
        System.out.println(p.getNom());
        final ObservableList<Patient> data = FXCollections.observableArrayList(p);
        for(int i=1;i<sir.getListePatient().size();i++){
            data.add(sir.getListePatient().get(i));
        }
        colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<>("id"));
        colonne_nomPatient.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne_prenomPatient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        menu_controller controller = loader.getController();
        controller.initData(sir);
        top.getChildren().add(menu);

        tableau.setItems(data);
         p = new Patient();
    }

    private void addRDV(Patient patient) {
        grid.setVisible(true);
        idPatient.setText(String.valueOf(patient.getId()));
        nom.setText("Nom : "+patient.getNom());
        prenom.setText("Prenom : "+patient.getPrenom());
        this.p=patient;


    }
    @FXML
    public void ajoutCR(ActionEvent event) throws IOException {
        LocalDate date = date_RDV.getValue();
        Date resultDate = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        java.sql.Date gooddate = new java.sql.Date(resultDate.getTime());
        Object type = typeExam.getValue();
        TypeExamen typeExamEnum = TypeExamen.RADIO;
        String typeExamen = (String)type;
        typeExamEnum=typeExamEnum.matchType(typeExamen);
        String salle = salle_champ.getText();
        String idPat = idPatient.getText();
        int id = 0+(int)(Math.random()*((999999-0)+1));
        while(sir.checkIdPatient(id)){
            id = 0+(int)(Math.random()*((999999-0)+1));
        }
        String medecinPrescri = ajoutpatient_champ_Rue.getText();
        RDV rdv = new RDV(gooddate,typeExamEnum,String.valueOf(id),Integer.parseInt(salle),"TEST",p.getId(),medecinPrescri);
        this.sir.getListeRDV().add(rdv);
        sir.UpdateTableRDV();
        FXMLLoader loadera = new FXMLLoader();
        loadera.setLocation(getClass().getResource("/IU/acceuil_secretaire/secretaire_accueil.fxml"));
        Parent root= loadera.load();
        secretaire_accueil_controller secretaire_accueil_controller = loadera.getController();
        secretaire_accueil_controller.initData(sir,menu,loader);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris

        stage.setScene(scene);
        stage.show();

    }
    public void retour(ActionEvent event) throws IOException{
        FXMLLoader loadera = new FXMLLoader();
        loadera.setLocation(getClass().getResource("/IU/acceuil_secretaire/secretaire_accueil.fxml"));
        Parent root= loadera.load();
        secretaire_accueil_controller secretaire_accueil_controller = loadera.getController();
        secretaire_accueil_controller.initData(sir,menu,loader);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris

        stage.setScene(scene);
        stage.show();
    }
}
