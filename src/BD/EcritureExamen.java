package BD;

import java.sql.*;

public class EcritureExamen {
    public static void main(String[] args) {
        Connection connexion = null;
        Statement statement = null;

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();
            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete d'écriture
            int statut = statement.executeUpdate("INSERT INTO `Examen` (`idExamen`,`idPatient`,`dateRDV`,`ExamenFait`,`medecinPrescri`,`medecinRadio`,`dateExamen`,`image`,`validation`" +
                    ",`CRExamen`,`typeExamen`,`Salle`,`vue`,`zoneetudie`,`lateralite`,`produit,dose`) VALUES\n" +
                    "(234567, '2019-02-09 12:00:00', 1, 1, 'présence frature ouverte', 'Radiographie', 5);");
            //Récupération des données du statut de la requete d'écriture
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
