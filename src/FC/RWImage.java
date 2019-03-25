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

    /**
     * Constructeur qui requiert tout les attributs de la classe pour l'instancier
     * @param nom
     * @param id
     * @param buffer
     * @param idPatient
     */
    public RWImage(String nom, int id, BufferedImage buffer,String idPatient) {
        this.nom = nom;
        this.id = id;
        this.buffer = buffer;
        this.idPatient=idPatient;
    }

    /**
     * Méthode qui retourne le nom de l'image
     * @return le nom de l'image
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui retourne l'id de l'image
     * @return l'id de l'image
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui retourne l'image sous forme de buffered
     * @return le buffered Image
     */
    public BufferedImage getBuffer() {
        return buffer;
    }

    /**
     * Méthode qui retourne l'id de l'EXAMEN
     * @return l'id de l'examen
     */
    public String getIdPatient() {
        return idPatient;
    }
}
