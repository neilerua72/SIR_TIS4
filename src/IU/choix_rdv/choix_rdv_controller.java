package IU.choix_rdv;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ClassTable.TableRDV;
import FC.RDV;
import FC.SIR;
import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.acceuil_secretaire.secretaire_accueil_controller;
import IU.ajout_examen.ajout_examen_controller;
import IU.menu.menu_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class choix_rdv_controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date;

    @FXML
    private TableColumn<?, ?> colonne_nomPatient;

    @FXML
    private TableView<TableRDV> tableau;

    @FXML
    private TableColumn<?, ?> colonne_medecinPrescripteur;

    @FXML
    private TableColumn<?, ?> colonne_patient;

    @FXML
    private AnchorPane top;

    @FXML
    private TableColumn<?, ?> colonne_dateRDV;

    @FXML
    private TableColumn<?, ?> colonne_IDPatient;

    @FXML
    private TableColumn<?, ?> colonne_id;

    @FXML
    private TableColumn<?, ?> colonne_prenomPatient;

    @FXML
    private TableColumn<?, ?> colonne_salle;

    @FXML
    private Button recherche;
    SIR sir;
    Parent menu;
    FXMLLoader loadermenu;

    @FXML
    void initialize() {
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_nomPatient != null : "fx:id=\"colonne_nomPatient\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert tableau != null : "fx:id=\"tableau\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_medecinPrescripteur != null : "fx:id=\"colonne_medecinPrescripteur\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert top != null : "fx:id=\"top\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_dateRDV != null : "fx:id=\"colonne_dateRDV\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_id != null : "fx:id=\"colonne_id\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_prenomPatient != null : "fx:id=\"colonne_prenomPatient\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert colonne_salle != null : "fx:id=\"colonne_salle\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        assert recherche != null : "fx:id=\"recherche\" was not injected: check your FXML file 'choix_rdv.fxml'.";
        tableau.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    try {
                        selectionRDV(newValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

    }

    public void initData(SIR sir, Parent menu, FXMLLoader loadermenu){
        this.sir=sir;
        this.menu=menu;
        this.loadermenu=loadermenu;
        if(sir.getTableRDV().size()!=0) {
            TableRDV rdv = sir.getTableRDV().get(0);
            final ObservableList<TableRDV> data = FXCollections.observableArrayList(rdv);
            for (int i = 1; i < sir.getTableRDV().size(); i++) {
                data.add(sir.getTableRDV().get(i));
            }
            menu_controller menu_controller = loadermenu.getController();
            menu_controller.initData(sir);
            top.getChildren().add(menu);
            colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
            colonne_dateRDV.setCellValueFactory(new PropertyValueFactory<>("dateRDV"));
            colonne_medecinPrescripteur.setCellValueFactory(new PropertyValueFactory<>("medecinPrescri"));
            colonne_nomPatient.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colonne_prenomPatient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colonne_salle.setCellValueFactory(new PropertyValueFactory<>("salle"));
            colonne_id.setCellValueFactory(new PropertyValueFactory<>("idExam"));
            tableau.setItems(data);

        }
    }
    public void selectionRDV(TableRDV rdv) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/ajout_examen/ajout_examen.fxml"));
        Parent parent = loader.load();
        ajout_examen_controller controller = loader.getController();
        System.out.println(controller.toString());

        controller.initData(this.sir,this.sir.getRDVfromTableRDV(rdv),menu,loadermenu);
        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Sinpati - Ajout Examen");
        stage.setScene(scene);
        stage.show();

    }

    public void retour(ActionEvent event) throws IOException{
        FXMLLoader loadera = new FXMLLoader();
        loadera.setLocation(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
        Parent root= loadera.load();
        acceuil_medecin_controller secretaire_accueil_controller = loadera.getController();
        secretaire_accueil_controller.initData(sir,menu,loadermenu);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris
        stage.setTitle("Sinpati - Acceuil");
        stage.setScene(scene);
        stage.show();
    }
}
