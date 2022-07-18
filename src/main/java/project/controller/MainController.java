package project.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    AnchorPane anchorPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        banHang();
    }
    public void banHang(){
    }
    public void sanPham(){
        try{
            anchorPane.getChildren().clear();
            Parent rootChild = FXMLLoader.load(this.getClass().getResource("ProductController.fxml"));
            anchorPane.getChildren().add(rootChild);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void hoaDon(){
        try{
            anchorPane.getChildren().clear();
            Parent rootChild = FXMLLoader.load(this.getClass().getResource("BillController.fxml"));
            anchorPane.getChildren().add(rootChild);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void khuyenMai(){
        try{
            anchorPane.getChildren().clear();
            Parent rootChild = FXMLLoader.load(this.getClass().getResource("PromotionController.fxml"));
            anchorPane.getChildren().add(rootChild);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void nhanVien(){
        try{
            anchorPane.getChildren().clear();
            Parent rootChild = FXMLLoader.load(this.getClass().getResource("EmployeeController.fxml"));
            anchorPane.getChildren().add(rootChild);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void khachHang(){
        try{
            anchorPane.getChildren().clear();
            Parent rootChild = FXMLLoader.load(this.getClass().getResource("CustomerController1.fxml"));
            anchorPane.getChildren().add(rootChild);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void thongKe(){
    }
}
