package FC;

import java.util.Date;

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

    public CR(){

    }

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


    public int getIdExam() {
        return idExam;
    }

    public int getIdCR() {
        return idCR;
    }

    public String getProblemeClinique() {
        return problemeClinique;
    }

    public String getTechnique() {
        return technique;
    }


    public String getComparaisonExamenAnt() {
        return comparaisonExamenAnt;
    }

    public Date getDateCR() {
        return dateCR;
    }



    public String getProtocoleStandardise() {
        return protocoleStandardise;
    }

    public String getResultat() {
        return resultat;
    }

    public String getSynthese() {
        return synthese;
    }

    public String getConclusion() {
        return conclusion;
    }
}
