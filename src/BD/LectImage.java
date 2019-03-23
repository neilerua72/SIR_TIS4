package BD;

import FC.RWImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class LectImage {
    ArrayList<RWImage> listeImage;
    public LectImage(){
        listeImage = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT nom,image,idExamen FROM Image;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {

                String name = resultat.getString("nom");
                int idExamen = resultat.getInt("idExamen");
                //Blob img = resultat.getBlob("img");
                byte[] imgData= resultat.getBytes("image");

                System.out.println(name);
                System.out.println(imgData);

                // convert byte array back to BufferedImage
                InputStream in = new ByteArrayInputStream(imgData);
                BufferedImage bImageFromConvert = ImageIO.read(in);

               /* ImageIO.write(bImageFromConvert, "jpg", new File(
                        "/Users/hugobosquet/Desktop/new-sinus.jpg"));*/
               RWImage rwImage = new RWImage(name,idExamen,bImageFromConvert,String.valueOf(idExamen));
               listeImage.add(rwImage);
                System.out.println("copie de l'image sur le bureau");


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //libération des  ressources
        finally {
            if (resultat != null) {
                try {
                    /* On commence par fermer le ResultSet */
                    resultat.close();
                } catch (SQLException ignore) {
                }
            }
            if (statement != null) {
                try {
                    /* Puis on ferme le Statement */
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connexion != null) {
                try {
                    /* Et enfin on ferme la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }

    public ArrayList<RWImage> getListeImage() {
        return listeImage;
    }
}
