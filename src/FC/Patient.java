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
    private String service_acceuil;
    private String nomMedecinPrescripteur;
    private String sexe;


    public Patient(String nom, String prenom, int id, Date dateDeNaissance,String sexe, String mail, int numTel, Adresse adresse, String service_acceuil, String nomMedecinPrescripteur) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.dateDeNaissance = dateDeNaissance;
        this.mail = mail;
        this.numTel = numTel;
        this.adresse = adresse;
        this.service_acceuil = service_acceuil;
        this.nomMedecinPrescripteur = nomMedecinPrescripteur;
        this.sexe=sexe;

    }
    public Patient(){

    }


    public String toString(){
        String s="";
        s="Nom : "+nom + " Prénom :"+prenom;
        s+="\n "+id;
        s+="\n "+dateDeNaissance;
        s+="\n "+mail;
        s+="\n "+numTel;
        s+="\n "+adresse;
        s+="\n "+service_acceuil;
        s+="\n "+nomMedecinPrescripteur;


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
        return service_acceuil;
    }

    public String getNomMedecinPrescripteur() {
        return nomMedecinPrescripteur;
    }

    public String getSexe(){
        return this.sexe;
    }


}
