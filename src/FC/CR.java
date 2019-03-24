package FC;

import java.util.Date;
/**
 * Classe qui modélise un compte rendu radiologique. Il contient toute les informations q'un CR est sensé contenir, en étant relié à un a examen
 * @author Hugo
 * @version 1.0
 *
 */
public class CR {
    private int idCR;
    private int idExam;
    private String problemeClinique;
    private String technique;

    private String comparaisonExamenAnt;
    private Date dateCR;
    private String protocoleStandardise;
    private String resultat;
    private String synthese;
    private String conclusion;

    /**
     * Constructeur de la classe qui ne recquiert aucun paramètre
     */
    public CR(){

    }

    /**
     * Constructeur de la classe qui requiert tout les attributs de la classe pour l'instancier
     * @param idCR l'id du compte rendu
     * @param idExam l'id de l'examen
     * @param problemeClinique le problème clinique
     * @param technique la technique utilisé
     * @param comparaisonExamenAnt la comparaison avec les examens antèrieurs
     * @param dateCR la date du Compte rendu
     * @param protocoleStandardise le protocole standardisé
     * @param resultat le resultat de l'examen
     * @param synthese la synthèse de l'examen
     * @param conclusion la conclusion du compte rendu
     */
    public CR(int idCR,int idExam, String problemeClinique, String technique, String comparaisonExamenAnt, Date dateCR, String protocoleStandardise, String resultat, String synthese, String conclusion) {
        this.idCR = idCR;
        this.idExam=idExam;
        this.problemeClinique = problemeClinique;
        this.technique = technique;
        this.comparaisonExamenAnt = comparaisonExamenAnt;
        this.dateCR = dateCR;
        this.protocoleStandardise = protocoleStandardise;
        this.resultat = resultat;
        this.synthese = synthese;
        this.conclusion = conclusion;
    }

    /**
     * Méthode qui permet de récuperer une chaine de caractère à partir d'un CR
     * @return le CR sous forme de chaine de caractère
     */
    public String toString() {
        return "CR{" +
                "idCR=" + idCR +
                ", problemeClinique='" + problemeClinique + '\'' +


                ", comparaisonExamenAnt='" + comparaisonExamenAnt + '\'' +
                ", dateCR=" + dateCR +

                ", protocoleStandardise='" + protocoleStandardise + '\'' +
                ", resultat='" + resultat + '\'' +
                ", synthese='" + synthese + '\'' +
                ", conclusion='" + conclusion + '\'' +
                '}';
    }


    /**
     * Méthode qui retourne l'id d'examen
     * @return l'id de l'examen
     */
    public int getIdExam() {
        return idExam;
    }

    /**
     * Méthode qui retourne l'id du CR
     * @return l'id du CR
     */
    public int getIdCR() {
        return idCR;
    }

    /**
     * Méthode qui retourne le problème clinique
     * @return le problème clinique
     */
    public String getProblemeClinique() {
        return problemeClinique;
    }

    /**
     * Méthode qui retourne la technique utilisée
     * @return la technique utilisée
     */
    public String getTechnique() {
        return technique;
    }

    /**
     * Méthode qui retourne la comparaison avec les examens antérieures
     * @return la comparaison avec les examens antérieuses
     */
    public String getComparaisonExamenAnt() {
        return comparaisonExamenAnt;
    }

    /**
     * Méthode qui retourne la date du CR
     * @return la date du CR
     */
    public Date getDateCR() {
        return dateCR;
    }

    /**
     * Méthode qui retourne le protocole standardisé
     * @return le protocole standardisé
     */
    public String getProtocoleStandardise() {
        return protocoleStandardise;
    }

    /**
     * Méthode qui retourne le résultat du CR
     * @return le protocole standardisé
     */
    public String getResultat() {
        return resultat;
    }

    /**
     * Méthode qui retourne la synthèse de l'examen
     * @return la synthèse de l'examen
     */
    public String getSynthese() {
        return synthese;
    }

    /**
     * Méthode qui retourne la conclusion de l'examen
     * @return la conclusion de l'examen
     */
    public String getConclusion() {
        return conclusion;
    }
}
