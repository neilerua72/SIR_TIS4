package IU.choix_rdv;

import ClassTable.TableRDV;
import FC.Patient;
import FC.RDV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Classe qui permet de mettre à jour une table de RDV
 * @author Aurélien
 * @version 1.0
 */
public class MaJRDV {
    private final ObservableList<TableRDV> data;

    /**
     * Constructeur qui remplit une ObservableList à partir d'une ArrayList
     * @param tb
     */
    public MaJRDV(ArrayList<TableRDV> tb){
        if(tb.size()>0){
            data = FXCollections.observableArrayList(tb.get(0));
            for(int i=1;i<tb.size();i++){
                data.add(tb.get(i));
            }
        }
        else
            data=null;

    }

    /**
     * Méthode qui retourne les données à mettre dans la table
     * @return
     */
    public ObservableList<TableRDV> getData() {
        return data;
    }
}
