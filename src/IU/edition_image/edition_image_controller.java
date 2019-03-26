package IU.edition_image;


/**
 * Sample Skeleton for 'edition_image.fxml' Controller Class
 */

import FC.*;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.print.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import IU.ajout_examen.*;

import static FC.TypeExamen.IRM;
import static sun.plugin.javascript.navig.JSType.Window;

public class edition_image_controller implements Initializable {
    private ajout_examen_controller ajout_examen;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button_inversionGris"
    private Button button_inversionGris; // Value injected by FXMLLoader

    @FXML //fx:id="button_imprimer"
    private Button button_imprimer;

    @FXML //fx:id="pane_image"
    private Pane pane_image;

    @FXML // fx:id="button_symetrieHorizontale"
    private Button button_symetrieHorizontale; // Value injected by FXMLLoader

    @FXML // fx:id="button_refaire"
    private Button button_refaire; // Value injected by FXMLLoader

    @FXML // fx:id="imageView_editionImage"
    private ImageView imageView_editionImage = new ImageView(); // Value injected by FXMLLoader

    @FXML // fx:id="imageView_editionImage"
    private Slider slider_brightness = new Slider(-1, 1, 0.5);

    @FXML // fx:id="button_symetrieVerticale"
    private Button button_symetrieVerticale; // Value injected by FXMLLoader

    @FXML // fx:id="button_augmenterContraste"
    private Button button_augmenterContraste; // Value injected by FXMLLoader

    @FXML // fx:id="button_diminuerContraste"
    private Button button_diminuerContraste; // Value injected by FXMLLoader

    @FXML // fx:id="button_supprimer"
    private Button button_supprimer; // Value injected by FXMLLoader

    @FXML // fx:id="button_annuler"
    private Button button_annuler; // Value injected by FXMLLoader

    @FXML // fx:id="button_rotationGauche"
    private Button button_rotationGauche; // Value injected by FXMLLoader

    @FXML // fx:id="button_valider"
    private Button button_valider = new Button(); // Value injected by FXMLLoader

    @FXML // fx:id="button_rotationDroite"
    private Button button_rotationDroite; // Value injected by FXMLLoader

    @FXML
    private Slider slider_contrast = new Slider();
    Date date = new Date(2019, 03, 02);

    private javafx.scene.image.Image image_edit;

    private StackPane stackPane = new StackPane();
    private ArrayList<File> listImg;

    //private RDV rdv = new RDV(date, IRM, "deux", 07, "fres", 01020102, "bourat");
    private RDV rdv;
    private SIR sir;
    private Parent menu;
    private FXMLLoader loadermenu;

    /**
     * Méthode qui retourne le slider du contraste
     * @return le slider du contraste
     */
    public Slider getSlider_contrast() {
        return slider_contrast;
    }

    int countPair = 0;
    int countOdd = 0;
    int rotateLeftCount = 0;
    int verticalFlipCount = 0;
    int rotateRightCount = 0;

    /**
     * Méthode qui initialise l'interface en background
     * @param location
     * @param resources
     */
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

        pane_image.setMinSize(imageView_editionImage.getFitWidth(), imageView_editionImage.getFitHeight());
        slider_contrast.setValue(0.5);
        ColorAdjust colorAdjust = new ColorAdjust();
        slider_contrast.valueProperty().addListener(new ChangeListener<Number>() {
            /**
             * Méthode qui observe les changement du slider. Si il y a changement, il modifie le contraste
             * @param observable
             * @param oldValue l'ancienne valeur du slider
             * @param newValue la nouvelle valeur du slider
             */
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {
                double newContrast = (newValue.doubleValue()) / 100;
                colorAdjust.setContrast(newContrast);
                System.out.println("newContrast=" + newContrast);
                imageView_editionImage.setEffect(colorAdjust);
                imageView_editionImage.setCache(true);
            }
        });

        slider_brightness.setValue(0.5);
        slider_brightness.valueProperty().addListener(new ChangeListener<Number>() {
            /**
             * Méthode qui observe les changements sur le slider de la luminosité. Si il y a changement, la méthode modifie la luminosité
             * @param observable
             * @param oldValue l'ancienne valeur du slider
             * @param newValue la nouvelle valeur du slider
             */
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {
                double newBrightness = (newValue.doubleValue()) / 100;
                colorAdjust.setBrightness(newBrightness);
                System.out.println("newBrightness=" + newBrightness);
                imageView_editionImage.setEffect(colorAdjust);
                imageView_editionImage.setCache(true);
            }
        });
        //imageView_editionImage.setCacheHint(CacheHint.SPEED);


        //BufferedImage BUFFEREDIMAGE = SwingFXUtils.fromFXImage(imageView_editionImage.getImage(), null);
    }


    public Node printNode;


    /*
    PRINT IMAGE
     */
    private Stage owner;

    /**
     * méthode qui permet de valider l'image et de la rajouter à la liste des images de l'examen
     * @param event event qui déclenche l'action
     * @throws IOException Exception pour gérer le chargement de l'interface
     */
    public void validerImg(ActionEvent event) throws IOException {

            // Scaling the image gives it a higher resolution which results in a better image quality when the image is exported
            SnapshotParameters snapshotParameters = new SnapshotParameters();
            snapshotParameters.setTransform(new Scale(0.445, 0.44444));
            WritableImage snapshot = pane_image.snapshot(snapshotParameters, null);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(snapshot, null);

            //Copy the image so that it won't save pink colored
            BufferedImage imageToSave = new BufferedImage(renderedImage.getWidth(), renderedImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
            imageToSave.getGraphics().drawImage((BufferedImage) renderedImage, 0, 0, null);

            Iterator iter = ImageIO.getImageWritersByFormatName("jpg");
            //Then, choose the first image writer available and create an ImageWriter instance:
            ImageWriter writer = (ImageWriter) iter.next();
            // instantiate an ImageWriteParam object with default compression options
            ImageWriteParam iwp = writer.getDefaultWriteParam();
            //Now, we can set the compression quality:
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT); //set to Explicit mode in order to specify the compression quality
            iwp.setCompressionQuality(1);   // an integer between 0 and 1,  1 specifies minimum compression and maximum quality

            // Output the file:
            String new_file = new String();
            new_file=System.getProperty("user.dir")+"\\Images";
            File dossier=new File(new_file);

            if (!dossier.exists() || !dossier.isDirectory()){
                dossier.mkdir();
            }
            new_file=new_file+"\\"+rdv.getIdPatient();
            dossier=new File(new_file);
            if (!dossier.exists() || !dossier.isDirectory()){
                dossier.mkdir();
            }

            new_file=new_file+"\\"+rdv.getId();
            dossier =new File(new_file);
            if (!dossier.exists() || !dossier.isDirectory()){
                dossier.mkdir();
            }
            int idImg=(int)(Math.random() * ( 999999 - 100000 )+1);
            new_file=new_file+"\\"+idImg+".jpg";


            File file = new File(new_file);
            FileImageOutputStream output;
            try {
                output = new FileImageOutputStream(file);
                writer.setOutput(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
            IIOImage image = new IIOImage(imageToSave, null, null);

            ImageWriteParam param = writer.getDefaultWriteParam();
            ImageTypeSpecifier type = new ImageTypeSpecifier(renderedImage);

            IIOMetadata imgMetadata = writer.getDefaultImageMetadata(type, param);
            listImg.add(file);

            try {
                writer.write(imgMetadata, image, iwp);
                System.out.println("writer");
                System.out.println(new_file);

                String url = "jdbc:mysql://db4free.net/bdsirtis";
                String user = "testbd";
                String passwd = "12345678";
                String sql = "INSERT INTO Image (idExamen,nom,image) VALUES(?,?,?)";

                int idExamen = Integer.valueOf(rdv.getId());


                try (Connection conn = DriverManager.getConnection(url, user, passwd);) {
                    File imagemodif = new File(new_file);
                    try (FileInputStream inputStream = new FileInputStream(imagemodif);
                         PreparedStatement stmt = conn.prepareStatement(sql);) {
                        stmt.setInt(1,idExamen);
                        stmt.setString(2, ""+idImg);
                        stmt.setBinaryStream(3, inputStream, imagemodif.length());
                        stmt.executeUpdate();
                        System.out.println("Image sauvegarder dans la BD image");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.dispose();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/IU/ajout_examen/ajout_examen.fxml"));
            Parent parent = null;
            try {
                parent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ajout_examen_controller controller = loader.getController();
            System.out.println(controller.toString());

            controller.initData(this.sir,rdv,menu,loadermenu);
            controller.initImg(listImg);
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }


    /**
     * Méthode qui permet d'imprimer une image
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void printImage() throws
            NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("pressed");
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        /*double scaleX = pageLayout.getPrintableWidth() / imageView_editionImage.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / imageView_editionImage.getBoundsInParent().getHeight();
        Scale scale = new Scale(scaleX, scaleY); */
        // pane_image.getTransforms().add(scale);
        PrinterJob job = PrinterJob.createPrinterJob();
        //PrinterAttributes attr = printer.getPrinterAttributes();
        pane_image.setPrefSize(pageLayout.getPrintableWidth(), pageLayout.getPrintableHeight());
        if (job == null) {
            return;
        }
        //boolean proceed = job.showPageSetupDialog(owner);
        boolean proceed = job.showPrintDialog(owner);
        if (proceed) {
            //  print(job);
            //}
            //System.out.println(job);
            if (job != null) {
                System.out.println(job);
                //boolean success = job.printPage(pane_image);
                boolean success = job.printPage(pageLayout, pane_image);
                System.out.println("success?" + success);
                if (success) {
                    job.endJob();
                    System.out.println("ok");
                }
            }
        }
    }

    /**
     * Méthode qui retourne l'imageView de l'édition d'image
     * @return un ImageView
     */
    public ImageView getImageView_editionImage() {
        return imageView_editionImage;
    }

    /**
     * Méthode qui permet d'initialiser l'interface et de mettre à jour les champs avec les informations nécessaires.
     * @param Image l'image à éditer
     * @param rdv le RDV correspondant à l'examen en cours
     * @param listImg la liste d'image en cours d'enregistrement
     * @param sir le SIR de l'application
     * @param menu le menu de l'application
     * @param loadermenu le loader du menu
     */
    public void setImageView_editionImage(Image Image, RDV rdv, ArrayList<File> listImg, SIR sir, Parent menu, FXMLLoader loadermenu) {
        this.imageView_editionImage.setImage(Image);
        this.rdv=rdv;
        this.listImg=listImg;
        this.sir=sir;
        this.menu=menu;
        this.loadermenu=loadermenu;
    }

    /**
     * Méthode qui retourne l'image
     * @param actionEvent l'event qui déclenche l'action
     */
    public void verticalFlipActivated(ActionEvent actionEvent) {
        if (verticalFlipCount % 2 == 0) {
            imageView_editionImage.setScaleY(-1.0);
            System.out.println("verticalFlipActivated");
        } else if (verticalFlipCount % 2 == 1) {
            imageView_editionImage.setScaleY(1.0);
            System.out.println("verticalFlipActivated again");
        }
        verticalFlipCount++;
    }


    int horizontalFlipCount = 0;

    /**
     * Méthode qui retourne l'image horizontalement
     * @param actionEvent event qui déclenche l'action
     */
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

    /**
     * Méthode qui retourne l'image à gauche
     * @param actionEvent event qui déclenche l'action
     */
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

    /**
     * Méthode qui retourne l'image à droite
     * @param actionEvent event qui déclenche l'action
     */
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

    /**
     * Méthode qui inverse les couleurs
     */
    public void invertGreyScale() {
        PixelReader pixelReader = imageView_editionImage.getImage().getPixelReader();
        WritableImage copyImage = new WritableImage((int) imageView_editionImage.getImage().getWidth(), (int) imageView_editionImage.getImage().getHeight());
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
    }

}
