package IU.afficher_dossiers_patient;


/**
 * Sample Skeleton for 'afficher_dossiers_patient.fxml' Controller Class
 */

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ClassTable.TableExamen;
import ClassTable.TablePatient;
import FC.*;
import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.acceuil_secretaire.secretaire_accueil_controller;
import IU.edition_image.edition_image_controller;
import IU.img_grand.img_grand_controller;
import IU.menu.menu_controller;
import IU.redaction_CR.redaction_CR_controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;

public class afficher_dossiers_patient_controller {

    @FXML
    private AnchorPane listViewAnchor;

    @FXML
    private ToggleButton toggle_medecinRadiologue;

    @FXML
    private TableColumn<?, ?> colonne_date;

    @FXML
    private Text protocole;

    @FXML
    private TextField champ_rechercherParNomPatient;

    @FXML
    private TableView<TableExamen> listeExam;

    @FXML
    private Text radio;

    @FXML
    private TableColumn<?, ?> colonne_patient;

    @FXML
    private Text text_descriptionTechniqueCR;

    @FXML
    private ListView<?> listView_examensRealises;

    @FXML
    private Text date_CRCR;

    @FXML
    private Text text_quantiteContrasteCR;

    @FXML
    private Text text_resumeProblemeCliniqueCR;

    @FXML
    private Text date_examenCR;

    @FXML
    private Text quantite;

    @FXML
    private Text text_nomPatientCR;

    @FXML
    private Text text_typeExamenCR;

    @FXML
    private Text resumePbClinique;

    @FXML
    private Text prescri;

    @FXML
    private ToggleButton toggle_medecinPrescripteur;

    @FXML
    private Rectangle ractangle_recherche;

    @FXML
    private Text texte_rechercherPar;

    @FXML
    private DatePicker champ_date;

    @FXML
    private ToggleButton toggle_IDPatient;

    @FXML
    private Text text_comparaisonExamensExterieursCR;

    @FXML
    private TableColumn<?, ?> colonne_radio;

    @FXML
    private TableColumn<?, ?> colonne_nom;

    @FXML
    private Text text_typeContrasteCR;

    @FXML
    private Text nom;

    @FXML
    private Text typeExam;

    @FXML
    private TableColumn<?, ?> colonne_prenom;

    @FXML
    private ScrollPane comparaison;

    @FXML
    private TableView<Patient> tableau_colonnes;

    @FXML
    private Text text_specialiteRadiologueCR;

    @FXML
    private Text prenom;

    @FXML
    private Text texte_date;

    @FXML
    private Text text_syntheseCR;

    @FXML
    private Text text_prenomPatientCR;

    @FXML
    private ListView<ImageView> listView_imagesExam;

    @FXML
    private Text text_nomRadiologueCR;

    @FXML
    private TableColumn<?, ?> colonne_IDPatient;

    @FXML
    private Text typeProduit;

    @FXML
    private Text dateDeNaissance;

    @FXML
    private Text text_conclusionCR;

    @FXML
    private Text dateRDV;

    @FXML
    private Text text_protocoleStandardiseCR;

    @FXML
    private Text text_resultatCR;

    @FXML
    private ToggleButton toggle_nomPatient;

    @FXML
    private TableColumn<?, ?> colonne_prescri;

    @FXML
    private Text date_naissancePatientCR;

    @FXML
    private TableColumn<?, ?> colonne_type;

    @FXML
    private Text dateExamen;

    @FXML
    private Text resultat;
    @FXML
    private AnchorPane cranchor;
    @FXML
    private Text synthese;
    @FXML
    private ScrollPane scrolpane;
    @FXML
    private Button agrandir;

    @FXML
    private AnchorPane top;
    @FXML
    private Button retour;
    @FXML
    private Button rediger;
    @FXML
            private TableColumn<?,?> sexe;
    @FXML
            private Text aucunExamen;


    FXMLLoader loadermenu;
    Parent menu;
    SIR sir;
    Examen examen;

    private BufferedImage image_to_edit;

    public Image getImage_to_edit(){
        return SwingFXUtils.toFXImage(image_to_edit, null);
    }




    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert toggle_medecinRadiologue != null : "fx:id=\"toggle_medecinRadiologue\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_IDPatient != null : "fx:id=\"toggle_IDPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert listView_imagesExam != null : "fx:id=\"listView_imagesExam\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_IDPatient != null : "fx:id=\"colonne_IDPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert champ_rechercherParNomPatient != null : "fx:id=\"champ_rechercherParNomPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_medecinPrescripteur != null : "fx:id=\"toggle_medecinPrescripteur\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert colonne_patient != null : "fx:id=\"colonne_patient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert ractangle_recherche != null : "fx:id=\"ractangle_recherche\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert texte_rechercherPar != null : "fx:id=\"texte_rechercherPar\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert toggle_nomPatient != null : "fx:id=\"toggle_nomPatient\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert tableau_colonnes != null : "fx:id=\"tableau_colonnes\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert champ_date != null : "fx:id=\"champ_date\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert listView_examensRealises != null : "fx:id=\"listView_examensRealises\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        assert texte_date != null : "fx:id=\"texte_date\" was not injected: check your FXML file 'afficher_dossiers_patient.fxml'.";
        ToggleGroup groupe_toggle_rechercherPar = new ToggleGroup();
        toggle_nomPatient.setToggleGroup(groupe_toggle_rechercherPar);
        toggle_IDPatient.setToggleGroup(groupe_toggle_rechercherPar);
        tableau_colonnes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showListeExam(newValue));

        listeExam.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailExam(newValue));

        champ_rechercherParNomPatient.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString().equals("BACK_SPACE") && champ_rechercherParNomPatient.getText().length() < 2) {
                    MaJTableau maJTableau = new MaJTableau(sir.getListePatient());
                    tableau_colonnes.setItems(maJTableau.getData());

                }
                if(champ_rechercherParNomPatient.getText().length()>0){
                if(toggle_nomPatient.isSelected()){
                    Recherche recherche=new Recherche(sir,event,champ_rechercherParNomPatient.getText());
                    MaJTableau maj = new MaJTableau(recherche.rechercherPatient());
                    tableau_colonnes.setItems(maj.getData());
                }
                else if(toggle_IDPatient.isSelected()){
                    Recherche recherche=new Recherche(sir,event,champ_rechercherParNomPatient.getText());
                    MaJTableau maj = new MaJTableau(recherche.rechercherIdPatient());
                    tableau_colonnes.setItems(maj.getData());
                }

            }}
        });
        listView_imagesExam.getSelectionModel().selectedItemProperty().addListener(observable -> {
            image_to_edit = sir.recupImageExam(Integer.parseInt(examen.getId())).get(listView_imagesExam.getSelectionModel().getSelectedIndex()).getBuffer();

        } );

    }

    private void showDetailExam(TableExamen tableExamen) {
            examen = sir.getExamenFromId(Integer.parseInt(tableExamen.getIdexamen()));
            CR cr = sir.getCRFromIdExam(Integer.parseInt(examen.getId()));
            ArrayList<RWImage>listeIMG=new ArrayList<>(sir.recupImageExam(Integer.parseInt(examen.getId())));
           listViewAnchor.setVisible(true);
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
            resumePbClinique.setText(cr.getProblemeClinique());
            protocole.setText(cr.getProtocoleStandardise());
            text_resultatCR.setText(cr.getResultat());
            text_syntheseCR.setText(cr.getSynthese());
            typeProduit.setText(examen.getProduit());
            quantite.setText(examen.getDose());
            scrolpane.setVisible(true);
            aucunExamen.setVisible(false);
            rediger.setVisible(false);
            }
            else{
                scrolpane.setVisible(false);
                aucunExamen.setText("Aucun Compte-Rendu de rédigé pour l'instant");
                aucunExamen.setVisible(true);
                rediger.setVisible(true);
                if(sir.getConnexion().getType().equals(TypeConnexion.MAN))
                    rediger.setDisable(true);
                System.out.println("CR NULL");
            }
            if(listeIMG.size()>0){
                listView_imagesExam.setDisable(false);
                if(listView_imagesExam.getItems().size()>0)
                    listView_imagesExam.getItems().clear();

                agrandir.setDisable(false);

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
                    if(listView_imagesExam.getItems().size()>0)
                        listView_imagesExam.getItems().clear();

                    listView_imagesExam.setDisable(false);
                    agrandir.setDisable(false);
                }
            }else{
                listView_imagesExam.setDisable(true);
                agrandir.setDisable(true);
            }


    }


    public void initData(SIR sir, Parent menu, FXMLLoader loadermenu){
        this.sir=sir;
        this.menu=menu;
        this.loadermenu=loadermenu;
        Patient patient =sir.getListePatient().get(0);
        final ObservableList<Patient> data= FXCollections.observableArrayList(patient);

        for(int i=1;i<sir.getListePatient().size();i++){
            data.add(sir.getListePatient().get(i));
        }
        menu_controller menu_controller = loadermenu.getController();
        menu_controller.initData(sir);

        colonne_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colonne_IDPatient.setCellValueFactory(new PropertyValueFactory<>("id"));
        sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        tableau_colonnes.setItems(data);

        top.getChildren().add(menu);



    }


    public void showListeExam(Patient patient){
        ArrayList<TableExamen> listetableExamen = new ArrayList<>(sir.getTableExamenFromIdPatient(patient.getId()));
        if(listetableExamen.size()!=0){

            if(listeExam.getItems().size()>0)
                listeExam.getItems().clear();

            TableExamen tableExamen = listetableExamen.get(0);
            final ObservableList<TableExamen> data= FXCollections.observableArrayList(tableExamen);
            for(int i=1;i<listetableExamen.size();i++){
                data.add(listetableExamen.get(i));
            }
            colonne_date.setCellValueFactory(new PropertyValueFactory<>("dateExamen"));
            colonne_prescri.setCellValueFactory(new PropertyValueFactory<>("medecinprescri"));
            colonne_radio.setCellValueFactory(new PropertyValueFactory<>("medecinradio"));
            colonne_type.setCellValueFactory(new PropertyValueFactory<>("typeExam"));
            listeExam.setItems(data);



        }
        else{
            if(listeExam.getItems().size()>0)
            listeExam.getItems().clear();
        }
       scrolpane.setVisible(false);
        aucunExamen.setText("Aucun examen sélectionné");
        aucunExamen.setVisible(true);

    }
    public void retour(ActionEvent event) throws IOException {
        FXMLLoader loadera = new FXMLLoader();
        loadera.setLocation(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
        Parent root= loadera.load();
        acceuil_medecin_controller acceuil_medecin_controller= loadera.getController();
        acceuil_medecin_controller.initData(sir,menu,loadermenu);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();     //pas compris
        stage.setTitle("Sinpati - Acceuil");
        stage.setScene(scene);
        stage.show();
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
        stage.setTitle("Sinpati - Agrandissement");
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
        stage.setTitle("Sinpati - Rédaction CR");
        stage.setScene(scene);
        stage.show();

    }



}


