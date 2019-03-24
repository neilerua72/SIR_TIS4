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

    public RDV(Date dateRDV, TypeExamen typeExamen, String id, int salle,int idPatient,String medecinPrescri) {
        this.dateRDV = dateRDV;
        this.typeExamen = typeExamen;
        this.id = id;
        this.salle = salle;

        this.idPatient=idPatient;
        this.medecinPrescri=medecinPrescri;

    }

    public RDV() {

    }

    public Date getDateRDV() {
        return dateRDV;
    }

    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    public String getId() {
        return id;
    }

    public int getSalle() {
        return salle;
    }



    public int getIdPatient() {
        return idPatient;
    }

    public String getMedecinPrescri() {
        return medecinPrescri;
    }
}
