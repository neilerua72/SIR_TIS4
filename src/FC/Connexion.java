package FC;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;

public class Connexion {
    private boolean connect;
    private TypeConnexion type;
    private Utilisateur user;
    private ArrayList<Utilisateur> user1;

    public Connexion(boolean verif, TypeConnexion type, Utilisateur user){
        this.connect=verif;
        this.type=type;
        this.user=user;

    }


    public Connexion(Utilisateur user,ArrayList<Utilisateur> user1){
        connect=false;
        int i=0;
        while(i<user1.size()&&connect==false){
            if(user1.get(i).equals(user)){
                this.connect=true;
                this.type=TypeConnexion.MED;
                this.user=user;
                System.out.println("Bien connecté");
            }
            i++;
        }
        if(i>user1.size()-1){
            this.type=TypeConnexion.MED;
            this.user=user;
            System.out.println("Erreur");
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
}
