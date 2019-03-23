package IU.acceuil_medecin;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import FC.*;
import ClassTable.TableExamen;
import IU.afficher_dossiers_patient.afficher_dossiers_patient_controller;
import IU.ajouter_patient.ajouter_patient_controller;
import IU.choix_rdv.choix_rdv_controller;
import IU.img_grand.img_grand_controller;
import IU.menu.menu_controller;
import IU.redaction_CR.redaction_CR_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    private Button agrandir;
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
    @FXML
    private ToggleButton date_button;

    @FXML
    private Button buttonRechercher;

    @FXML
    private Text nom;

    @FXML
    private Text prenom;
    @FXML
    private Text sexe;
    @FXML
    private Text dateDeNaissance;
    @FXML
    private Text dateRDV;
    @FXML
    private Text typeExam;
    @FXML
    private Text dateExamen;
    @FXML
    private Text radio;
    @FXML
    private Text prescri;
    @FXML
    private Text text_descriptionTechniqueCR;
    @FXML
    private Text resumePbClinique;
    @FXML
    private Text protocole;
    @FXML
    private Text typeProduit;
    @FXML
    private Text quantite;
    @FXML
    private Text text_comparaisonExamensExterieursCR;

    @FXML
    private Text text_resultatCR;
    @FXML
    private Text text_conclusionCR;
    @FXML
    private Text text_syntheseCR;
    @FXML
    private ListView<ImageView> listView_imagesExam;
    @FXML
    private AnchorPane cranchor;
    @FXML
    private Button rediger;
    private Examen examen;

    private BufferedImage image_to_edit;

    public Image getImage_to_edit(){
        return SwingFXUtils.toFXImage(image_to_edit, null);
    }

    public void AjouterPat (ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/ajouter_patient/ajouter_patient.fxml"));
        Parent parent = loader.load();
        ajouter_patient_controller controller = loader.getController();
        System.out.println(controller.toString());

        controller.initData(sir,menu,loader);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris
        //Stage stage = new Stage(StageStyle.DECORATED);
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

        menu_controller controller = loadermenu.getController();
        controller.initData(sir);
        tableau_colonnes.setItems(data);

        top.getChildren().add(menu);
    }

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
        toggle_medecinPrescripteur.setText("Médecin"+"\n"+"Préscripteur");
        toggle_medecinRadiologue.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_medecinRadiologue.setText("Médecin"+"\n"+"radiologue");
        toggle_IDExamen.setToggleGroup(groupe_toggle_rechercherPar);
        date_button.setToggleGroup(groupe_toggle_rechercherPar);
        tableau_colonnes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showExamDetails(newValue));


        champ_rechercherParNomPatient.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString().equals("BACK_SPACE") && champ_rechercherParNomPatient.getText().length() < 2) {
                    MaJTableau maJTableau = new MaJTableau(sir.getTableExamen());
                    tableau_colonnes.setItems(maJTableau.getData());
                }
                if (champ_rechercherParNomPatient.getText().length() > 0) {
                    if (toggle_nomPatient.isSelected()) {


                        Recherche recherche = new Recherche(sir, event, champ_rechercherParNomPatient.getText());
                        MaJTableau maJTableau = new MaJTableau(recherche.rechercheExamenNom());
                        tableau_colonnes.setItems(maJTableau.getData());
                    } else if (toggle_IDPatient.isSelected()) {

                        Recherche recherche = new Recherche(sir, event, champ_rechercherParNomPatient.getText());
                        MaJTableau maJTableau = new MaJTableau(recherche.rechercheExamenIDPat());
                        tableau_colonnes.setItems(maJTableau.getData());


                    } else if (toggle_IDExamen.isSelected()) {

                        Recherche recherche = new Recherche(sir, event, champ_rechercherParNomPatient.getText());
                        MaJTableau maJTableau = new MaJTableau(recherche.rechercheExamenIDExamn());
                        tableau_colonnes.setItems(maJTableau.getData());

                    } else if (toggle_medecinPrescripteur.isSelected()) {

                        Recherche recherche = new Recherche(sir, event, champ_rechercherParNomPatient.getText());
                        MaJTableau maJTableau = new MaJTableau(recherche.rechercherExamenParMedecinPrescri());
                        tableau_colonnes.setItems(maJTableau.getData());


                    } else if (toggle_medecinRadiologue.isSelected()) {

                        Recherche recherche = new Recherche(sir, event, champ_rechercherParNomPatient.getText());
                        MaJTableau maJTableau = new MaJTableau(recherche.rechercherExamenParMedecinRadio());
                        tableau_colonnes.setItems(maJTableau.getData());
                    }
                }





            }});
        listView_imagesExam.getSelectionModel().selectedItemProperty().addListener(observable -> {
            image_to_edit = sir.recupImageExam(Integer.parseInt(examen.getId())).get(listView_imagesExam.getSelectionModel().getSelectedIndex()).getBuffer();

        } );
       }



   @FXML
    private void Envoyer() {


        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/HL7/TestServeur.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
           TestServeur_controlleur scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferNom(tableau_colonnes.getSelectionModel().getSelectedItem().getNom());
            scene2Controller.transferPrenom(tableau_colonnes.getSelectionModel().getSelectedItem().getPrenom());
            scene2Controller.transferID(tableau_colonnes.getSelectionModel().getSelectedItem().getIdpatient());
            scene2Controller.transferDate(tableau_colonnes.getSelectionModel().getSelectedItem().getDateExamen());
            scene2Controller.transferMedPresc(tableau_colonnes.getSelectionModel().getSelectedItem().getMedecinprescri());
            scene2Controller.transferMedRadio(tableau_colonnes.getSelectionModel().getSelectedItem().getMedecinradio());
            scene2Controller.transferType(tableau_colonnes.getSelectionModel().getSelectedItem().getTypeExam());
            scene2Controller.transferIDExam(tableau_colonnes.getSelectionModel().getSelectedItem().getIdexamen());

            //Show scene 2 in new window
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(root));
            stage.setTitle("Second Window");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    private void showExamDetails(TableExamen tableExamen) {
        examen = sir.getExamenFromId(Integer.parseInt(tableExamen.getIdexamen()));
        CR cr = sir.getCRFromIdExam(Integer.parseInt(examen.getId()));
        ArrayList<RWImage>listeIMG=new ArrayList<>(sir.recupImageExam(Integer.parseInt(examen.getId())));

        if(examen.getCr()){
            Patient patient = sir.getPatientFromId(examen.getIdPatient());
            nom.setText(patient.getNom());
            prenom.setText(patient.getPrenom());
            dateDeNaissance.setText(patient.getDateDeNaissance().toString());
            dateRDV.setText(examen.getDateRDV().toString());
            dateExamen.setText(examen.getDateExamen().toString());
            radio.setText(examen.getMedecinRadio());
            prescri.setText(examen.getMedecinPrescri());
            typeExam.setText(examen.getTypeExamen().toString());
            text_descriptionTechniqueCR.setText(cr.getTechnique());
            text_comparaisonExamensExterieursCR.setText(cr.getComparaisonExamenAnt());
            text_conclusionCR.setText(cr.getConclusion());

            protocole.setText(cr.getProtocoleStandardise());
            text_resultatCR.setText(cr.getResultat());
            text_syntheseCR.setText(cr.getSynthese());
            typeProduit.setText(examen.getProduit());
            quantite.setText(examen.getDose()+"");
            cranchor.setVisible(true);
            aucunExamen.setVisible(false);
            rediger.setVisible(false);
        }
        else{
            cranchor.setVisible(false);
            aucunExamen.setText("Aucun Compte-Rendu de rédigé pour l'instant");
            aucunExamen.setVisible(true);
            rediger.setVisible(true);
            if(sir.getConnexion().getType().equals(TypeConnexion.MAN))
                rediger.setDisable(true);
            System.out.println("CR NULL");
        }
        if(listeIMG.size()>0){
            for(int i=0;i<listeIMG.size();i++){
                BufferedImage buffered_image=listeIMG.get(i).getBuffer();
                if ((buffered_image.getHeight() > 275) && (buffered_image.getWidth() > 275)) {
                    AffineTransform tx = new AffineTransform();
                    tx.scale(0.2, 0.2);
                    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
                    BufferedImage bufferedimage = op.filter(buffered_image, null);
                    Image image = SwingFXUtils.toFXImage(bufferedimage, null);
                    javafx.scene.image.ImageView imageview = new javafx.scene.image.ImageView(image);
                    listView_imagesExam.getItems().add(imageview);
                } else {
                    //
                    //int lastItem = listView_images.getItems().size()-1;
                    //listView_images.getItems().size();
                    // listView_images.getItems().remove(listView_images.getItems().get(0),listView_images.getItems().get(lastItem)); //vider le truc qui affiche et le re remplir

                    Image image = SwingFXUtils.toFXImage(buffered_image, null);
                    javafx.scene.image.ImageView imageview = new ImageView(image);
                    listView_imagesExam.getItems().add(imageview);
                }
            }listView_imagesExam.setDisable(false);
            agrandir.setDisable(false);
        }
    else{
        listView_imagesExam.setDisable(true);
        agrandir.setDisable(true);
    }
    }







    public void afficheDossierPatient(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/afficher_dossiers_patient/afficher_dossiers_patient.fxml"));
        Parent parent = loader.load();
        afficher_dossiers_patient_controller afficher_dossiers_patient_controller = loader.getController();
        afficher_dossiers_patient_controller.initData(sir,menu,loadermenu);
        Scene scene = new Scene(parent);
         Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();     //pas compris
        stage.setScene(scene);
        stage.show();


    }

    public void DoExamen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/choix_rdv/choix_rdv.fxml"));
        Parent parent = loader.load();
        choix_rdv_controller controller = loader.getController();
        System.out.println(controller.toString());

        controller.initData(this.sir,menu,loadermenu);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris

        stage.setScene(scene);
        stage.show();
    }
    public void rechercherParDate(ActionEvent event){
        if(!date_button.isSelected()){
            date_button.setSelected(true);
        }
        LocalDate date = champ_date.getValue();
        Date resultDate = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        java.sql.Date gooddate = new java.sql.Date(resultDate.getTime());
        Recherche recherche = new Recherche(sir, event, gooddate.toString());
        MaJTableau maJTableau = new MaJTableau(recherche.rechercherExamenParDate());
        tableau_colonnes.setItems(maJTableau.getData());
    }
    public void reset(ActionEvent event){
        MaJTableau maJTableau = new MaJTableau(sir.getTableExamen());
        tableau_colonnes.setItems(maJTableau.getData());
    }
    public void agrandir(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/img_grand/img_grand.fxml"));
        Parent parent = loader.load();

        //access the controller and get a method
        img_grand_controller controller = loader.getController();

        controller.initData(this.getImage_to_edit());
        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();


    }
    public void rediger(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/redaction_CR/redaction_CR.fxml"));
        Parent parent = loader.load();
        redaction_CR_controller redaction_cr = loader.getController();
        redaction_cr.initData(sir,examen,this.menu,this.loadermenu);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }


}







