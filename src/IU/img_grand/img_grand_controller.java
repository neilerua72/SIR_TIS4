package IU.img_grand;

import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;

import java.awt.image.BufferedImage;

public class img_grand_controller {
  @FXML
  private ImageView test;


    public void initData(Image image){
            test.setImage(image);
    }
}
