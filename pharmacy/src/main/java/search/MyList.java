package search;

import entity.Drug;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MyList implements Initializable {

    @FXML
    public ListView lv_showAll;
    @FXML
    private Button btn_show;
    @FXML
    public  TextField tf_drugName;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void showList(ActionEvent event){

        if (!tf_drugName.getText().isEmpty()) {

            Drug drug = new Drug();


            SessionFactory sf = new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
            Session session = sf.getCurrentSession();
            Transaction tx = session.beginTransaction();

            try {


                Criteria criteria = session.createCriteria(Drug.class);

                Criterion ilike = Restrictions.ilike("name", "%" + tf_drugName.getText().toString() + "%");
                criteria.add(ilike);
                List<Drug> drugs = criteria.list();
                ObservableList obs = FXCollections.observableArrayList(drugs);
                lv_showAll.setItems(obs);


                tx.commit();
                session.close();

                if (drugs != null && drugs.size() > 0) {


                } else {
                    JOptionPane.showMessageDialog(null, "دارویی با این نام یافت نشد");
                }


            } catch (Exception e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(null, "لطفا فقط از حروف استفاده کنید  ! ");

            }


        } else {
            JOptionPane.showMessageDialog(null, "لطفا فیلد را پر کنید ! ");

        }
    }




    }




