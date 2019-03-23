package IU.acceuil_medecin;

import ClassTable.TableExamen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class MaJTableau {
    private final ObservableList <TableExamen> data;
    public MaJTableau(ArrayList<TableExamen> tb){
        if(tb.size()>0){
            data = FXCollections.observableArrayList(tb.get(0));
            for(int i=1;i<tb.size();i++){
                data.add(tb.get(i));
            }
        }
        else
            data=null;

    }

    public ObservableList<TableExamen> getData() {
        return data;
    }
}
