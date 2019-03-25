package FC;

import java.util.Date;
/**
 * Classe qui modélise un patient. On y retrouve toute les informations pour un patient. Elle contient aussi une adresse.
 * @author Aurélien
 * @version 1.0
 * @see FC.Adresse
 */

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

    /**
     * Constructeur qui requiert tout les attributs pour instancier la classe Patient
     * @param nom le nom du patient
     * @param prenom le prenom du patient
     * @param id l'id du patient
     * @param dateDeNaissance la date de naissance du patient
     * @param sexe le sexe du patient
     * @param mail l'adresse mail du patient
     * @param numTel le numéro de téléphone du patient
     * @param adresse l'adresse du patient
     * @param service_acceuil le service d'accueil du patient
     * @param nomMedecinPrescripteur le medecin prescripteur
     */
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

    /**
     * Méthode qui instancit un patient sans paramètre
     */
    public Patient(){

    }


    /**
     * Méthode qui renvoit le patient sous forme de chaine de caractère
     * @return une chaine de caractère
     */
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

    /**
     * Méthode qui retoune le nom du patient
     * @return le nom du patient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui retoune le prénom du patient
     * @return le prénom du patient
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * Méthode qui retoune l'id du patient
     * @return l'id du patient
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode qui retoune la date de naissance du patient
     * @return la date de naissance du patient
     */
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    /**
     * Méthode qui retoune le sexe du patient
     * @return le sexe du patient
     */
    public String getSexe(){
        return this.sexe;
    }


}
