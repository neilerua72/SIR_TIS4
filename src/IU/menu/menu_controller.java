package IU.menu;

import FC.SIR;
import FC.TypeConnexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class menu_controller{

    @FXML
    private ImageView img;

    @FXML
    private Button deco;

    @FXML
    private Text nomprenom;

    @FXML
    private AnchorPane menu;

    /**
     * Méthode qui initialise les données de l'interface
     * @param sir le SIR de l'application
     */
    public void initData(SIR sir){
        nomprenom.setText(sir.getConnexion().getUser().getNomPremnom()+" / "+sir.getConnexion().getType().toString());
        if(sir.getConnexion().getType().equals(TypeConnexion.SEC))
        img.setImage(new Image("/IU/icone/sec.jpg"));
        else if(sir.getConnexion().getType().equals(TypeConnexion.MED))
            img.setImage(new Image("/IU/icone/med.jpg"));
        else
            img.setImage(new Image("/IU/icone/man.jpg"));
    }

    /**
     * Action pour un bouton qui permet de se déconnecter
     * @param e l'event qui déclenche l'action
     * @throws IOException
     */
    public void seDeco(ActionEvent e) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Voulez vous vous déconnecter ?");
        alert.setHeaderText("Vous allez vous déconnecter.");
        alert.setContentText("Etes vous sûr ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/IU/page_connection/page_connection.fxml"));
            Parent conne = loader.load();
            Scene scene = new Scene(conne);
            Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
            System.out.println("deConnecter");
        } else {

        }


    }


}
