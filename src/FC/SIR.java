package FC;

import BD.LectConnexion;
import BD.LectExamen;
import BD.LectPatient;

import java.util.ArrayList;

public class SIR {
    private Connexion connexion;
    private ArrayList<Patient> listePatient;
    private ArrayList<Utilisateur> listeUtilisateur;
    private ArrayList<RDV> listeRDV;
    private ArrayList<Examen> listeExamen;

    public SIR(Connexion connexion){
        this.connexion=connexion;
        LectConnexion lectConnexion = new LectConnexion();
        LectPatient lectPatient = new LectPatient();
        LectExamen lectExamen=new LectExamen();
        this.listeUtilisateur=new ArrayList<Utilisateur>(lectConnexion.getListeUsers());
        connexion.setUser1(listeUtilisateur);
        if(connexion.isConnect()){
            this.listePatient=new ArrayList<>(lectPatient.getListePatient());
            this.listeRDV=new ArrayList<>(lectExamen.getListeRDV());
            this.listeExamen=new ArrayList<>(lectExamen.getListeExamen());
        }


    }

    public Connexion getConnexion(){
        return connexion;
    }
}
