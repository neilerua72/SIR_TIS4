package BD;

import FC.Connexion;
import FC.TypeConnexion;
import FC.Utilisateur;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LectConnexion {
    private ArrayList<Utilisateur> listeUsers = new ArrayList<>();
    public LectConnexion(){
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT id,mdp,prenom,nom,type FROM Connexion;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                String idConnexion = resultat.getString("id");
                String motDePasseUtilisateur = resultat.getString("mdp");
                String prenom = resultat.getString("prenom");
                String nom = resultat.getString("nom");
                String type = resultat.getString("type");
                TypeConnexion typec=TypeConnexion.SEC;
                        typec=typec.matchType(type);
                Utilisateur u = new Utilisateur(nom,prenom,idConnexion,motDePasseUtilisateur,typec);
                this.listeUsers.add(u);
                System.out.println(idConnexion);
                System.out.println(motDePasseUtilisateur);
                System.out.println(prenom);
                System.out.println(nom);
                System.out.println(type);
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
    public ArrayList<Utilisateur> getListeUsers(){
        return this.listeUsers;
    }
}

