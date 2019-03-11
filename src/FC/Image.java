package FC;

import java.awt.image.BufferedImage;
import java.sql.Blob;

public class Image {
    private String nom;
    private Blob img;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    public Image(String nom, Blob img) {
        this.nom = nom;
        this.img = img;
    }

    public void setImage(BufferedImage read) {
    }
}
