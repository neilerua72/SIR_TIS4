package IU.menu;

import FC.SIR;
import FC.TypeConnexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class menu_controller{

    @FXML
    private ImageView img;

    @FXML
    private Button deco;

    @FXML
    private Text nomprenom;

    @FXML
    private AnchorPane menu;


    public void initData(SIR sir){
        nomprenom.setText(sir.getConnexion().getUser().getNomPremnom()+" / "+sir.getConnexion().getType().toString());
        if(sir.getConnexion().getType().equals(TypeConnexion.SEC))
        img.setImage(new Image("/IU/icone/sec.jpg"));
        else if(sir.getConnexion().getType().equals(TypeConnexion.MED))
            img.setImage(new Image("/IU/icone/med.jpg"));
        else
            img.setImage(new Image("/IU/icone/man.jpg"));
    }
    public void seDeco(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/page_connection/page_connection.fxml"));
        Parent conne = loader.load();
        Scene scene = new Scene(conne);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
        System.out.println("deConnecter");

    }


}
