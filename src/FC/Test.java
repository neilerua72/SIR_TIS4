package FC;

public class Test {


    public static void main(String[] args) {
        String id="1";
        String mdp="1";
        Connexion conn = new Connexion(new Utilisateur(id,mdp));
        SIR sir = new SIR(conn);
        int idPat=(int)(Math.random() * ( 999999 - 0 )+1);;
        System.out.println(idPat);

    }

}
