package BD;


import FC.CR;


import java.sql.*;
import java.util.ArrayList;

/**
 * Classe qui modélise la lecture de notre base de donnée apres connexion à celle ci,
 * cette classe contient une arrayList de tous les compte rendu
 */


public class LectCR {
    private ArrayList<CR> listeCR = new ArrayList<CR>();

    /**
     *Méthode qui permet de se connecter à la base de donnée et lire la table Compte rendu, afin d'ajouter
     * idCR,idExam,problemeClinique,technique,comparaisonExamenAnt,dateCR,protocoleStandardise,
     * resultat,synthese,conclusion dans la liste des comptes rendu.
     */
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
            resultat = statement.executeQuery("SELECT idCR,idExam,problemeClinique,technique," +
                    "comparaisonExamenAnt,dateCR,protocoleStandardise," +
                    "resultat,synthese,conclusion FROM CR;");
            //Récupération des données du résultat de la requete de lecture
            while (resultat.next()) {
                int idCR = resultat.getInt("idCR");
                String problemeClinique = resultat.getString("problemeClinique");
                int idExam = resultat.getInt("idExam");
                String technique = resultat.getString("technique");

                String comparaisonExamenAnt= resultat.getString("comparaisonExamenAnt");
                System.out.println("TEST :"+comparaisonExamenAnt);
                Date dateCR = resultat.getDate("dateCR");

                String protocoleStandardise= resultat.getString("protocoleStandardise");
                String resultatCR = resultat.getString("resultat");
                String synthese = resultat.getString("synthese");
                String conclusion = resultat.getString("conclusion");




                CR cr = new CR(idCR,idExam,problemeClinique,technique,comparaisonExamenAnt,dateCR,
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
    /**
     * Méthode qui retourne la liste de compte rendu
     * @return liste des comptes rendu
     */
    public ArrayList<CR> getListeCR() {
        return listeCR;
    }
}


