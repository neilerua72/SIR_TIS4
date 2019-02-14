package IU.edition_image;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection;

import static javafx.scene.image.Image.*;

public class edition_image_main extends Application {


        edition_image_controller edition_image = new edition_image_controller();

        @Override
        public void start(Stage primaryStage) throws Exception {
            // just load fxml file and display it in the stage:

            FXMLLoader loader = new FXMLLoader(getClass().getResource("edition_image.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Edition d'Image");
            Scene scene = new Scene(root);
            //edition_image_controller edition_d_image = new edition_image_controller();
            final edition_image_controller edition_d_image = loader.getController();
            //edition_d_image.getImageView_editionImage().setImage(new Image(getClass().getResourceAsStream("test_image_local/mri-abdomen11.jpg")));
            primaryStage.setScene(scene);
            primaryStage.show();


        }


        // main method to support non-JavaFX-aware environments:

        public static void main(String[] args) {
            // starts the FX toolkit, instantiates this class,
            // and calls start(...) on the FX Application thread:
            launch(args);

        }

    }
