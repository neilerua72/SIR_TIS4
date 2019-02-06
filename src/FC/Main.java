package FC;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        ArrayList<Utilisateur> listeUsers = new ArrayList<>();
        Utilisateur user1 = new Utilisateur("Walton","Jack","1","123");
        listeUsers.add(user1);
        Utilisateur user2 = new Utilisateur("Paul","Jack","2","124");
        Connexion connexion = new Connexion(user2,listeUsers);

    }
}
