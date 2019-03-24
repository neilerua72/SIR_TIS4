package FC;

import java.awt.image.BufferedImage;
import java.sql.Blob;
/**
 * Classe qui modélise une image. Elle permet de retrouver les infos d'une image dont cette application a besoin pour tourner
 * @author Aurélien
 * @version 1.0
 *
 */
public class RWImage {
   private String nom;
   private int id;
   private BufferedImage buffer;
   private String idPatient;

    public RWImage(String nom, int id, BufferedImage buffer,String idPatient) {
        this.nom = nom;
        this.id = id;
        this.buffer = buffer;
        this.idPatient=idPatient;
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

    public String getIdPatient() {
        return idPatient;
    }
}
