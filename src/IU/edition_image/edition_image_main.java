package IU.edition_image;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
/*
            edition_d_image.getSlider_contrast().valueProperty().addListener(new ChangeListener<Number>() {
                public void changed (ObservableValue <? extends Number > ov,
                                     Number old_val, Number new_val){
                    edition_d_image.getSlider_contrast().setOpacity(new_val.doubleValue());

                }
            });*/

        }


        // main method to support non-JavaFX-aware environments:

        public static void main(String[] args) {
            // starts the FX toolkit, instantiates this class,
            // and calls start(...) on the FX Application thread:
            launch(args);

        }

    }
