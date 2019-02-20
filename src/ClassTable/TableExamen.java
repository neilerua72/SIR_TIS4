package ClassTable;

import java.sql.Date;

public class TableExamen {
    private String nom;
    private String prenom;
    private int idpatient;
    private Date dateExamen;
    private String medecinradio;
    private String medecinprescri;
    private int idexamen;
    private String cr;
    private String typeExam;
    private String image;
    private String dossierPatient;

    public TableExamen(String nom, String prenom, int idpatient, Date dateExamen, String medecinradio, String medecinprescri, int idexamen, String typeExam, String image, String dossierPatient,String cr) {

        this.nom = nom;
        this.prenom = prenom;
        this.idpatient = idpatient;
        this.dateExamen = dateExamen;
        this.medecinradio = medecinradio;
        this.medecinprescri = medecinprescri;
        this.idexamen = idexamen;
        this.typeExam = typeExam;
        this.image = image;
        this.dossierPatient = dossierPatient;
        this.cr=cr;

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public String getMedecinradio() {
        return medecinradio;
    }

    public String getMedecinprescri() {
        return medecinprescri;
    }

    public int getIdexamen() {
        return idexamen;
    }

    public String getCr() {
        return cr;
    }

    public String getTypeExam() {
        return typeExam;
    }

    public String getImage() {
        return image;
    }

    public String getDossierPatient() {
        return dossierPatient;
    }
}
