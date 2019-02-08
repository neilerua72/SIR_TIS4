package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lecture {
    public static void main(String[] args) {
        Connection connexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://192.168.64.2/bdsir";
            String user = "hugo";
            String passwd = "polytech";

            connexion = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            //Création de l'objet gérant les requêtes
            Statement statement= connexion.createStatement();
            //Exécution d'une requete de lecture
            ResultSet resultat = statement.executeQuery("SELECT id,mdp,prénom,nom,Spécialité FROM Connexion;");
            //Récupération des données du résultat de la requete de lecture
            while(resultat.next()){
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
    }

    }
