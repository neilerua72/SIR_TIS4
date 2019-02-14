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
        String sql = "INSERT INTO Image (nom,img) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, passwd);) {
            File image = new File("/Users/hugobosquet/SIR_TIS4/SIR_TIS4/pgm/sinus/sinus1_0000.pgm");
            try (FileInputStream inputStream = new FileInputStream(image);
                 PreparedStatement stmt = conn.prepareStatement(sql);) {

                stmt.setString(1, "sinus1");
                stmt.setBinaryStream(2, inputStream, image.length());
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