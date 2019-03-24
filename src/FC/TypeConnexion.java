package FC;
/**
 * Classe qui définit les différents types de connexion possible
 * @author Aurélien
 * @version 1.0
 *
 */
public enum TypeConnexion {
    MED("Médecin Radiologue"),
    MAN("Manipulateur Radiologue"),
    SEC("Secrétaire");
    private String nom="";
    TypeConnexion(String nom) {
        this.nom=nom;
    }

    public TypeConnexion matchType(String type){
        if(type.equals("MED"))
            return TypeConnexion.MED;
        if(type.equals("MAN"))
            return TypeConnexion.MAN;
        if(type.equals("SEC"))
            return TypeConnexion.SEC;
        else
            return null;
    }
    public String toString(){
        return nom;
    }
}

