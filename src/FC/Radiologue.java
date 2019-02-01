package FC;



public class Radiologue extends Utilisateur {

    private String nom;
    private String prenom;
    private String id;
    private String mdp;

    public Radiologue(String nom, String prenom, String id, String mdp) {
        super(nom, prenom, id, mdp);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getId() {
        return id;
    }

    public String getMdp() {
        return mdp;
    }

    /* Affichage du nom, prénom du médecin */
    public String toString() {
        return "Dr " + nom.toUpperCase() + " " + prenom;
    }



}
