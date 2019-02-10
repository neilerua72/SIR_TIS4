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
        String jdbcUrl = "jdbc:mysql://192.168.64.2/bdsir";
        String username = "hugo";
        String password = "polytech";
        String sql = "INSERT INTO Image (name,img) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);) {
            File image = new File("/Users/hugobosquet/SIR_TIS4/SIR_TIS4/pgm/brain/brain1_0000.pgm");
            try (FileInputStream inputStream = new FileInputStream(image);
                 PreparedStatement stmt = conn.prepareStatement(sql);) {

                stmt.setString(1, "brain");
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