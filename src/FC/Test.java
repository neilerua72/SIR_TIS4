package FC;

import java.io.File;

public class Test {


    public static void main(String[] args) {
        String id="1";
        String mdp="1";
        //Connexion conn = new Connexion(new Utilisateur(id,mdp));-
        //SIR sir = new SIR(conn);
        //System.out.println("TEST "+ sir.getListePatient().get(0).getSexe());
        //System.out.println(sir.getPatientFromId(123456).getNom());
        String new_file = new String();
        new_file=System.getProperty("user.dir")+"\\Images";
        File dossier=new File(new_file);

        if (!dossier.exists() || !dossier.isDirectory()){
            dossier.mkdir();
        }

    }

}
