package HL7;

import FC.SIR;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestClient_main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        // just load fxml file and display it in the stage:

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TestClient.fxml"));
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
        System.out.println(System.getProperty("user.dir"));

    }
}
