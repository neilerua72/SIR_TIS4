package FC;

import BD.*;
import ClassTable.TableExamen;
import ClassTable.TableRDV;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SIR {
    private Connexion connexion;
    private ArrayList<Patient> listePatient;
    private ArrayList<Utilisateur> listeUtilisateur;
    private ArrayList<RDV> listeRDV;
    private ArrayList<Examen> listeExamen;
    private ArrayList<TableExamen> tableExamen;
    private ArrayList<CR> listeCR;
    private ArrayList<TableRDV> tableRDV;
    private ArrayList<RWImage> listeImage;

    public SIR(Connexion connexion){
        this.connexion=connexion;
        TableExamen tb;
        LectConnexion lectConnexion = new LectConnexion();
        LectPatient lectPatient = new LectPatient();
        LectExamen lectExamen=new LectExamen();
        LectImage lectImage = new LectImage();

        LectCR lectCR= new LectCR();

        this.listeUtilisateur=new ArrayList<Utilisateur>(lectConnexion.getListeUsers());
        connexion.setUser1(getListeUtilisateur());
        if(connexion.isConnect()){
            this.listePatient=new ArrayList<>(lectPatient.getListePatient());
            //this.listeRDV=new ArrayList<>(lectExamen.getListeRDV());
            this.listeExamen=new ArrayList<>(lectExamen.getListeExamen());
            this.tableExamen=new ArrayList<>();
            this.listeCR=new ArrayList<>(lectCR.getListeCR());
            this.listeRDV=new ArrayList<>(lectExamen.getListeRDV());
            this.tableRDV=new ArrayList<>();
            this.listeImage=new ArrayList<>(lectImage.getListeImage());
            System.out.println("TEST ::: " +listeCR.get(0).getConclusion());
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
            for (int i=0;i<listeRDV.size();i++){
                RDV rdv = listeRDV.get(i);
                TableRDV tr = new TableRDV(rdv.getDateRDV(),rdv.getTypeExamen().toString(),rdv.getId(),String.valueOf(rdv.getSalle()),"Test",rdv.getIdPatient(),rdv.getMedecinPrescri(),this.getNomPatient(rdv.getIdPatient()),this.getPrenomPatient(rdv.getIdPatient()));
                this.tableRDV.add(tr);
                System.out.println(rdv.getIdPatient());
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

    public ArrayList<CR> getListeCR() { return listeCR; }

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

    public String getNomPatient(int id){
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
    public String getPrenomPatient(int id){
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

    public ArrayList<TableRDV> getTableRDV() {
        return tableRDV;
    }


    public void UpdateTableRDV(){
        RDV rdv = listeRDV.get(listeRDV.size()-1);
        TableRDV tr = new TableRDV(rdv.getDateRDV(),rdv.getTypeExamen().toString(),rdv.getId(),String.valueOf(rdv.getSalle()),"Test",rdv.getIdPatient(),rdv.getMedecinPrescri(),this.getNomPatient(rdv.getIdPatient()),this.getPrenomPatient(rdv.getIdPatient()));
        this.tableRDV.add(tr);

    }
    public boolean checkIdPatient(int idtest){
        int i=0;
        boolean rep = false;
        while(i<this.listePatient.size()&&rep==false){
            if(idtest==this.listePatient.get(i).getId()){
                rep = true;
            }
            i++;
        }
        return rep;
    }
    public boolean checkIdRDV(int idtest){
        int i=0;
        boolean rep = false;
        while(i<this.listeRDV.size()&&rep==false){
            if(idtest==Integer.parseInt(this.listeRDV.get(i).getId())){
                rep = true;
            }
            i++;
        }
        return rep;
    }
    public boolean checkIdExamen(int idtest){
        int i=0;
        boolean rep = false;
        while(i<this.listeExamen.size()&&rep==false){
            if(idtest==Integer.parseInt(this.listeExamen.get(i).getId())){
                rep = true;
            }
            i++;
        }
        return rep;
    }

    public ArrayList<RWImage> getListeImage() {
        return listeImage;
    }
    public ArrayList<TableExamen> getTableExamenFromIdPatient(int idPatient){
        ArrayList<TableExamen> result = new ArrayList<>();
       for(int i=0;i<this.tableExamen.size();i++){
           if(tableExamen.get(i).getIdpatient()==idPatient){
               result.add(tableExamen.get(i));
           }
       }
        return result;
    }
    public Examen getExamenFromId(int idExam){
        Examen examen=new Examen();
        boolean rep = false;
        int i=0;
        while(i<listeExamen.size()&&rep==false){
            if(Integer.parseInt(this.listeExamen.get(i).getId())==idExam) {
                examen = this.listeExamen.get(i);
                rep=true;
            }
            i++;

        }
        return examen;
    }

    public CR getCRFromIdExam(int idExamen){
        CR cr = new CR();
        boolean rep = false;
        int i=0;
        while(i<listeCR.size()&&rep==false){
            if(this.listeCR.get(i).getIdExam()==idExamen) {
                cr = this.listeCR.get(i);
                rep=true;
            }
            i++;

        }
        return cr;
    }
    public Patient getPatientFromId(int id){
        int i=0;
        Patient p = new Patient();
        boolean rep=false;
        while(i<listePatient.size()&&rep){
            if(id==listePatient.get(i).getId()){
                p=listePatient.get(i);
                rep=true;
            }
            i++;
        }
        return p;
    }
}
