package FC;


public enum TypeExamen{
        SCANNER,
        RADIO,
        IRM;

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
    }

