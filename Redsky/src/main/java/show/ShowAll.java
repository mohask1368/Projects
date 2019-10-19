package show;

import entity.Drug;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowAll implements Initializable {

    @FXML
    private Button btn_show;
    @FXML
    private ListView lv_showAll;
    private List<Drug> drugs;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void show(ActionEvent event) {

        SessionFactory sf = new Configuration().configure("/main/java/config/ProjectConfig.xml").buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM Drug");
        drugs = query.list();
        ObservableList obs = FXCollections.observableArrayList(drugs);
        lv_showAll.setItems(obs);

        tx.commit();
        session.close();
    }
}
