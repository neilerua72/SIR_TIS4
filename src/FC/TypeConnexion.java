package FC;

public enum TypeConnexion {
    MED,
    MAN,
    SEC;


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
}

