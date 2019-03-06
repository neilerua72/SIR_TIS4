package IU.menu;

import FC.SIR;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
    }

}
