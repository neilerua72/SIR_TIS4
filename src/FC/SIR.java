package FC;

import java.util.ArrayList;

public class SIR {
    private Connexion connexion;
    private ArrayList<Patient> listePatient;

    public SIR(Connexion connexion, ArrayList listePatient){
        this.connexion=connexion;
        this.listePatient=listePatient;
        if(connexion.isConnect()){

        }
        else{

        }
    }
}
