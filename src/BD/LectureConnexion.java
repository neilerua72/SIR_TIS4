package BD;

import java.sql.*;

public class LectureConnexion {
    public static void main(String[] args) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {

            String url = "jdbc:mysql://192.168.64.2/bdsir";
            String user = "hugo";
            String passwd = "polytech";

            connexion = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT id,mdp,prénom,nom,Spécialité FROM Connexion;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                int idConnexion = resultat.getInt("id");
                int motDePasseUtilisateur = resultat.getInt("mdp");
                String prenom = resultat.getString("prénom");
                String nom = resultat.getString("nom");
                String specialite = resultat.getString("Spécialité");

                System.out.println(idConnexion);
                System.out.println(motDePasseUtilisateur);
                System.out.println(prenom);
                System.out.println(nom);
                System.out.println(specialite);
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
