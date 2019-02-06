package BD;

import java.sql.*;


public class Connect {
    public static void main(String[] args) {

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:8080/bdsir";
        String utilisateur = "root@localhost ";
        String motDePasse = "";
        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

            /* Ici, nous placerons nos requêtes vers la BDD */

            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();
            /* Exécution d'une requête de lecture */
            ResultSet resultat = statement.executeQuery( "SELECT id FROM Connexion;" );
            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                System.out.println("test");
                System.out.println(resultat.getInt( "id" ));
            }
            /* ... */

        } catch ( SQLException e ) {
            System.out.println("erreur 2");
            /* Gérer les éventuelles erreurs ici */
        } finally {
            if ( connexion != null )
                try {
                    /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }
    }
}

