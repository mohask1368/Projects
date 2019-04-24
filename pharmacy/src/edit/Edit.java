package edit;

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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Edit implements Initializable {

    @FXML
    private TextField tf_drugCode;
    @FXML
    private TextField tf_drugName;
    @FXML
    private TextField tf_drugPrice;
    @FXML
    private TextArea ta_drugUseCase;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_return;
    @FXML
    private Button btn_clear;


    Connection connection;
   private final int NOT_EXIST=0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {





    }


    @FXML
    public void editDataBase(ActionEvent event) throws SQLException {


        if (!tf_drugCode.getText().isEmpty() && !tf_drugName.getText().isEmpty() && !tf_drugPrice.getText().isEmpty() && !ta_drugUseCase.getText().isEmpty()) {



            Drug drug=new Drug();


            SessionFactory sf=new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
            Session session=sf.getCurrentSession();
            Transaction tx=session.beginTransaction();
            try {
                drug = session.get(Drug.class,Integer.valueOf((tf_drugCode.getText().toString())));
                if (drug!=null){
                    drug.setName(tf_drugName.getText().toString());
                    drug.setPrice(tf_drugPrice.getText().toString());
                    drug.setUseCase(ta_drugUseCase.getText().toString());
                    session.update(drug);
                    tx.commit();
                    JOptionPane.showMessageDialog(null,"دارو با موفقیت ویرایش شد");

                }else {
                    JOptionPane.showMessageDialog(null,"دارویی با کد وارد شده یافت نشد !!!");

                }


            }catch (Exception e){
                e.printStackTrace();
            }finally {
                session.close();

            }



        }
    }


    public void return2ManagementSection() {

        Controller controller = new Controller();

        try {

            Stage stage = (Stage) btn_return.getScene().getWindow();
            stage.close();
            controller.managementSection();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void clear(ActionEvent event){

        tf_drugCode.clear();
        tf_drugName.clear();
        tf_drugPrice.clear();
        ta_drugUseCase.clear();
    }


}


