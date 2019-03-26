package IU.choix_rdv;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import ClassTable.TableRDV;
import FC.RDV;
import FC.Recherche;
import FC.SIR;
import IU.acceuil_medecin.MaJTableau;
import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.acceuil_secretaire.secretaire_accueil_controller;
import IU.ajout_examen.ajout_examen_controller;
import IU.menu.menu_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class choix_rdv_controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane top;

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
    @FXML
            private TextField rechercherParNom;
    SIR sir;
    Parent menu;
    FXMLLoader loadermenu;

    /**
     * Méthode qui initialise l'interface en background
     */
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
        rechercherParNom.setOnKeyReleased(new EventHandler<KeyEvent>() {
            /**
             * Listenner qui regarde le comportement de la barre de recherche. A chaque fois qu'une touche est relaché, cette méthode est appelé
             * @param event event qui déclenche l'action
             */
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString().equals("BACK_SPACE") && rechercherParNom.getText().length() < 2) {
                    MaJRDV maJTableau = new MaJRDV(sir.getTableRDV());
                    tableau.setItems(maJTableau.getData());
                }
                if(rechercherParNom.getText().length()>0){
                    Recherche recherche = new Recherche(sir, event, rechercherParNom.getText());
                    MaJRDV maJTableau = new MaJRDV(recherche.rechercherRDVParNom());
                    tableau.setItems(maJTableau.getData());
                }
            }
        });

    }

    /**
     * Méthode qui initialise les données de l'interface
     * @param sir le SIR de l'application
     * @param menu le menu de l'application
     * @param loadermenu le loader du menu
     */
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

            colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
            colonne_dateRDV.setCellValueFactory(new PropertyValueFactory<>("dateRDV"));
            colonne_medecinPrescripteur.setCellValueFactory(new PropertyValueFactory<>("medecinPrescri"));
            colonne_nomPatient.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colonne_prenomPatient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colonne_salle.setCellValueFactory(new PropertyValueFactory<>("salle"));
            colonne_id.setCellValueFactory(new PropertyValueFactory<>("idExam"));
            tableau.setItems(data);

        }
        menu_controller menu_controller = loadermenu.getController();
        menu_controller.initData(sir);
        top.getChildren().add(menu);

    }

    /**
     * Méthode qui permet de sélectionner un rdv dans une table.
     * @param rdv le rdv selectionné
     * @throws IOException
     */
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

    /**
     * Méthode qui implémente l'action retour sur cette interface
     * @param event event qui déclenche l'action
     * @throws IOException
     */
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

    /**
     * Méthode qui affiche les rdv pour la date du jour
     * @param event event qui déclenche l'action
     */
    public void RDVDate(ActionEvent event){
        Date date = new Date();
        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "Europe/Paris" ) );
        java.sql.Date sqlDate = java.sql.Date.valueOf(todayLocalDate);
        Recherche recherche = new Recherche(sir, event, sqlDate.toString());
        MaJRDV maJTableau = new MaJRDV(recherche.rechercheRDVparDate());
        tableau.setItems(maJTableau.getData());
    }

    /**
     * Méthode qui réinitialise la liste de RDV
     * @param event
     */
    public void Reinitialiser(ActionEvent event){
        MaJRDV maJRDV = new MaJRDV(sir.getTableRDV());
        tableau.setItems(maJRDV.getData());
    }
}
