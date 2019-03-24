package IU.liste_patient_secretaire;

import ClassTable.TableRDV;
import FC.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class MaJPatient {
    private final ObservableList<Patient> data;
    public MaJPatient(ArrayList<Patient> tb){
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
