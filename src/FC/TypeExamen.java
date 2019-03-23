package FC;


public enum TypeExamen{
        SCANNER("Scanner"),
        RADIO("Radio"),
        IRM("IRM");
private String nom="";

    TypeExamen(String nom) {
        this.nom=nom;
    }

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

    public String toString(){
        return nom;
    }

    public String returnType(){
        if(this.nom.equals("Scanner"))
            return "SCANNER";
        else if(this.nom.equals("Radio"))
        return "RADIO";
	else
        return "IRM";
    }

}