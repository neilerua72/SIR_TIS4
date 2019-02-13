package FC;

import javafx.beans.value.ObservableValue;

import java.util.ArrayList;

public class Connexion {
    private boolean connectMed;
    private boolean connectMan;
    private TypeConnexion type;
    private Utilisateur med;
    private Utilisateur man;
    private ArrayList<Utilisateur> user1;
    private ArrayList<Utilisateur> user2;


    public Connexion(boolean verif, TypeConnexion type, Utilisateur user){
        this.connectMed=verif;
        this.type=type;
        this.med=user;

    }


    public Connexion(Utilisateur user,ArrayList<Utilisateur> user1,ArrayList<Utilisateur> user2){
        connectMed=false;
        connectMan = false;
        int i=0;
        int j = 0;
        while(i<user1.size()&& connectMed==false){
            if(user1.get(i).equals(user)){
                this.connectMed=true;
                this.type=TypeConnexion.MED;
                this.med=user;
                System.out.println("Connexion medecin");
            }
            i++;
        }

        while(j<user2.size()&&connectMan==false) {
            if (user2.get(j).equals(user)) {
                this.connectMan = true;
                this.type = TypeConnexion.MAN;
                this.man = user;
                System.out.println("Connexion manip");
            }
            j++;
        }
        if(i>user1.size()){
            this.type=TypeConnexion.MED;
            this.med=user;
            System.out.println("ErreurMed");
        }
            if(j>user2.size()){
                this.type=TypeConnexion.MAN;
                this.man=user;
                System.out.println("ErreurMan");
            }
    }


    public boolean isConnectMed() {
        return connectMed;
    }

    public boolean isConnectMan() {
        return connectMan;
    }
    public TypeConnexion getType() {
        return type;
    }
    public Utilisateur getMed(){
        return this.med;
    }
    public Utilisateur getMan(){
        return this.man;
    }
}
