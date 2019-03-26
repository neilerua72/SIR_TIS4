package BD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe qui modélise une connexion à la base de donnée en ligne. cette classe contient un url, un
 * mot de passe ainsi qu'un identifiant
 */
public class ConnexionBase {
    private String url;
    private String passwd;
    private String user;

    /**
     * méthode qui permet de stocker l'identifiant et le mot de passe de notre base de donnée en ligne
     * disponible à partir de cet URL
     */
    public ConnexionBase(){
        this.url="jdbc:mysql://db4free.net/bdsirtis";;
        this.passwd="12345678";
        this.user="testbd";
    }

    /**
     *L'instruction try vous permet de définir un bloc de code à tester pour détecter les erreurs lors de son exécution:
     * - test la présence du driver dans l'external librarie celui ci permet d'établir une connexion entre un programme
     * Java et un système de gestion de bases de données  ici jdbc
     * - test si la connexion est effective à notre base de donnée (url, idetifiant et mot de passe correct)
     * L'instruction catch permet l'affiche de l'exception et de son état dans la pile d'exécution au moment de son appel en cas d'erreur dans le bloc try
     *
     * @return conn ou null
     */
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
