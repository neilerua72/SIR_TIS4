package FC;

import java.sql.Date;

public class Examen extends RDV {
    private Date dateExamen;
    private boolean image;
    private boolean validation;
    private String crExamen;
    private String medecinRadio;


    public Examen(Date dateRDV, TypeExamen typeExamen, String id, int salle, String cr, String idPatient,String medecinPrescri,Date dateExamen, boolean image, boolean validation, String crExamen,String medecinRadio) {
        super(dateRDV, typeExamen, id, salle, cr,idPatient,medecinPrescri);
        this.dateExamen = dateExamen;
        this.image = image;
        this.validation = validation;
        this.crExamen = crExamen;
        this.medecinRadio=medecinRadio;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public boolean isImage() {
        return image;
    }

    public boolean isValidation() {
        return validation;
    }

    public String getCrExamen() {
        return crExamen;
    }

    public String getMedecinRadio() {
        return medecinRadio;
    }
}
