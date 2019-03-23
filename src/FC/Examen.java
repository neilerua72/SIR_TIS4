package FC;

import java.sql.Date;

public class Examen extends RDV {
    private Date dateExamen;
    private boolean image;
    private boolean validation;
    private boolean crExamen;
    private String medecinRadio;
    private String lateralite;
    private String vue;
    private String zoneetudie;
    private String produit;
    private String dose;



    public Examen(String produit, String dose,String lateralite,String vue,String zoneetudie,Date dateRDV, TypeExamen typeExamen, String id, int salle, int idPatient,String medecinPrescri,Date dateExamen, boolean image, boolean validation, boolean crExamen,String medecinRadio) {
        super(dateRDV, typeExamen, id, salle,idPatient,medecinPrescri);
        this.dateExamen = dateExamen;
        this.image = image;
        this.validation = validation;
        this.crExamen = crExamen;
        this.medecinRadio=medecinRadio;
        this.lateralite=lateralite;
        this.vue=vue;
        this.zoneetudie=zoneetudie;
        this.dose=dose;
        this.produit=produit;
    }

    public Examen() {
        super();
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

    public boolean getCr() {
        return crExamen;
    }

    public String getMedecinRadio() {
        return medecinRadio;
    }
    public void setCrExamen(boolean set){
        this.crExamen=set;
    }

    public boolean isCrExamen() {
        return crExamen;
    }

    public String getLateralite() {
        return lateralite;
    }

    public String getVue() {
        return vue;
    }

    public String getZoneetudie() {
        return zoneetudie;
    }

    public String getProduit() {
        return produit;
    }

    public String getDose() {
        return dose;
    }
}
