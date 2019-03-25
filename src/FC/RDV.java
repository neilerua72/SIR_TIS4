package FC;

import java.sql.Date;
/**
 * Classe qui modélise un RDV. Il s'agit d'une classe avec les informations de base d'un RDV
 * @author Aurélien
 * @version 1.0
 *
 */
public class RDV {
    private Date dateRDV;
    private TypeExamen typeExamen;
    private String id;
    private int salle;

    private int idPatient;
    private String medecinPrescri;

    /**
     * Méthode qui requiert tout les attributs de la classe pour l'instancier
     * @param dateRDV la date du RDV
     * @param typeExamen le type d'examen
     * @param id l'id du RDV
     * @param salle la salle du RDV
     * @param idPatient l'id du patient concerné
     * @param medecinPrescri le medecin prescripteur
     */
    public RDV(Date dateRDV, TypeExamen typeExamen, String id, int salle,int idPatient,String medecinPrescri) {
        this.dateRDV = dateRDV;
        this.typeExamen = typeExamen;
        this.id = id;
        this.salle = salle;

        this.idPatient=idPatient;
        this.medecinPrescri=medecinPrescri;

    }

    /**
     * Méthode qui instancie la classe RDV sans paramètre
     */
    public RDV() {

    }

    /**
     * Méthode qui retourne la date du RDV
     * @return la date du Rendez-Vous
     */
    public Date getDateRDV() {
        return dateRDV;
    }

    /**
     * Méthode qui retoune le type d'examen
     * @return le type d'examen
     */
    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    /**
     * Méthode qui retoune l'id du RDV (qui deviendra id de l'examen)
     * @return id du RDV
     */
    public String getId() {
        return id;
    }

    /**
     * Méthode qui retoune la salle du RDV
     * @return la salle du RDV
     */
    public int getSalle() {
        return salle;
    }


    /**
     * Méthode qui retoune l'id du patient qui a un RDV
     * @return l'id du patient
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * Méthode qui retoune le medecin prescripteur du RDV
     * @return le medecin préscripteur
     */
    public String getMedecinPrescri() {
        return medecinPrescri;
    }
}
