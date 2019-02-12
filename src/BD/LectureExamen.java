package BD;

import java.sql.*;

public class LectureExamen {
    public static void main(String[] args) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {

            String url = "jdbc:mysql://mysql-hugdude.alwaysdata.net/hugdude_bdsir?serverTimezone=UTC";
            String user = "hugdude";
            String passwd = "hugo";

            connexion = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT idExamen,dateExamen,image,validation,compteRendu,typeExamen,Salle FROM Examen;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                int idExamen = resultat.getInt("idExamen");
                Date dateExamen = resultat.getDate("dateExamen");
                int image = resultat.getInt("image");
                boolean validation = resultat.getBoolean("validation");
                String compteRendu = resultat.getString("compteRendu");
                String typeExamen = resultat.getString("typeExamen");
                int salle = resultat.getInt("salle");


                System.out.println(idExamen);
                System.out.println(dateExamen);
                System.out.println(image);
                System.out.println(validation);
                System.out.println(compteRendu);
                System.out.println(typeExamen);
                System.out.println(salle);
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
