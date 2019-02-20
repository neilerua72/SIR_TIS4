package FC;

public class Adresse {
    private String rue;
    private String infoComp;
    private int CP;
    private String ville;

    public Adresse(String rue, String infoComp, int CP, String ville) {
        this.rue = rue;
        this.infoComp = infoComp;
        this.CP = CP;
        this.ville = ville;
    }
    public String toString(){
        String s="";
        s=rue+" "+infoComp+" "+CP+" "+ville;
        return s;
    }
}
