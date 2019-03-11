package FC;

import java.util.Date;

public class CR {
    private int idCR;
    private String problemeClinique;
    private String technique;
    private String produitContrasteType;
    private int quantiteProduitContraste;
    private String comparaisonExamenAnt;
    private Date dateCR;
    private String specialiteRadiologue;
    private String protocoleStandardise;
    private String resultat;
    private String synthese;
    private String conclusion;

    public CR(int idCR, String problemeClinique, String technique, String produitContrasteType, int quantiteProduitContraste, String comparaisonExamenAnt, Date dateCR, String specialiteRadiologue, String protocoleStandardise, String resultat, String synthese, String conclusion) {
        this.idCR = idCR;
        this.problemeClinique = problemeClinique;
        this.technique = technique;
        this.produitContrasteType = produitContrasteType;
        this.quantiteProduitContraste = quantiteProduitContraste;
        this.comparaisonExamenAnt = comparaisonExamenAnt;
        this.dateCR = dateCR;
        this.specialiteRadiologue = specialiteRadiologue;
        this.protocoleStandardise = protocoleStandardise;
        this.resultat = resultat;
        this.synthese = synthese;
        this.conclusion = conclusion;
    }

    public String toString() {
        return "CR{" +
                "idCR=" + idCR +
                ", problemeClinique='" + problemeClinique + '\'' +
                ", technique='" + technique + '\'' +
                ", produitContrasteType='" + produitContrasteType + '\'' +
                ", quantiteProduitContraste=" + quantiteProduitContraste +
                ", comparaisonExamenAnt='" + comparaisonExamenAnt + '\'' +
                ", dateCR=" + dateCR +
                ", specialiteRadiologue='" + specialiteRadiologue + '\'' +
                ", protocoleStandardise='" + protocoleStandardise + '\'' +
                ", resultat='" + resultat + '\'' +
                ", synthese='" + synthese + '\'' +
                ", conclusion='" + conclusion + '\'' +
                '}';
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

    public String getProduitContrasteType() {
        return produitContrasteType;
    }

    public int getQuantiteProduitContraste() {
        return quantiteProduitContraste;
    }

    public String getComparaisonExamenAnt() {
        return comparaisonExamenAnt;
    }

    public Date getDateCR() {
        return dateCR;
    }

    public String getSpecialiteRadiologue() {
        return specialiteRadiologue;
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
