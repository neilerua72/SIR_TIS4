package FC;

public class Utilisateur {
    private String id;
    private String mdp;
    private String nom;
    private String prenom;
    public Utilisateur (String nom, String prenom, String id, String mdp){
        this.nom = nom;
        this.prenom = prenom;
        this.setId(id);
        this.setMdp(mdp);
    }
    public Utilisateur(String id, String mdp){
        this.mdp=mdp;
        this.id=id;
        this.nom="jacky";
        this.prenom="Paul";
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public boolean equals (Utilisateur user){
        if(this.id.equals(user.getId())&&this.mdp.equals(user.getMdp()))
            return true;

        else
            return false;
    }
}
