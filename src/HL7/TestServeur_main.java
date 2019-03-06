package HL7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class TestServeur_main  extends Application{

        @Override
        public void start(Stage primaryStage) throws Exception {
            // just load fxml file and display it in the stage:

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestServeur.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
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


