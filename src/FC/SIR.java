package FC;

import BD.*;
import ClassTable.TableExamen;
import ClassTable.TableRDV;

import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * Classe qui modélise un système d'information radiologique. Ils contient toutes les informations qu'un SIR est sensé contenir. Il se compose de listes
 * d'objets et d'une connexion
 * @author Aurélien
 * @version 1.0
 * @see FC.Connexion
 * @see FC.Patient
 * @see FC.Utilisateur
 * @see FC.RDV
 * @see FC.Examen
 * @see ClassTable.TableExamen
 * @see FC.CR
 * @see ClassTable.TableRDV
 * @see FC.RWImage
 */
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

    /**
     * Constructeur de la classe qui recquiert le paramètrze connexion
     * @param connexion la connexion nécessaire à la formation du SIR
     */
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

                String cr;
                if(e.getCr()){
                    cr="Ecrit";
                }
                else
                    cr="Non écrit";

                tb=new TableExamen(this.getNomPatient(e.getIdPatient()),this.getPrenomPatient(e.getIdPatient()),e.getIdPatient(),e.getDateExamen(),e.getMedecinPrescri(),e.getMedecinRadio(),e.getId(),e.getTypeExamen().toString(),image,validation,cr);

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

    /**
     * Méthode qui retourne la connexion correspondant au SIR
     * @return la connexion
     */
    public Connexion getConnexion(){
        return connexion;
    }

    /**
     * Méthode qui retourne qui retourne la liste des patients du SIR
     * @return la liste des patients
     */
    public ArrayList<Patient> getListePatient() {
        return listePatient;
    }

    /**
     * Méthode qui retourne la liste des CR du SIR
     * @return
     */
    public ArrayList<CR> getListeCR() { return listeCR; }

    /**
     * Méthode qui retourne la liste des utilisateurs du SIR
     * @return la liste d'utilisateurs
     */
    public ArrayList<Utilisateur> getListeUtilisateur() {
        return listeUtilisateur;
    }

    /**
     * Méthode qui retourne la liste des RDV du SIR
     * @return la liste de RDV
     */
    public ArrayList<RDV> getListeRDV() {
        return listeRDV;
    }

    /**
     * Méthode qui retourne la liste des examens du SIR
     * @return la liste d'examen
     */
    public ArrayList<Examen> getListeExamen() {
        return listeExamen;
    }

    /**
     * Méthode qui retourne la liste d'examen pour l'affichage sous forme de table
     * @return la liste d'examen pour l'affichage sous forme de table
     */
    public ArrayList<TableExamen> getTableExamen() {
        return tableExamen;
    }

    /**
     * Méthode qui retourne le nom du patient en fonction de son ID
     * @param id l'id d'un patient
     * @return le nom du patient
     */
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

    /**
     * Méthode qui retourne le prénom du patient en fonction de son id
     * @param id l'id du patient
     * @return le prenom du patient
     */
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

    /**
     * Méthode qui retourne la liste des RDV pour l'afficahge sous forme de table
     * @return la liste des TablesRDV
     */
    public ArrayList<TableRDV> getTableRDV() {
        return tableRDV;
    }

    /**
     * Méthode qui met à jour la liste de Table RDV
     */
    public void UpdateTableRDV(){
        RDV rdv = listeRDV.get(listeRDV.size()-1);
        TableRDV tr = new TableRDV(rdv.getDateRDV(),rdv.getTypeExamen().toString(),rdv.getId(),String.valueOf(rdv.getSalle()),"Test",rdv.getIdPatient(),rdv.getMedecinPrescri(),this.getNomPatient(rdv.getIdPatient()),this.getPrenomPatient(rdv.getIdPatient()));
        this.tableRDV.add(tr);

    }

    /**
     * Méthode qui met à jour la liste de la Table d'examen
     */
    public void UpdateTableExamen(){
        tableExamen.clear();
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

            String cr;
            if(e.getCr()){
                cr="Ecrit";
            }
            else
                cr="Non écrit";

            TableExamen tb=new TableExamen(this.getNomPatient(e.getIdPatient()),this.getPrenomPatient(e.getIdPatient()),e.getIdPatient(),e.getDateExamen(),e.getMedecinPrescri(),e.getMedecinRadio(),e.getId(),e.getTypeExamen().toString(),image,validation,cr);

            tableExamen.add(tb);
        }

    }

    /**
     * Méthode qui vérifie qu'un id de patient n'est pas déjà affecté
     * @param idtest id que l'on souhaite tester
     * @return si oui ou non l'id existe déjà
     */
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

    /**
     * Méthode qui vérifie qu'un id de RDV n'est pas déjà affecté
     * @param idtest id que l'on souhaite tester
     * @return si oui ou non l'id existe déjà
     */
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

    /**
     * Méthode qui vérifie qu'un id d'examen n'est pas déjà affecté
     * @param idtest id que l'on souhaite tester
     * @return si oui ou non l'id existe déjà
     */
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

    /**
     * Méthode qui retourne l'objet RDV en fonction du RDV qui sert à l'affichage de la table
     * @param trdv l'objet qui sert à l'afficahge dans la table
     * @return l'objet RDV
     */
    public RDV getRDVfromTableRDV(TableRDV trdv){
        int i=0;
        boolean rep=false;
        while(i<this.listeRDV.size()&&rep==false){
           if(trdv.getIdExam()==listeRDV.get(i).getId()){

               rep=true;
           }
           i++;
        }
        if(rep==true){
            return listeRDV.get(i-1);
        }
        else return null;

    }

    /**
     * Méthode qui renvoit la liste des images du SIR
     * @return la liste d'image du SIR
     */
    public ArrayList<RWImage> getListeImage() {
        return listeImage;
    }

    /**
     * Méthiode qui retourne la liste d'examen pour l'affichage en fonction de l'id d'un patient
     * @param idPatient l'id du patient
     * @return une liste de TableExamen
     */
    public ArrayList<TableExamen> getTableExamenFromIdPatient(int idPatient){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<this.tableExamen.size();i++){
            if(tableExamen.get(i).getIdpatient()==idPatient){
                result.add(tableExamen.get(i));
            }
        }
        return result;
    }

    /**
     * Méthode qui retourne l'examen en fonction de l'id de l'examen
     * @param idExam id de l'examen
     * @return l'examen correspondant à l'id
     */
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

    /**
     * Méthode qui retourne un CR en fonction de l'id de l'examen
     * @param idExamen id de l'examen
     * @return le cr correspondant à l'id d'examen
     */
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

    /**
     * Méthode qui retourne le patient en fonction de son id
     * @param id id du patient
     * @return le patient
     */
    public Patient getPatientFromId(int id){
        int i=0;
        Patient p = new Patient();
        boolean rep=false;
        while(i<listePatient.size()&&rep==false){
            System.out.println(i);
            if(id==listePatient.get(i).getId()){
                p=listePatient.get(i);
                rep=true;
            }
            i++;
        }
        return p;
    }

    /**
     * Méthode qui supprime un RDV. Cette methode sert quand l'examen est fait, à enlever le RDV
     * @param id id du RDV à supprimer de la liste
     */
    public void supprimerRDV(String id){
        int i=0;
        boolean rep = true;
        while(i<listeRDV.size()&&rep==false){
            if(listeRDV.get(i).getId().equals(id)){
                rep =true;
                listeRDV.remove(i);
            }
            i++;
        }
    }

    /**
     * Méthode qui vérifie si un id d'image est déjà affecté ou non
     * @param idtest id à tester
     * @return si oui ou non l'id est déjà affecté
     */
    public boolean checkIdImage(int idtest){
        int i=0;
        boolean rep = false;
        while(i<this.listeImage.size()&&rep==false){
            if(idtest==this.listeImage.get(i).getId()){
                rep = true;
            }
            i++;
        }
        return rep;
    }

    /**
     * Méthode qui retourne une liste d'image en fonction de l'id d'un examen
     * @param id id examen
     * @return la liste d'image correspondant
     */
    public ArrayList<RWImage> recupImageExam(int id){
        ArrayList<RWImage> result = new ArrayList<>();
        for(int i=0;i<this.listeImage.size();i++){
            if(this.listeImage.get(i).getIdPatient().equals(String.valueOf(id))){
                result.add(listeImage.get(i));
            }
        }
        return result;
    }

    /**
     * Méthode qui permet de définir si un examen possède un CR ou non
     * @param id id de l'examen a modifier
     * @param value valeur du boolean pour le CR
     */
    public void ecrireCR(String id, boolean value){
        boolean rep=false;
        int i=0;
        while(i<listeExamen.size()&&rep==false){
            if(id.equals(listeExamen.get(i).getId())){
                rep = true;
                listeExamen.get(i).setCrExamen(value);
            }
            i++;
        }
    }
}
