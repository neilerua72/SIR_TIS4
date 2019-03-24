/**
 * Sample Skeleton for 'secretaire_accueil_controller.fxml' Controller Class
 */


package IU.acceuil_secretaire;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ClassTable.TableRDV;
import FC.SIR;
import IU.ajouter_patient.ajouter_patient_controller;
import IU.liste_patient_secretaire.liste_patient_secretaire_controller;
import IU.menu.menu_controller;
import IU.redaction_CR.redaction_CR_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class secretaire_accueil_controller {
    SIR sir;
    private FXMLLoader loaderMenu;
    private Parent menu;
    @FXML
    private TableView<TableRDV> tableau;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="colonne_CR"
    private TableColumn<?, ?> colonne_id; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_nomPatient"
    private TableColumn<?, ?> colonne_nomPatient; // Value injected by FXMLLoader

    @FXML // fx:id="button_creationRDV"
    private Button button_creationRDV; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinRadiologue"
    private TableColumn<?, ?> colonne_salle; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinPrescripteur"
    private TableColumn<?, ?> colonne_medecinPrescripteur; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_patient"
    private TableColumn<?, ?> colonne_patient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_dateRDV"
    private TableColumn<?, ?> colonne_dateRDV; // Value injected by FXMLLoader

    @FXML // fx:id="button_ajoutPatient"
    private Button button_ajoutPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_IDPatient"
    private TableColumn<?, ?> colonne_IDPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_prenomPatient"
    private TableColumn<?, ?> colonne_prenomPatient; // Value injected by FXMLLoader
    @FXML
    AnchorPane top;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert colonne_id != null : "fx:id=\"colonne_CR\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_nomPatient != null : "fx:id=\"colonne_nomPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert button_creationRDV != null : "fx:id=\"button_creationRDV\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_salle != null : "fx:id=\"colonne_medecinRadiologue\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_medecinPrescripteur != null : "fx:id=\"colonne_medecinPrescripteur\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_dateRDV != null : "fx:id=\"colonne_dateRDV\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert button_ajoutPatient != null : "fx:id=\"button_ajoutPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";
        assert colonne_prenomPatient != null : "fx:id=\"colonne_prenomPatient\" was not injected: check your FXML file 'secretaire_accueil_controller.fxml'.";

    }
    public void redigerCompteRendu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/redaction_CR/redaction_CR.fxml"));
        Parent parent = loader.load();
        redaction_CR_controller controller = loader.getController();
        System.out.println(controller.toString());

        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Sinpati - Rédaction CR");
        stage.setScene(scene);
        stage.show();

    }
    public void AjouterPat (ActionEvent event) throws IOException {

        FXMLLoader loaderListe = new FXMLLoader();
        loaderListe.setLocation(getClass().getResource("/IU/liste_patient_secretaire/liste_patient_secretaire.fxml"));
        Parent parent = loaderListe.load();
        liste_patient_secretaire_controller controller = loaderListe.getController();
        System.out.println(controller.toString());
        controller.initData(sir,menu,loaderMenu);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris
        stage.setTitle("Sinpati - Liste Patient");
        stage.setScene(scene);
        stage.show();


    }
    public void initData(SIR sir, Parent menu, FXMLLoader loader){
        this.sir=sir;
        this.loaderMenu=loader;
        this.menu=menu;
        if(sir.getTableRDV().size()!=0){
        TableRDV rdv = sir.getTableRDV().get(0);
        final ObservableList<TableRDV> data = FXCollections.observableArrayList(rdv);
        for(int i=1;i<sir.getTableRDV().size();i++){
            data.add(sir.getTableRDV().get(i));
        }
        menu_controller menu_controller = loader.getController();
        menu_controller.initData(sir);
        top.getChildren().add(menu);
        colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
        colonne_dateRDV.setCellValueFactory(new PropertyValueFactory<>("dateRDV"));
        colonne_medecinPrescripteur.setCellValueFactory(new PropertyValueFactory<>("medecinPrescri"));
        colonne_nomPatient.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne_prenomPatient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colonne_salle.setCellValueFactory(new PropertyValueFactory<>("salle"));
        colonne_id.setCellValueFactory(new PropertyValueFactory<>("idExam"));
        tableau.setItems(data);}
    }

}

