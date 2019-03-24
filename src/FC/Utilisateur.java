package FC;
/**
 * Classe qui modélise un utilisateur
 * @author Aurélien
 * @version 1.0
 *
 */
public class Utilisateur {
    private String id;
    private String mdp;
    private String nom;
    private String prenom;
    private TypeConnexion type;

    /**
     * Constructeur qui requiert tout les paramètres pour s'instancier
     * @param nom le nom de l'utilisateur
     * @param prenom le prénom de l'utilisateur
     * @param id l'id de l'utilisateur
     * @param mdp le mot de passe de l'utilisateur
     * @param type le type d'utilisateur
     */
    public Utilisateur (String nom, String prenom, String id, String mdp, TypeConnexion type){
        this.nom = nom;
        this.prenom = prenom;
        this.setId(id);
        this.setMdp(mdp);
        this.type=type;
    }

    /**
     * Constructeur qui ne requiert que l'id et le mot de passe pour s'instancier
     * @param id l'id de l'utilisateur
     * @param mdp le mot de passe de l'utilisateur
     */
    public Utilisateur(String id, String mdp){
        this.mdp=mdp;
        this.id=id;
        this.nom="";
        this.prenom="";
    }

    /**
     * Méthode qui retourne le nom d'utilisateur
     * @return le nom d'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui permet de définir le nom d'utilisateur
     * @param nom le nom d'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode qui retourne le prénom de l'utilisateur
     * @return le prénom d'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Méthode qui permet de définir le prénom d'utilisateur
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }

    /**
     * Méthode qui permet de définir l'ID d'utilisateur
     * @param id l'id de l'utilisateur
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Méthode qui retourne le mot de passe de l'utilisateur
     * @return le mot de passe de l'utilisateur
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Méthode qui permet de définir le mot de passe utilisateur
     * @param mdp le mot de passe utilisateur
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Méthode qui vérifie si 2 utilisateurs sont égaux. On considère 2 utilisateurs égaux si ils ont le même mot de passe et le même id
     * @param user utilisateur que l'on veut comparé
     * @return un boolean qui permet de savoir si il y a égalité ou non
     */
    public boolean equals (Utilisateur user){
        if(this.id.equals(user.getId())&&this.mdp.equals(user.getMdp()))
            return true;

        else
            return false;
    }

    /**
     * Méthode qui retourne le type de connexion
     * @return le type de connexion
     */
    public TypeConnexion getType(){
        return this.type;
    }

    /**
     * Méthode qui retourne le nom et le prénom de l'utilisateur séparé d'un espace
     * @return nom et prénom de l'utilisateur
     */
    public String getNomPremnom(){
        return this.nom + " " + this.prenom;
    }
}
