package IU.choix_rdv;

import ClassTable.TableRDV;
import FC.Patient;
import FC.RDV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class MaJRDV {
    private final ObservableList<TableRDV> data;
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

    public ObservableList<TableRDV> getData() {
        return data;
    }
}
