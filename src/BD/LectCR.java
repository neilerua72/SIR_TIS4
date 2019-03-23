package BD;


import FC.CR;


import java.sql.*;
import java.util.ArrayList;

public class LectCR {
    private ArrayList<CR> listeCR = new ArrayList<CR>();

    public LectCR() {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {

            ConnexionBase cb = new ConnexionBase();
            connexion = cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete de lecture
            resultat = statement.executeQuery("SELECT idCR,idExam,problemeClinique,technique,produitContrasteType," +
                    "quantiteProduitContraste,comparaisonExamenAnt,dateCR,specialiteRadiologue,protocoleStandardise," +
                    "resultat,synthese,conclusion FROM CR;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                int idCR = resultat.getInt("idCR");
                String problemeClinique = resultat.getString("problemeClinique");
                int idExam = resultat.getInt("idExam");
                String technique = resultat.getString("technique");
                String produitContrasteType= resultat.getString("produitContrasteType");
                int quantiteProduitContraste = resultat.getInt("quantiteProduitContraste");
                String comparaisonExamenAnt= resultat.getString("comparaisonExamenAnt");
                Date dateCR = resultat.getDate("dateCR");
                String specialiteRadiologue=resultat.getString("specialiteRadiologue");
                String protocoleStandardise= resultat.getString("protocoleStandardise");
                String resultatCR = resultat.getString("resultat");
                String synthese = resultat.getString("synthese");
                String conclusion = resultat.getString("conclusion");




                CR cr = new CR(idCR,idExam,problemeClinique,technique,produitContrasteType,quantiteProduitContraste,comparaisonExamenAnt,dateCR,specialiteRadiologue,
                        protocoleStandardise,resultatCR,synthese,conclusion);
                listeCR.add(cr);
            }
        }catch (Exception e) {
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

    }}

    public ArrayList<CR> getListeCR() {
        return listeCR;
    }
}


