
package IU.ajout_examen;

/**
 * * Sample Skeleton for 'ajout_manip.fxml' Controller Class
 */


import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.Date;

import BD.ConnexionBase;
import FC.*;
import IU.acceuil_medecin.acceuil_medecin_controller;
import IU.edition_image.edition_image_controller;
import IU.redaction_CR.redaction_CR_controller;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

public class ajout_examen_controller {

    @FXML
    private Text textNom;

    @FXML
    private Text textIdExamen;

    @FXML
    private Button button_editionImage;

    @FXML
    private TextField champ_vueManip;

    @FXML
    private Button button_validerManipulation;

    @FXML
    private Text textIdPatient;

    @FXML
    private ChoiceBox<?> choice_uniteDoseManip;

    @FXML
    private TextField champ_doseRecueManip;

    @FXML
    private Text textTypeExam;

    @FXML
    private Button button_acquisitionImage;

    @FXML
    private Text textDateExam;

    @FXML
    private TextField champ_lateraliteManip;

    @FXML
    private Button button_annulerEdition;

    @FXML
    private Text textPrenom;

    @FXML
    private TextField champ_manipulateurManip;

    @FXML
    private ListView<ImageView> listView_images;

    @FXML
    private Text champ_medecinPrescripteurManip;

    @FXML
    private TextField champ_medecinRadiologueManip;

    @FXML
    private TextField champ_zoneEtudieeManip;

    @FXML
            private TextField produitdecontraste;

    RDV rdv;
    SIR sir;
    Parent menu;
    FXMLLoader loadermenu;
    List<File> selectedImages;

    ArrayList<File> selectedImage = new ArrayList<>();
    String st = new String();
    private int indice;

    private BufferedImage image_to_edit;
    public Image getImage_to_edit(){
        return SwingFXUtils.toFXImage(image_to_edit, null);
    }

    public Image setImage_to_edit(BufferedImage image){
        return SwingFXUtils.toFXImage(image, null);
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert button_editionImage != null : "fx:id=\"button_editionImage\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_vueManip != null : "fx:id=\"champ_vueManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert button_validerManipulation != null : "fx:id=\"button_validerManipulation\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert choice_uniteDoseManip != null : "fx:id=\"choice_uniteDoseManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_doseRecueManip != null : "fx:id=\"champ_doseRecueManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";

        assert button_acquisitionImage != null : "fx:id=\"button_acquisitionImage\" was not injected: check your FXML file 'ajout_manip.fxml'.";

        assert champ_lateraliteManip != null : "fx:id=\"champ_lateraliteManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert button_annulerEdition != null : "fx:id=\"button_annulerEdition\" was not injected: check your FXML file 'ajout_manip.fxml'.";

        assert champ_manipulateurManip != null : "fx:id=\"champ_manipulateurManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";

        assert champ_medecinPrescripteurManip != null : "fx:id=\"champ_medecinPrescripteurManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";

        assert champ_medecinRadiologueManip != null : "fx:id=\"champ_medecinRadiologueManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_zoneEtudieeManip != null : "fx:id=\"champ_zoneEtudieeManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";

        listView_images.getSelectionModel().selectedItemProperty().addListener(observable ->
                //st =  listView_images.getSelectionModel().getSelectedItem().getId());
                //System.out.println("st"+st);
                //   int indice = listView_images.getSelectionModel().getSelectedIndex();
        {
            try {
                image_to_edit = ImageIO.read(selectedImage.get(listView_images.getSelectionModel().getSelectedIndex()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("??" + selectedImage.get(listView_images.getSelectionModel().getSelectedIndex()));
            //  System.out.println("Valeur Selectionnée"+ listView_images.getSelectionModel().getSelectedIndices()));
        });
    }
    public void initData(SIR sir, RDV rdv,Parent menu, FXMLLoader loadermenu){
        this.sir=sir;
        this.menu=menu;
        this.loadermenu=loadermenu;
        this.rdv=rdv;
        textNom.setText(sir.getPatientFromId(rdv.getIdPatient()).getNom());
        textPrenom.setText(sir.getPatientFromId(rdv.getIdPatient()).getPrenom());
        textIdPatient.setText(""+rdv.getIdPatient());
        textIdExamen.setText(rdv.getId());
        textTypeExam.setText(rdv.getTypeExamen().toString());
        if(sir.getConnexion().getType().equals(TypeConnexion.MED))
        {
            champ_medecinRadiologueManip.setText(sir.getConnexion().getUser().getNomPremnom());
        }
        else{
            champ_manipulateurManip.setText(sir.getConnexion().getUser().getNomPremnom());
        }
        champ_medecinPrescripteurManip.setText(rdv.getMedecinPrescri());
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(date);
        textDateExam.setText(dat);
    }

    //faire liaison bouton

    ObservableList<BufferedImage> list_images;

    public void chooseFileForList(ActionEvent event) throws IOException {
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Choisir les images associées au dossier");
        //file_chooser.setInitialDirectory(new File("C:\\Users\\Utilisateur\\Documents\\Polytech\\Cours TIS4\\Semestre 8\\SIR\\SIR_TIS4\\src\\IU\\edition_image\\test_image_local"));
        file_chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Fichiers Image",
                        "*.bmp", "*.png", "*.jpg")); // limit fileChooser options to image files
        //File file = chooser.showOpenDialog(new Stage());
        //File file = file_chooser.showOpenDialog(button_acquisitionImage.getScene().getWindow());


        /**
         * bloc qui rajoute les noms de fichiers images
         */
       /* List<File> selectedFiles = file_chooser.showOpenMultipleDialog(null);
        System.out.println("liste selected files"+selectedFiles);
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                listView_images.getItems().add(file);
            }
        } else {
            System.out.println("File is not Valid");
        }
*/
        /**
         * bloc qui rajoute les images à la liste
         */
        listView_images.getItems().clear();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        selectedImages = file_chooser.showOpenMultipleDialog(stage);
        System.out.println("selectedImages" + selectedImages);

        File item = selectedImages.get(0);
        // System.out.println(selectedImages.get(0));
        //System.out.println("contains"+ selectedImage.contains(item));
        if (selectedImage.contains(item) != true) {
            selectedImage.add(item);
        }
        // System.out.println("selectedImage before"+selectedImage);
        if (selectedImages != null) {
            for (int i = 1; i < selectedImages.size(); i++) {
                item = selectedImages.get(i);
                //System.out.println("item boucle"+item);
                if (selectedImage.contains(item) != true) {
                    selectedImage.add(item);
                    //  System.out.println("image" + selectedImage);
                }
            }
            System.out.println("liste selected files" + selectedImages);
            for (File file : selectedImage) {
                BufferedImage buffered_image = ImageIO.read(file);
                //if trop grand: rescale -> Il faut qu'elles fassent toutes la même taille
                if ((buffered_image.getHeight() > 275) && (buffered_image.getWidth() > 275)) {
                    AffineTransform tx = new AffineTransform();
                    tx.scale(0.2, 0.2);
                    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
                    BufferedImage bufferedimage = op.filter(buffered_image, null);
                    Image image = SwingFXUtils.toFXImage(bufferedimage, null);
                    ImageView imageview = new ImageView(image);
                    listView_images.getItems().add(imageview);
                } else {
                    //
                    //int lastItem = listView_images.getItems().size()-1;
                    //listView_images.getItems().size();
                    // listView_images.getItems().remove(listView_images.getItems().get(0),listView_images.getItems().get(lastItem)); //vider le truc qui affiche et le re remplir

                    Image image = SwingFXUtils.toFXImage(buffered_image, null);
                    ImageView imageview = new ImageView(image);
                    listView_images.getItems().add(imageview);
                }
            }
        } else {
            System.out.println("File is not Valid");
        }
    }

    public void editionImage(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/edition_image/edition_image.fxml"));
        Parent parent = loader.load();

        //access the controller and get a method
        edition_image_controller controller = loader.getController();
        System.out.println(controller);
        controller.setImageView_editionImage(this.getImage_to_edit(),this.rdv,this.selectedImage,sir,menu,loadermenu);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Sinpati - Edition Image");

        stage.setScene(scene);
        stage.show();


    }
    public void ValiderManip(ActionEvent event) throws IOException {
        String lateralite = champ_lateraliteManip.getText();
        String vue = champ_vueManip.getText();
        String dose = champ_doseRecueManip.getText();
        String produit = produitdecontraste.getText();
        String zoneetudie = champ_zoneEtudieeManip.getText();
        java.sql.Date date = rdv.getDateRDV();
        TypeExamen type = rdv.getTypeExamen();
        String id = rdv.getId();
        int salle = rdv.getSalle();
        boolean cr = false;
        int idPatient = rdv.getIdPatient();
        String medecinPrescri = rdv.getMedecinPrescri();
        String medecinRadio = champ_medecinRadiologueManip.getText();
        String manip = champ_manipulateurManip.getText();
        java.sql.Date dateEx = new java.sql.Date(new Date().getTime());
        boolean image=true;
        boolean validation=false;



        Examen examen= new Examen(produit,dose,lateralite,vue,zoneetudie,date,type,id,salle,idPatient,medecinPrescri,dateEx,image,validation,cr,medecinRadio);
        sir.getListeExamen().add(examen);
        sir.supprimerRDV(id);

        Connection connexion = null;
        Statement statement = null;

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();
            String query = "UPDATE Examen SET idExamen=?,idPatient=?,dateRDV=?,ExamenFait=?,dateExamen=?," +
                    "CRExamen=?,image=?,validation=?,typeExamen=?,Salle=?,medecinPrescri=?,medecinRadio=?," +
                    "vue=?,lateralite=?,zoneetudie=?,dose=?,produit=? WHERE idExamen='"+id+"'";
            //Création de l'objet gérant les requêtes
            PreparedStatement preparedStmt= connexion.prepareStatement(query);
            preparedStmt.setString(1,id);
            preparedStmt.setInt(2,idPatient);
            preparedStmt.setDate(3,date);
            preparedStmt.setInt(4,1);
            preparedStmt.setDate(5,dateEx);
            preparedStmt.setInt(6,0);
            preparedStmt.setInt(7,1);
            preparedStmt.setInt(8,0);
            preparedStmt.setString(9,type.returnType());
            preparedStmt.setInt(10,salle);
            preparedStmt.setString(11,medecinPrescri);
            preparedStmt.setString(12,medecinRadio);
            preparedStmt.setString(13,vue);
            preparedStmt.setString(14,lateralite);
            preparedStmt.setString(15,zoneetudie);
            preparedStmt.setString(16,dose);
            preparedStmt.setString(17,produit);



            //Récupération des données du statut de la requete d'update
            preparedStmt.executeUpdate();
            System.out.println("update de la BD examen");

        }
        catch (Exception e) {
            e.printStackTrace();
        }



        for(int i=0;i<this.selectedImages.size();i++){
            int index = selectedImages.get(i).getName().indexOf('.');
            String nomFichier = selectedImages.get(i).getName().substring(0,index);
            int idImg=(int)(Math.random() * ( 999999 - 100000 )+1);
            while(sir.checkIdImage(idImg)){
                idImg = 0+(int)(Math.random()*((999999-0)+1));
            }
            BufferedImage buffered_image = ImageIO.read(selectedImages.get(i));
            RWImage rwImage = new RWImage(nomFichier,idImg,buffered_image,rdv.getId());
            sir.getListeImage().add(rwImage);
        }


        if(this.sir.getConnexion().getType().equals(TypeConnexion.MED)){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/IU/redaction_CR/redaction_CR.fxml"));
            Parent parent = loader.load();
            redaction_CR_controller redaction_cr_controller = loader.getController();
            redaction_cr_controller.initData(sir,examen,menu,loadermenu);
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sinpati - Rédaction CR");
            stage.setScene(scene);
            stage.show();

        }
        else{


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
            Parent parent = loader.load();
            acceuil_medecin_controller redaction_cr_controller = loader.getController();
            redaction_cr_controller.initData(sir,menu,loadermenu);
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sinpati - Acceuil");
            stage.setScene(scene);
            stage.show();
        }
    }
    public void initImg(ArrayList<File> listeImg) throws IOException {
        for(int i=0;i<listeImg.size();i++){
            selectedImage.add(listeImg.get(i));
        }
        for (File file : selectedImage) {
            BufferedImage buffered_image = ImageIO.read(file);
            //if trop grand: rescale -> Il faut qu'elles fassent toutes la même taille
            if ((buffered_image.getHeight() > 275) && (buffered_image.getWidth() > 275)) {
                AffineTransform tx = new AffineTransform();
                tx.scale(0.2, 0.2);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage bufferedimage = op.filter(buffered_image, null);
                Image image = SwingFXUtils.toFXImage(bufferedimage, null);
                ImageView imageview = new ImageView(image);
                listView_images.getItems().add(imageview);
            } else {
                //
                //int lastItem = listView_images.getItems().size()-1;
                //listView_images.getItems().size();
                // listView_images.getItems().remove(listView_images.getItems().get(0),listView_images.getItems().get(lastItem)); //vider le truc qui affiche et le re remplir

                Image image = SwingFXUtils.toFXImage(buffered_image, null);
                ImageView imageview = new ImageView(image);
                listView_images.getItems().add(imageview);
            }
        }
    }
}


