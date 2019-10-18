package show;

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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import main.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Show implements Initializable {

    @FXML
    private TextField tf_drugCode;
    @FXML
    private TextArea ta_show;
    @FXML
    private Button btn_return;
    @FXML
    private Button btn_show;
    @FXML
    private Button btn_go2showAll;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

    public void showDataBase(ActionEvent event) {
        Drug drug = new Drug();

        SessionFactory sf = new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            drug = session.get(Drug.class, Integer.valueOf((tf_drugCode.getText().toString())));
            if (drug != null) {
                ta_show.setText(drug.toString());
                tx.commit();

            } else {
                JOptionPane.showMessageDialog(null, "دارویی با کد وارد شده یافت نشد !!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "لطفا فقط عدد وارد کنید  !!!");
        } finally {
            session.close();
        }

    }

    public void showAllSection() {

        try {
            Stage listStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/main/java/show/showAll.fxml"));
            Scene scene1 = new Scene(root);
            listStage.setScene(scene1);
            listStage.setTitle("لیست تمام داروها");
            listStage.show();
            listStage.setResizable(false);
            Image img = new Image("/main/java/images/icon.png");
            listStage.getIcons().add(img);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khata dar show all section");
        }

    }

}
