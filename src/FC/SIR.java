package FC;

import BD.LectConnexion;
import BD.LectExamen;
import BD.LectPatient;
import ClassTable.TableExamen;

import java.util.ArrayList;

public class SIR {
    private Connexion connexion;
    private ArrayList<Patient> listePatient;
    private ArrayList<Utilisateur> listeUtilisateur;
    private ArrayList<RDV> listeRDV;
    private ArrayList<Examen> listeExamen;
    private ArrayList<TableExamen> tableExamen;

    public SIR(Connexion connexion){
        this.connexion=connexion;
        TableExamen tb;
        LectConnexion lectConnexion = new LectConnexion();
        LectPatient lectPatient = new LectPatient();
        LectExamen lectExamen=new LectExamen();
        this.listeUtilisateur=new ArrayList<Utilisateur>(lectConnexion.getListeUsers());
        connexion.setUser1(getListeUtilisateur());
        if(connexion.isConnect()){
            this.listePatient=new ArrayList<>(lectPatient.getListePatient());
            //this.listeRDV=new ArrayList<>(lectExamen.getListeRDV());
            this.listeExamen=new ArrayList<>(lectExamen.getListeExamen());
            this.tableExamen=new ArrayList<>();
            for(int i=0;i<listeExamen.size();i++){
                Examen e = listeExamen.get(i);
                String image;

                if(e.isImage())
                    image="Traitées";
                else
                    image="Non traitées";

                String validation;
                if(e.isValidation())
                    validation="Validé";
                else
                    validation="Non validé";

                tb=new TableExamen(this.getNomPatient(e.getIdPatient()),this.getPrenomPatient(e.getIdPatient()),e.getIdPatient(),e.getDateExamen(),e.getMedecinPrescri(),e.getMedecinRadio(),e.getId(),e.getTypeExamen().toString(),image,validation,e.getCr());

                tableExamen.add(tb);
            }
            System.out.println("Fin de la lecture de la BD");
        }


    }

    public Connexion getConnexion(){
        return connexion;
    }

    public ArrayList<Patient> getListePatient() {
        return listePatient;
    }

    public ArrayList<Utilisateur> getListeUtilisateur() {
        return listeUtilisateur;
    }

    public ArrayList<RDV> getListeRDV() {
        return listeRDV;
    }

    public ArrayList<Examen> getListeExamen() {
        return listeExamen;
    }

    public ArrayList<TableExamen> getTableExamen() {
        return tableExamen;
    }

    public String getNomPatient(String id){
        int i=0;
        String s="";
        boolean rep =false;
        while(i<listePatient.size()||!rep){
            if(id==listePatient.get(i).getId()){
                s=listePatient.get(i).getNom();
                rep=true;
            }
            i++;
        }
        return s;
    }
    public String getPrenomPatient(String id){
        int i=0;
        String s="";
        boolean rep=false;
        while(i<listePatient.size()||!rep){
            if(id==listePatient.get(i).getId()){
                s=listePatient.get(i).getPrenom();
                rep=true;
            }
            i++;
        }
        return s;
    }
}
