package BD;

import java.sql.*;

public class LecturePatient {
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
            resultat = statement.executeQuery("SELECT nom,prenom,id,dateDeNaissance,mail,numeroTel,rue,infoComp,codePostal," +
                    "ville,pathologie,nomMedecinPrescripteur,serviceAcceuil,dateRDV FROM Patient;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                int idConnexion = resultat.getInt("id");
                Date dateDeNaissance = resultat.getDate("dateDeNaissance");
                String mail = resultat.getString("mail");
                int numeroTel = resultat.getInt("numeroTel");
                String rue = resultat.getString("rue");
                String infoComp = resultat.getString("infoComp");
                int codePostal = resultat.getInt("codePostal");
                String ville = resultat.getString("ville");
                String pathologie = resultat.getString("pathologie");
                String nomMedecinPrescripteur = resultat.getString("nomMedecinPrescripteur");
                Date dateRDV = resultat.getDate("dateRDV");


                System.out.println(nom);
                System.out.println(prenom);
                System.out.println(idConnexion);
                System.out.println(dateDeNaissance);
                System.out.println(mail);
                System.out.println(numeroTel);
                System.out.println(rue);
                System.out.println(infoComp);
                System.out.println(codePostal);
                System.out.println(ville);
                System.out.println(pathologie);
                System.out.println(nomMedecinPrescripteur);
                System.out.println(dateRDV);
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