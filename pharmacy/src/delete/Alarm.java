package delete;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import manager.Manager;

public class Alarm {

    @FXML
    private Button btn_yes;
    @FXML
    private Button btn_no;

    Delete delete = new Delete();
    public void yes(){
        try {

            Stage stage = (Stage) this.btn_yes.getScene().getWindow();
            stage.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
        delete.deletAll( new ActionEvent() );
    }

    public void no(){
        Stage stage = (Stage) this.btn_no.getScene().getWindow();
        stage.close();

    }
}
