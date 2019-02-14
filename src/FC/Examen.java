package FC;

import java.sql.Date;

public class Examen extends RDV {
    private Date dateExamen;
    private boolean image;
    private boolean validation;
    private String crExamen;


    public Examen(Date dateRDV, TypeExamen typeExamen, int id, int salle, String cr, Date dateExamen, boolean image, boolean validation, String crExamen) {
        super(dateRDV, typeExamen, id, salle, cr);
        this.dateExamen = dateExamen;
        this.image = image;
        this.validation = validation;
        this.crExamen = crExamen;
    }
}
