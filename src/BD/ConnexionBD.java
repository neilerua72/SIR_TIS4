package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBD {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://db4free.net/bdsirtis";
            String user = "testbd";
            String passwd = "12345678";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


