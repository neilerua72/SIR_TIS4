package FC;
/**
 * Classe qui modélise le sexe
 * @author Aurélien
 * @version 1.0
 *
 */
public enum Sexe {
    H("Homme"),
    F("Femme");

    private String nom="";
    Sexe(String nom) {
        this.nom=nom;
    }

    public Sexe matchType(String type){
        if(type.equals("H"))
            return Sexe.H;
        if(type.equals("F"))
            return Sexe.F;
        else
            return null;
    }
    public String toString(){
        return nom;
    }

}
