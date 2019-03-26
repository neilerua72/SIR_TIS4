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

/**
 * Classe qui modélise la lecture de notre base de donnée apres connexion à celle ci,
 * cette classe contient une arrayList de toutes les images
 */

public class LectImage {
    ArrayList<RWImage> listeImage;

    /**
     *Méthode qui permet de se connecter à la base de donnée et lire la table image, afin d'ajouter
     * le nom,l' image,idExamen et id dans la liste des images
     */

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
            resultat = statement.executeQuery("SELECT nom,image,idExamen,id FROM Image;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                int id =resultat.getInt("id");
                String name = resultat.getString("nom");
                int idExamen = resultat.getInt("idExamen");
                //Blob img = resultat.getBlob("img");
                byte[] imgData= resultat.getBytes("image");

                System.out.println(name);
                System.out.println(imgData);

                // convert byte array back to BufferedImage
                InputStream in = new ByteArrayInputStream(imgData);
                BufferedImage bImageFromConvert = ImageIO.read(in);

               RWImage rwImage = new RWImage(name,id,bImageFromConvert,String.valueOf(idExamen));
               listeImage.add(rwImage);
                System.out.println("lecture de l'image de la BD");


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
    /**
     * Méthode qui retourne la liste d'images
     * @return liste d'images
     */
    public ArrayList<RWImage> getListeImage() {
        return listeImage;
    }
}
