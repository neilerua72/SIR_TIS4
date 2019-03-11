package FC;

import java.sql.Date;

public class RDV {
    private Date dateRDV;
    private TypeExamen typeExamen;
    private String id;
    private int salle;
    private String cr;
    private int idPatient;
    private String medecinPrescri;

    public RDV(Date dateRDV, TypeExamen typeExamen, String id, int salle, String cr,int idPatient,String medecinPrescri) {
        this.dateRDV = dateRDV;
        this.typeExamen = typeExamen;
        this.id = id;
        this.salle = salle;
        this.cr = cr;
        this.idPatient=idPatient;
        this.medecinPrescri=medecinPrescri;

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

    public String getCr() {
        return cr;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public String getMedecinPrescri() {
        return medecinPrescri;
    }
}
