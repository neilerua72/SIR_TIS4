package FC;

import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
/**
 * Classe qui modélise une connexion. cette classe contient un utilisaateur, un type de connexion ainsi que la liste de tout les utilisateurs
 *
 * @author Aurélien
 * @version 1.0
 *
 */
public class Connexion {
    private boolean connect;

    private TypeConnexion type;
    private Utilisateur user;
    private ArrayList<Utilisateur> user1;

    /**
     * Constructeur de la classe qui ne requiert que l'utilisateur pour s'instancier
     * @param user un Utilisateur, celui voulant se connecter
     * @see Utilisateur
     */
    public Connexion(Utilisateur user){
        this.user=user;
        this.connect=false;
    }

    /**
     * Constructeur de la classe qui demande tout les attributs afin de s'instancier
     * @param verif un boolean qui correspond au fait que l'utilisateur soit connecté ou non
     * @param type le type de connexion, correspondant à l'enum TypeConnexion
     * @param user l'Utilisateur souhaitant ce connecter au SIR
     * @see Utilisateur
     * @see TypeConnexion
     */
    public Connexion(boolean verif, TypeConnexion type, Utilisateur user){
        this.connect=verif;
        this.type=type;
        this.user=user;

    }

    /**
     * Constructeur qui créer la connexion si l'utilisateur passé en paramètre a bien le droit de se connecter conformement à la liste d'utilisateur
     * @param user l'utilisateur qui souhaite se connecter
     * @param user1 la liste de tous les utilisateurs possible du SIR
     * @see Utilisateur
     */
    public Connexion(Utilisateur user,ArrayList<Utilisateur> user1){
        connect=false;
        int i=0;
        int j = 0;
        while(i<user1.size()&& connect==false){
            if(user1.get(i).equals(user)){
                this.connect=true;
                this.type=user1.get(i).getType();
                this.user=user1.get(i);
                System.out.println("Connexion medecin");
            }
            i++;
        }


        if(i>user1.size()){
            this.user=user;
            System.out.println("ErreurMed");
        }

    }

    /**
     * Méthode qui vérifie si la connexion est effective ou non
     * @return si la connexion est effective ou non
     */
    public boolean isConnect() {
        return connect;
    }

    /**
     * Méthode qui retourne le type de connexion
     * @return le type de connexion
     * @see TypeConnexion
     */
    public TypeConnexion getType() {
        return type;
    }
    /**
     * Méthode qui retourne l'utilisateur
     * @return l'Utilisateur
     * @see Utilisateur
     */
    public Utilisateur getUser(){
        return this.user;
    }

    /**
     *  Méthode qui permet de définit la liste des utilisateurs possibles* du SIR
     * @param user1 la liste des utilisateurs
     */
    public void setUser1(ArrayList<Utilisateur> user1){
        this.connect=false;
        int i=0;

        while(i<user1.size()&& connect==false){
            if(user1.get(i).equals(user)){
                this.connect=true;
                this.type=user1.get(i).getType();
                this.user=user1.get(i);
            }
            i++;
        }



        if(i>user1.size()){
            this.user=user;
            System.out.println("Erreur");
        }
    }


}
