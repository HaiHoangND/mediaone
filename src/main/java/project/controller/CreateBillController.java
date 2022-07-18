package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateBillController {

    @FXML
    private Button buttonXacNhan;

    @FXML
    private Button chonKH;

    @FXML
    private Label labelKH;

    @FXML
    private Label labelKH2;

    @FXML
    private Label labelMaHD;

    @FXML
    private Label labelMaHD2;

    @FXML
    private Label labelMaKH;

    @FXML
    private Label labelNgay;

    @FXML
    private Label labelNgay2;

    @FXML
    private Label labelTenKH;

    @FXML
    private Button themKH;

    @FXML
    private TextField txtMaKH;

    @FXML
    private TextField txtTenKH;

    @FXML
    void actionChonKH(ActionEvent event) {

    }

    @FXML
    void actionMaKH(ActionEvent event) {

    }

    @FXML
    void actionTenKH(ActionEvent event) {
    }

    @FXML
    void actionThemKH(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("CustomerController2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Thêm khách hàng");
        stage.showAndWait();
    }

    @FXML
    void actionXacNhan(ActionEvent event) {

    }

}
