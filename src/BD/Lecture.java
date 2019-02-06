package BD;

import java.sql.*;

public class Lecture {
    public static void main (String[] args) {
        String url = "jdbc:mysql://localhost:3306/bdsir";
        String utilisateur = "root";
        String motDePasse = "";
        Connection cn = null; Statement st =null; ResultSet rs =null;

        try{
            // Etape 1 récupértion de la connexion
            cn= DriverManager.getConnection(url, utilisateur, motDePasse);
            //Etape 2 Création d'un statement
            st = cn.createStatement();
            String sql = "SELECT "
        }
    }
}
