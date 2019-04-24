package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Controller  {



    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField pf_password;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_register;
    @FXML
    private ImageView iv_status;




    public void managementSection(){

        try {


            Stage managementStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/manager/manager.fxml"));

            manager.Manager manager = (manager.Manager) loader.getController();

            Scene scene=new Scene(root);
            managementStage.setScene(scene);
            managementStage.setTitle("پنل مدیریت داروخانه");
            managementStage.show();
            managementStage.setResizable(false);
            Image img = new Image("/images/icon.png");
            managementStage.getIcons().add(img);


        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    public void loginCheker(javafx.event.ActionEvent event){

    try {

        if (true){
            Stage stage = (Stage) this.btn_login.getScene().getWindow();
            stage.close();
            managementSection();
        }else {
            JOptionPane.showMessageDialog(null,"اطلاعات وارد شده صحیح نیست !!!");
        }

    }catch (Exception e1){

        e1.printStackTrace();    }

    }


}


