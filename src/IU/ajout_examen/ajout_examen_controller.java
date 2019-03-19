
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import FC.RDV;
import FC.SIR;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private TextField champ_medecinPrescripteurManip;

    @FXML
    private TextField champ_medecinRadiologueManip;

    @FXML
    private TextField champ_zoneEtudieeManip;


    ArrayList<File> selectedImage = new ArrayList<>();

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

    }
    public void initData(SIR sir, RDV rdv){
        textNom.setText(sir.getPatientFromId(rdv.getIdPatient()).getNom());
        textPrenom.setText(sir.getPatientFromId(rdv.getIdPatient()).getPrenom());
        textIdPatient.setText(""+rdv.getIdPatient());
        textIdExamen.setText(rdv.getId());
        textTypeExam.setText(rdv.getTypeExamen().toString());
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(date);
        textDateExam.setText(dat);
    }

    ObservableList<BufferedImage> list_images;

    public void chooseFileForList() throws IOException {
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Choisir les images associées au dossier");
        file_chooser.setInitialDirectory(new File("C:\\Users\\Utilisateur\\Documents\\Polytech\\Cours TIS4\\Semestre 8\\SIR\\SIR_TIS4\\src\\IU\\edition_image\\test_image_local"));
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
        List<File> selectedImages = file_chooser.showOpenMultipleDialog(null);
        System.out.println("selectedImages"+selectedImages);
        //problème avec contains check doc
        File item = selectedImages.get(0);
       // System.out.println(selectedImages.get(0));
        //System.out.println("contains"+ selectedImage.contains(item));
        if (selectedImage.contains(item) != true) {selectedImage.add(item); }
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
        loader.setLocation(getClass().getResource("/IU/afficher_dossiers_patient/afficher_dossiers_patient.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();


    }
}



   /* public void chooseFile(ActionEvent actionEvent) throws MalformedURLException {
FileChooser chooser = new FileChooser();
chooser.setTitle("Choisir une Image");
chooser.getExtensionFilters().addAll(
new FileChooser.ExtensionFilter("Image Files",
"*.bmp", "*.png", "*.jpg")); // limit fileChooser options to image files
//File file = chooser.showOpenDialog(new Stage());
File file = chooser.showOpenDialog(button_acquisitionImage.getScene().getWindow());  * /
if (file != null) {
try {
BufferedImage bufferedImage = ImageIO.read(file);
Image image = SwingFXUtils.toFXImage(bufferedImage, null);
imageView_dl.setImage(image);
} catch (IOException e) {
//e.printStackTrace();
}

} else {
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Message d'information");
alert.setHeaderText("Vous n'avez pas choisi d'image à traiter!");
//alert.setContentText("Veuillez sélectionner une image à traiter");
alert.showAndWait();
}

}
}  */