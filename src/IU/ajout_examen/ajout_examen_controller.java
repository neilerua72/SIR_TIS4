
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import IU.edition_image.edition_image_controller;
import javafx.scene.image.Image;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

public class ajout_examen_controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button_editionImage"
    private Button button_editionImage; // Value injected by FXMLLoader

    @FXML // fx:id="champ_vueManip"
    private TextField champ_vueManip; // Value injected by FXMLLoader

    @FXML // fx:id="button_validerManipulation"
    private Button button_validerManipulation; // Value injected by FXMLLoader

    @FXML // fx:id="choice_uniteDoseManip"
    private ChoiceBox<?> choice_uniteDoseManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_doseRecueManip"
    private TextField champ_doseRecueManip; // Value injected by FXMLLoader

    @FXML // fx:id="choice_sexePatientManip"
    private ChoiceBox<?> choice_sexePatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="choice_typeExamManip"
    private ChoiceBox<?> choice_typeExamManip; // Value injected by FXMLLoader

    @FXML // fx:id="button_acquisitionImage"
    private Button button_acquisitionImage; // Value injected by FXMLLoader

    @FXML // fx:id="champ_nomPatientManip"
    private TextField champ_nomPatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="date_examenManip"
    private DatePicker date_examenManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_idExamManip"
    private TextField champ_idExamManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_lateraliteManip"
    private TextField champ_lateraliteManip; // Value injected by FXMLLoader

    @FXML // fx:id="button_annulerEdition"
    private Button button_annulerEdition; // Value injected by FXMLLoader

    @FXML // fx:id="date_naissancePatientManip"
    private DatePicker date_naissancePatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_manipulateurManip"
    private TextField champ_manipulateurManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_idPatienManip"
    private TextField champ_idPatienManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_medecinPrescripteurManip"
    private TextField champ_medecinPrescripteurManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_prenomPatientManip"
    private TextField champ_prenomPatientManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_medecinRadiologueManip"
    private TextField champ_medecinRadiologueManip; // Value injected by FXMLLoader

    @FXML // fx:id="champ_zoneEtudieeManip"
    private TextField champ_zoneEtudieeManip; // Value injected by FXMLLoader

    @FXML
    private ListView<ImageView> listView_images;

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
        assert choice_sexePatientManip != null : "fx:id=\"choice_sexePatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert choice_typeExamManip != null : "fx:id=\"choice_typeExamManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert button_acquisitionImage != null : "fx:id=\"button_acquisitionImage\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_nomPatientManip != null : "fx:id=\"champ_nomPatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert date_examenManip != null : "fx:id=\"date_examenManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_idExamManip != null : "fx:id=\"champ_idExamManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_lateraliteManip != null : "fx:id=\"champ_lateraliteManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert button_annulerEdition != null : "fx:id=\"button_annulerEdition\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert date_naissancePatientManip != null : "fx:id=\"date_naissancePatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_manipulateurManip != null : "fx:id=\"champ_manipulateurManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_idPatienManip != null : "fx:id=\"champ_idPatienManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_medecinPrescripteurManip != null : "fx:id=\"champ_medecinPrescripteurManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
        assert champ_prenomPatientManip != null : "fx:id=\"champ_prenomPatientManip\" was not injected: check your FXML file 'ajout_manip.fxml'.";
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

    //faire liaison bouton

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
        controller.setImageView_editionImage(this.getImage_to_edit());
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