package ClassTable;

import java.sql.Date;

public class TableRDV {
    private Date dateRDV;
    private String typeExam;
    private String idExam;
    private String salle;
    private String cr;
    private int idPatient;
    private String medecinPrescri;
    private String nom;
    private String prenom;


    public Date getDateRDV() {
        return dateRDV;
    }

    public String getTypeExam() {
        return typeExam;
    }

    public String getIdExam() {
        return idExam;
    }

    public String getSalle() {
        return salle;
    }

    public String getCr() {
        return cr;
    }

    public int getIdPatient() {
        return idPatient;
    }


    public TableRDV(Date dateRDV, String typeExam, String idExam, String salle, String cr, int idPatient, String medecinPrescri,String nom, String prenom) {
        this.dateRDV = dateRDV;
        this.typeExam = typeExam;
        this.idExam = idExam;
        this.salle = salle;
        this.cr = cr;
        this.idPatient = idPatient;
        this.medecinPrescri = medecinPrescri;
        this.prenom=prenom;
        this.nom=nom;
    }

    public String getMedecinPrescri() {
        return medecinPrescri;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
