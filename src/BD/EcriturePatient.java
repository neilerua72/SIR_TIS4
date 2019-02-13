package BD;

import java.sql.*;

public class EcriturePatient {
    public static void main(String[] args) {
        Connection connexion = null;
        Statement statement = null;

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete d'écriture
            int statut = statement.executeUpdate("INSERT INTO `Patient` (`nom`, `prenom`, `id`, `dateDeNaissance`, `mail`, `numeroTel`, `rue`, `infoComp`, `codePostal`, `ville`, `pathologie`, `nomMedecinPrescripteur`, `serviceAcceuil`, `dateRDV`) VALUES\n" +
                            "('Techer', 'Leslie', 234567, '1995-02-08', 'Leslie.Techer@gmail.com', 062350563, '26 chemin de la réunion', NULL, 69007, 'Lyon', 'Fracture', 'Cohen', 'Urgence', '2019-02-09 10:00:00');");
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
