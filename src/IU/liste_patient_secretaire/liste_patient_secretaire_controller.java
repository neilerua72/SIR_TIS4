package IU.liste_patient_secretaire;


import java.net.URL;
import java.util.ResourceBundle;

import ClassTable.TableRDV;
import FC.Patient;
import FC.SIR;
import IU.menu.menu_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class liste_patient_secretaire_controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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


    }

    public void initData(SIR sir, Parent menu, FXMLLoader loader){

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
    }
}
