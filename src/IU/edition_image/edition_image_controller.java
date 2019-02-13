package IU.edition_image;


/**
 * Sample Skeleton for 'edition_image.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class edition_image_controller {

        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="button_inversionGris"
        private Button button_inversionGris; // Value injected by FXMLLoader

        @FXML // fx:id="button_symetrieHorizontale"
        private Button button_symetrieHorizontale; // Value injected by FXMLLoader

        @FXML // fx:id="button_refaire"
        private Button button_refaire; // Value injected by FXMLLoader

        @FXML // fx:id="imageView_editionImage"
        private ImageView imageView_editionImage; // Value injected by FXMLLoader

        @FXML // fx:id="button_symetrieVerticale"
        private Button button_symetrieVerticale; // Value injected by FXMLLoader

        @FXML // fx:id="button_augmenterContraste"
        private Button button_augmenterContraste; // Value injected by FXMLLoader

        @FXML // fx:id="button_diminuerContraste"
        private Button button_diminuerContraste; // Value injected by FXMLLoader

        @FXML // fx:id="button_ajoutCommentaire"
        private Button button_ajoutCommentaire; // Value injected by FXMLLoader

        @FXML // fx:id="button_supprimer"
        private Button button_supprimer; // Value injected by FXMLLoader

        @FXML // fx:id="button_annuler"
        private Button button_annuler; // Value injected by FXMLLoader

        @FXML // fx:id="button_rotationGauche"
        private Button button_rotationGauche; // Value injected by FXMLLoader

        @FXML // fx:id="button_valider"
        private Button button_valider; // Value injected by FXMLLoader

        @FXML // fx:id="button_rotationDroite"
        private Button button_rotationDroite; // Value injected by FXMLLoader

        // @FXML
        //  void 97979700(ActionEvent event) {
        //
        // }



        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert button_inversionGris != null : "fx:id=\"button_inversionGris\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_symetrieHorizontale != null : "fx:id=\"button_symetrieHorizontale\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_refaire != null : "fx:id=\"button_refaire\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert imageView_editionImage != null : "fx:id=\"imageView_editionImage\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_symetrieVerticale != null : "fx:id=\"button_symetrieVerticale\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_augmenterContraste != null : "fx:id=\"button_augmenterContraste\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_diminuerContraste != null : "fx:id=\"button_diminuerContraste\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_ajoutCommentaire != null : "fx:id=\"button_ajoutCommentaire\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_supprimer != null : "fx:id=\"button_supprimer\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_annuler != null : "fx:id=\"button_annuler\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_rotationGauche != null : "fx:id=\"button_rotationGauche\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_valider != null : "fx:id=\"button_valider\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_rotationDroite != null : "fx:id=\"button_rotationDroite\" was not injected: check your FXML file 'edition_image.fxml'.";

        }
    }



