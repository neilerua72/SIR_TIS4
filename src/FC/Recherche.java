package FC;

import ClassTable.TableExamen;
import ClassTable.TableRDV;
import javafx.event.Event;
import java.util.ArrayList;
/**
 * Classe qui modélise une recherche. Cette classe prends comme attribut une chaine de caractère, un event et le SIR. Elle permet de retourner des
 * d'objets qui se trouvent dans les listes du SIR si il y a égalité entre un attribut de cet objet et la chaine de caractère
 * @author Aurélien
 * @version 1.0
 * @see FC.SIR
 */

public class Recherche {
    SIR sir;
    Event event;
    String s;

    /**
     * Constructeur qui prends en paramètre le SIR, l'event qui déclenche la recherche, et l'a chaine de caractère pour la recherche
     * @param sir le SIR de l'application
     * @param event l'event qui a déclenché la recherche
     * @param s la chaine de caractère pour la comparaison
     */
    public Recherche(SIR sir, Event event,String s){
        this.sir=sir;
        this.event=event;
        this.s=s;
    }

    /**
     * Méthode qui permet de rechercher un examen en fonction d'un nom de patient et qui retourne sous le résultat de la recherche sous forme d'une liste d'examen pour l'affichage
     * @return une liste de TableExamen (examen pour l'affichage)
     */
    public ArrayList<TableExamen> rechercheExamenNom(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getNom().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getNom().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un examen en fonction de l'id de l'examen et qui retourne sous le résultat de la recherche sous forme d'une liste d'examen pour l'affichage
     * @return la liste de TableExamen (examen pour l'affichage)
     */
    public ArrayList<TableExamen> rechercheExamenIDExamn(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getIdexamen().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getIdexamen().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un examen en fonction de l'ID du patient et qui retourne sous le résultat de la recherche sous forme d'une liste d'examen pour l'affichage
     * @return la liste de TableExamen(examen pour l'affichage)
     */
    public ArrayList<TableExamen> rechercheExamenIDPat(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=String.valueOf(sir.getTableExamen().get(i).getIdpatient()).length()&&s.toLowerCase().equals(String.valueOf(sir.getTableExamen().get(i).getIdpatient()).substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un examen en fonction d'un medecin prescripteur et qui retourne sous le résultat de la recherche sous forme d'une liste d'examen pour l'affichage
     * @return la liste de TableExamen (examen pour l'affichage)
     */
    public ArrayList<TableExamen> rechercherExamenParMedecinPrescri(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getMedecinprescri().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getMedecinprescri().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un examen en fonction d'un medecin radiologue et qui retourne sous le résultat de la recherche sous forme d'une liste d'examen pour l'affichage
     * @return la liste de TableExamen (examen pour l'affichage)
     */
    public ArrayList<TableExamen> rechercherExamenParMedecinRadio(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getMedecinradio().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getMedecinradio().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un examen en fonction de la date d'examen et qui retourne sous le résultat de la recherche sous forme d'une liste d'examen pour l'affichage
     * @return la liste de TableExamen (examen pour l'affichage)
     */
    public ArrayList<TableExamen> rechercherExamenParDate(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            System.out.println("COMPARAISON : "+sir.getTableExamen().get(i).getDateExamen().toString()+"   /   "+s);
            if(sir.getTableExamen().get(i).getDateExamen().toString().equals(s)){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un patient en fonction de son nom et qui retourne sous le résultat de la recherche sous forme d'une liste de Patient
     * @return la liste de patient correspondant à la requête
     */
    public ArrayList<Patient> rechercherPatient(){
        ArrayList<Patient> result = new ArrayList<>();
        for(int i=0;i<sir.getListePatient().size();i++){
            if(s.length()<=sir.getListePatient().get(i).getNom().length()&&s.toLowerCase().equals(sir.getListePatient().get(i).getNom().substring(0,s.length()).toLowerCase())){
                result.add(sir.getListePatient().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un patient en fonction de son id et qui retourne sous le résultat de la recherche sous forme d'une liste de Patient
     * @return la liste de patient correspondant à la requête
     */
    public ArrayList<Patient> rechercherIdPatient(){
        ArrayList<Patient> result = new ArrayList<>();
        for(int i=0;i<sir.getListePatient().size();i++){
            if(s.length()<=String.valueOf(sir.getListePatient().get(i).getId()).length()&&s.toLowerCase().equals(String.valueOf(sir.getListePatient().get(i).getId()).substring(0,s.length()).toLowerCase())){
                result.add(sir.getListePatient().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un RDV en fonction de sa date et qui retourne sous le résultat de la recherche sous forme d'une liste de RDV pour l'affichage
     * @return la liste des RDV pour une date donné sous forme d'afficahge
     */
    public ArrayList<TableRDV> rechercheRDVparDate(){
        ArrayList<TableRDV> result = new ArrayList<>();
        for(int i=0;i<sir.getTableRDV().size();i++){
            System.out.println("COMPARAISON : "+sir.getTableRDV().get(i).getDateRDV().toString()+"   /   "+s);
            if(sir.getTableRDV().get(i).getDateRDV().toString().equals(s)){
                result.add(sir.getTableRDV().get(i));
            }
        }

        return result;
    }

    /**
     * Méthode qui permet de rechercher un RDV en fonction du nom du patient et qui retourne sous le résultat de la recherche sous forme d'une liste de RDV pour l'affichage
     * @return une liste de RDV pour un nom de patient
     */
    public ArrayList<TableRDV> rechercherRDVParNom(){
        ArrayList<TableRDV>result=new ArrayList<>();
        for(int i=0;i<sir.getTableRDV().size();i++){
            if(s.length()<=sir.getTableRDV().get(i).getNom().length()&&s.toLowerCase().equals(sir.getTableRDV().get(i).getNom().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableRDV().get(i));
            }
        }
        return result;
    }

    }

