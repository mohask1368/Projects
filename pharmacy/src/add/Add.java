package add;

import entity.Drug;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import main.Controller;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Add implements Initializable {


    @FXML
    private TextField tf_drugName;
    @FXML
    private TextField tf_drugPrice;
    @FXML
    private TextArea ta_drugUseCase;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_return;
    @FXML
    private Button btn_clear;




    @FXML
    public void add2DataBase(ActionEvent event) throws SQLException {

        if ( !tf_drugName.getText().isEmpty() && !tf_drugPrice.getText().isEmpty() && !ta_drugUseCase.getText().isEmpty()) {


            Drug drug=new Drug();

        drug.setName(tf_drugName.getText().toString());

        drug.setPrice(tf_drugPrice.getText().toString());

        drug.setUseCase(ta_drugUseCase.getText().toString());


        SessionFactory sf = new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(drug);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null,"دارو با موفقیت اضافه شد");

    }else {
            JOptionPane.showMessageDialog(null, "لطفا تمام فیلد هارا پر کنید ! ");

        }
    }






    public void return2ManagementSection(){

        Controller controller=new Controller();

        try {

            Stage stage = (Stage) btn_return.getScene().getWindow();
            stage.close();
            controller.managementSection();


        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void clear(ActionEvent event){

        tf_drugName.clear();
        tf_drugPrice.clear();
        ta_drugUseCase.clear();


    }

    public void priceValidation(){
        if (!tf_drugPrice.getText().matches("[0-9]+") && (tf_drugPrice.getText() != null || tf_drugPrice.getText() != "")){
            tf_drugPrice.clear();
            JOptionPane.showMessageDialog(null, " لطفا فقط عدد وارد کنید ! ");

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
