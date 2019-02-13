package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBase {
    private String url;
    private String passwd;
    private String user;
    public ConnexionBase(){
        this.url="jdbc:mysql://db4free.net/bdsirtis";;
        this.passwd="12345678";
        this.user="testbd";
    }
    public Connection returnConnexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://db4free.net/bdsirtis";
            String user = "testbd";
            String passwd = "12345678";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
