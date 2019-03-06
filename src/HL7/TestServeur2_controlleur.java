package HL7;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import library.interfaces.ClientHL7;
import library.interfaces.MessageInterface;
import library.interfaces.Patient;

public class TestServeur2_controlleur {



    @FXML
    private Button connect;

    @FXML
    private TextField host;

    @FXML
    private TextField port;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

   /* @FXML
    private void Envoie(){
        String host = this.host.getText();
        Integer port = Integer.parseInt(this.port.getText());
        ClientHL7 c = new ClientHL7();
        c.connexion(host, port);
        c.admit(patient);
        MessageInterface messageAck = c.getMsg();
        this.l1.setText("ID message : " + messageAck.getId());
        this.l2.setText(messageAck.getAcknowledgmentCodeString());
        this.l3.setText("ID Ack: " + messageAck.getIdAck());
    }*/
}
