package IU.afficher_dossiers_patient;

import ClassTable.TableExamen;
import FC.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class MaJTableau {
    private final ObservableList<Patient> data;
    public MaJTableau(ArrayList<Patient> tb){
        if(tb.size()>0){
            data = FXCollections.observableArrayList(tb.get(0));
            for(int i=1;i<tb.size();i++){
                data.add(tb.get(i));
            }
        }
        else
            data=null;

    }

    public ObservableList<Patient> getData() {
        return data;
    }
}
