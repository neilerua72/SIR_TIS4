package FC;

import java.awt.image.BufferedImage;
import java.sql.Blob;

public class RWImage {
   private String nom;
   private int id;
   private BufferedImage buffer;

    public RWImage(String nom, int id, BufferedImage buffer) {
        this.nom = nom;
        this.id = id;
        this.buffer = buffer;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public BufferedImage getBuffer() {
        return buffer;
    }
}
