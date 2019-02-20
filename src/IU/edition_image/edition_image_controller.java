package IU.edition_image;


/**
 * Sample Skeleton for 'edition_image.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Lighting;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

import javax.swing.*;

public class edition_image_controller implements Initializable {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button_inversionGris"
    private Button button_inversionGris; // Value injected by FXMLLoader

    @FXML // fx:id="button_symetrieHorizontale"
    private Button button_symetrieHorizontale; // Value injected by FXMLLoader

    @FXML // fx:id="button_refaire"
    private Button button_refaire; // Value injected by FXMLLoader

    @FXML // fx:id="imageView_editionImage"
    private ImageView imageView_editionImage = new ImageView(); // Value injected by FXMLLoader


    @FXML // fx:id="button_symetrieVerticale"
    private Button button_symetrieVerticale; // Value injected by FXMLLoader

    @FXML // fx:id="button_augmenterContraste"
    private Button button_augmenterContraste; // Value injected by FXMLLoader

    @FXML // fx:id="button_diminuerContraste"
    private Button button_diminuerContraste; // Value injected by FXMLLoader

    @FXML // fx:id="button_ajoutCommentaire"
    private Button button_ajoutCommentaire; // Value injected by FXMLLoader

    @FXML // fx:id="button_supprimer"
    private Button button_supprimer; // Value injected by FXMLLoader

    @FXML // fx:id="button_annuler"
    private Button button_annuler; // Value injected by FXMLLoader

    @FXML // fx:id="button_rotationGauche"
    private Button button_rotationGauche; // Value injected by FXMLLoader

    @FXML // fx:id="button_valider"
    private Button button_valider; // Value injected by FXMLLoader

    @FXML // fx:id="button_rotationDroite"
    private Button button_rotationDroite; // Value injected by FXMLLoader

    @FXML
    private Slider slider_contrast = new Slider();


    public Slider getSlider_contrast() {
        return slider_contrast;
    }


    // @FXML
    //  void 97979700(ActionEvent event) {
    //
    // }

    @FXML
    // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources) {
           /* assert button_inversionGris != null : "fx:id=\"button_inversionGris\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_symetrieHorizontale != null : "fx:id=\"button_symetrieHorizontale\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_refaire != null : "fx:id=\"button_refaire\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert imageView_editionImage != null : "fx:id=\"imageView_editionImage\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_symetrieVerticale != null : "fx:id=\"button_symetrieVerticale\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_augmenterContraste != null : "fx:id=\"button_augmenterContraste\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_diminuerContraste != null : "fx:id=\"button_diminuerContraste\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_ajoutCommentaire != null : "fx:id=\"button_ajoutCommentaire\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_supprimer != null : "fx:id=\"button_supprimer\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_annuler != null : "fx:id=\"button_annuler\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_rotationGauche != null : "fx:id=\"button_rotationGauche\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_valider != null : "fx:id=\"button_valider\" was not injected: check your FXML file 'edition_image.fxml'.";
            assert button_rotationDroite != null : "fx:id=\"button_rotationDroite\" was not injected: check your FXML file 'edition_image.fxml'.";
*/
        slider_contrast.setValue(0.5);
        ColorAdjust colorAdjust = new ColorAdjust();
        slider_contrast.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {
                double newBrightness = (newValue.doubleValue()) / 100;
                colorAdjust.setBrightness(newBrightness);
                System.out.println("newBrightness=" + newBrightness);
                imageView_editionImage.setEffect(colorAdjust);
                colorAdjust.setContrast((newValue.doubleValue()) / 100);
                imageView_editionImage.setEffect(colorAdjust);
            }
        });
    }

    public ImageView getImageView_editionImage() {
        return imageView_editionImage;
    }

    public void setImageView_editionImage(ImageView imageView_editionImage) {
        this.imageView_editionImage = imageView_editionImage;
    }

    int verticalFlipCount = 0;

    public void verticalFlipActivated(ActionEvent actionEvent) {

        if (verticalFlipCount % 2 == 0) {
            this.imageView_editionImage.setScaleY(-1.0);
            System.out.println("verticalFlipActivated");
        } else if (verticalFlipCount % 2 == 1) {
            this.imageView_editionImage.setScaleY(1.0);
            System.out.println("verticalFlipActivated again");
        }
        verticalFlipCount++;
    }

    int horizontalFlipCount = 0;

    public void horizontalFlipActivated(ActionEvent actionEvent) {
        if (horizontalFlipCount % 2 == 0) {
            this.imageView_editionImage.setScaleX(-1.0);
            System.out.println("horizontalFlipActivated");
        } else if (horizontalFlipCount % 2 == 1) {
            this.imageView_editionImage.setScaleX(1.0);
            System.out.println("horizontalFlipActivated again");
        }
        horizontalFlipCount++;
    }

    int countPair = 0;
    int countOdd = 0;

    int rotateLeftCount = 0;

    public void rotateLeftActivated(ActionEvent actionEvent) {
        if (rotateLeftCount % 2 == 0) {
            if (countPair % 2 == 0) {
                this.imageView_editionImage.rotateProperty().setValue(90);
                System.out.println("rotate left 90");
            } else if (countPair % 2 == 1) {
                this.imageView_editionImage.rotateProperty().setValue(-90);
                System.out.println("rotate left -90");
            }
            countPair++;
        } else if (rotateLeftCount % 2 == 1) {
            if (countOdd % 2 == 0) {
                this.imageView_editionImage.rotateProperty().setValue(180);
                System.out.println("rotate left 180");
            } else if (countOdd % 2 == 1) {
                this.imageView_editionImage.rotateProperty().setValue(0);
                System.out.println("rotate left 0");
            }
            countOdd++;
        }
        rotateLeftCount++;
    }


    int rotateRightCount = 0;

    public void rotateRightActivated(ActionEvent actionEvent) {
        if (rotateRightCount % 2 == 0) {
            if (countPair % 2 == 0) {
                this.imageView_editionImage.rotateProperty().setValue(-90);
                System.out.println("rotate right -90");
            } else if (countPair % 2 == 1) {
                this.imageView_editionImage.rotateProperty().setValue(90);
                System.out.println("rotate right 90");
            }
            countPair++;

        } else if (rotateRightCount % 2 == 1) {
            if (countOdd % 2 == 0) {
                this.imageView_editionImage.rotateProperty().setValue(-180);
                System.out.println("rotate right -180");
            } else if (countOdd % 2 == 1) {
                this.imageView_editionImage.rotateProperty().setValue(0);
                System.out.println("rotate right 0");
            }
            countOdd++;
        }
        rotateRightCount++;
    }

    public void invertGreyScale() {
        PixelReader pixelReader = imageView_editionImage.getImage().getPixelReader();
       WritableImage copyImage
                = new WritableImage(
                (int) imageView_editionImage.getImage().getWidth(),
                (int) imageView_editionImage.getImage().getHeight());
        PixelWriter pixelWriter = copyImage.getPixelWriter();
        for (int y = 0; y < imageView_editionImage.getImage().getHeight(); y++) {
            for (int x = 0; x < imageView_editionImage.getImage().getWidth(); x++) {
                Color color = pixelReader.getColor(x, y);
                color = color.invert();
                pixelWriter.setColor(x, y, color);
            }
        }
        System.out.println("pixelWriter.setColor(x, y, color");
        imageView_editionImage.setImage(copyImage);
        //return copyImage;
    }



    /* // Create Slider to Adjust Color
    private Slider createSlider(final int adjustType) {
        Slider slider_contrast = this.createSlider(ADJUST_TYPE_CONTRAST);
        Slider slider = new Slider();
        slider.setMin(-1);
        slider.setMax(1);
        slider.setBlockIncrement(0.1);
        slider.setValue(0);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {
                switch (adjustType) {
                    case ADJUST_TYPE_CONTRAST:
                        colorAdjust.setContrast(newValue.doubleValue());
                        break;
                }
            }
        });
        return slider;
    }  */
}


/*    public void changeImage() {

        Image newImg = SwingFXUtils.toFXImage(imgt, null);
        img_1.setImage(newImg);
...
    } catch (Exception e) {
        System.out.println("Not working");
    }
            return img_1;
}*/

