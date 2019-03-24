package FC;

import java.sql.Date;
/**
 * Classe qui modélise un examen. Un examen est un examen radiologique, qui hérite de la classe RDV, puisque un examen est un rdv élargit
 * @author Aurélien
 * @version 1.0
 * @see FC.RDV
 */
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


    /**
     * Constructeur qui requiert tout les attributs pour instancier la classe
     * @param produit le produit utilisé pour l'imagerie
     * @param dose la dose injecté ou utilisé
     * @param lateralite la latéralité de la prise
     * @param vue la vue de la prise
     * @param zoneetudie la zone étudié
     * @param dateRDV la date du RDV
     * @param typeExamen le type d'examen
     * @param id l'id de l'examen
     * @param salle la salle de l'examen
     * @param idPatient l'id du Patient
     * @param medecinPrescri le medecin prescripteur de l'examen
     * @param dateExamen la date de l'exaxmen
     * @param image si les images sont validés ou non
     * @param validation si l'examen est validé ou non
     * @param crExamen si il y a un CR pour cet examen ou non
     * @param medecinRadio le médecin Radiologue
     */
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

    /**
     * Constructeur de la classe qui ne requiert aucun attribut pour s'instancier
     */
    public Examen() {
        super();
    }

    /**
     * Méthode qui retourne la date de l'examen
     * @return la date de l'examen
     */
    public Date getDateExamen() {
        return dateExamen;
    }

    /**
     * Méthode qui retourne si les images sont validés ou non
     * @return si les images sont validés ou non
     */
    public boolean isImage() {
        return image;
    }

    /**
     * Méthode qui retourne si l'examen est validé ou non
     * @return si l'examen est validé ou non
     */
    public boolean isValidation() {
        return validation;
    }

    /**
     * Méthode qui retourne si il y a un CR pour l'examen ou non
     * @return si il y a un CR pour l'examen ou non
     */
    public boolean getCr() {
        return crExamen;
    }

    /**
     * Méthode qui retourne qui retourne le médecin radiologue
     * @return le médecin radiologue
     */
    public String getMedecinRadio() {
        return medecinRadio;
    }

    /**
     * Méthode qui fixe la valeur de l'attribut CrExamen. Permet de notifier le fait qu'un CR a été éditer pour l'examen
     * @param set
     */
    public void setCrExamen(boolean set){
        this.crExamen=set;
    }

    /**
     * Méthode qui retourne la latéralité
     * @return la latéralité
     */
    public String getLateralite() {
        return lateralite;
    }

    /**
     * Méthode qui retourne la vue
     * @return la vue
     */
    public String getVue() {
        return vue;
    }

    /**
     * Méthode qui retourne la zone étudiée
     * @return la zone étudié
     */
    public String getZoneetudie() {
        return zoneetudie;
    }

    /**
     * Méthode qui retourne le produit utilisé
     * @return le produit utilisé
     */
    public String getProduit() {
        return produit;
    }

    /**
     * Méthode qui retourne la dose
     * @return la dose
     */
    public String getDose() {
        return dose;
    }
}
