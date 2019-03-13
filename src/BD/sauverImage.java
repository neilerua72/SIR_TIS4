package BD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class sauverImage {
    public static void main(String[] args) {
        String url = "jdbc:mysql://db4free.net/bdsirtis";
        String user = "testbd";
        String passwd = "12345678";
        String sql = "INSERT INTO Image (idExamen,nom,image) VALUES(?,?,?)";

        int idExamen = 0+(int)(Math.random()*((999999-0)+1));


        try (Connection conn = DriverManager.getConnection(url, user, passwd);) {
            File image = new File("/Users/hugobosquet/Desktop/Projet/jpg/abdomen/cor494-i78.jpg");
            try (FileInputStream inputStream = new FileInputStream(image);
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
               stmt.setInt(1,idExamen);
                stmt.setString(2, "cor494");
                stmt.setBinaryStream(3, inputStream, image.length());
                stmt.executeUpdate();
                System.out.println("Image sauvegarder dans la BD image");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}