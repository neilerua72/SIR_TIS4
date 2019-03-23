package FC;

public class Test {


    public static void main(String[] args) {
        String id="1";
        String mdp="1";
        Connexion conn = new Connexion(new Utilisateur(id,mdp));
        SIR sir = new SIR(conn);


        Examen examen = sir.getExamenFromId(Integer.parseInt("304865"));
        CR cr = sir.getCRFromIdExam(Integer.parseInt(examen.getId()));
        System.out.println(cr.getComparaisonExamenAnt());

    }

}
