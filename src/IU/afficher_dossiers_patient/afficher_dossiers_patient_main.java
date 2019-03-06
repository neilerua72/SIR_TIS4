package IU.afficher_dossiers_patient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class afficher_dossiers_patient_main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        // just load fxml file and display it in the stage:

        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_dossiers_patient.fxml"));
        Parent root = loader.load();
        //root.autosize();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class,
        // and calls start(...) on the FX Application thread:
        launch(args);

    }

}
