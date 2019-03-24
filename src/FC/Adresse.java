package FC;

/**
 * Classe qui modélise une adresse postale française
 * @author Aurélien
 * @version 1.0
 *
 */
public class Adresse {
    private String rue;
    private String infoComp;
    private int CP;
    private String ville;

    /**
     * Constructeur de la classe, qui recquiert tout les paramètres
     * @param rue La rue de l'adresse
     * @param infoComp Les infos complémentaires de l'adresse comme par exemple l'étage ou le N° d'appartement
     * @param CP Le code postale de l'adresse
     * @param ville La ville de l'adresse
     */
    public Adresse(String rue, String infoComp, int CP, String ville) {
        this.rue = rue;
        this.infoComp = infoComp;
        this.CP = CP;
        this.ville = ville;
    }

    /**
     * Méthode qui renvoit l'adresse sous forme de chaine de caractère
     * @return l'adresse sous forme de caractère
     */
    public String toString(){
        String s="";
        s=rue+" "+infoComp+" "+CP+" "+ville;
        return s;
    }
}
