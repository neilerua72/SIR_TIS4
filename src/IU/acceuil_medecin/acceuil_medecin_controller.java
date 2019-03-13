package IU.acceuil_medecin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import FC.*;
import ClassTable.TableExamen;
import IU.afficher_dossiers_patient.afficher_dossiers_patient_controller;
import IU.ajouter_patient.ajouter_patient_controller;
import IU.menu.menu_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import HL7.TestServeur_controlleur;

public class acceuil_medecin_controller implements Initializable{
    Connexion connect;
    SIR sir;
    Parent menu;
    FXMLLoader loadermenu;

    String nom;



    private ObservableList data;



    /**
     * Sample Skeleton for 'acceuil_medecin.fxml' Controller Class
     */
    @FXML
    private AnchorPane afficheExam;
    @FXML
    private Text aucunExamen;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="colonne_CR"
    private TableColumn<?, ?> colonne_CR; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_dossierPatient"
    private TableColumn<?, ?> colonne_dossierPatient; // Value injected by FXMLLoader


    @FXML
    private AnchorPane top;
    /**
     * Toggle Buttons pour la "recherche par"
     **/
    @FXML
    private Text idExamen;

    @FXML
    private Text prenomPatient;

    @FXML
    private Text typeExamen;

    @FXML
    private Text nomPatient;
    @FXML // fx:id="toggle_IDPatient"
    private ToggleButton toggle_IDPatient = new ToggleButton("ID Patient");// Value injected by FXMLLoader

    @FXML // fx:id="toggle_medecinPrescripteur"
    private ToggleButton toggle_medecinPrescripteur = new ToggleButton("Médecin Prescripteur"); // Value injected by FXMLLoader

    @FXML // fx:id="toggle_nomPatient"
    private ToggleButton toggle_nomPatient = new ToggleButton("Nom patient)"); // Value injected by FXMLLoader

    @FXML // fx:id="toggle_medecinRadiologue"
    private ToggleButton toggle_medecinRadiologue = new ToggleButton("Médecin Radiologue");

    @FXML // fx:id="toggle_IDExamen"
    private ToggleButton toggle_IDExamen = new ToggleButton("ID Examen");


    /**
     * Bouton consulter tous les DP et bouton ajouter un patient
     * **/
    @FXML // fx:id="button_consulterTousLesDP"
    private Button button_consulterTousLesDP;// Value injected by FXMLLoader


    @FXML //fx:id="button_envoyerDMR"
    private Button button_envoyerDMR; //Value injected by FXMLLoader



    @FXML // fx:id="button_ajouterPatient"
    private Button button_ajouterPatient = new Button("Ajouter Patient");// Value injected by FXMLLoader

    /**
     * Colones du tableau
     * **/
    @FXML // fx:id="colonne_IDExamen"
    private TableColumn<?, ?> colonne_IDExamen; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_typeExamen"
    private TableColumn<?, ?> colonne_typeExamen; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_IDPatient"
    private TableColumn<?, ?> colonne_IDPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_image"
    private TableColumn<?, ?> colonne_image; // Value injected by FXMLLoader

    @FXML // fx:id="champ_rechercherParNomPatient"
    private TextField champ_rechercherParNomPatient; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_dateExamen"
    private TableColumn<?, ?> colonne_dateExamen; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinRadiologue"
    private TableColumn<?, ?> colonne_medecinRadiologue; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_medecinPrescripteur"
    private TableColumn<?, ?> colonne_medecinPrescripteur; // Value injected by FXMLLoader

    @FXML // fx:id="colonne_patient"
    private TableColumn<?, ?> colonne_patient; // Value injected by FXMLLoader
    @FXML // fx:id="colonne_patient"
    private TableColumn<?, ?> colonne_nom; // Value injected by FXMLLoader
    @FXML // fx:id="colonne_patient"
    private TableColumn<?, ?> colonne_prenom; // Value injected by FXMLLoader

    @FXML // fx:id="ractangle_recherche"
    private Rectangle ractangle_recherche; // Value injected by FXMLLoader

    @FXML // fx:id="texte_rechercherPar"
    private Text texte_rechercherPar; // Value injected by FXMLLoader

    @FXML // fx:id="tableau_colonnes"
    private TableView<TableExamen> tableau_colonnes; // Value injected by FXMLLoader

    @FXML // fx:id="champ_date"
    private DatePicker champ_date; // Value injected by FXMLLoader

    @FXML // fx:id="texte_date"
    private Text texte_date; // Value injected by FXMLLoader

    private Examen exam1;



    public void AjouterPat (ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/ajouter_patient/ajouter_patient.fxml"));
        Parent parent = loader.load();
        ajouter_patient_controller controller = loader.getController();
        System.out.println(controller.toString());

        controller.initData(sir,menu,loader);
        Scene scene = new Scene(parent);
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();


    }


    public void initData(SIR sir,Parent menu,FXMLLoader loader){
        System.out.println("Init data");
        this.sir=sir;
        TableExamen tb =sir.getTableExamen().get(0);
        final ObservableList<TableExamen> data= FXCollections.observableArrayList(tb);
        System.out.println(tb.getIdpatient());
        this.menu=menu;
        this.loadermenu=loader;
        for(int i=1;i<sir.getListeExamen().size();i++){
            data.add(sir.getTableExamen().get(i));
        }
        texte_rechercherPar.setText(sir.getConnexion().getType().toString());

        colonne_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colonne_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<>("idpatient"));
        colonne_dateExamen.setCellValueFactory(new PropertyValueFactory<>("dateExamen"));
        colonne_medecinPrescripteur.setCellValueFactory(new PropertyValueFactory<>("medecinprescri"));
        colonne_medecinRadiologue.setCellValueFactory(new PropertyValueFactory<>("medecinradio"));
        colonne_IDExamen.setCellValueFactory(new PropertyValueFactory<>("idexamen"));
        colonne_typeExamen.setCellValueFactory(new PropertyValueFactory<>("typeExam"));
        colonne_CR.setCellValueFactory(new PropertyValueFactory<>("cr"));
        colonne_image.setCellValueFactory(new PropertyValueFactory<>("image"));


        colonne_dossierPatient.setCellValueFactory(new PropertyValueFactory<>("dossierPatient"));
        if(!sir.getConnexion().getType().equals(TypeConnexion.MED)){
            button_consulterTousLesDP.setDisable(true);
        }

        menu_controller controller = loader.getController();
        controller.initData(sir);
        tableau_colonnes.setItems(data);

        top.getChildren().add(menu);
    }


    /*@FXML
    private void Envoyer (ActionEvent e) throws IOException {
        nom =tableau_colonnes.getSelectionModel().getSelectedItem().getNom();
        id = tableau_colonnes.getSelectionModel().getSelectedItem().getIdpatient();
        prenom =tableau_colonnes.getSelectionModel().getSelectedItem().getPrenom();



        Parent parent = FXMLLoader.load(getClass().getResource("/HL7/TestServeur.fxml"));

        Scene scene = new Scene(parent);

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();     //pas compris
        stage.setScene(scene);

        stage.show();

                    }*/









    /**
     * test
     */

    /* @FXML
    void b8cada00(ActionEvent event) {

    } */

   /* @FXML
    void 6f6e6ead(ActionEvent event) {

    } */

    @FXML
    public
    // This method is called by the FXMLLoader when initialization is complete
    void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize");
        assert colonne_CR != null : "fx:id=\"colonne_CR\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_dossierPatient != null : "fx:id=\"colonne_dossierPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert toggle_IDPatient != null : "fx:id=\"toggle_IDPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert button_ajouterPatient != null : "fx:id=\"button_ajouterPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_IDExamen != null : "fx:id=\"colonne_IDExamen\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_typeExamen != null : "fx:id=\"colonne_typeExamen\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert button_consulterTousLesDP != null : "fx:id=\"button_consulterTousLesDP\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_image != null : "fx:id=\"colonne_image\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert champ_rechercherParNomPatient != null : "fx:id=\"champ_rechercherParNomPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_dateExamen != null : "fx:id=\"colonne_dateExamen\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_medecinRadiologue != null : "fx:id=\"colonne_medecinRadiologue\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_medecinPrescripteur != null : "fx:id=\"colonne_medecinPrescripteur\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert toggle_medecinPrescripteur != null : "fx:id=\"toggle_medecinPrescripteur\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert ractangle_recherche != null : "fx:id=\"ractangle_recherche\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert texte_rechercherPar != null : "fx:id=\"texte_rechercherPar\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert toggle_nomPatient != null : "fx:id=\"toggle_nomPatient\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert tableau_colonnes != null : "fx:id=\"tableau_colonnes\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert champ_date != null : "fx:id=\"champ_date\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert texte_date != null : "fx:id=\"texte_date\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_nom != null : "fx:id=\"colonne_nom\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert colonne_prenom != null : "fx:id=\"colonne_prenom\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        assert top != null : "fx:id=\"top\" was not injected: check your FXML file 'acceuil_medecin.fxml'.";
        ToggleGroup groupe_toggle_rechercherPar = new ToggleGroup();
        toggle_nomPatient.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_IDPatient.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_medecinPrescripteur.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_medecinRadiologue.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_IDExamen.setToggleGroup(groupe_toggle_rechercherPar);
        tableau_colonnes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showExamDetails(newValue));
        /*final ObservableList<Utilisateur> data = FXCollections.observableArrayList(
                new Utilisateur("1","Jacob")
        );

        colonne_patient.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("Patient"));

        colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("name"));


        myTable.setItems(data);*/



    }


   /* @FXML
    private void Envoyer(ActionEvent event) throws IOException{



       *//* //charger interface HL7
        Parent parent = FXMLLoader.load(getClass().getResource("/HL7/TestServeur.fxml"));

        Scene scene = new Scene(parent);

        //Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();     //pas compris
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);

        stage.show();
*//*

        //context.setSelection(tableau_colonnes.getSelectionModel().getSelectedItem().getPrenom());




    }*/
   @FXML
    private void Envoyer(ActionEvent event) throws IOException {
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/HL7/TestServeur.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
           TestServeur_controlleur scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferMessage(tableau_colonnes.getSelectionModel().getSelectedItem().getPrenom());

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Second Window");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void showExamDetails(TableExamen examen) {

        if(examen!=null){
            aucunExamen.setVisible(false);
            afficheExam.setVisible(true);
            idExamen.setText("ID: "+examen.getIdexamen());
            prenomPatient.setText("Prénom : "+examen.getPrenom());
            nomPatient.setText("Nom : "+examen.getNom());
            typeExamen.setText("Type Examen "+examen.getTypeExam());}
        else{
            System.out.println("Erreur chargement examen");
            aucunExamen.setVisible(true);
            afficheExam.setVisible(false);
        }
    }


    public void afficheDossierPatient(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/afficher_dossiers_patient/afficher_dossiers_patient.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();


    }
}







