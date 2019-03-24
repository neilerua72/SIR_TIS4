package IU.redaction_CR;

/**
 * Sample Skeleton for 'redaction_CR.fxml' Controller Class
 */

import BD.ConnexionBase;
import FC.CR;
import FC.Examen;
import FC.SIR;
import IU.acceuil_medecin.acceuil_medecin_controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class redaction_CR_controller implements Initializable {

    public redaction_CR_controller(){

    }


    @FXML
    private TextArea champ_resumeProblemeCliniqueCR;

    @FXML
    private Text DateExamen;

    @FXML
    private Text dateNaissance;

    @FXML
    private Button button_annulerCR;

    @FXML
    private Text sexe;

    @FXML
    private TextArea champ_protocoleStandardiseCR;

    @FXML
    private Text type;

    @FXML
    private Text nom;

    @FXML
    private TextArea champ_descriptionTechniqueCR;

    @FXML
    private Text dateRDV;

    @FXML
    private Text NomPrescri;

    @FXML
    private TextArea champ_comparaisonExamensExterieursCR;

    @FXML
    private TextArea champ_conclusionCR;

    @FXML
    private TextArea champ_syntheseCR;

    @FXML
    private TextArea champ_resultatCR;

    @FXML
    private Button button_validerBisCR;

    @FXML
    private Text prenom;

    @FXML
    private Text typeExamen;

    @FXML
    private Text NomRadiologue;

    @FXML
    private Text quantite;



    private SIR sir;
    private Examen examen;
    private Parent menu;
    private FXMLLoader loadermenu;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void validerCR(ActionEvent actionEvent) throws IOException{


        java.sql.Date dateEx = new java.sql.Date(new java.util.Date().getTime());

        String resumeProblemeClinique= champ_resumeProblemeCliniqueCR.getText();
        System.out.println(resumeProblemeClinique);
        String descriptionTechnique= champ_descriptionTechniqueCR.getText();
        System.out.println(descriptionTechnique);
        String protocoleStandarise= champ_protocoleStandardiseCR.getText();
        System.out.println(protocoleStandarise);
        String examenAnt= champ_comparaisonExamensExterieursCR.getText();
        System.out.println(examenAnt);
        String comparairon = champ_comparaisonExamensExterieursCR.getText();
        System.out.println(comparairon);
        String resultatCR= champ_resultatCR.getText();
        System.out.println(resultatCR);
        String synthese = champ_syntheseCR.getText();
        System.out.println(synthese);
        String conclusion= champ_conclusionCR.getText();
        System.out.println(conclusion);
        int idCRaleatoire = 0+(int)(Math.random()*((999999-0)+1));

        Connection connexion = null;
        Statement statement = null;
        CR cr = new CR(idCRaleatoire,Integer.valueOf(examen.getId()),resumeProblemeClinique,descriptionTechnique,comparairon,dateEx,protocoleStandarise,resultatCR,synthese,conclusion);
        sir.getListeCR().add(cr);
        examen.setCrExamen(true);

        try {

            ConnexionBase cb = new ConnexionBase();
            connexion=cb.returnConnexion();

            //Création de l'objet gérant les requêtes
            statement = connexion.createStatement();
            //Exécution d'une requete d'écriture

            int statut = statement.executeUpdate("INSERT INTO `CR` (`idCR`,`idExam`,`problemeClinique`," +
                    " `technique`," +
                    " `comparaisonExamenAnt`, `dateCR`, `protocoleStandardise`" +
                    ", `resultat`, `synthese`, `conclusion`) VALUES\n" +
                    "('"+idCRaleatoire+"' ,'"+examen.getId()+"','"+resumeProblemeClinique+"', '"+descriptionTechnique+"'," +
                    "'"+examenAnt+"','"+dateEx+"','"+protocoleStandarise+"'," +
                    "'"+resultatCR+"','"+synthese+"','"+conclusion+"');");
        //Récupération des données du statut de la requete d'écriture
        System.out.println("Résultat de la requête d'insertion:" +statut + ".");
    }
        catch (Exception e) {
        e.printStackTrace();
    }
        finally {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ignore) {
            }
        }
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException ignore) {
            }
        }
    }

        Connection connexion2 = null;
        Statement statement2 = null;
        try {

            ConnexionBase cb = new ConnexionBase();
            connexion2=cb.returnConnexion();
            String query = "UPDATE Examen SET idExamen=?,idPatient=?,dateRDV=?,ExamenFait=?,dateExamen=?," +
                    "CRExamen=?,image=?,validation=?,typeExamen=?,Salle=?,medecinPrescri=?,medecinRadio=?," +
                    "vue=?,lateralite=?,zoneetudie=?,dose=?,produit=? WHERE idExamen='"+examen.getId()+"'";
            //Création de l'objet gérant les requêtes
            PreparedStatement preparedStmt= connexion2.prepareStatement(query);
            preparedStmt.setString(1,examen.getId());
            preparedStmt.setInt(2,examen.getIdPatient());
            preparedStmt.setDate(3,examen.getDateRDV());
            preparedStmt.setInt(4,1);
            preparedStmt.setDate(5,dateEx);
            preparedStmt.setInt(6,1);
            preparedStmt.setInt(7,1);
            preparedStmt.setInt(8,0);
            preparedStmt.setString(9,examen.getTypeExamen().returnType());
            preparedStmt.setInt(10,examen.getSalle());
            preparedStmt.setString(11,examen.getMedecinPrescri());
            preparedStmt.setString(12,examen.getMedecinRadio());
            preparedStmt.setString(13,examen.getVue());
            preparedStmt.setString(14,examen.getLateralite());
            preparedStmt.setString(15,examen.getZoneetudie());
            preparedStmt.setString(16,examen.getDose());
            preparedStmt.setString(17,examen.getProduit());



            //Récupération des données du statut de la requete d'update
            preparedStmt.executeUpdate();
            System.out.println("update de la BD examen");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/IU/acceuil_medecin/acceuil_medecin.fxml"));
        Parent parent = loader.load();
        acceuil_medecin_controller acceuil_medecin_controller = loader.getController();
        acceuil_medecin_controller.initData(sir,menu,loadermenu);
        Scene scene= new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Sinpati - Acceuil");
        stage.setScene(scene);
        stage.show();
    }
public void initData(SIR sir, Examen examen,Parent menu,FXMLLoader loadermenu){
this.sir=sir;
this.examen=examen;
this.menu=menu;
this.loadermenu=loadermenu;
}

}


