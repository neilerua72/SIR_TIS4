package FC;

import java.util.Date;

public class RDV {
    private Date dateRDV;
    private TypeExamen typeExamen;
    private int id;
    private int salle;
    private String cr;

    public RDV(Date dateRDV, TypeExamen typeExamen, int id, int salle, String cr) {
        this.dateRDV = dateRDV;
        this.typeExamen = typeExamen;
        this.id = id;
        this.salle = salle;
        this.cr = cr;
    }
}
