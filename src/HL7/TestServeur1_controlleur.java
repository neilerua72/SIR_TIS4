package HL7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TestServeur1_controlleur {
    @FXML
    private Button Connect;


    @FXML
    private void Connexion(ActionEvent e)  throws IOException {
        URL url_accreuil_medecin;
        //url_accreuil_medecin = new File("IU.acceuil_medecin.acceuil_medecin.fxml").toURL();
        Parent parent = FXMLLoader.load(getClass().getResource("/HL7/TestServeur2.fxml"));

        Scene scene = new Scene(parent);

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();     //pas compris
        stage.setScene(scene);

        stage.show();
    }
}


