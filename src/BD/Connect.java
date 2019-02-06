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
        String url = "jdbc:mysql://localhost:3306/bdsir";
        String utilisateur = "root";
        String motDePasse = "";
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */

        } catch ( SQLException e ) {
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

