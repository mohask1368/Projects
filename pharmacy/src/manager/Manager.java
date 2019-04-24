package manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Manager implements Initializable {

    @FXML
    private Button btn_add;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_search;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_show_all;
    @FXML
    private Button btn_save_to_excel;


    public void addSection() {

        try {
            Stage addStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/add/add.fxml"));


            Scene scene1 = new Scene(root);
            addStage.setScene(scene1);
            addStage.setTitle("اضافه کردن دارو");
            addStage.show();
            addStage.setResizable(false);
            Image img = new Image("/images/icon.png");
            addStage.getIcons().add(img);


        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    public void addDrug(ActionEvent event) {


        try {

            Stage stage = (Stage) this.btn_add.getScene().getWindow();
            stage.close();
            addSection();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void editSection() {

        try {
            Stage editStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/edit/edit.fxml"));


            Scene scene1 = new Scene(root);
            editStage.setScene(scene1);
            editStage.setTitle("ویرایش دارو");
            editStage.show();
            editStage.setResizable(false);
            Image img = new Image("/images/icon.png");
            editStage.getIcons().add(img);


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void editDrug(ActionEvent event) {


        try {

            Stage stage = (Stage) this.btn_edit.getScene().getWindow();
            stage.close();
            editSection();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void searchSection() {

        try {
            Stage searchStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/search/search.fxml"));


            Scene scene1 = new Scene(root);
            searchStage.setScene(scene1);
            searchStage.setTitle("جست و جوی دارو");
            searchStage.show();
            searchStage.setResizable(false);
            Image img = new Image("/images/icon.png");
            searchStage.getIcons().add(img);


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void searchDrug(ActionEvent event) {


        try {

            Stage stage = (Stage) this.btn_search.getScene().getWindow();
            stage.close();
            searchSection();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void deleteSection() {

        try {
            Stage deleteStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/delete/delete.fxml"));


            Scene scene1 = new Scene(root);
            deleteStage.setScene(scene1);
            deleteStage.setTitle("حذف دارو");
            deleteStage.show();
            deleteStage.setResizable(false);
            Image img = new Image("/images/icon.png");
            deleteStage.getIcons().add(img);


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void deleteDrug(ActionEvent event) {


        try {

            Stage stage = (Stage) this.btn_delete.getScene().getWindow();
            stage.close();
            deleteSection();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void showSection() {

        try {
            Stage showStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/show/show.fxml"));


            Scene scene1 = new Scene(root);
            showStage.setScene(scene1);
            showStage.setTitle("نمایش دارو");
            showStage.show();
            showStage.setResizable(false);
            Image img = new Image("/images/icon.png");
            showStage.getIcons().add(img);


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void showDrug(ActionEvent event) {


        try {

            Stage stage = (Stage) this.btn_show_all.getScene().getWindow();
            stage.close();
            showSection();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void printAllDrug(ActionEvent event) throws IOException {


        Print.print();


    }

    public void addOnMouseEntered() {
        btn_add.setEffect(new DropShadow());
        btn_add.setFont(Font.font("b titr"));

    }

    public void addOnMouseExited() {
        btn_add.setEffect(null);
        btn_add.setFont(Font.font("b koodak"));
    }

    public void editOnMouseEntered() {
        btn_edit.setEffect(new DropShadow());
        btn_edit.setFont(Font.font("b titr"));

    }

    public void editOnMouseExited() {
        btn_edit.setEffect(null);
        btn_edit.setFont(Font.font("b koodak"));
    }

    public void showOnMouseEntered() {
        btn_show_all.setEffect(new DropShadow());
        btn_show_all.setFont(Font.font("b titr"));
    }

    public void showOnMouseExited() {
        btn_show_all.setEffect(null);
        btn_show_all.setFont(Font.font("b koodak"));
    }

    public void searchOnMouseEntered() {
        btn_search.setEffect(new DropShadow());
        btn_search.setFont(Font.font("b titr"));
    }

    public void searchOnMouseExited() {
        btn_search.setEffect(null);
        btn_search.setFont(Font.font("b koodak"));
    }

    public void deleteOnMouseEntered() {
        btn_delete.setEffect(new DropShadow());
        btn_delete.setFont(Font.font("b titr"));
    }

    public void deleteOnMouseExited() {
        btn_delete.setEffect(null);
        btn_delete.setFont(Font.font("b koodak"));
    }

    public void saveOnMouseEntered() {
        btn_save_to_excel.setEffect(new DropShadow());
        btn_save_to_excel.setFont(Font.font("b titr", 13));
    }

    public void saveOnMouseExited() {
        btn_save_to_excel.setEffect(null);
        btn_save_to_excel.setFont(Font.font("b koodak", 14));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
