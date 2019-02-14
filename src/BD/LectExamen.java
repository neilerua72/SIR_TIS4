package BD;

import FC.Examen;
import FC.RDV;
import FC.TypeExamen;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;

public class LectExamen {
    private ArrayList<Examen> listeExamen;
    private ArrayList<RDV> listeRDV;

    public ArrayList<Examen> getListeExamen() {
        return listeExamen;
    }

    public ArrayList<RDV> getListeRDV() {
        return listeRDV;
    }

    public LectExamen(){

        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();
            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT idExamen,idPatient,dateRDV,ExamenFait,dateExamen,image,validation,compteRendu,CRExamen,typeExamen,Salle FROM Examen;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                boolean examenFait = resultat.getBoolean("ExamenFait");
                Date dateRDV=resultat.getDate("dateRDV");
                String typeExamen = resultat.getString("typeExamen");
                int idExamen = resultat.getInt("idExamen");
                int salle = resultat.getInt("salle");
                String compteRendu = resultat.getString("compteRendu");
                TypeExamen typeExamenc = TypeExamen.RADIO;
                typeExamenc= typeExamenc.matchType(typeExamen);
                if(!examenFait){
                    RDV rdv = new RDV(dateRDV,typeExamenc,idExamen,salle,compteRendu);
                    listeRDV.add(rdv);
                }else{
                    Date dateExamen = resultat.getDate("dateExamen");
                    boolean image = resultat.getBoolean("image");
                    boolean validation = resultat.getBoolean("validation");
                    String crExamen = resultat.getString("CRExamen");
                    Examen examen=new Examen(dateRDV,typeExamenc,idExamen,salle,compteRendu,dateExamen,image,validation,crExamen);
                    listeExamen.add(examen);
                }







            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //libération des  ressources
        finally {
            if (resultat != null) {
                try {
                    /* On commence par fermer le ResultSet */
                    resultat.close();
                } catch (SQLException ignore) {
                }
            }
            if (statement != null) {
                try {
                    /* Puis on ferme le Statement */
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connexion != null) {
                try {
                    /* Et enfin on ferme la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }

    }
}

