package project.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Manager.*;
import project.dao.*;

public class Main extends Application {
    public static void main(String[] args) {
        ProductManager.productList=ProductManagerDAO.importAll();
        EmployeeManager.employeeList=EmployeeManagerDAO.importAll();
        CustomerManager.customerList= CustomerManagerDAO.importALl();
        BillManager.billList= BillManagerDAO.importAll();


        System.out.println();
        launch(args);
    };
    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(this.getClass().getResource("CustomerController2.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("One Media");
            primaryStage.show();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
