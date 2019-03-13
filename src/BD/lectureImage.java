package BD;




import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;


public class lectureImage {

    public static void main(String[] args) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT idExamen,nom,img FROM Image;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {

                int idExamen = resultat.getInt("idExamen");
                String name = resultat.getString("nom");
               //Blob img = resultat.getBlob("img");
                byte[] imgData= resultat.getBytes("img");

                System.out.println(idExamen);
                System.out.println(name);
                System.out.println(imgData);

                // convert byte array back to BufferedImage
                InputStream in = new ByteArrayInputStream(imgData);
                BufferedImage bImageFromConvert = ImageIO.read(in);

                ImageIO.write(bImageFromConvert, "jpg", new File(
                        "/Users/hugobosquet/Desktop/new-sinus.jpg"));
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
}
