package FC;

/**
 * Classe qui définit les différents types d'examens possible
 * @author Aurélien
 * @version 1.0
 *
 */
public enum TypeExamen{
        SCANNER("Scanner"),
        RADIO("Radio"),
        IRM("IRM");
private String nom="";

    /**
     * Constructeur de l'enum qui prends en paramètre le nom de l'examen
     * @param nom nom de l'examen
     */
    TypeExamen(String nom) {
        this.nom=nom;
    }

    /**
     * Méthode qui retourne selon une chaine de caractère donné en paramètre le type correspondant. Cela permet notamment de définir un type lorsque l'ont recoit un string de la base de données
     * @param type la chaine de caractère dont on veut retrouver le type
     * @return le type d'examen correspondant
     */
    public TypeExamen matchType(String type){
        if(type.equals("SCANNER"))
            return TypeExamen.SCANNER;
        if(type.equals("RADIO"))
            return TypeExamen.RADIO;
        if(type.equals("IRM"))
            return TypeExamen.IRM;
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

    /**
     * Méthode qui retour le type sous forme de chaine de caractère pour pouvoir ensuite être de nouveau interpreter par la méthode matchType()
     * @return une chaine de caractère
     */
    public String returnType(){
        if(this.nom.equals("Scanner"))
            return "SCANNER";
        else if(this.nom.equals("Radio"))
        return "RADIO";
	else
        return "IRM";
    }

}