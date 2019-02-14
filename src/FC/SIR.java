package FC;

import BD.LectConnexion;

import java.util.ArrayList;

public class SIR {
    private Connexion connexion;
    private ArrayList<Patient> listePatient;
    private ArrayList<Utilisateur> listeUtilisateur;


    public SIR(Connexion connexion){
        this.connexion=connexion;
        LectConnexion lectConnexion = new LectConnexion();
        this.listeUtilisateur=new ArrayList<Utilisateur>(lectConnexion.getListeUsers());
        connexion.setUser1(listeUtilisateur);

        System.out.println(connexion.isConnect());

    }

    public Connexion getConnexion(){
        return connexion;
    }
}
