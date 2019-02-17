package FC;

import java.util.Date;

public class Patient {
    private String nom;
    private String prenom;
    private int id;
    private Date dateDeNaissance;
    private String mail;
    private int numTel;
    private Adresse adresse;
    private String pathologie;
    private String nomMedecinPrescripteur;
    private Date dateRDV;

    public Patient(String nom, String prenom, int id, Date dateDeNaissance, String mail, int numTel, Adresse adresse, String pathologie, String nomMedecinPrescripteur, Date dateRDV) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.dateDeNaissance = dateDeNaissance;
        this.mail = mail;
        this.numTel = numTel;
        this.adresse = adresse;
        this.pathologie = pathologie;
        this.nomMedecinPrescripteur = nomMedecinPrescripteur;
        this.dateRDV = dateRDV;
    }


    public String toString(){
        String s="";
        s="Nom : "+nom + " Prénom :"+prenom;
        s+="\n "+id;
        s+="\n "+dateDeNaissance;
        s+="\n "+mail;
        s+="\n "+numTel;
        s+="\n "+adresse;
        s+="\n "+pathologie;
        s+="\n "+nomMedecinPrescripteur;
        s+="\n "+dateRDV;

        return s;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getMail() {
        return mail;
    }

    public int getNumTel() {
        return numTel;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getPathologie() {
        return pathologie;
    }

    public String getNomMedecinPrescripteur() {
        return nomMedecinPrescripteur;
    }

    public Date getDateRDV() {
        return dateRDV;
    }
}
