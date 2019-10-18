package delete;

import entity.Drug;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import main.Controller;

import javax.persistence.Query;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Delete implements Initializable {


    @FXML
    private TextField tf_drugCode;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_return;


    @FXML
    public void deleteFromDataBase(ActionEvent event) {

        Drug drug;
        SessionFactory sf = new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try {
            drug = session.get(Drug.class, Integer.valueOf((tf_drugCode.getText().toString())));
            session.delete(drug);
            tx.commit();
            JOptionPane.showMessageDialog(null, "داروی مورد نظر پاک شد");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "دارویی با این کد وجود ندارد ");
        } finally {
            session.close();
        }

    }

    public void deletAll(ActionEvent event) {

        SessionFactory sf = new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        try {
            Query query = session.createQuery("DELETE FROM Drug");
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "تمام دارو ها با موفقیت حذف شدند ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "خطا در حذف تمام دارو ها  ");
        } finally {
            session.close();
        }

    }


    public void return2managementSection() {

        Controller controller = new Controller();
        try {
            Stage stage1 = (Stage) btn_return.getScene().getWindow();
            stage1.close();
            controller.managementSection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alarm() {

        try {
            Stage Stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/delete/alarm.fxml"));
            Scene scene = new Scene(root);
            Stage.setScene(scene);
            Stage.setTitle("حذف تمام داروها");
            Stage.show();
            Stage.setResizable(false);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khata dar alarm");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
