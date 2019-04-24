package search;

import entity.Drug;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import main.Controller;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {


    @FXML
    private TextField tf_drugCode;
    @FXML
    public  TextField tf_drugName;
    @FXML
    private Button btn_return;
    @FXML
    private Button btn_searchById;
    @FXML
    private Button btn_searchByName;



    public void searchById(ActionEvent event) {


        if (!tf_drugCode.getText().isEmpty()) {

            Drug drug = new Drug();


            SessionFactory sf = new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
            Session session = sf.getCurrentSession();
            Transaction tx = session.beginTransaction();

            try {
                drug = session.get(Drug.class, Integer.valueOf((tf_drugCode.getText().toString())));
                tx.commit();

                if (drug != null) {

                    JOptionPane.showMessageDialog(null, drug.toString());

                } else {
                    JOptionPane.showMessageDialog(null, "دارویی با کد وارد شده یافت نشد !!!");

                }


            } catch (Exception e)

            {
                JOptionPane.showMessageDialog(null, "لطفا فقط عدد وارد کنید  !!!");
            } finally {
                session.close();

            }

        } else {
            JOptionPane.showMessageDialog(null, "لطفا فیلد را پر کنید ! ");

        }

    }

    @FXML
    public void searchByName(ActionEvent event) {


                    myListSection();

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


    public void myListSection() {

        try {
            Stage listStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/search/myList.fxml"));
            Scene scene1 = new Scene(root);
            listStage.setScene(scene1);
            listStage.setTitle("لیست دارو");

            listStage.show();
            // listStage.setResizable(false);
            Image img = new Image("/images/icon.png");
            listStage.getIcons().add(img);



        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("khata dar MyList section");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }



}