package IU.acceuil_secretaire;

/**
 * Sample Skeleton for 'acceuil_secretaire.fxml' Controller Class
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import IU.ajouter_patient.ajouter_patient_controller;
import IU.redaction_CR.redaction_CR_controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class acceuil_secretaire_controller {


        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="comboBoxTrierPar"
        private ComboBox<?> comboBoxTrierPar; // Value injected by FXMLLoader

        @FXML // fx:id="text_Valides"
        private Text text_Valides; // Value injected by FXMLLoader

        @FXML // fx:id="precriptions"
        private Text precriptions; // Value injected by FXMLLoader

        @FXML // fx:id="listView_Valides"
        private ListView<?> listView_Valides; // Value injected by FXMLLoader

        @FXML // fx:id="scrollPane_Prescriptions"
        private ScrollPane scrollPane_Prescriptions; // Value injected by FXMLLoader

        @FXML // fx:id="listView_Admissions"
        private ListView<?> listView_Admissions; // Value injected by FXMLLoader

        @FXML // fx:id="button_NouveauRDV"
        private Button button_NouveauRDV; // Value injected by FXMLLoader

        @FXML // fx:id="button_RedigerCompteRendu"
        private Button button_RedigerCompteRendu; // Value injected by FXMLLoader

        @FXML // fx:id="text_Admission"
        private Text text_Admission; // Value injected by FXMLLoader

        @FXML // fx:id="button_AjouterPatient"
        private Button button_AjouterPatient; // Value injected by FXMLLoader




        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert comboBoxTrierPar != null : "fx:id=\"comboBoxTrierPar\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            assert text_Valides != null : "fx:id=\"text_Valides\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            assert precriptions != null : "fx:id=\"precriptions\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            assert listView_Valides != null : "fx:id=\"listView_Valides\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            assert scrollPane_Prescriptions != null : "fx:id=\"scrollPane_Prescriptions\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            assert listView_Admissions != null : "fx:id=\"listView_Admissions\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
           // assert button_NouveauRDV != null : "fx:id=\"button_NouveauRDV\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            assert button_RedigerCompteRendu != null : "fx:id=\"button_RedigerCompteRendu\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            //assert text_Admission != null : "fx:id=\"text_Admission\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";
            assert button_AjouterPatient != null : "fx:id=\"button_AjouterPatient\" was not injected: check your FXML file 'acceuil_secretaire.fxml'.";

        }

    public void redigerCompteRendu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/redaction_CR/redaction_CR.fxml"));
        Parent parent = loader.load();
        redaction_CR_controller controller = loader.getController();
        System.out.println(controller.toString());

        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();

    }

}



