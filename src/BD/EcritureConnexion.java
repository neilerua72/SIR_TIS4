package BD;

import java.sql.*;

public class EcritureConnexion {
    public static void main(String[] args) {
        Connection connexion = null;
        Statement statement = null;

        try {

            String url = "jdbc:mysql://192.168.64.2/bdsir";
            String user = "hugo";
            String passwd = "polytech";

            connexion = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete d'écriture
            int statut = statement.executeUpdate("INSERT INTO Connexion (id,mdp,prénom,nom,Spécialité)" +
                    "VALUES ('444444','123456','hugo','bosquet','manipulateur');");
            //Récupération des données du statut de la requete de lecture
            System.out.println("Résultat de la requête d'insertion:" +statut + ".");
            }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

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

