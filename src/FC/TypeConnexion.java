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

    /**
     * Constructeur de l'enum qui prends en paramètre le nom de la connexion
     * @param nom nom de la connexion
     */
    TypeConnexion(String nom) {
        this.nom=nom;
    }

    /**
     * Méthode qui retourne selon une chaine de caractère donné en paramètre le type correspondant. Cela permet notamment de définir un type lorsque l'ont recoit un string de la base de données
     * @param type la chaine de caractère dont on veut retrouver le type
     * @return le type de connexion correspondant
     */
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
    /**
     * Méthode qui retourne le type sous forme de chaine de caractère
     * @return le type sous forme de chaine de caractère
     */
    public String toString(){
        return nom;
    }
}

