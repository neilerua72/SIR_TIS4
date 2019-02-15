package BD;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;


public class afficheImage extends Application {

    @Override
    public void start(Stage primaryStage) {

        final String imageURI = new File("/Users/hugobosquet/Desktop/jpg/abdomen/cor494-i43.jpg").toURI().toString();
        final Image image = new Image(imageURI);

        final ImageView imageView = new ImageView(image);
        final Pane root = new Pane();
        root.getChildren().setAll(imageView);
        final Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Test d'affichage d'image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}