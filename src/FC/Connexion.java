package FC;

import javafx.beans.value.ObservableValue;

import java.util.ArrayList;

public class Connexion {
    private boolean connect;

    private TypeConnexion type;
    private Utilisateur user;
    private ArrayList<Utilisateur> user1;
    public Connexion(Utilisateur user){
        this.user=user;
        this.connect=false;
    }
    public Connexion(boolean verif, TypeConnexion type, Utilisateur user){
        this.connect=verif;
        this.type=type;
        this.user=user;

    }


    public Connexion(Utilisateur user,ArrayList<Utilisateur> user1){
        connect=false;
        int i=0;
        int j = 0;
        while(i<user1.size()&& connect==false){
            if(user1.get(i).equals(user)){
                this.connect=true;
                this.type=TypeConnexion.MED;
                this.user=user;
                System.out.println("Connexion medecin");
            }
            i++;
        }


        if(i>user1.size()){
            this.user=user;
            System.out.println("ErreurMed");
        }

    }


    public boolean isConnect() {
        return connect;
    }


    public TypeConnexion getType() {
        return type;
    }
    public Utilisateur getUser(){
        return this.user;
    }
    public void setUser1(ArrayList<Utilisateur> user1){
        this.connect=false;
        int i=0;

        while(i<user1.size()&& this.connect==false){
            if(user1.get(i).equals(user)){
                this.connect=true;
                this.type=TypeConnexion.MED;
                this.user=user;
                System.out.println("Connexion medecin");
            }
            i++;
        }


        if(i>user1.size()){
            this.user=user;
            System.out.println("Erreur");
        }
    }


}
