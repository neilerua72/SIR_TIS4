package BD;

import FC.Examen;
import FC.RDV;
import FC.TypeExamen;

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
    listeExamen=new ArrayList<>();
    listeRDV=new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();
            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT idExamen,idPatient,dateRDV,ExamenFait,medecinPrescri,medecinRadio,dateExamen,image,validation,CRExamen,typeExamen,Salle,vue,zoneetudie,lateralite,produit,dose FROM Examen;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                boolean examenFait = resultat.getBoolean("ExamenFait");
                Date dateRDV=resultat.getDate("dateRDV");
                String typeExamen = resultat.getString("typeExamen");
                int idPatient=resultat.getInt("idPatient");
                String idExamen = resultat.getString("idExamen");
                int salle = resultat.getInt("salle");

                TypeExamen typeExamenc = TypeExamen.RADIO;
                typeExamenc= typeExamenc.matchType(typeExamen);
                 String medecinPrescri = resultat.getString("medecinPrescri");

                if(!examenFait){
                    RDV rdv = new RDV(dateRDV,typeExamenc,idExamen,salle,idPatient,medecinPrescri);
                    listeRDV.add(rdv);
                }else{
                    Date dateExamen = resultat.getDate("dateExamen");
                    boolean image = resultat.getBoolean("image");
                    boolean validation = resultat.getBoolean("validation");
                    boolean crExamen = resultat.getBoolean("CRExamen");
                    String medecinRadio = resultat.getString("medecinRadio");
                    String lateralite= resultat.getString("lateralite");
                    String vue = resultat.getString("vue");
                    String zoneetudie = resultat.getString("zoneetudie");
                    String produit = resultat.getString("produit");
                    String dose = resultat.getString("dose");
                    Examen examen=new Examen(produit,dose,lateralite,vue,zoneetudie,dateRDV,typeExamenc,idExamen,salle,idPatient,medecinPrescri,dateExamen,image,validation,crExamen,medecinRadio);
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

