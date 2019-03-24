package FC;

import ClassTable.TableExamen;
import ClassTable.TableRDV;
import javafx.event.Event;


import java.util.ArrayList;

public class Recherche {
    SIR sir;
    Event event;
    String s;
    public Recherche(SIR sir, Event event,String s){
        this.sir=sir;
        this.event=event;
        this.s=s;
    }
    public ArrayList<TableExamen> rechercheExamenNom(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getNom().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getNom().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }
    public ArrayList<TableExamen> rechercheExamenIDExamn(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getIdexamen().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getIdexamen().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }
    public ArrayList<TableExamen> rechercheExamenIDPat(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=String.valueOf(sir.getTableExamen().get(i).getIdpatient()).length()&&s.toLowerCase().equals(String.valueOf(sir.getTableExamen().get(i).getIdpatient()).substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }
    public ArrayList<TableExamen> rechercherExamenParMedecinPrescri(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getMedecinprescri().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getMedecinprescri().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }
    public ArrayList<TableExamen> rechercherExamenParMedecinRadio(){
        ArrayList<TableExamen> result = new ArrayList<>();
        for(int i=0;i<sir.getTableExamen().size();i++){
            if(s.length()<=sir.getTableExamen().get(i).getMedecinradio().length()&&s.toLowerCase().equals(sir.getTableExamen().get(i).getMedecinradio().substring(0,s.length()).toLowerCase())){
                result.add(sir.getTableExamen().get(i));
            }
        }

        return result;
    }
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

    public ArrayList<Patient> rechercherPatient(){
        ArrayList<Patient> result = new ArrayList<>();
        for(int i=0;i<sir.getListePatient().size();i++){
            if(s.length()<=sir.getListePatient().get(i).getNom().length()&&s.toLowerCase().equals(sir.getListePatient().get(i).getNom().substring(0,s.length()).toLowerCase())){
                result.add(sir.getListePatient().get(i));
            }
        }

        return result;
    }
    public ArrayList<Patient> rechercherIdPatient(){
        ArrayList<Patient> result = new ArrayList<>();
        for(int i=0;i<sir.getListePatient().size();i++){
            if(s.length()<=String.valueOf(sir.getListePatient().get(i).getId()).length()&&s.toLowerCase().equals(String.valueOf(sir.getListePatient().get(i).getId()).substring(0,s.length()).toLowerCase())){
                result.add(sir.getListePatient().get(i));
            }
        }

        return result;
    }
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

